package co.simplon.itp3.mailsender.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.mailsender.dtos.SendEmailDto;
import co.simplon.itp3.mailsender.services.EmailService;

@RestController
@RequestMapping("/send-mail")
public class MailController {

    private final EmailService service;

    public MailController(EmailService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendSimpleMail(HttpServletRequest request,
	    @Valid @RequestBody SendEmailDto inputs) {
	this.service.getHeaders(request);
	this.service.sendSimpleMail(inputs);
    }

}
