package io.java_core.day2.model;

public class Notification {
    private String id;
    private String message;
    private String recepient;

    public Notification(String id, String message, String recepient) {
        this.id = id;
        this.message = message;
        this.recepient = recepient;
    }

    public String getMessage() {
        return message;
    }

    public String getRecepient() {
        return recepient;
    }
}
