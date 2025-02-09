package com.cactro.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(VCacheApplication.class, args);
	}

}
