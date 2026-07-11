package io.java_core.model;

import java.time.Instant;
import java.time.LocalTime;
import java.util.UUID;

public class AuditEntry {

    private final String instanceId;
    private final String timestamp;

    public AuditEntry() {
        instanceId = UUID.randomUUID().toString();
        timestamp = Instant.from(LocalTime.now()).toString();
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "AuditEntry{" +
                "instanceId=" + instanceId +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
