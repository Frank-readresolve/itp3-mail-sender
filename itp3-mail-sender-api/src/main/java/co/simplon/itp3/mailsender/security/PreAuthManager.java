package co.simplon.itp3.mailsender.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import co.simplon.itp3.mailsender.services.CustomerService;

public class PreAuthManager
	implements AuthenticationManager {

    private final CustomerService service;

    public PreAuthManager(CustomerService service) {
	this.service = service;
    }

    @Override
    public Authentication authenticate(
	    Authentication authentication)
	    throws AuthenticationException {
	String principal = (String) authentication
		.getPrincipal();
	String credentials = (String) authentication
		.getCredentials();
	service.authenticate(principal, credentials);
	authentication.setAuthenticated(true);
	return authentication;
    }

}
