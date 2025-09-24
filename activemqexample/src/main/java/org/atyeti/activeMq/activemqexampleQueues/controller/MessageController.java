package org.atyeti.activeMq.activemqexampleQueues.controller;

import org.atyeti.activeMq.activemqexampleQueues.producer.MessageProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageProducer producer;

    public MessageController(MessageProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String send(@RequestParam String msg) {
        producer.sendMessage("my-queue", msg);


        return "Message sent: " + msg;
    }
}
