package com.example.kafka.consumer;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SseController {

    private final KafkaConsumer kafkaConsumer;

    // @GetMapping("/sse/updates")
    // SseEmitter emitter = new SseEmitter();
    // public SseEmitter streamUpdates() {
    // // Keep this emitter open and push messages to it as they come
    // return emitter;
    // }
    // @GetMapping("/sse/updates")
    // public SseEmitter streamUpdates() {
    // SseEmitter emitter = new SseEmitter(0L); // 0L means no timeout
    // new Thread(() -> {
    // try {
    // for (int i = 0; i < 10; i++) { // Simulate 10 messages
    // emitter.send("Message " + i);
    // Thread.sleep(5000);
    // }
    // emitter.complete();
    // } catch (IOException | InterruptedException e) {
    // emitter.completeWithError(e);
    // }
    // }).start();
    // return emitter;
    // }
}
