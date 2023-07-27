package co.simplon.itp3.mailsender.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_roles")
public class ContactRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "contact_role")
    private String contactRole;
    @Column(name = "contact_name")
    private String contactName;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getContactRole() {
	return contactRole;
    }

    public void setContactRole(String codeRole) {
	this.contactRole = codeRole;
    }

    public String getContactName() {
	return contactName;
    }

    public void setContactName(String codeName) {
	this.contactName = codeName;
    }

    @Override
    public String toString() {
	return "{id=" + id + ", codeRole=" + contactRole
		+ ", codeName=" + contactName + "}";
    }

}
