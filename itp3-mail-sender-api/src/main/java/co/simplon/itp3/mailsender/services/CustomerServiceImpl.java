package co.simplon.itp3.mailsender.services;

import java.util.UUID;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.itp3.mailsender.dtos.CreateCustomerDto;
import co.simplon.itp3.mailsender.dtos.CustomerView;
import co.simplon.itp3.mailsender.entities.ContactRole;
import co.simplon.itp3.mailsender.entities.Customer;
import co.simplon.itp3.mailsender.entities.EmailTemplate;
import co.simplon.itp3.mailsender.entities.Subscription;
import co.simplon.itp3.mailsender.repositories.ContactRoleRepository;
import co.simplon.itp3.mailsender.repositories.CustomerRepository;
import co.simplon.itp3.mailsender.repositories.EmailTemplateRepository;
import co.simplon.itp3.mailsender.repositories.SubscriptionRepository;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl
	implements CustomerService {

    private final CustomerRepository customers;

    private final ContactRoleRepository contactRoles;

    private final SubscriptionRepository subscriptions;

    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    private final EmailTemplateRepository emailTemplates;
    private final JavaMailSender javaMailSender;

    public CustomerServiceImpl(CustomerRepository customers,
	    ContactRoleRepository contactRoles,
	    SubscriptionRepository subscriptions,
	    EmailTemplateRepository emailTemplates,
	    JavaMailSender javaMailSender) {
	this.customers = customers;
	this.contactRoles = contactRoles;
	this.subscriptions = subscriptions;
	this.emailTemplates = emailTemplates;
	this.javaMailSender = javaMailSender;
    }

    @Override
    @Transactional
    public void create(CreateCustomerDto inputs) {
	Customer customer = new Customer();
	customer.setCustomerName(inputs.getCustomerName());
	customer.setFirstName(inputs.getFirstName());
	customer.setLastName(inputs.getLastName());
	customer.setContactEmail(inputs.getContactEmail());
	customer.setMarketingConsent(
		inputs.getMarketingConsent());
	long countCustomerNumber = this.customers
		.getNextValMySequence();
	customer.setCustomerNumber(countCustomerNumber);
	ContactRole contactRole = contactRoles
		.getReferenceById(inputs.getRoleId());
	Subscription subscription = subscriptions
		.getReferenceById(
			inputs.getSubscriptionId());
	customer.setSubscriptionId(subscription);
	customer.setFromReplyTo(inputs.getFromReplyTo());
	customer.setContactRole(contactRole);
	String apiKey = UUID.randomUUID().toString();
	String apiKeyEncoded = encoder.encode(apiKey);
	customer.setApiKey(apiKeyEncoded);
	sendApiKeyEmail(inputs, apiKey);
	this.customers.save(customer);

    }

    public void sendApiKeyEmail(CreateCustomerDto inputs,
	    String ApiKey) {
	EmailTemplate emailCustomerTemplate = new EmailTemplate();
	emailCustomerTemplate = this.emailTemplates
		.getByTemplateIdentifier("CUSTOMER");
	String emailSubject = emailCustomerTemplate
		.getTemplateSubject();
	String replaceSubject = emailSubject.replace(
		"${client_subject}",
		inputs.getCustomerName());

	String emailBody = emailCustomerTemplate
		.getTemplateBody();
	String replaceBody = emailBody
		.replace("${contact_firstname}",
			inputs.getFirstName())
		.replace("${api_key}", ApiKey);

	try {
	    SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage.setTo(inputs.getContactEmail());
	    mailMessage.setFrom(inputs.getFromReplyTo());
	    mailMessage.setText(replaceBody);
	    mailMessage.setSubject(replaceSubject);
	    this.javaMailSender.send(mailMessage);
	} catch (Exception e) {
	    System.out.println(e);
	}
    };

    @Override
    public boolean emailValueExists(String email)
	    throws UnsupportedOperationException {

	return this.customers
		.existsByContactEmail(email.toString());
    }

    @Override
    public boolean customerNameValueExist(
	    String customerName)
	    throws UnsupportedOperationException {
	return this.customers.existsByCustomerName(
		customerName.toString());
    }

    @Override
    public void authenticate(String customerNumber,
	    String rawKey) throws BadCredentialsException {
	CustomerView client = customers
		.findByCustomerNumber(customerNumber)
		.orElseThrow(
			() -> new BadCredentialsException(
				String.format(
					"Customer not found with customer number '%s'",
					customerNumber)));
	if (!encoder.matches(rawKey, client.getApiKey())) {
	    throw new BadCredentialsException(String.format(
		    "Bad API Key for client with name '%s'",
		    customerNumber));
	}

    }

}
