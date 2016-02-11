package com.tothenew.intellimeet.enums;

public enum SessionStat {
    SCHEDULED("Scheduled"), NOT_SCHEDULED("Not Scheduled"), CURRENT_MONTH("Current Month");

    String value;

    SessionStat(String value) {
        this.value = value;
    }

    public static SessionStat getSessionStat(String value) throws IllegalArgumentException {
        for (SessionStat sessionStat : SessionStat.values()) {
            if (sessionStat.value.equalsIgnoreCase(value)) {
                return sessionStat;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
