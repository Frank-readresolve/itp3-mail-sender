package co.simplon.itp3.mailsender.services;

import java.util.Collection;

import co.simplon.itp3.mailsender.dtos.CreateCustomerDto;
import co.simplon.itp3.mailsender.dtos.CustomersList;

public interface CustomerService {
    void create(CreateCustomerDto inputs);

    public boolean emailValueExists(String email);

    public boolean customerNameValueExist(
	    String customerName);

    Collection<CustomersList> getAll();
}
