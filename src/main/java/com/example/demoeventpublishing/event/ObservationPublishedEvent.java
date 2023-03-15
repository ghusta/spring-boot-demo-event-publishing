package com.example.demoeventpublishing.event;


import com.example.demoeventpublishing.model.Observation;

/**
 * Event : <i>Observation Published</i>.
 */
public class ObservationPublishedEvent extends ObservationEvent {

    public ObservationPublishedEvent(Observation observation) {
        super(observation);
    }

}
