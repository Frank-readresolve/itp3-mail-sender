package co.simplon.itp3.mailsender.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.mailsender.dtos.CreateContactRoleDto;
import co.simplon.itp3.mailsender.services.ContactRoleService;

@RestController
@RequestMapping("/contact-roles")
public class ContactRoleController {

    private final ContactRoleService service;

    public ContactRoleController(
	    ContactRoleService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(
	    @Valid @RequestBody CreateContactRoleDto inputs) {
	service.create(inputs);
    }

}
