package com.example.demoeventpublishing.event;


import com.example.demoeventpublishing.model.Observation;

/**
 * Event : <i>Observation Modified</i>.
 */
public class ObservationModifiedEvent extends ObservationEvent {

    public ObservationModifiedEvent(Observation observation) {
        super(observation);
    }

}
