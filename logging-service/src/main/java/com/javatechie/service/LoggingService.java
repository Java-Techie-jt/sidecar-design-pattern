package com.javatechie.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

@Service
public class LoggingService {

    private static final Logger log = LoggerFactory.getLogger(LoggingService.class);

    public LoggingService() {
        log.info("LoggingService initialized..");
    }

    public static final String LOG_FILE_PATH = "/logs/book-service.log";

    @Scheduled(fixedRate = 60000)
    public void processLog() {

        log.info("LoggingService scheduler triggered {}", new Date());
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_PATH))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Simulate pushing logs to a centralized system
                //-> splunk , ELK , ES
                log.info("Processing log: {}", line);
            }

        } catch (IOException e) {
            log.error("error {}", e.getMessage());
        }
    }
}
