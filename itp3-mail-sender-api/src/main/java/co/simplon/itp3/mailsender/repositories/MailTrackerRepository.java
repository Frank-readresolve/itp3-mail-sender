package co.simplon.itp3.mailsender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.simplon.itp3.mailsender.entities.MailTracker;

public interface MailTrackerRepository
	extends JpaRepository<MailTracker, Long> {

    @Query("SELECT count(mt) FROM MailTracker mt")
    long countAllEmailSent();

    @Query("SELECT count(mt) FROM MailTracker mt WHERE mt.success = true")
    long countSuccessfullySentMail();

    @Query("SELECT MAX(mt.bodyLength) FROM MailTracker mt")
    long maxBodylength();

    @Query("SELECT MAX(mt.subjectLength) FROM MailTracker mt")
    long maxSubjectlength();
}
