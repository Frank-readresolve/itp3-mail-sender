package co.simplon.itp3.mailsender.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "marketing_consent")
    private Boolean marketingConsent;

    @Column(name = "customer_number")
    private Long customerNumber;

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

    public String getCustomerName() {
	return customerName;
    }

    public void setCustomerName(String customerName) {
	this.customerName = customerName;
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

    public Long getCustomerNumber() {
	return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
	this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
	return "{firstName=" + firstName + ", lastName="
		+ lastName + ", customerName="
		+ customerName + ", contactEmail="
		+ contactEmail + ", marketingConsent="
		+ marketingConsent + ", customerNumber="
		+ customerNumber + "}";
    }
}
