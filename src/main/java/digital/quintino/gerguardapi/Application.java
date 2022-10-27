package digital.quintino.gerguardapi;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import digital.quintino.gerguardapi.utility.DateUtility;

@SpringBootApplication
@EnableFeignClients
@RestController
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@GetMapping("/")
	public String api() {
		return "GERGUARDAPI - Gerenciador de Acessos (Versão 1.0.0)";
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(DateUtility.formatarData(new Date()) + " - GERGUARDAPI - Gerenciador de Acessos (Versão 1.0.0)");
	}

}
