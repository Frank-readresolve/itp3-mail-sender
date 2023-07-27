package co.simplon.itp3.mailsender.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CreateContactRoleDto {

    @NotBlank
    @Size(min = 1, max = 5)
    @Pattern(regexp = "[A-Z]+")
    private String codeRole;
    @NotBlank
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[a-zA-Z]+")
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
