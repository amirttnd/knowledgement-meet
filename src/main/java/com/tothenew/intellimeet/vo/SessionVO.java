package com.tothenew.intellimeet.vo;

import com.tothenew.intellimeet.domain.Intellimeet;
import com.tothenew.intellimeet.domain.Paper;
import com.tothenew.intellimeet.domain.Schedule;
import com.tothenew.intellimeet.domain.Topic;
import com.tothenew.intellimeet.enums.SessionStat;

import java.util.Date;
import java.util.List;

public class SessionVO {
    Long id;

    Topic topic;
    Paper paper;
    String dateCreated;
    String lastUpdated;
    List<String> presenters;
    Intellimeet intellimeet;

    Boolean isAddedInIntellimeet = false;

    Schedule schedule;
    SessionStat sessionStat;


    public Intellimeet getIntellimeet() {
        return intellimeet;
    }

    public void setIntellimeet(Intellimeet intellimeet) {
        this.intellimeet = intellimeet;
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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<String> getPresenters() {
        return presenters;
    }

    public void setPresenters(List<String> presenters) {
        this.presenters = presenters;
    }

    public Boolean getIsAddedInIntellimeet() {
        return isAddedInIntellimeet;
    }

    public void setIsAddedInIntellimeet(Boolean isAddedInIntellimeet) {
        this.isAddedInIntellimeet = isAddedInIntellimeet;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public SessionStat getSessionStat() {
        return sessionStat;
    }

    public void setSessionStat(SessionStat sessionStat) {
        this.sessionStat = sessionStat;
    }
}
