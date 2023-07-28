package co.simplon.itp3.mailsender.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subscriptions")
public class Subscription extends AbstractEntity {

    @Column(name = "subscription_code")
    private String subscriptionCode;

    @Column(name = "subscription_name")
    private String subscriptionName;

    @Column(name = "description")
    private String description;

    @Column(name = "free_subscription")
    private boolean freeSubscription;

    @Column(name = "duration_in_months")
    private Short durationInMonths;

    @Column(name = "max_mail_num")
    private int maxMailNum;

    public String getSubscriptionCode() {
	return subscriptionCode;
    }

    public void setSubscriptionCode(
	    String subscriptionCode) {
	this.subscriptionCode = subscriptionCode;
    }

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
	return "{subscriptionCode=" + subscriptionCode
		+ ", subscriptionName=" + subscriptionName
		+ ", description=" + description
		+ ", freeSubscription=" + freeSubscription
		+ ", durationInMonths=" + durationInMonths
		+ ", maxMailNum=" + maxMailNum + "}";
    }

}
