package com.tothenew.intellimeet.model;

public class PaperModel {
	String agenda;
	String givenBy;
	String topicName;
	String topicType;

	public String getTopicType() {
		return topicType;
	}

	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public String getGivenBy() {
		return givenBy;
	}

	public void setGivenBy(String givenBy) {
		this.givenBy = givenBy;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	@Override
	public String toString() {
		return "PaperModel [agenda=" + agenda + ", givenBy=" + givenBy
				+ ", topicName=" + topicName + ", topicType=" + topicType + "]";
	}

}
