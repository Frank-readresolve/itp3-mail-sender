package co.simplon.itp3.mailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Itp3MailSenderApiApplication {

    public static void main(String[] args) {
	SpringApplication.run(
		Itp3MailSenderApiApplication.class, args);
    }

}
