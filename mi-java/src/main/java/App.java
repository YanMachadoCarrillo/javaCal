import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SpringBootApplication
@RestController
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/calcular")
    public Map<String, Double> calcular(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam String op
    ) {
        double resultado = 0;

        switch (op) {
            case "suma":
                resultado = a + b;
                break;
            case "resta":
                resultado = a - b;
                break;
            case "multiplicacion":
                resultado = a * b;
                break;
            case "division":
                if (b == 0) {
                    throw new RuntimeException("No se puede dividir por 0");
                }
                resultado = a / b;
                break;
        }

        return Map.of("resultado", resultado);
    }
}
