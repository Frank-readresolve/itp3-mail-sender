package co.simplon.itp3.mailsender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.itp3.mailsender.entities.ContactRole;

public interface ContactRoleRepository
	extends JpaRepository<ContactRole, Long> {

    boolean existsByRoleCode(String string);

    boolean existsByContactRoleName(String string);

}
