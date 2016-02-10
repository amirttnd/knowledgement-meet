package com.tothenew.intellimeet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tothenew.intellimeet.constants.IntellimeetConstants;
import com.tothenew.intellimeet.util.DateUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "intellimeet")
public class Intellimeet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Timestamp intellimeetDate;

    Date dateCreated;
    Date lastUpdated;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "intellimeet_sessions", joinColumns = @JoinColumn(name = "intellimeet_id"))
    @JsonManagedReference
    List<Session> sessions;

    Boolean isDefaultDateChanged;

    @PrePersist
    protected void onCreate() {
        dateCreated = new Date();
        lastUpdated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdated = new Date();
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Boolean getIsDefaultDateChanged() {
        return isDefaultDateChanged;
    }

    public void setIsDefaultDateChanged(Boolean isDefaultDateChanged) {
        this.isDefaultDateChanged = isDefaultDateChanged;
    }

    @JsonFormat(pattern = IntellimeetConstants.INTELLIMEET_DISPLAY_DATE_FORMAT)
    public Date getDateCreated() {
        return dateCreated;
    }

    @JsonFormat(pattern = IntellimeetConstants.INTELLIMEET_DISPLAY_DATE_FORMAT)
    public Date getLastUpdated() {
        return lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public String getIntellimeetDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(IntellimeetConstants.INTELLIMEET_DISPLAY_DATE_FORMAT);
        return simpleDateFormat.format(intellimeetDate);
    }

    public Date getIntellimeetDateInstance() {
        return intellimeetDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSession(Session session) {
        if (this.sessions == null) {
            this.sessions = new ArrayList<Session>();
        }
        this.sessions.add(session);
    }

    public void setSessions(List<Session> sessions) {
        if (this.sessions == null) {
            this.sessions = new ArrayList<Session>();
        }
        this.sessions.addAll(sessions);
    }

    public Boolean removeSession(Session session) {
        if (this.sessions != null) {
            return this.sessions.remove(session);
        }
        return false;
    }

    public void setIntellimeetDate(Timestamp intellimeetDate) {
        this.intellimeetDate = intellimeetDate;
    }

    public Boolean isExpire() {
        return intellimeetDate.before(DateUtil.toTimestamp(DateUtil.converInDDMMYYYformat(new Date())));
    }

    public boolean isDefaultIntellimeetDateChange() {
        Timestamp lastSaturday = DateUtil.toTimestamp(DateUtil
                .getLastSaturdayOfIntellimeet());
        return !(DateUtil.getMonth(intellimeetDate) == DateUtil.getMonth(lastSaturday) && DateUtil.getDay(intellimeetDate) == DateUtil.getDay(lastSaturday));
    }

    @Override
    public String toString() {
        return "Intellimeet{" +
                "id=" + id +
                ", intellimeetDate=" + intellimeetDate +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", sessions=" + sessions +
                ", isDefaultDateChanged=" + isDefaultDateChanged +
                '}';
    }
}
