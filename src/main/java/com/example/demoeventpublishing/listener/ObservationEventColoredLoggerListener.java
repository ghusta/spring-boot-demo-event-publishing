package com.example.demoeventpublishing.listener;

import com.example.demoeventpublishing.event.ObservationAddedEvent;
import com.example.demoeventpublishing.event.ObservationEvent;
import com.example.demoeventpublishing.event.ObservationModifiedEvent;
import com.example.demoeventpublishing.event.ObservationPublishedEvent;
import com.example.demoeventpublishing.event.ObservationRemovedEvent;
import org.springframework.context.event.EventListener;

import static com.example.demoeventpublishing.AnsiColorCodes.ANSI_RESET;

public abstract class ObservationEventColoredLoggerListener {

    /**
     * Pick in {@link com.example.demoeventpublishing.AnsiColorCodes}
     */
    protected abstract String textAnsiColor();

    @EventListener(classes = ObservationEvent.class)
    protected void handleObservationEvent(ObservationEvent observationEvent) {
        if (observationEvent instanceof ObservationAddedEvent) {
            System.out.println(coloredMessage("It's a ObservationAddedEvent... Content is : " + observationEvent.getObservation().title()));
        } else if (observationEvent instanceof ObservationModifiedEvent) {
            System.out.println(coloredMessage("It's a ObservationModifiedEvent !"));
        } else if (observationEvent instanceof ObservationPublishedEvent) {
            System.out.println(coloredMessage("It's a ObservationPublishedEvent !"));
        } else if (observationEvent instanceof ObservationRemovedEvent) {
            System.out.println(coloredMessage("It's a ObservationRemovedEvent !"));
        }
    }

    private String coloredMessage(String message) {
        return textAnsiColor() + message + ANSI_RESET;
    }

}
