package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicCongig {

    @Bean
    public NewTopic RandomTopic() {

        return TopicBuilder
                .name("Avichal")
                .build();

    }

}
