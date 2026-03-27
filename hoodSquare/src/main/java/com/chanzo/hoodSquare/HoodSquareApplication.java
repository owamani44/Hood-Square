package com.chanzo.hoodSquare;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@SpringBootApplication
public class HoodSquareApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoodSquareApplication.class, args);
	}

	@Bean
	public ApplicationRunner checkChains(List<SecurityFilterChain> chains) {
		return args -> {
			System.out.println(">>> Total SecurityFilterChain beans: " + chains.size());
			chains.forEach(c -> System.out.println(">>> Chain: " + c));
		};
	}
}
