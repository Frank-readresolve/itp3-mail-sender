package co.simplon.itp3.mailsender.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import co.simplon.itp3.mailsender.customValidations.UniqueSubscriptionName;

public class CreateSubscriptionDto {

    @NotBlank
    @Size(min = 1, max = 100)
    @UniqueSubscriptionName
    private String subscriptionName;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9\\s]+")
    @Size(min = 1, max = 1000)
    private String description;
    @NotNull
    private Boolean freeSubscription;
    @NotNull
    @Min(1)
    @Max(12)
    private Short durationInMonths;
    @NotNull
    @Min(11)
    @Max(1000000)
    private int maxMailNum;

    public String getSubscriptionName() {
	return subscriptionName;
    }

    public void setSubscriptionName(
	    String subscriptionName) {
	this.subscriptionName = subscriptionName;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Boolean getFreeSubscription() {
	return freeSubscription;
    }

    public void setFreeSubscription(
	    Boolean freeSubscription) {
	this.freeSubscription = freeSubscription;
    }

    public Short getDurationInMonths() {
	return durationInMonths;
    }

    public void setDurationInMonths(
	    Short durationInMonths) {
	this.durationInMonths = durationInMonths;
    }

    public int getMaxMailNum() {
	return maxMailNum;
    }

    public void setMaxMailNum(int maxMailNum) {
	this.maxMailNum = maxMailNum;
    }

    @Override
    public String toString() {
	return "{subscriptionName=" + subscriptionName
		+ ", description=" + description
		+ ", freeSubscription=" + freeSubscription
		+ ", durationInMonths=" + durationInMonths
		+ ", maxMailNum=" + maxMailNum + "}";
    }

}
