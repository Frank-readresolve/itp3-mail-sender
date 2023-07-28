package co.simplon.itp3.mailsender.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.itp3.mailsender.dtos.CreateCustomerDto;
import co.simplon.itp3.mailsender.entities.ContactRole;
import co.simplon.itp3.mailsender.entities.Customer;
import co.simplon.itp3.mailsender.repositories.ContactRoleRepository;
import co.simplon.itp3.mailsender.repositories.CustomerRepository;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl
	implements CustomerService {

    private final CustomerRepository customers;

    private ContactRoleRepository contactRoles;

    public CustomerServiceImpl(CustomerRepository customers,
	    ContactRoleRepository contactRoles) {
	this.customers = customers;
	this.contactRoles = contactRoles;
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
	customer.setContactRole(contactRole);
	this.customers.save(customer);

    }

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
