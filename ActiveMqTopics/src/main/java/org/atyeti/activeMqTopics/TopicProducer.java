package org.atyeti.activeMqTopics;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class TopicProducer {

    private final JmsTemplate jmsTopicTemplate;

    public TopicProducer(JmsTemplate jmsTopicTemplate) {
        this.jmsTopicTemplate = jmsTopicTemplate;
    }

    public void publish(String topicName, String message) {
        jmsTopicTemplate.convertAndSend(topicName, message);
    }
}
