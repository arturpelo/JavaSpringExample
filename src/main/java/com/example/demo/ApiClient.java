package com.example.demo;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiClient {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/api";

    public ApiClient() {
        this.restTemplate = new RestTemplate();
    }

    // GET - Pobieranie zasobu
    public String getWelcomeMessage() {
        String url = baseUrl + "/";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    // POST - Tworzenie nowego zasobu
    public String createResource(String data) {
        String url = baseUrl + "/create";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(data, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response.getBody();
    }

    // PUT - Aktualizacja zasobu
    public String updateResource(Long id, String data) {
        String url = baseUrl + "/update/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(data, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
        return response.getBody();
    }

    // DELETE - Usunięcie zasobu
    public String deleteResource(Long id) {
        String url = baseUrl + "/delete/" + id;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        return response.getBody();
    }
}