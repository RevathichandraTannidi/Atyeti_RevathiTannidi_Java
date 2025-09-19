package org.atyeti.kafka.springboot_kafka_beginning.controller;


import org.atyeti.kafka.springboot_kafka_beginning.kafka.PartitionKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/partition")
public class PartitionController {

    private final PartitionKafkaProducer producer;

    public PartitionController(PartitionKafkaProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(
            @RequestParam("key") String key,
            @RequestParam("message") String message) {

        producer.sendMessageWithKey(key, message);
        return ResponseEntity.ok("Message sent to partition_java topic");
    }
}

