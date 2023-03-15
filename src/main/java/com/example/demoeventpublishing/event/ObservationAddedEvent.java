package com.example.demoeventpublishing.event;


import com.example.demoeventpublishing.model.Observation;

/**
 * Event : <i>Observation Added</i>.
 */
public class ObservationAddedEvent extends ObservationEvent {

    public ObservationAddedEvent(Observation observation) {
        super(observation);
    }

}
