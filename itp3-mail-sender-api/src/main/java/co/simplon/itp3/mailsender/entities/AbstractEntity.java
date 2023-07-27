package co.simplon.itp3.mailsender.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
	return id;
    }

    @SuppressWarnings("unused")
    public void setId(Long id) {
	this.id = id;
    }

}
