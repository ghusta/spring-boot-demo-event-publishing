package com.example.demoeventpublishing.event;


/**
 * Event : <i>Observation Removed</i>.
 */
public class ObservationRemovedEvent extends ObservationEvent {

    private int observationId;

    public ObservationRemovedEvent(int observationId) {
        super(null);
        this.observationId = observationId;
    }

}
