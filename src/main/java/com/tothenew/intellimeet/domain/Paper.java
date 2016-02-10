package com.tothenew.intellimeet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tothenew.intellimeet.constants.IntellimeetConstants;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "paper")
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Date dateCreated;
    Date lastUpdated;

    @NotBlank
    @NotNull
    @Column(columnDefinition = "text")
    String agenda;

    @NotBlank
    @NotNull
    @Email
    String givenBy;

    Boolean deleted = false;

    @OneToOne
    Topic topic;


    @PrePersist
    protected void onCreate() {
        dateCreated = new Date();
        lastUpdated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdated = new Date();
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public void setGivenBy(String givenBy) {
        this.givenBy = givenBy;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public String getAgenda() {
        return agenda;
    }

    public String getGivenBy() {
        return givenBy;

    }

    public Topic getTopic() {
        return topic;
    }

    @JsonFormat(pattern = IntellimeetConstants.INTELLIMEET_DISPLAY_DATE_FORMAT)
    public Date getDateCreated() {
        return dateCreated;
    }

    @JsonFormat(pattern = IntellimeetConstants.INTELLIMEET_DISPLAY_DATE_FORMAT)
    public Date getLastUpdated() {
        return lastUpdated;
    }
}
