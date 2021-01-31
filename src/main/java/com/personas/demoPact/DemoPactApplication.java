package com.personas.demoPact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.personas.demoPact.controller.Controller.chargeCache;

@SpringBootApplication
public class DemoPactApplication {

	public static void main(String[] args) {
		chargeCache();
		SpringApplication.run(DemoPactApplication.class, args);
	}

}
