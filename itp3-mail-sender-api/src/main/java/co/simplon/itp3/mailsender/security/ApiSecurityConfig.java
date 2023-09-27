package co.simplon.itp3.mailsender.security;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.SecurityContextHolderFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class ApiSecurityConfig {

    @Value("${mail-sender.api-key.customer-number.header}")
    private String clientNameHeader;

    @Value("${mail-sender.api-key.credentials.header}")
    private String credentialsHeader;

    private final AuthenticationManager manager;

    public ApiSecurityConfig(
	    AuthenticationManager manager) {
	this.manager = manager;
	// TODO Auto-generated constructor stub
    }

    @Bean
    protected SecurityFilterChain filterChain(
	    HttpSecurity http) throws Exception {
	http.csrf().disable().sessionManagement()
		.sessionCreationPolicy(
			SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(preAuthExceptionFilter(),
			SecurityContextHolderFilter.class)
		.addFilterAfter(preAuthFilter(),
			PreAuthFilter.class)
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,
			"/send-attached-mail")
		.fullyAuthenticated()
		.antMatchers(HttpMethod.POST, "/send-mail")
		.anonymous();
	return http.build();
    }

    @Bean
    protected Filter preAuthFilter() {
	PreAuthFilter filter = new PreAuthFilter(
		clientNameHeader, credentialsHeader);
	filter.setAuthenticationManager(manager);
	filter.setContinueFilterChainOnUnsuccessfulAuthentication(
		false);
	filter.setRequiresAuthenticationRequestMatcher(
		new AntPathRequestMatcher(
			"/send-attached-mail", "POST"));
	return filter;
    }

    @Bean
    protected Filter preAuthExceptionFilter() {
	return new PreAuthExceptionFilter();
    }
}
