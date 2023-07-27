package co.simplon.itp3.mailsender.services;

import co.simplon.itp3.mailsender.dtos.AnonymousEmail;

public interface EmailService {

    void sendSimpleMail(AnonymousEmail inputs);
}
