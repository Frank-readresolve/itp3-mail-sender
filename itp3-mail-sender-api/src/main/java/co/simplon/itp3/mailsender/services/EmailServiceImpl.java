package co.simplon.itp3.mailsender.services;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import co.simplon.itp3.mailsender.dtos.SendEmailDto;
import co.simplon.itp3.mailsender.entities.EmailTemplate;
import co.simplon.itp3.mailsender.repositories.EmailTemplateRepository;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final EmailTemplateRepository emailTemplates;

    public EmailServiceImpl(JavaMailSender javaMailSender,
	    EmailTemplateRepository emailTemplates) {
	this.javaMailSender = javaMailSender;
	this.emailTemplates = emailTemplates;
    }

    @Async
    @Override
    public void sendSimpleMail(SendEmailDto inputs) {

	EmailTemplate freeMail = applyFreeMailTemplate(
		inputs);
	SimpleMailMessage mailMessage = new SimpleMailMessage();
	mailMessage.setTo(inputs.getPrimaryRecipient());
	mailMessage.setFrom(inputs.getSender());

	mailMessage.setText(freeMail.getTemplateBody());
	mailMessage
		.setSubject(freeMail.getTemplateSubject());
	try {
	    this.javaMailSender.send(mailMessage);
	    System.out.println(mailMessage.toString());

	} catch (MailException e) {
	    System.out.println("Error Sending Email: "
		    + e.getMessage());
	}

    }

    private final EmailTemplate applyFreeMailTemplate(
	    SendEmailDto inputs) {
	EmailTemplate freeMail = this.emailTemplates
		.getByTemplateIdentifier("FREE_MAIL");
	String emailSubject = freeMail.getTemplateSubject();
	String replaceSubject = emailSubject.replace(
		"${client_subject}", inputs.getSubject());
	String emailbody = freeMail.getTemplateBody();
	String replaceBody = emailbody.replace(
		"${client_body}", inputs.getBody());
	freeMail.setTemplateSubject(replaceSubject);
	freeMail.setTemplateBody(replaceBody);
	return freeMail;
    }

}
