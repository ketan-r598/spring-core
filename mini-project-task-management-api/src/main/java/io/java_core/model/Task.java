package io.java_core.model;

public record Task(String id, String title, String description, TaskStatus status) {}