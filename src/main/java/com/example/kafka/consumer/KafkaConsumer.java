package com.example.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafka.payload.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

    // @KafkaListener(topics = "Avichal", groupId = "myGroup")
    // public void consumeMsg(String msg) {
    // log.info(String.format("Here is consumed message: %s", msg));

    // }
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "order", groupId = "myGroup")
    public void consumeMsg(Student msg) {
        try {
            String json = objectMapper.writeValueAsString(msg);
            Student student = objectMapper.readValue(json, Student.class);
            log.info("Here is consumed message: {}", student);
        } catch (Exception e) {
            log.error("Failed to convert JSON string to Student object", e);
        }

    }

}
