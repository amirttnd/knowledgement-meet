package com.tothenew.intellimeet.enums;

public enum TopicType {
    HYGIENE("Hygiene"), ADVANCED("Advanced");

    String value;

    TopicType(String value) {
        this.value = value;
    }

    public TopicType getTopic(String value) {
        for (TopicType topicType : TopicType.values()) {
            if (topicType.value == value) {
                return topicType;
            }
        }
        return null;
    }
}
