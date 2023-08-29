package co.simplon.itp3.mailsender.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.mailsender.dtos.EmailTemplateDto;
import co.simplon.itp3.mailsender.services.EmailTemplateService;

@RestController
@RequestMapping("/email-templates")
public class EmailTemplateController {
    private final EmailTemplateService service;

    public EmailTemplateController(
	    EmailTemplateService service) {
	this.service = service;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id,
	    @RequestBody @Valid EmailTemplateDto inputs) {
	service.update(id, inputs);
    }
}
