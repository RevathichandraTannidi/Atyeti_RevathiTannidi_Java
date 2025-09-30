package org.atyeti.activeMqTopics;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicProducer topicProducer;

      public TopicController(TopicProducer topicProducer) {
        this.topicProducer = topicProducer;
    }

    @PostMapping
    public String publish(@RequestParam String msg) {
        topicProducer.publish("news-topic", msg);
        return "Published to topic: " + msg;
    }
}
