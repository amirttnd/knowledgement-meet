package com.tothenew.intellimeet.vo;

import java.util.Set;

public class ScheduleVO {
	Long id;

	String breakFast;
	String sessionCommencement;
	Set<String> lunch;
	String discussionAndFeedback;
	String wrapUp;
	String intellimeetDay;

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

	public Set<String> getLunch() {
		return lunch;
	}

	public void setLunch(Set<String> lunch) {
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

	public String getIntellimeetDay() {
		return intellimeetDay;
	}

	public void setIntellimeetDay(String intellimeetDate) {
		this.intellimeetDay = intellimeetDate;
	}

	@Override
	public String toString() {
		return "ScheduleVO [id=" + id + ", breakFast=" + breakFast
				+ ", sessionCommencement=" + sessionCommencement + ", lunch="
				+ lunch + ", discussionAndFeedback=" + discussionAndFeedback
				+ ", wrapUp=" + wrapUp + "]";
	}
}
