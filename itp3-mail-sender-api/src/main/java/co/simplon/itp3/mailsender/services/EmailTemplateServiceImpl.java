package co.simplon.itp3.mailsender.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.itp3.mailsender.dtos.EmailTemplateDto;
import co.simplon.itp3.mailsender.entities.EmailTemplate;
import co.simplon.itp3.mailsender.repositories.EmailTemplateRepository;

@Service
@Transactional(readOnly = true)
public class EmailTemplateServiceImpl
	implements EmailTemplateService {

    private final EmailTemplateRepository emailTemplates;

    public EmailTemplateServiceImpl(
	    EmailTemplateRepository emailTemplates) {
	this.emailTemplates = emailTemplates;
    }

    @Override
    @Transactional
    public void update(Long id, EmailTemplateDto inputs) {

	EmailTemplate entity = emailTemplates.findById(id)
		.get();

	entity.setTemplateIdentifier(
		inputs.getTemplateIdentifier());
	entity.setTemplateSubject(
		inputs.getTemplateSubject());
	entity.setTemplateBody(inputs.getTemplateBody());
	this.emailTemplates.save(entity);
    }
}
