package co.simplon.itp3.mailsender.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.mailsender.dtos.SendEmailDto;
import co.simplon.itp3.mailsender.services.EmailService;

@RestController
@RequestMapping("/send-mail")
@CrossOrigin
public class MailController {

    private EmailService service;

    public MailController(
	    EmailService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendSimpleMail(
	    @Valid @RequestBody SendEmailDto inputs) {
	this.service.sendSimpleMail(inputs);
    }

}
