package com.fakeStore.springBootBE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.fakeStore.springBootBE")
public class SpringBootBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBeApplication.class, args);
	}

}
