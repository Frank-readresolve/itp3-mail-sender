package co.simplon.itp3.mailsender.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contact_roles")
public class ContactRole extends AbstractEntity {

    @Column(name = "code_role")
    private String codeRole;

    @Column(name = "code_name")
    private String codeName;

    public String getCodeRole() {
	return codeRole;
    }

    public void setCodeRole(String codeRole) {
	this.codeRole = codeRole;
    }

    public String getCodeName() {
	return codeName;
    }

    public void setCodeName(String codeName) {
	this.codeName = codeName;
    }

    @Override
    public String toString() {
	return "{codeRole=" + codeRole + ", codeName="
		+ codeName + "}";
    }

}
