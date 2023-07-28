package co.simplon.itp3.mailsender.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import co.simplon.itp3.mailsender.dtos.SendEmailDto;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
	this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendSimpleMail(SendEmailDto inputs) {
	try {
	    SimpleMailMessage mailMessage = new SimpleMailMessage();

	    mailMessage.setTo(inputs.getPrimaryRecipient());
	    mailMessage.setFrom(inputs.getSender());
	    mailMessage.setText(inputs.getBody());
	    mailMessage.setSubject(inputs.getSubject());

	    this.javaMailSender.send(mailMessage);
	    System.out.println(mailMessage);

	} catch (Exception e) {
	    System.out.println(e);
	}
    }

}
