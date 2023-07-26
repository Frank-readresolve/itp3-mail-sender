package co.simplon.itp3.mailsender.services;

import co.simplon.itp3.mailsender.dtos.CreateCustomerDto;

public interface CustomerService {
    void create(CreateCustomerDto inputs);

    public boolean emailValueExists(String email);

    public boolean customerNameValueExist(
	    String customerName);
}
