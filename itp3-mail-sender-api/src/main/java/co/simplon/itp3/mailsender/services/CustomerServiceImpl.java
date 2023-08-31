package co.simplon.itp3.mailsender.services;

import java.util.UUID;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.itp3.mailsender.config.ApiHelper;
import co.simplon.itp3.mailsender.dtos.CreateCustomerDto;
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

    private final ApiHelper apiHelper;

    private final EmailTemplateRepository emailTemplates;
    private final JavaMailSender javaMailSender;

    public CustomerServiceImpl(CustomerRepository customers,
	    ContactRoleRepository contactRoles,
	    SubscriptionRepository subscriptions,
	    ApiHelper apiHelper,
	    EmailTemplateRepository emailTemplates,
	    JavaMailSender javaMailSender) {
	this.customers = customers;
	this.contactRoles = contactRoles;
	this.subscriptions = subscriptions;
	this.apiHelper = apiHelper;
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
	String hash = apiHelper.encode(apiKey);
	customer.setApiKey(hash);
	sendApiKeyEmail(inputs, apiKey);
	this.customers.save(customer);

    }

    public void sendApiKeyEmail(CreateCustomerDto inputs,
	    String ApiKey) {
	EmailTemplate emailCustomer = new EmailTemplate();
	emailCustomer = this.emailTemplates
		.getByTemplateIdentifier("CUSTOMER");
	String emailSubject = emailCustomer
		.getTemplateSubject();
	String[] subjectParts = emailSubject
		.split("\\$\\{");
	String subjectPart1 = subjectParts[0];
	String subjectPart2 = inputs.getCustomerName();
	String concatSubject = subjectPart1 + subjectPart2;

	String emailBody = emailCustomer.getTemplateBody();
	String[] bodyParts = emailBody.split("\\$\\{");
	String bodyPart1 = bodyParts[0];
	String[] bodyParts2 = bodyParts[1].split("\\}");
	String bodyPart2 = inputs.getFirstName();
	String bodyPart3 = bodyParts2[1];
	String[] bodyParts3 = bodyParts[2].split("\\}");
	String bodyPart4 = ApiKey;
	String bodyPart5 = bodyParts3[1];
	String concatBody = bodyPart1 + bodyPart2
		+ bodyPart3 + bodyPart4 + bodyPart5;

	try {
	    SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage.setTo(inputs.getContactEmail());
	    mailMessage.setFrom(inputs.getFromReplyTo());
	    mailMessage.setText(concatBody);
	    mailMessage.setSubject(concatSubject);
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

}
