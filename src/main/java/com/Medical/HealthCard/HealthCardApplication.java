package com.Medical.HealthCard;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthCardApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HealthCardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sysytem is started successfully ");
	}
}
