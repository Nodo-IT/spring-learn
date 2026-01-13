package com.nodoit.event_listener.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStateEventListeners {

  private static final Logger logger = LoggerFactory.getLogger(ApplicationStateEventListeners.class);

  @EventListener
  public void onReadinessStateChange(AvailabilityChangeEvent<ReadinessState> event) {
    switch (event.getState()) {
      case ACCEPTING_TRAFFIC -> {
        logger.info("[ReadinessState] The application is ready to receive traffic");
      }

      case REFUSING_TRAFFIC -> {
        logger.info("[ReadinessState] The application is not willing to receive traffic");
      }
    }
  }

  @EventListener
  public void onLivenessStateChange(AvailabilityChangeEvent<LivenessState> event) {
    switch (event.getState()) {
      case BROKEN -> {
        logger.info("[LivenessState] The application is running but its internal state is broken");
      }

      case CORRECT -> {
        logger.info("[LivenessState] The application is running and its internal state is correct");
      }
    }
  }

}
