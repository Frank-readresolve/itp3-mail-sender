package co.simplon.itp3.mailsender.services;

import org.springframework.stereotype.Service;

import co.simplon.itp3.mailsender.dtos.CreateSubscriptionDto;
import co.simplon.itp3.mailsender.entities.Subscription;
import co.simplon.itp3.mailsender.repositories.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl
	implements SubscriptionService {

    private SubscriptionRepository subscriptions;

    public SubscriptionServiceImpl(
	    SubscriptionRepository subscriptions) {
	this.subscriptions = subscriptions;
    }

    @Override
    public void create(CreateSubscriptionDto inputs) {
	Subscription subscription = new Subscription();
	subscription.setSubscriptionName(
		inputs.getSubscriptionName());
	subscription
		.setDescription(inputs.getDescription());
	subscription.setFreeSubscription(
		inputs.getFreeSubscription());
	subscription.setDurationInMonths(
		inputs.getDurationInMonths());
	subscription.setMaxMailNum(inputs.getMaxMailNum());
	Long code = this.subscriptions.count() + 1;
	subscription.setSubscriptionCode(
		"CD".concat(code.toString()));
	this.subscriptions.save(subscription);
    }

    @Override
    public boolean subscriptionNameValueExist(
	    String subscriptionName)
	    throws UnsupportedOperationException {
	return this.subscriptions.existsBySubscriptionName(
		subscriptionName.toString());
    }

}
