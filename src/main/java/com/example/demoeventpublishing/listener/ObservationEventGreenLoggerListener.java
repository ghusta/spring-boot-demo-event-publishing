package com.example.demoeventpublishing.listener;

import org.springframework.stereotype.Component;

import static com.example.demoeventpublishing.AnsiColorCodes.ANSI_GREEN;

@Component
public class ObservationEventGreenLoggerListener extends ObservationEventColoredLoggerListener {

    @Override
    protected String textAnsiColor() {
        return ANSI_GREEN;
    }

}
