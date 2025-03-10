package com.example.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.kafka.payload.Student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Student> kafkaTemplate;
    // private final ObjectMapper objectMapper;

    public void sendMessage(Student student) {
        // try {
        // String studentJson = objectMapper.writeValueAsString(student);
        log.info("Sending message: {}", student);
        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "order")
                .build();

        kafkaTemplate.send(message);
        // }
    }

}
