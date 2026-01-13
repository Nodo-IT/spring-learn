package com.nodoit.event_listener;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class EventListenerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(EventListenerApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}

}
