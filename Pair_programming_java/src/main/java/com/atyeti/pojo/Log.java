package com.atyeti.pojo;

import java.time.LocalDateTime;

public class Log {
    private LocalDateTime timestamp;
    private String loglevel;
    private String message;

    public Log(LocalDateTime timestamp, String loglevel, String message) {
        this.timestamp = timestamp;
        this.loglevel = loglevel;
        this.message = message;
    }

    public Log(String line) {
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getLevel() {
        return loglevel;
    }

    public void setLevel(String level) {
        this.loglevel = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return
                 timestamp +" "+ loglevel + '\'' +
              message ;
    }
}
