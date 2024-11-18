package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			// Pobranie klienta API z kontekstu Springa
			ApiClient apiClient = context.getBean(ApiClient.class);

			// Wywołanie metody GET z kontrolera
			String welcomeMessage = apiClient.getWelcomeMessage();
			System.out.println("Tekst bazowy (GET /api/): " + welcomeMessage);

			// Wywołanie metody POST - Tworzenie nowego zasobu
			String newResource = "{\"name\": \"Nowy zasób\"}";
			String postResponse = apiClient.createResource(newResource);
			System.out.println("Odpowiedź (POST /api/create): " + postResponse);

			// Wywołanie metody PUT - Aktualizacja istniejącego zasobu
			String updatedResource = "{\"name\": \"Zaktualizowany zasób\"}";
			String putResponse = apiClient.updateResource(1L, updatedResource);
			System.out.println("Odpowiedź (PUT /api/update/1): " + putResponse);

			// Wywołanie metody DELETE - Usunięcie zasobu
			String deleteResponse = apiClient.deleteResource(1L);
			System.out.println("Odpowiedź (DELETE /api/delete/1): " + deleteResponse);
		};
	}

}
