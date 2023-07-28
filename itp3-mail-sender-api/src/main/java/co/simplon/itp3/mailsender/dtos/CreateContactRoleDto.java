package co.simplon.itp3.mailsender.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CreateContactRoleDto {

    @NotBlank
    @Size(min = 1, max = 5)
    @Pattern(regexp = "[A-Z]+")
    private String roleCode;
    @NotBlank
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[a-zA-Z]+")
    private String contactName;

    public String getContactRole() {
	return roleCode;
    }

    public void setContactRole(String contactRole) {
	this.roleCode = contactRole;
    }

    public String getContactName() {
	return contactName;
    }

    public void setContactName(String contactName) {
	this.contactName = contactName;
    }

    @Override
    public String toString() {
	return "{contactRole=" + roleCode + ", contactName="
		+ contactName + "}";
    }

}
