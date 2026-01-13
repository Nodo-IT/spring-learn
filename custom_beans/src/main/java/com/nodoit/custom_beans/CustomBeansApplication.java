package com.nodoit.custom_beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nodoit.custom_beans.beans.DogServiceBean;

@SpringBootApplication
public class CustomBeansApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(CustomBeansApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

	@Autowired
	private DogServiceBean dogServiceBean;

	@Override
	public void run(String... args) throws Exception {
		dogServiceBean.bark();
	}

}
