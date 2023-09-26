package co.simplon.itp3.mailsender.services;

import javax.mail.MessagingException;

import co.simplon.itp3.mailsender.dtos.SendAuthEmailDto;
import co.simplon.itp3.mailsender.dtos.SendEmailDto;

public interface EmailService {

    void sendSimpleMail(SendEmailDto inputs);

    void sendAuthMail(SendAuthEmailDto inputs)
	    throws MessagingException;
}
