package com.example.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.payload.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Service
@Slf4j
public class KafkaConsumer {

    // @KafkaListener(topics = "Avichal", groupId = "myGroup")
    // public void consumeMsg(String msg) {
    // log.info(String.format("Here is consumed message: %s", msg));

    // }

    // private final List<SseEmitter> emitters = new ArrayList<>();
    // private final List<Student> messages = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "order", groupId = "myGroup")
    public void consumeMsg(String msg) {
        try {
            // String studentjson = objectMapper.writeValueAsString(msg);
            Student student = objectMapper.readValue(msg, Student.class);
            log.info("Here is consumed message: {}", student);

            // for (SseEmitter emitter : emitters) {
            // try {
            // emitter.send(Studentjson);
            // } catch (IOException e) {
            // log.error("Failed to send message to a client", e);
            // emitters.remove(emitter); // Remove failed emitter
            // }
            // }

            // messages.add(student);

            // sendToEmitters(studentjson);
        } catch (Exception e) {
            log.error("Failed to convert JSON string to Student object", e);
        }

    }

    // public List<Student> getMessages() {
    // synchronized (messages) {
    // List<Student> copy = new ArrayList<>(messages);
    // messages.clear();
    // return copy;
    // }
    // }

    // @GetMapping("/sse/updates")
    // public SseEmitter streamUpdates() {
    // SseEmitter emitter = new SseEmitter(60000L); // Set timeout to 1 minute

    // // Add the emitter to the list
    // emitters.add(emitter);

    // emitter.onCompletion(() -> emitters.remove(emitter)); // Remove emitter on
    // completion
    // emitter.onTimeout(() -> emitters.remove(emitter)); // Remove emitter on
    // timeout

    // return emitter;
    // }

    // private void sendToEmitters(String json) {
    // // Use a copy of the emitters list to avoid ConcurrentModificationException
    // for (SseEmitter emitter : new ArrayList<>(emitters)) {
    // try {
    // // Sending JSON as a proper SSE event
    // emitter.send("data: " + json + "\n\n"); // Note the "data: " prefix and
    // double newline
    // } catch (IOException e) {
    // log.error("Failed to send message to a client", e);
    // emitters.remove(emitter); // Remove failed emitter
    // }
    // }
    // }

}
