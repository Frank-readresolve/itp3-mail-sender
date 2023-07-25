package co.simplon.itp3.mailsender.services;

import org.springframework.stereotype.Service;

import co.simplon.itp3.mailsender.dtos.CreateCustomerDto;
import co.simplon.itp3.mailsender.entities.Customer;
import co.simplon.itp3.mailsender.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl
	implements CustomerService {

    private CustomerRepository customers;

    public CustomerServiceImpl(
	    CustomerRepository customers) {
	this.customers = customers;
    }

    @Override
    public void create(CreateCustomerDto inputs) {
	Customer customer = new Customer();
	customer.setCustomerName(inputs.getCustomerName());
	customer.setFirstName(inputs.getFirstName());
	customer.setLastName(inputs.getLastName());
	customer.setContactEmail(inputs.getContactEmail());
	customer.setMarketingConsent(
		inputs.getMarketingConsent());
	this.customers.save(customer);
    }

}
