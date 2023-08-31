package co.simplon.itp3.mailsender.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contact_roles")
public class ContactRole extends AbstractEntity {

    @Column(name = "role_code")
    private String roleCode;
    @Column(name = "contact_role_name")
    private String contactRoleName;

    public ContactRole() {
    }

    public String getRoleCode() {
	return roleCode;
    }

    public void setRoleCode(String roleCode) {
	this.roleCode = roleCode;
    }

    public String getContactRoleName() {
	return contactRoleName;
    }

    public void setContactRoleName(String contactRoleName) {
	this.contactRoleName = contactRoleName;
    }

    @Override
    public String toString() {
	return "{roleCode=" + roleCode
		+ ", contactRoleName=" + contactRoleName
		+ "}";
    }

}
