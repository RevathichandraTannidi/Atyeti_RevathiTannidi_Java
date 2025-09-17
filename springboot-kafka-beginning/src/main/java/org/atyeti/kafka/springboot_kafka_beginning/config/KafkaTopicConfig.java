package org.atyeti.kafka.springboot_kafka_beginning.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic javaTopics()
    {
        return TopicBuilder.name("javatopics")

                .build();
    }
    @Bean
    public NewTopic jsonTopic() {
        return TopicBuilder.name("json_topic").build();
    }
}
