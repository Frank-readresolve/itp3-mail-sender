package co.simplon.itp3.mailsender.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contact_roles")
public class ContactRole extends AbstractEntity {

    @Column(name = "contact_role")
    private String contactRole;
    @Column(name = "contact_name")
    private String contactName;

    public String getContactRole() {
	return contactRole;
    }

    public void setContactRole(String contactRole) {
	this.contactRole = contactRole;
    }

    public String getContactName() {
	return contactName;
    }

    public void setContactName(String contactName) {
	this.contactName = contactName;
    }

    @Override
    public String toString() {
	return "{contactRole=" + contactRole
		+ ", contactName=" + contactName + "}";
    }

}
