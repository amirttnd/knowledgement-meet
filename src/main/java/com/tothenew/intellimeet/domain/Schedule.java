package com.tothenew.intellimeet.domain;

import com.tothenew.intellimeet.model.ScheduleModel;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String breakFast;
	String sessionCommencement;
	String lunch;
	String discussionAndFeedback;
	String wrapUp;

	public Schedule() {

	}

	public Schedule(ScheduleModel scheduleModel) {
		setSchedule(scheduleModel);
	}

	public void setSchedule(ScheduleModel scheduleModel) {
		this.breakFast = scheduleModel.getBreakFast();
		this.sessionCommencement = scheduleModel.getSessionCommencement();
		this.lunch = scheduleModel.getLunch();
		this.discussionAndFeedback = scheduleModel.getDiscussionAndFeedback();
		this.wrapUp = scheduleModel.getWrapUp();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBreakFast() {
		return breakFast;
	}

	public void setBreakFast(String breakFast) {
		this.breakFast = breakFast;
	}

	public String getSessionCommencement() {
		return sessionCommencement;
	}

	public void setSessionCommencement(String sessionCommencement) {
		this.sessionCommencement = sessionCommencement;
	}

	public String getLunch() {
		return lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	public String getDiscussionAndFeedback() {
		return discussionAndFeedback;
	}

	public void setDiscussionAndFeedback(String discussionAndFeedback) {
		this.discussionAndFeedback = discussionAndFeedback;
	}

	public String getWrapUp() {
		return wrapUp;
	}

	public void setWrapUp(String wrapUp) {
		this.wrapUp = wrapUp;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", breakFast=" + breakFast
				+ ", sessionCommencement=" + sessionCommencement + ", lunch="
				+ lunch + ", discussionAndFeedback=" + discussionAndFeedback
				+ ", wrapUp=" + wrapUp + "]";
	}

}
