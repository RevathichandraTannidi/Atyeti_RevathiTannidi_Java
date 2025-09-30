package org.atyeti.activeMqAndKafka.producers;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {
    private final JmsTemplate jmsTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderProducer(JmsTemplate jmsTemplate, KafkaTemplate<String, String> kafkaTemplate) {
        this.jmsTemplate = jmsTemplate;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendToActiveMQ(String order) {
        jmsTemplate.convertAndSend("orders.queue", order);
        System.out.println("Sent to ActiveMQ: " + order);
    }

    public void sendToKafka(String order) {
        kafkaTemplate.send("orders", order);
        System.out.println(" Sent to Kafka: " + order);
    }
}
