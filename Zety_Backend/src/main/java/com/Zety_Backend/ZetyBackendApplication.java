package com.Zety_Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZetyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZetyBackendApplication.class, args);
		System.out.println("Zety resume maker Backend website...");
	}

}

// This dependancy added here for counter the error when we connect database add this in pom.xml
//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-data-jpa</artifactId>
//</dependency>