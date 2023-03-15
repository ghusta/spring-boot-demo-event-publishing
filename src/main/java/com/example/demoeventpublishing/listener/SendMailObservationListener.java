package com.example.demoeventpublishing.listener;

import com.example.demoeventpublishing.event.ObservationAddedEvent;
import com.example.demoeventpublishing.event.ObservationEvent;
import com.example.demoeventpublishing.event.ObservationPublishedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.mail.MailSendException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * NOTE: {@link org.springframework.scheduling.annotation.EnableAsync @EnableAsync} must be configured
 * if using {@link Async @Async}.
 */
@Component
@Slf4j
public class SendMailObservationListener {

    @Async
    @EventListener(classes = ObservationEvent.class)
    protected void handleObservationEvent(ObservationEvent observationEvent) {
        if (observationEvent instanceof ObservationAddedEvent) {
            sendMail("Observation added", observationEvent);
        } else if (observationEvent instanceof ObservationPublishedEvent) {
            sendMail("Observation published", observationEvent);
        } else {
            log.debug("Event not managed ({})", observationEvent.getClass().getName());
        }
    }

    private void sendMail(String subject, ObservationEvent observationEvent) {
        // should end a mail...
        log.debug("Sending a mail... ({}) (in {})", subject, Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new MailSendException(e.getMessage(), e);
        }
        log.debug("Mail sent (in {})", Thread.currentThread().getName());
    }

}
