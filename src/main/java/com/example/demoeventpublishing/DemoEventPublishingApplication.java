package com.example.demoeventpublishing;

import com.example.demoeventpublishing.model.Observation;
import com.example.demoeventpublishing.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * See also :
 * <ul>
 *     <li><a href="https://stackoverflow.com/questions/46792838/spring-command-line-app-hangs-after-async-method-calls-complete">Spring Command Line App hangs after Async method calls complete</a></li>
 * </ul>
 */
@SpringBootApplication
@EnableAsync
@Slf4j
public class DemoEventPublishingApplication implements CommandLineRunner {

    private final MyService myService;

    public DemoEventPublishingApplication(MyService myService) {
        this.myService = myService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoEventPublishingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Running the app...");
        myService.addObservation(new Observation(555, "Nothing interesting 😴"));
        myService.publishObservation(132);
        myService.removeObservation(132);
    }
}
