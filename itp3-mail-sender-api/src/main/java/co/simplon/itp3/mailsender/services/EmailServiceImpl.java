package co.simplon.itp3.mailsender.services;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import co.simplon.itp3.mailsender.dtos.SendEmailDto;
import co.simplon.itp3.mailsender.entities.Header;
import co.simplon.itp3.mailsender.repositories.HeaderRepository;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    private HeaderRepository headers;

    public EmailServiceImpl(JavaMailSender javaMailSender,
	    HeaderRepository headers) {
	this.javaMailSender = javaMailSender;
	this.headers = headers;
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

    @Override
    public void getHeaders(HttpServletRequest request) {

	Enumeration<String> headerNames = request
		.getHeaderNames();
	while (headerNames.hasMoreElements()) {
	    Header header = new Header();
	    String headerName = headerNames.nextElement();
	    String headerValue = request
		    .getHeader(headerName);
	    header.setName(headerName);
	    header.setValue(headerValue);

	    this.headers.save(header);

	}

    }
}
