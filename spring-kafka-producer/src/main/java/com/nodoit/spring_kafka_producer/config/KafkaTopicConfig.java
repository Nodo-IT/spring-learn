package com.nodoit.spring_kafka_producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  // Put topic Bean in the Application Context
  @Bean
  public NewTopic messagesTopic() {
    return TopicBuilder.name("messages")
        .build();
  }

}
