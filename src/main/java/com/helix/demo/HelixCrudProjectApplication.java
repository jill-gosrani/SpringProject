package com.helix.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class HelixCrudProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelixCrudProjectApplication.class, args);
	}

}
//springboot comfiguration, enable auto-configuration, component scan -> combines to form SpringBootApplication
