package com.tothenew.intellimeet.vo;

import java.util.List;

import com.tothenew.intellimeet.domain.Session;

public class IntellimeetVO {

    Long id;
    String intellimeetDate;
    List<Session> sessions;
    String dateCreated;
    String lastUpdated;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getIntellimeetDate() {
        return intellimeetDate;
    }

    public void setIntellimeetDate(String intellimeetDate) {
        this.intellimeetDate = intellimeetDate;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "IntellimeetVO{" +
                "id=" + id +
                ", intellimeetDate='" + intellimeetDate + '\'' +
                ", sessions=" + sessions +
                ", dateCreated='" + dateCreated + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
