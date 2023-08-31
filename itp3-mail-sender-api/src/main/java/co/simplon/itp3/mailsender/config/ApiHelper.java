package co.simplon.itp3.mailsender.config;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.algorithms.Algorithm;

public class ApiHelper {
    private final PasswordEncoder encoder;

    public ApiHelper(Builder builder) {
	this.encoder = builder.encoder;
    }

    public String encode(String apiKey) {
	return encoder.encode(apiKey);
    }

    public static class Builder {
	private String issuer;
	private long expiration;
	private Algorithm algorithm;
	private PasswordEncoder encoder;

	public Builder() {

	}

	public Builder issuer(String issuer) {
	    this.issuer = issuer;
	    return this;
	}

	public Builder algorithm(Algorithm algorithm) {
	    this.algorithm = algorithm;
	    return this;
	}

	public Builder expiration(long expiration) {
	    this.expiration = expiration;
	    return this;
	}

	public Builder encoder(PasswordEncoder encoder) {
	    this.encoder = encoder;
	    return this;
	}

	public ApiHelper build() {
	    return new ApiHelper(this);
	}
    }
}
