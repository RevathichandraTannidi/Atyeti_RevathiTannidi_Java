package org.atyeti.kafka.springboot_kafka_beginning.controller;


import org.atyeti.kafka.springboot_kafka_beginning.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final KafkaProducer producer;

    public MessageController(KafkaProducer producer) {
        this.producer = producer;
    }



    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message)
    {
        producer.sendMessage(message);
        return ResponseEntity.ok("message sent to the topic");
    }
}
