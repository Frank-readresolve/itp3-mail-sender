package co.simplon.itp3.mailsender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.itp3.mailsender.entities.Customer;

public interface CustomerRepository
	extends JpaRepository<Customer, Long> {

    boolean existsByContactEmail(String string);

}
