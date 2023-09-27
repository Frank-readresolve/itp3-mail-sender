package co.simplon.itp3.mailsender.services;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.simplon.itp3.mailsender.dtos.CustomerView;
import co.simplon.itp3.mailsender.repositories.CustomerRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final CustomerRepository customers;

    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthServiceImpl(CustomerRepository customers) {
	this.customers = customers;
    }

    @Override
    public void authenticate(String customerNumber,
	    String rawKey) throws BadCredentialsException {
	if ((customerNumber == null)
		|| customerNumber.equals("")) {
	    throw new BadCredentialsException(
		    String.format("Customer not found"));
	}
	CustomerView client = customers
		.findByCustomerNumber(
			Long.valueOf(customerNumber))
		.orElseThrow(
			() -> new BadCredentialsException(
				String.format(
					"Customer not found with customer name '%s'",
					customerNumber)));
	if (!encoder.matches(rawKey, client.getApiKey())) {
	    throw new BadCredentialsException(String.format(
		    "Bad API Key for client with name '%s'",
		    customerNumber));
	}

    }
}
