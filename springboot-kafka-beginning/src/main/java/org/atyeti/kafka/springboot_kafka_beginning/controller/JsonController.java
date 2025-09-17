package org.atyeti.kafka.springboot_kafka_beginning.controller;

import org.atyeti.kafka.springboot_kafka_beginning.kafka.JsonKafkaProducer;
import org.atyeti.kafka.springboot_kafka_beginning.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/json")
public class JsonController {
    private JsonKafkaProducer kafkaProducer;

    public JsonController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user)
    {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("json message sent to kafka");
    }

}
