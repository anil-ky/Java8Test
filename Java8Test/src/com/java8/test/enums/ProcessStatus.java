package com.java8.test.enums;

/**
 * This enum holds the process status values.
 *
 * @author Anil Kumar Yellamandala
 * @since 02.02.2021
 */
public enum ProcessStatus {
    TO_BE_PROCESSED("TO_BE_PROCESSED"),
    IN_PROCESSING("IN_PROCESSING"),
    PROCESSED("PROCESSED");

    private String status;

    ProcessStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
