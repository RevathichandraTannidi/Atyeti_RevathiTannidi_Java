package org.atyeti.trafficManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class TrafficEvent {
    @Id @GeneratedValue
    private Long id;
    private String type;
    private String direction;
    private String value;
    private LocalDateTime timestamp = LocalDateTime.now();

public TrafficEvent()
{

}
    public TrafficEvent(String type, String direction, String value) {
        this.type = type;
        this.direction = direction;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}