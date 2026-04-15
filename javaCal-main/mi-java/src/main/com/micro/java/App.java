package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@CrossOrigin(origins = "*") // Permite peticiones desde otros dominios
@SpringBootApplication
@RestController
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/calcular")
    public Map<String, Double> calcular(@RequestParam double a, @RequestParam double b, @RequestParam String op) {
        double resultado = 0;
        if (op.equals("suma")) resultado = a + b;
        else if (op.equals("resta")) resultado = a - b;
        else if (op.equals("multiplicacion")) resultado = a * b;
        else if (op.equals("division")) {
            if (b == 0) throw new RuntimeException("División por cero");
            resultado = a / b;
        }
        return Map.of("resultado", resultado);
    }
}

        return Map.of("resultado", resultado);
    }
}
