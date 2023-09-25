package co.simplon.itp3.mailsender.services;

import java.time.LocalDateTime;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import co.simplon.itp3.mailsender.dtos.SendEmailDto;
import co.simplon.itp3.mailsender.entities.Header;
import co.simplon.itp3.mailsender.entities.MailTracker;
import co.simplon.itp3.mailsender.repositories.HeaderRepository;
import co.simplon.itp3.mailsender.repositories.MailTrackerRepository;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    private HeaderRepository headers;

    private MailTrackerRepository mailTracker;

    public EmailServiceImpl(JavaMailSender javaMailSender,
	    HeaderRepository headers,
	    MailTrackerRepository mailTracker) {
	this.javaMailSender = javaMailSender;
	this.headers = headers;
	this.mailTracker = mailTracker;
    }

    @Override
    public void sendSimpleMail(SendEmailDto inputs,
	    HttpServletRequest request) {
	Boolean success = false;
	String errorMessage = null;
	try {
	    SimpleMailMessage mailMessage = new SimpleMailMessage();

	    mailMessage.setTo(inputs.getPrimaryRecipient());
	    mailMessage.setFrom(inputs.getSender());
	    mailMessage.setText(inputs.getBody());
	    mailMessage.setSubject(inputs.getSubject());
	    this.javaMailSender.send(mailMessage);
	    success = true;
	    sendMailTracker(inputs, success, errorMessage,
		    request);

	} catch (Exception e) {
	    System.out.println(e);
	    errorMessage = e.toString();
	    sendMailTracker(inputs, success, errorMessage,
		    request);
	}
    }

    public void sendHeaders(HttpServletRequest request,
	    MailTracker mailTracker) {

	Enumeration<String> headerNames = request
		.getHeaderNames();
	while (headerNames.hasMoreElements()) {
	    Header header = new Header();
	    String headerName = headerNames.nextElement();
	    String headerValue = request
		    .getHeader(headerName);
	    header.setName(headerName);
	    header.setValue(headerValue);
	    header.setMailTracker(mailTracker);
	    this.headers.save(header);

	}

    }

    public void sendMailTracker(SendEmailDto inputs,
	    Boolean success, String errorMessage,
	    HttpServletRequest request) {
	MailTracker mailTracker = new MailTracker();
	mailTracker
		.setBodyLength(inputs.getBody().length());
	mailTracker.setSubjectLength(
		inputs.getSubject().length());
	LocalDateTime dateTime = LocalDateTime.now();
	mailTracker.setDateTime(dateTime);
	mailTracker.setSuccess(success);
	mailTracker.setMessage(errorMessage);
	this.mailTracker.save(mailTracker);
	this.sendHeaders(request, mailTracker);
    }
}
