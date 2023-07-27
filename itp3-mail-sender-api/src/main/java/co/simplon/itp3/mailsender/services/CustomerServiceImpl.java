package co.simplon.itp3.mailsender.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.itp3.mailsender.dtos.CreateCustomerDto;
import co.simplon.itp3.mailsender.entities.Customer;
import co.simplon.itp3.mailsender.repositories.CustomerRepository;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl
	implements CustomerService {

    private CustomerRepository customers;

    public CustomerServiceImpl(
	    CustomerRepository customers) {
	this.customers = customers;
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
