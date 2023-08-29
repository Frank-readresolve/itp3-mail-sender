package co.simplon.itp3.mailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {
	SecurityAutoConfiguration.class })
public class Itp3MailSenderApiApplication {

    public static void main(String[] args) {
	SpringApplication.run(
		Itp3MailSenderApiApplication.class, args);
    }

}
