package com.example.kafka.restcontorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.producer.Kafkaproducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    @Autowired
    private final Kafkaproducer kafkaproducer;

    @PostMapping("/msg")
    public ResponseEntity<String> postMethodName(@RequestBody String messsage) {
        kafkaproducer.sendMessage(messsage);
        return new ResponseEntity<>("message send successfully", HttpStatus.OK);
    }

}
