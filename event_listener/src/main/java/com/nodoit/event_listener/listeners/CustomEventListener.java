package com.nodoit.event_listener.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.nodoit.event_listener.event.CustomEvent;
import com.nodoit.event_listener.publisher.CustomEventPublisher;

@Component
public class CustomEventListener {

  private static final Logger logger = LoggerFactory.getLogger(CustomEventPublisher.class);

  @Async
  @EventListener
  public void listenCustomEvent(CustomEvent event) throws InterruptedException {
    logger.info("Reading message: %s".formatted(event.getMessage()));
    logger.info("Thread: {}", Thread.currentThread().getName());
  }

}
