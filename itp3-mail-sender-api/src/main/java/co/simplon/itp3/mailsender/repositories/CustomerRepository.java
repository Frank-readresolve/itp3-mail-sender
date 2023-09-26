package co.simplon.itp3.mailsender.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.simplon.itp3.mailsender.dtos.CustomerView;
import co.simplon.itp3.mailsender.entities.Customer;

public interface CustomerRepository
	extends JpaRepository<Customer, Long> {

    boolean existsByContactEmail(String string);

    boolean existsByCustomerName(String string);

    @Query(value = "SELECT nextval('customers_customer_number_seq')", nativeQuery = true)
    public int getNextValMySequence();

    Optional<CustomerView> findByCustomerNumber(
	    Long valueOf);
}
