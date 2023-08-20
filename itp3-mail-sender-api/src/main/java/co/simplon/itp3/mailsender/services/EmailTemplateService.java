package co.simplon.itp3.mailsender.services;

import co.simplon.itp3.mailsender.dtos.EmailTemplateDto;

public interface EmailTemplateService {

    void update(Long id, EmailTemplateDto inputs);
}
