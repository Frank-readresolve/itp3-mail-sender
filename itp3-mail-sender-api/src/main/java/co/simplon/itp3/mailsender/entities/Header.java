package co.simplon.itp3.mailsender.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "headers")
public class Header extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "value_header")
    private String value;

    @JoinColumn(name = "mail_tracker_id")
    @ManyToOne
    private MailTracker mailTracker;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

    public MailTracker getMailTracker() {
	return mailTracker;
    }

    public void setMailTracker(MailTracker mailTracker) {
	this.mailTracker = mailTracker;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", value=" + value
		+ ", mailTracker=" + mailTracker + "}";
    }

}
