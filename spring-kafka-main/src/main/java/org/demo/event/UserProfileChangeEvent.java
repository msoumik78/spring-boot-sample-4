package org.demo.event;

import lombok.Data;

@Data
public class UserProfileChangeEvent {
    private String userId;
    private String eventType;
    private String eventDescription;
}
