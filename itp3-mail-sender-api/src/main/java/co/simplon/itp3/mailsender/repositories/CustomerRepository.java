package co.simplon.itp3.mailsender.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.simplon.itp3.mailsender.dtos.CustomersList;
import co.simplon.itp3.mailsender.entities.Customer;

public interface CustomerRepository
	extends JpaRepository<Customer, Long> {

    boolean existsByContactEmail(String string);

    boolean existsByCustomerName(String string);

    @Query(value = "SELECT nextval('customers_customer_number_seq')", nativeQuery = true)
    public int getNextValMySequence();

    @Query(value = "SELECT c.id AS id, c.customerNumber AS number, c.customerName AS name, c.contactEmail AS email, cr.contactRoleName AS roleName, s.subscriptionName AS subscriptionName "
	    + "FROM Customer c JOIN c.contactRole cr JOIN c.subscriptionId s")
    Collection<CustomersList> getCustomerItems();

}
