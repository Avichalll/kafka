package com.example.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafka.payload.Student;

import lombok.extern.slf4j.Slf4j;

// @RestController
@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "Avichal", groupId = "studentGroup")
    public void consumeMsg(String msg) {
        log.info(String.format("Here is consumed message: %s", msg));
    }

    // private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "order", groupId = "studentGroup")
    public void consumeMsg(Student student) {
        try {

            log.info("Raw message received: {}", student);
            // String studentjson = objectMapper.writeValueAsString(msg);
            // Student studentJson = objectMapper.readValue(student, Student.class);
            // log.info("Here is consumed message: {}", student);

        } catch (Exception e) {
            log.error("Failed to convert JSON string to Student object", e);
        }

    }

}
