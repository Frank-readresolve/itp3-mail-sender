package co.simplon.itp3.mailsender.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import co.simplon.itp3.mailsender.customValidations.EmailValueDifferent;
import co.simplon.itp3.mailsender.customValidations.UniqueCustomerName;
import co.simplon.itp3.mailsender.customValidations.UniqueEmail;

@EmailValueDifferent(field = "contactEmail", fieldMatch = "fromReplyTo")
public class CreateCustomerDto {

    @NotBlank
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[a-zA-Z]+")
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[a-zA-Z]+")
    private String lastName;

    @Email
    @NotBlank
    @Size(min = 1, max = 256)
    @UniqueEmail
    private String contactEmail;
    @NotNull
    private Boolean marketingConsent;

    @NotBlank
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[a-zA-Z_0-9]+")
    @UniqueCustomerName
    private String customerName;

    @NotBlank
    @Email
    @Size(min = 1, max = 256)
    private String fromReplyTo;

    @NotNull
    private Long roleId;

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getContactEmail() {
	return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
	this.contactEmail = contactEmail;
    }

    public Boolean getMarketingConsent() {
	return marketingConsent;
    }

    public void setMarketingConsent(
	    Boolean marketingConsent) {
	this.marketingConsent = marketingConsent;
    }

    public String getCustomerName() {
	return customerName;
    }

    public void setCustomerName(String customerName) {
	this.customerName = customerName;
    }

    public String getFromReplyTo() {
	return fromReplyTo;
    }

    public void setFromReplyTo(String fromReplyTo) {
	this.fromReplyTo = fromReplyTo;
    }

    public Long getRoleId() {
	return roleId;
    }

    public void setRoleId(Long roleId) {
	this.roleId = roleId;
    }

    @Override
    public String toString() {
	return "{firstName=" + firstName + ", lastName="
		+ lastName + ", contactEmail="
		+ contactEmail + ", marketingConsent="
		+ marketingConsent + ", customerName="
		+ customerName + ", fromReplyTo="
		+ fromReplyTo + ", roleId=" + roleId + "}";
    }

}
