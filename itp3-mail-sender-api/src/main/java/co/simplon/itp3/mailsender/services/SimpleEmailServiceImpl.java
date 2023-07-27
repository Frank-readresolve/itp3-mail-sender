package co.simplon.itp3.mailsender.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import co.simplon.itp3.mailsender.dtos.SimpleMailDto;

public class SimpleEmailServiceImpl
	implements SimpleEmailService {

    private JavaMailSender javaMailSender;

    public SimpleEmailServiceImpl(
	    JavaMailSender javaMailSender) {
	this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendSimpleMail(SimpleMailDto inputs) {
	try {
	    SimpleMailMessage mailMessage = new SimpleMailMessage();

	    mailMessage.setTo(inputs.getPrimaryRecipient());
	    mailMessage.setText(inputs.getBody());
	    mailMessage.setSubject(inputs.getSubject());

	    this.javaMailSender.send(mailMessage);
	} catch (Exception e) {
	    System.out.println(e);
	}
    }

}
