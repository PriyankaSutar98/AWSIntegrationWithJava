package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sample")
public class SpringBootConfiguration {

	public static void main(String... args) {
		{
			SpringApplication.run(SpringBootConfiguration.class, args);
		}
	}

}
