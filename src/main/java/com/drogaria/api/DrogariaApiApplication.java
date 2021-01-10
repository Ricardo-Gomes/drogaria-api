package com.drogaria.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.drogaria.api.rest.controller"})
public class DrogariaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrogariaApiApplication.class, args);
	}

}
