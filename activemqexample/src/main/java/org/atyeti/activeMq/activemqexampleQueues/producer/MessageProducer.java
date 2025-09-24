package org.atyeti.activeMq.activemqexampleQueues.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    private final JmsTemplate jmsTemplate;

    public MessageProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
    }
}
