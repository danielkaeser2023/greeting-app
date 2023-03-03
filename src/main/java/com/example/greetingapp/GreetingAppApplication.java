package com.example.greetingapp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RestController
@RequiredArgsConstructor
class GreetingController {

	private final GreetingConfigurationProperties properties;

	@GetMapping("/greeting")
	public String greeting() {
		log.info("Hallo, ich wurde angefragt");
		return "test123? " + properties.getGreeting();
	}
}

@Getter
@Setter
@Component
@ConfigurationProperties("some")
class GreetingConfigurationProperties {
	private String greeting;
}
