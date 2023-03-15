package com.example.demoeventpublishing.event;

import com.example.demoeventpublishing.model.Observation;

/**
 * @see org.springframework.context.ApplicationEvent
 */
public abstract class ObservationEvent {

    private final Observation observation;

    protected ObservationEvent(Observation observation) {
        this.observation = observation;
    }

    public Observation getObservation() {
        return observation;
    }
}
