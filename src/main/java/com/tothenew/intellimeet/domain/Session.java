package com.tothenew.intellimeet.domain;

import com.fasterxml.jackson.annotation.*;
import com.tothenew.intellimeet.constants.IntellimeetConstants;
import com.tothenew.intellimeet.enums.SessionStat;
import groovy.transform.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "session")
@EqualsAndHashCode
public class Session implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Date dateCreated;
    Date lastUpdated;

    @OneToOne
    Topic topic;

    @OneToOne
    Paper paper;

    @OneToOne
    Schedule schedule;


    @ElementCollection
    @CollectionTable(name = "session_presenters", joinColumns = @JoinColumn(name = "session_id"))
    List<String> presenters;

    Boolean isAddedInIntellimeet = false;

    @Enumerated(EnumType.STRING)
    SessionStat sessionStat;

    @OneToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    Intellimeet intellimeet;

    public Intellimeet getIntellimeet() {
        return intellimeet;
    }

    public void setIntellimeet(Intellimeet intellimeet) {
        this.intellimeet = intellimeet;
    }

    @PrePersist
    public void onCreate() {
        dateCreated = new Date();
        lastUpdated = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        lastUpdated = new Date();
    }

    public SessionStat getSessionStat() {
        return sessionStat;
    }

    public void setSessionStat(SessionStat sessionStat) {
        this.sessionStat = sessionStat;
    }

    @JsonFormat(pattern = IntellimeetConstants.INTELLIMEET_DISPLAY_DATE_FORMAT)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @JsonFormat(pattern = IntellimeetConstants.INTELLIMEET_DISPLAY_DATE_FORMAT)
    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<String> getPresenters() {
        return presenters;
    }

    public void setPresenters(List<String> presenters) {
        if (this.getPresenters() == null) {
            this.presenters = new ArrayList<String>();
        }
        this.presenters.addAll(presenters);
    }

    public void setPresenter(String presenter) {
        if (this.getPresenters() == null) {
            this.presenters = new ArrayList<String>();
        }
        this.presenters.add(presenter);
    }

    public void removePresenter(String presenter) {
        this.presenters.remove(presenter);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Boolean getIsAddedInIntellimeet() {
        return isAddedInIntellimeet;
    }

    public void setIsAddedInIntellimeet(Boolean isAddedInIntellimeet) {
        this.isAddedInIntellimeet = isAddedInIntellimeet;
    }

    public Boolean hasScheduled() {
        return this.getSessionStat() == SessionStat.SCHEDULED;
    }

    public Session clone() {
        Session session = new Session();
        session.setTopic(topic);
        session.setPaper(paper);
        session.setPresenter(paper.getTopic().getOwner());
        session.setSessionStat(SessionStat.CURRENT_MONTH);
        session.onCreate();
        return session;
    }

    @Override
    public String toString() {
        return "Session [id=" + id + ", topic=" + topic + ", paper=" + paper
                + ", schedule=" + schedule + ", presenters=" + presenters
                + ", isAddedInIntellimeet=" + isAddedInIntellimeet + "]";
    }
}
