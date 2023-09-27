package co.simplon.itp3.mailsender.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * A helper class to deal with the security context.
 */
public final class SecurityHelper {

    private SecurityHelper() {
	// Ensures non-instantiability
    }

    /**
     * Returns the customer number of the authenticated customer.
     *
     * @return the customerNumber of the authenticated customer
     */
    public static String authenticatedCustomer() {
	Authentication auth = SecurityContextHolder
		.getContext().getAuthentication();
	String customerNumber = auth.getName();
	return customerNumber;
    }
}
