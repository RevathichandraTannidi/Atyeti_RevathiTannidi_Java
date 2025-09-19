package org.atyeti.kafka.springboot_kafka_beginning.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic javaTopics()
    {
        return TopicBuilder.name("javatopics")

                .build();
    }
    @Bean
    public NewTopic jsonTopic() {
        return TopicBuilder.name("json_topic").build();
    }
    @Bean
    public NewTopic partitionsjava()
    {
        return TopicBuilder.name("partition_java")
                .partitions(3)
                .replicas(1)
                .build();
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> batchKafkaListenerContainerFactory(
            ConsumerFactory<String, String> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setBatchListener(true);

        return factory;
    }

}
