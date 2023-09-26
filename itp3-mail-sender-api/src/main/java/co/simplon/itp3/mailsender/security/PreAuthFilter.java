package co.simplon.itp3.mailsender.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class PreAuthFilter
	extends AbstractPreAuthenticatedProcessingFilter {

    private final String clientNameHeader;

    private final String credentialsHeader;

    public PreAuthFilter(String clientNameHeader,
	    String credentialsHeader) {
	this.clientNameHeader = clientNameHeader;
	this.credentialsHeader = credentialsHeader;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(
	    HttpServletRequest request) {
	return headerValue(request, clientNameHeader);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(
	    HttpServletRequest request) {
	return headerValue(request, credentialsHeader);
    }

    private static String headerValue(
	    HttpServletRequest request, String headerName) {
	String value = request.getHeader(headerName);
	return value == null ? "" : value;
    }
}
