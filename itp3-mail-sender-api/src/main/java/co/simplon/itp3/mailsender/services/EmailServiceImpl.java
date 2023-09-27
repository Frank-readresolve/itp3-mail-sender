package co.simplon.itp3.mailsender.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.itp3.mailsender.dtos.SendAuthEmailDto;
import co.simplon.itp3.mailsender.dtos.SendEmailDto;
import co.simplon.itp3.mailsender.entities.EmailTemplate;
import co.simplon.itp3.mailsender.repositories.EmailTemplateRepository;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${mailsender.uploads.location}")
    private String uploadDir;

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

    @Override
    public void sendAuthMail(SendAuthEmailDto inputs)
	    throws MessagingException {
	MimeMessage mimeMessage = javaMailSender
		.createMimeMessage();
	MimeMessageHelper helper = new MimeMessageHelper(
		mimeMessage, true);
	helper.setFrom(inputs.getSender());
	helper.setReplyTo(inputs.getSender());
	helper.setSubject(inputs.getSubject());
	helper.setTo(inputs.getPrimaryRecipient());
	if (inputs.getCc() != null) {
	    helper.setCc(inputs.getCc());
	}
	if (inputs.getBcc() != null) {
	    helper.setBcc(inputs.getBcc());
	}
	helper.setText(inputs.getBody(), true);
	if (inputs.getFile() != null) {
	    MultipartFile file = inputs.getFile();
	    String fileName = inputs.getFile()
		    .getOriginalFilename();
	    helper.addAttachment(fileName, file);
	    store(file, fileName);
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

    private void store(MultipartFile file,
	    String fileName) {
	Path uploadPath = Paths.get(uploadDir);
	Path target = uploadPath.resolve(fileName);
	try (InputStream in = file.getInputStream()) {
	    Files.copy(in, target,
		    StandardCopyOption.REPLACE_EXISTING);
	} catch (IOException ex) {
	    throw new RuntimeException(ex);
	}
    }

}
