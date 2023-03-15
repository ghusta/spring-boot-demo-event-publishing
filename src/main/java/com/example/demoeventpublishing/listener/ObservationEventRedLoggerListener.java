package com.example.demoeventpublishing.listener;

import org.springframework.stereotype.Component;

import static com.example.demoeventpublishing.AnsiColorCodes.ANSI_RED;

@Component
public class ObservationEventRedLoggerListener extends ObservationEventColoredLoggerListener {

    @Override
    protected String textAnsiColor() {
        return ANSI_RED;
    }

}
