package co.simplon.itp3.mailsender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.itp3.mailsender.entities.Subscription;

public interface SubscriptionRepository
	extends JpaRepository<Subscription, Long> {

    boolean existsBySubscriptionName(String string);

}
