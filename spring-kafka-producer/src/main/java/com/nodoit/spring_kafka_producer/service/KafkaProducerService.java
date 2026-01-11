package com.nodoit.spring_kafka_producer.service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

  private final KafkaTemplate<String, String> template;
  private final Logger logger;

  public KafkaProducerService(KafkaTemplate<String, String> template) {
    this.template = template;
    this.logger = LoggerFactory.getLogger(KafkaProducerService.class);
  }

  public Optional<String> publish(String message) {
    try {
      return Optional.ofNullable(template
          .send("messages", message)
          .whenComplete((v, t) -> {
            // cleanup here for example
            if (t != null) {
              logger.atError().log("Exception ocurred while pushing a message: " + t.getMessage());
            } else {
              logger.atInfo().log("Message pushed: '%s'".formatted(v.getProducerRecord().value()));
            }
          })
          .get(1000, TimeUnit.MILLISECONDS)
          .getProducerRecord()
          .value());
    } catch (Exception e) {
      return Optional.empty();
    }
  }

}
