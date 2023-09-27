package co.simplon.itp3.mailsender.services;

import org.springframework.security.authentication.BadCredentialsException;

public interface AuthService {

    /**
     * Verifies that a client exists with given name and API <i>raw</i> key.
     *
     * @param customerNumber the client customer number
     * @param rawKey         the API <i>raw</i> key
     * @throws BadCredentialsException if no client is found with given name; or if
     *                                 <i>raw</i> key does not match the encoded key
     */
    void authenticate(String customerNumber, String rawKey)
	    throws BadCredentialsException;
}
