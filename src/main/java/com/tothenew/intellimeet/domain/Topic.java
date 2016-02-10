package com.tothenew.intellimeet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tothenew.intellimeet.constants.IntellimeetConstants;
import com.tothenew.intellimeet.enums.TopicType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "topic", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Date dateCreated;
    Date lastUpdated;

    @NotEmpty
    @NotBlank
    String name;

    @NotEmpty
    @NotBlank
    @Email
    String owner;

    String imageSrc;

    @Enumerated(EnumType.STRING)
    TopicType topicType;

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
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

    @JsonFormat(pattern = IntellimeetConstants.INTELLIMEET_DISPLAY_DATE_FORMAT)
    public Date getDateCreated() {
        return dateCreated;
    }

    @JsonFormat(pattern = IntellimeetConstants.INTELLIMEET_DISPLAY_DATE_FORMAT)
    public Date getLastUpdated() {
        return lastUpdated;
    }

    public TopicType getTopicType() {
        return topicType;
    }

    public void setTopicType(TopicType topicType) {
        this.topicType = topicType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }
}
