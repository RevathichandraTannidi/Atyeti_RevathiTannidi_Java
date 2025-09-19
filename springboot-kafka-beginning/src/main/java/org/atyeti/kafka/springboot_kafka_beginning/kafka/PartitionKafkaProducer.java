package org.atyeti.kafka.springboot_kafka_beginning.kafka;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PartitionKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(PartitionKafkaProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PartitionKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageWithKey(String key, String message) {
        log.info("Sending message='{}' with key='{}'", message, key);
        kafkaTemplate.send("partition_java", key, message);
    }
}
