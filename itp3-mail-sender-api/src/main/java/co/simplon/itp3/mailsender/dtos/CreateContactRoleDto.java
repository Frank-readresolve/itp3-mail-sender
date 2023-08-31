package co.simplon.itp3.mailsender.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import co.simplon.itp3.mailsender.customValidations.UniqueContactRoleName;
import co.simplon.itp3.mailsender.customValidations.UniqueRoleCode;

public class CreateContactRoleDto {

    @NotBlank
    @Size(min = 1, max = 5)
    @Pattern(regexp = "[A-Z]+")
    @UniqueRoleCode
    private String roleCode;

    @NotBlank
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[a-zA-Z]+")
    @UniqueContactRoleName
    private String contactRoleName;

    public CreateContactRoleDto() {
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
