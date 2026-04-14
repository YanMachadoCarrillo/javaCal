import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/calcular")
    public Map<String, Object> calcular(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam String op) {

        Map<String, Object> res = new HashMap<>();

        switch (op) {
            case "suma":
                res.put("resultado", a + b);
                break;
            case "resta":
                res.put("resultado", a - b);
                break;
            case "multiplicacion":
                res.put("resultado", a * b);
                break;
            case "division":
                if (b == 0) {
                    res.put("error", "División por cero");
                    return res;
                }
                res.put("resultado", a / b);
                break;
            default:
                res.put("error", "Operación inválida");
        }

        return res;
    }
}
