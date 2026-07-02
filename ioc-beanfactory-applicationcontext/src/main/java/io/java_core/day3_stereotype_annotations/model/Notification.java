package io.java_core.day3_stereotype_annotations.model;


public class Notification {
    private String id;
    private String message;
    private String recipient;

    public Notification(String id, String message, String recipient) {
        this.id = id;
        this.message = message;
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public String getRecipient() {
        return recipient;
    }
}
