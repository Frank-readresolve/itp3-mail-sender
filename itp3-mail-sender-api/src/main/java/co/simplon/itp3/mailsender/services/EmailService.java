package co.simplon.itp3.mailsender.services;

import co.simplon.itp3.mailsender.dtos.SendEmailDto;

public interface EmailService {

    void sendSimpleMail(SendEmailDto inputs);
}
