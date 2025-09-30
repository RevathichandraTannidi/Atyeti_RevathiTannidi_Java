package org.atyeti.activeMqTopics;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicSubscribers {

    @JmsListener(destination = "news-topic", containerFactory = "topicListenerFactory")
    public void subscriber1(String message) {
        System.out.println("Subscriber 1 received: " + message);
    }

    @JmsListener(destination = "news-topic", containerFactory = "topicListenerFactory")
    public void subscriber2(String message) {
        System.out.println("Subscriber 2 received: " + message);
    }
}

