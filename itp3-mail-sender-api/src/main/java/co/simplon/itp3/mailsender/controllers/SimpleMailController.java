package co.simplon.itp3.mailsender.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.mailsender.dtos.SimpleMailDto;
import co.simplon.itp3.mailsender.services.SimpleEmailService;

@RestController
@RequestMapping("/send-mail")
@CrossOrigin
public class SimpleMailController {

    private SimpleEmailService service;

    public SimpleMailController(
	    SimpleEmailService service) {

    }

    public void sendSimpleMail(
	    @Valid @RequestBody SimpleMailDto inputs) {
	service.sendSimpleMail(inputs);
    }

}
