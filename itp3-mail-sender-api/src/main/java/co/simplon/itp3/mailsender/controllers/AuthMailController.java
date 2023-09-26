package co.simplon.itp3.mailsender.controllers;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.mailsender.dtos.SendAuthEmailDto;
import co.simplon.itp3.mailsender.services.EmailService;

@RestController
@RequestMapping("/send-attached-mail")
public class AuthMailController {
    private final EmailService service;

    public AuthMailController(EmailService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendAuthMail(
	    @Valid @RequestBody SendAuthEmailDto inputs)
	    throws MessagingException {
	this.service.sendAuthMail(inputs);
    }
}
