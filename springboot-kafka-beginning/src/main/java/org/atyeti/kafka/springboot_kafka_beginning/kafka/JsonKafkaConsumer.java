package org.atyeti.kafka.springboot_kafka_beginning.kafka;

import org.atyeti.kafka.springboot_kafka_beginning.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "json_topic", groupId = "myGroup")
    public void consume(User user) {
        log.info("Received JSON message -> {}", user);
    }
}
