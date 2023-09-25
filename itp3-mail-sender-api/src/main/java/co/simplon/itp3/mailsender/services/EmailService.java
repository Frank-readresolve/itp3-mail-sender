package co.simplon.itp3.mailsender.services;

import javax.servlet.http.HttpServletRequest;

import co.simplon.itp3.mailsender.dtos.SendEmailDto;

public interface EmailService {

    void sendSimpleMail(SendEmailDto inputs,
	    HttpServletRequest request);

}
