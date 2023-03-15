package com.example.demoeventpublishing.service;

import com.example.demoeventpublishing.event.ObservationAddedEvent;
import com.example.demoeventpublishing.event.ObservationModifiedEvent;
import com.example.demoeventpublishing.event.ObservationPublishedEvent;
import com.example.demoeventpublishing.event.ObservationRemovedEvent;
import com.example.demoeventpublishing.model.Observation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyService {

    private final ApplicationEventPublisher eventPublisher;

    public MyService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void addObservation(Observation observation) {
        log.info("Entering addObservation()...");
        // ...
        eventPublisher.publishEvent(new ObservationAddedEvent(observation));
    }

    public void modifyObservation(Observation observation) {
        log.info("Entering modifyObservation()...");
        // ...
        eventPublisher.publishEvent(new ObservationModifiedEvent(observation));
    }

    public void removeObservation(int observationId) {
        log.info("Entering removeObservation()...");
        // ...
        eventPublisher.publishEvent(new ObservationRemovedEvent(observationId));
    }

    public void publishObservation(int observationId) {
        log.info("Entering publishObservation()...");
        // ...
        Observation observation = new Observation(observationId, null);
        eventPublisher.publishEvent(new ObservationPublishedEvent(observation));
    }

}
