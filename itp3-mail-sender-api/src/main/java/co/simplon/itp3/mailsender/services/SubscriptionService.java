package co.simplon.itp3.mailsender.services;

import co.simplon.itp3.mailsender.dtos.CreateSubscriptionDto;

public interface SubscriptionService {

    void create(CreateSubscriptionDto inputs);
}
