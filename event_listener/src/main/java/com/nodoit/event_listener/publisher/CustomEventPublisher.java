package com.nodoit.event_listener.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.nodoit.event_listener.event.CustomEvent;

@Component
public class CustomEventPublisher {

  private static final Logger logger = LoggerFactory.getLogger(CustomEventPublisher.class);

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  public void publishCustomEvent(final String message) {
    logger.info("Publishing custom event");
    
    // the `source` must be a publisher, a class annotated with @Component
    // and the publish method
    CustomEvent customEvent = new CustomEvent(this, message);
    // push the event
    applicationEventPublisher.publishEvent(customEvent);
  }

}
