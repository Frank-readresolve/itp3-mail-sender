package co.simplon.itp3.mailsender.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.itp3.mailsender.dtos.CreateSubscriptionDto;
import co.simplon.itp3.mailsender.entities.Subscription;
import co.simplon.itp3.mailsender.repositories.SubscriptionRepository;

@Service
@Transactional(readOnly = true)
public class SubscriptionServiceImpl
	implements SubscriptionService {

    private final SubscriptionRepository subscriptions;

    public SubscriptionServiceImpl(
	    SubscriptionRepository subscriptions) {
	this.subscriptions = subscriptions;
    }

    @Override
    @Transactional
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
	Long code = this.subscriptions
		.getNextValMySequence();
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
