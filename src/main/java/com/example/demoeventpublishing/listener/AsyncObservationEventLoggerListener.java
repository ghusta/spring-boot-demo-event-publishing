package com.example.demoeventpublishing.listener;

import com.example.demoeventpublishing.event.ObservationAddedEvent;
import com.example.demoeventpublishing.event.ObservationEvent;
import com.example.demoeventpublishing.event.ObservationPublishedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncObservationEventLoggerListener {

    private static final String PREFIX_MSG = "ASYNC -- ";

    @Async
    @EventListener(classes = ObservationEvent.class)
    protected void handleObservationEvent(ObservationEvent observationEvent) {
        if (observationEvent instanceof ObservationAddedEvent) {
            System.out.println(PREFIX_MSG + "It's a ObservationAddedEvent !");
        } else if (observationEvent instanceof ObservationPublishedEvent) {
            System.out.println(PREFIX_MSG + "It's a ObservationPublishedEvent !");
        }
    }

}
