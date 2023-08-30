package co.simplon.itp3.mailsender.services;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import co.simplon.itp3.mailsender.dtos.SendEmailDto;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
	this.javaMailSender = javaMailSender;
    }

    @Async
    @Override
    public void sendSimpleMail(SendEmailDto inputs) {

	SimpleMailMessage mailMessage = new SimpleMailMessage();
	mailMessage.setTo(inputs.getPrimaryRecipient());
	mailMessage.setFrom(inputs.getSender());
	mailMessage.setText(inputs.getBody());
	mailMessage.setSubject(inputs.getSubject());
	try {
	    this.javaMailSender.send(mailMessage);
	    System.out.println(mailMessage);

	} catch (MailException e) {
	    System.out.println("Error Sending Email: "
		    + e.getMessage());
	}
    }

}
