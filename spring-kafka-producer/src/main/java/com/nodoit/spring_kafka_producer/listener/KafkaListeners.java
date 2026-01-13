package com.nodoit.spring_kafka_producer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
  
  @KafkaListener(
    topics = "messages",
    groupId = "foo"
  )
  void listener(String data) {
    System.out.println("Listener received: %s".formatted(data));
  }

}
