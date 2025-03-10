package com.example.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // @Bean
    // public KafkaTemplate<String, Student> kafkaTemplate(ProducerFactory<String,
    // Student> producerFactory) {
    // return new KafkaTemplate<>(producerFactory);
    // }

}
