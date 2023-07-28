package co.simplon.itp3.mailsender.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contact_roles")
public class ContactRole extends AbstractEntity {

    @Column(name = "role_code")
    private String roleCode;
    @Column(name = "contact_name")
    private String contactName;

    public String getRoleCode() {
	return roleCode;
    }

    public void setRoleCode(String roleCode) {
	this.roleCode = roleCode;
    }

    public String getContactName() {
	return contactName;
    }

    public void setContactName(String contactName) {
	this.contactName = contactName;
    }

    @Override
    public String toString() {
	return "{roleCode=" + roleCode + ", contactName="
		+ contactName + "}";
    }

}
