package com.myapp.training_backend.config;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class LoggerConfig {

    @PostConstruct
    public void configureAssignmentLogger() {
        // Получаем логгер Logback (а не SLF4J-интерфейс)
        Logger logger = (Logger) LoggerFactory.getLogger("com.myapp.training_backend.transit.ExcelService");

        // Настройка encoder
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(logger.getLoggerContext());
        encoder.setCharset(StandardCharsets.UTF_8);
        encoder.setPattern("%d{yyyy-MM-dd HH:mm:ss} %-5level - %msg%n");
        encoder.start();

        // Настройка appender
        FileAppender<ILoggingEvent> fileAppender = new FileAppender<>();
        fileAppender.setContext(logger.getLoggerContext());
        fileAppender.setName("ASSIGNMENT_FILE");
        fileAppender.setFile("assignment-log.log");
        fileAppender.setEncoder(encoder);
        fileAppender.setAppend(true);
        fileAppender.start();

        // Применение appender только к этому логгеру
        logger.detachAndStopAllAppenders();
        logger.addAppender(fileAppender);
        logger.setAdditive(false); // чтобы не дублировать в root-лог
    }
}

