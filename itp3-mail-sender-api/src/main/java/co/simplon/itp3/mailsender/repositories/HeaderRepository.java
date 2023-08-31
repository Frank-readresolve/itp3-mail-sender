package co.simplon.itp3.mailsender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.itp3.mailsender.entities.Header;

public interface HeaderRepository
	extends JpaRepository<Header, Long> {

}
