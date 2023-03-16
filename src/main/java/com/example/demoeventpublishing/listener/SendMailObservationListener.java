package com.example.demoeventpublishing.listener;

import com.example.demoeventpublishing.event.ObservationAddedEvent;
import com.example.demoeventpublishing.event.ObservationEvent;
import com.example.demoeventpublishing.event.ObservationPublishedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * NOTE: {@link org.springframework.scheduling.annotation.EnableAsync @EnableAsync} must be configured
 * if using {@link Async @Async}.
 */
@Component
@Slf4j
public class SendMailObservationListener {

    private final JavaMailSender mailSender;

    public SendMailObservationListener(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

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
        log.debug("Sending a mail async... ({}) (in {})", subject, Thread.currentThread().getName());
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("admin@test.com");
        simpleMailMessage.setReplyTo("no-reply@test.com");
        simpleMailMessage.setTo("bob@test.com");
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText("Hello !👋\n\n" +
                "👀 Observation #" + observationEvent.getObservation().id()
                + " got " + observationEvent.getClass().getSimpleName());
        try {
            mailSender.send(simpleMailMessage);
            log.debug("Mail sent (in {})", Thread.currentThread().getName());
        } catch (MailException e) {
            log.error(e.getMessage());
        }
    }

}
