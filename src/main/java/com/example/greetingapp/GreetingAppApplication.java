package com.example.greetingapp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GreetingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingAppApplication.class, args);
	}
}

@RestController
@RequiredArgsConstructor
class GreetingController {

	private final GreetingConfigurationProperties properties;

	@GetMapping("/greeting")
	public String greeting() {
		return "updated automatically!!! heute auch noch? " + properties.getGreeting();
	}
}

@Getter
@Setter
@Component
@ConfigurationProperties("some")
class GreetingConfigurationProperties {
	private String greeting;
}
