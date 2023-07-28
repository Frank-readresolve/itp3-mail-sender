package co.simplon.itp3.mailsender.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.mailsender.dtos.CreateSubscriptionDto;
import co.simplon.itp3.mailsender.services.SubscriptionService;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private SubscriptionService service;

    public SubscriptionController(
	    SubscriptionService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(
	    @Valid @RequestBody CreateSubscriptionDto inputs) {
	service.create(inputs);
    }

}
