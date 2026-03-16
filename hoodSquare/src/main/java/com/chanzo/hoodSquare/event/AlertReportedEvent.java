package com.chanzo.hoodSquare.event;

public record AlertReportedEvent(String location,
                                 String description, byte[] image) {
}
