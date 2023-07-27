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
    @Column(name = "code_role")
    private String codeRole;
    @Column(name = "code_name")
    private String codeName;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

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
	return "{id=" + id + ", codeRole=" + codeRole
		+ ", codeName=" + codeName + "}";
    }

}
