package co.simplon.itp3.mailsender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.itp3.mailsender.dtos.EmailTemplateDto;
import co.simplon.itp3.mailsender.entities.EmailTemplate;

public interface EmailTemplateRepository
	extends JpaRepository<EmailTemplate, Long> {

    EmailTemplateDto findProjectedById(Long id);

    boolean existsByTemplateIdentifier(String string);
}
