package com.tothenew.intellimeet.model;

public class ScheduleModel {
    String breakFast;
    String sessionCommencement;
    String lunch;
    String discussionAndFeedback;
    String wrapUp;

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


    public static ScheduleModel populateDefaultScheduleModel() {
        ScheduleModel scheduleModel = new ScheduleModel();
        scheduleModel.setBreakFast("9:30 AM");
        scheduleModel.setSessionCommencement("10:00 AM (All)");
        scheduleModel.setLunch("1:00 PM");
        scheduleModel.setDiscussionAndFeedback("5:00 PM (Intra Session)");
        scheduleModel.setWrapUp("5:30 PM (All Session)");
        return scheduleModel;

    }


    @Override
    public String toString() {
        return "ScheduleModel [breakFast=" + breakFast
                + ", sessionCommencement=" + sessionCommencement + ", lunch="
                + lunch + ", discussionAndFeedback=" + discussionAndFeedback
                + ", wrapUp=" + wrapUp + "]";
    }
}
