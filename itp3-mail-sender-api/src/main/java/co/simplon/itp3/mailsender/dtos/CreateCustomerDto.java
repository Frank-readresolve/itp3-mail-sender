package co.simplon.itp3.mailsender.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateCustomerDto {

    @NotBlank
    @Size(max = 100)
    private String firstName;
    @NotBlank
    @Size(max = 100)
    private String lastName;
    @Email
    @NotNull
    @Size(max = 256)
    private String contactEmail;
    @NotNull
    private Boolean marketingConsent;
    @NotBlank
    @Size(max = 100)
    private String customerName;

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

    @Override
    public String toString() {
	return "{firstName=" + firstName + ", lastName="
		+ lastName + ", contactEmail="
		+ contactEmail + ", marketingConsent="
		+ marketingConsent + ", customerName="
		+ customerName + "}";
    }

}
