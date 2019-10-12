package com.winkelmand.winkelmandAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.winkelmand")
public class WinkelmandApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WinkelmandApiApplication.class, args);
	}

}
