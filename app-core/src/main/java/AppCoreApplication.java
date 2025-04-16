import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "com.uam.appcore",      
    "controlador"
})

public class AppCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppCoreApplication.class, args);
    }
}
