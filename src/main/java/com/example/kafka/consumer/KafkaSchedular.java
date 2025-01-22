package com.example.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kafka.payload.StudentRepository;

@Service
public class KafkaSchedular {

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @Autowired
    private StudentRepository studentRepository;

    // @Scheduled(fixedRate = 60000) // Run every minute
    // public void processMessages() {
    // List<Student> messages = kafkaConsumer.getMessages();
    // studentRepository.saveAll(messages);
    // // for (Student message : messages) {
    // // Student entity = new Student();
    // // entity.setId(message.getId());
    // // entity.setFirstname(message.getFirstname());
    // // entity.setLastname(message.getLastname());

    // // studentRepository.save(entity);
    // // }
    // }

}
