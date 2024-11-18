package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*Wyjaśnienie:
Adnotacje:

@GetMapping, @PostMapping, @PutMapping, i @DeleteMapping odpowiadają różnym metodom HTTP.
@RequestBody umożliwia odbieranie danych przesłanych w treści żądania.
@PathVariable pozwala na dynamiczne przekazywanie części ścieżki URL (np. ID zasobu).
@ResponseBody oznacza, że zwracana wartość zostanie bezpośrednio przesłana jako odpowiedź HTTP.
        Endpointy:

GET /api/ — Zwraca wiadomość powitalną.
        POST /api/create — Tworzy zasób z danymi przesłanymi w treści żądania.
PUT /api/update/{id} — Aktualizuje zasób identyfikowany przez ID.
        DELETE /api/delete/{id} — Usuwa zasób identyfikowany przez ID.
        Odpowiedzi:

Używam ResponseEntity dla bardziej elastycznego tworzenia odpowiedzi HTTP.
Testowanie:
Możesz przetestować powyższe metody za pomocą narzędzia takiego jak Postman lub curl. Na przykład:

GET:
curl -X GET http://localhost:8080/api/
POST:
curl -X POST -H "Content-Type: application/json" -d "Dane testowe" http://localhost:8080/api/create
PUT:
curl -X PUT -H "Content-Type: application/json" -d "Nowe dane" http://localhost:8080/api/update/1
DELETE:
curl -X DELETE http://localhost:8080/api/delete/1
*/

@Controller
@RequestMapping("/api") // Ustawienie bazowego URL dla wszystkich endpointów w tym kontrolerze
public class MainControler {

    // GET - Pobieranie zasobu
    @GetMapping("/")
    @ResponseBody
    public String getWelcomeMessage() {
        return "Witaj świecie - metoda GET";
    }

    // POST - Tworzenie nowego zasobu
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<String> createResource(@RequestBody String body) {
        return ResponseEntity.ok("Zasób utworzony: " + body);
    }

    // PUT - Aktualizacja istniejącego zasobu
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<String> updateResource(@PathVariable Long id, @RequestBody String body) {
        return ResponseEntity.ok("Zasób o ID " + id + " został zaktualizowany do: " + body);
    }

    // DELETE - Usunięcie zasobu
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteResource(@PathVariable Long id) {
        return ResponseEntity.ok("Zasób o ID " + id + " został usunięty");
    }
}
