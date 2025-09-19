package org.atyeti.kafka.springboot_kafka_beginning.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PartitionKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(PartitionKafkaConsumer.class);

    @KafkaListener(topics = "partition_java", groupId = "partitionGroup" )
    public void consume(ConsumerRecord<String, String> record) {
        log.info("Received message='{}' with key='{}' from partition={} and offset={}",
                record.value(), record.key(), record.partition(), record.offset());
    }
}
