package com.example.demoeventpublishing.listener;

import org.springframework.stereotype.Component;

import static com.example.demoeventpublishing.AnsiColorCodes.ANSI_CYAN;

@Component
public class ObservationEventCyanLoggerListener extends ObservationEventColoredLoggerListener {

    @Override
    protected String textAnsiColor() {
        return ANSI_CYAN;
    }

}
