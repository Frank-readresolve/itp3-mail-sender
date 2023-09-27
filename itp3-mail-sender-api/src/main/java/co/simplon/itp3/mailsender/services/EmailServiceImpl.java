package co.simplon.itp3.mailsender.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import co.simplon.itp3.mailsender.dtos.SendAuthEmailDto;
import co.simplon.itp3.mailsender.dtos.SendEmailDto;
import co.simplon.itp3.mailsender.entities.EmailTemplate;
import co.simplon.itp3.mailsender.repositories.CustomerRepository;
import co.simplon.itp3.mailsender.repositories.EmailTemplateRepository;
import co.simplon.itp3.mailsender.security.SecurityHelper;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final EmailTemplateRepository emailTemplates;
    private final CustomerRepository customers;

    public EmailServiceImpl(JavaMailSender javaMailSender,
	    EmailTemplateRepository emailTemplates,
	    CustomerRepository customers) {
	this.javaMailSender = javaMailSender;
	this.emailTemplates = emailTemplates;
	this.customers = customers;
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

    @Override
    public void sendAuthMail(SendAuthEmailDto inputs)
	    throws MessagingException {
	MimeMessage mimeMessage = javaMailSender
		.createMimeMessage();
	MimeMessageHelper helper = new MimeMessageHelper(
		mimeMessage, true);
	Long authenticatedCustomer = Long.valueOf(
		SecurityHelper.authenticatedCustomer());
	String customerEmail = customers
		.findCustomerByCustomerNumber(
			authenticatedCustomer)
		.getFromReplyTo();
	helper.setFrom("no-reply.dev@readresolve.io");
	helper.setReplyTo(customerEmail);
	helper.setSubject(inputs.getSubject());
	helper.setTo(inputs.getPrimaryRecipient());
	if (inputs.getCc() != null) {
	    helper.setCc(inputs.getCc());
	}
	if (inputs.getBcc() != null) {
	    helper.setBcc(inputs.getBcc());
	}
	helper.setText(inputs.getBody(), true);
	if (inputs.getFilePath() != null) {
	    FileSystemResource file = new FileSystemResource(
		    new String(inputs.getFilePath()));
	    helper.addAttachment(inputs.getFilePath(),
		    file);
	}
	try {
	    javaMailSender.send(mimeMessage);
	    System.out.println(
		    "HTML email with attachment sent successfully.");
	} catch (MailException e) {
	    System.out.println("Error Sending Email: "
		    + e.getMessage());
	}
    }

}
