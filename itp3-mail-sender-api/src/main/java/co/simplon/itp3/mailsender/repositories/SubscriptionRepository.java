package co.simplon.itp3.mailsender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.simplon.itp3.mailsender.entities.Subscription;

public interface SubscriptionRepository
	extends JpaRepository<Subscription, Long> {

    boolean existsBySubscriptionName(String string);

    @Query(value = "SELECT nextval('subscriptions_subscription_code_seq')", nativeQuery = true)
    public Long getNextValMySequence();

}
