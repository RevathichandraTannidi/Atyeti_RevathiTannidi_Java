package org.atyeti.kafka.springboot_kafka_beginning.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger log= LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics="javatopics" ,groupId = "myGroup")
    public void consume(String message)
    {
        log.info(String.format("message received -> %s",message));
    }

}
