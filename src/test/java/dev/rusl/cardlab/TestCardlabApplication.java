package dev.rusl.cardlab;

import org.springframework.boot.SpringApplication;

public class TestCardlabApplication {

	public static void main(String[] args) {
		SpringApplication.from(CardlabApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
