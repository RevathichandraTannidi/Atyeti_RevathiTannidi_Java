package org.atyeti.activeMqAndKafka.Controllers;

import org.atyeti.activeMqAndKafka.producers.OrderProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String createOrder(@RequestBody String order) {
        producer.sendToActiveMQ(order);
        producer.sendToKafka(order);
        return "Order sent to both ActiveMQ and Kafka: " + order;
    }
}
