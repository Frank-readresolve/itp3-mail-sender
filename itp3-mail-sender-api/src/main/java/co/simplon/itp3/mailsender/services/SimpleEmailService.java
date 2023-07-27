package co.simplon.itp3.mailsender.services;

import co.simplon.itp3.mailsender.dtos.SimpleMailDto;

public interface SimpleEmailService {

    void sendSimpleMail(SimpleMailDto inputs);
}
