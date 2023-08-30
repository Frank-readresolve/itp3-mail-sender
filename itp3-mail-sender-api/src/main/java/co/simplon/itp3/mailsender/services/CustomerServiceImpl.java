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
import co.simplon.itp3.mailsender.repositories.ContactRoleRepository;
import co.simplon.itp3.mailsender.repositories.CustomerRepository;
import co.simplon.itp3.mailsender.repositories.EmailTemplateRepository;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl
	implements CustomerService {

    private final CustomerRepository customers;

    private final ContactRoleRepository contactRoles;

    private final ApiHelper apiHelper;

    private final EmailTemplateRepository emailTemplates;
    private final JavaMailSender javaMailSender;

    public CustomerServiceImpl(CustomerRepository customers,
	    ContactRoleRepository contactRoles,
	    ApiHelper apiHelper,
	    EmailTemplateRepository emailTemplates,
	    JavaMailSender javaMailSender) {
	this.customers = customers;
	this.contactRoles = contactRoles;
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
	System.out.println(emailCustomer);
	try {
	    SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage
		    .setTo("juliette.madinier@gmail.com");
	    mailMessage
		    .setFrom("no-reply.dev@readresolve.io");
	    mailMessage.setText(
		    emailCustomer.getTemplateBody());
	    mailMessage.setSubject(
		    emailCustomer.getTemplateIdentifier());
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
