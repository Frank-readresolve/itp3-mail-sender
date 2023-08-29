package co.simplon.itp3.mailsender.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.algorithms.Algorithm;

@Configuration
public class SecurityConfig {

    @Value("${mailsender.auth.rounds}")
    private int rounds;

    @Value("${mailsender.auth.issuer}")
    private String issuer;

    @Value("${mailsender.auth.secret}")
    private String secret;

    @Value("${mailsender.auth.tokenExpiration}")
    private long tokenExpiration;

    public ApiHelper apiHelper() {
	Algorithm algorithm = Algorithm.HMAC256(secret);
	PasswordEncoder encoder = new BCryptPasswordEncoder(
		rounds);

	return new ApiHelper.Builder().algorithm(algorithm)
		.encoder(encoder)
		.expiration(tokenExpiration).issuer(issuer)
		.build();
    }

}
