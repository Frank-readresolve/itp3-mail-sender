package co.simplon.itp3.mailsender.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import co.simplon.itp3.mailsender.dtos.AnonymousEmail;

@Service
public class EmailServiceImpl
	implements EmailService {

    private JavaMailSender javaMailSender;

    public EmailServiceImpl(
	    JavaMailSender javaMailSender) {
	this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendSimpleMail(AnonymousEmail inputs) {
	try {
	    SimpleMailMessage mailMessage = new SimpleMailMessage();

	    mailMessage.setTo(inputs.getPrimaryRecipient());
	    mailMessage
		    .setFrom("no-reply.dev@readresolve.io");
	    mailMessage.setText(inputs.getBody());
	    mailMessage.setSubject(inputs.getSubject());
	    System.out.println(mailMessage);

	    this.javaMailSender.send(mailMessage);

	} catch (Exception e) {
	    System.out.println(e);
	}
    }

}
