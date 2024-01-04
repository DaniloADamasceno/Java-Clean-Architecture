package com.danilo.school;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectSchoolApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSchoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("✅ ✅");
		System.out.println();
		System.out.println("✅✅ Escola SOFTWAY iniciado com sucesso! ✅✅ ");
		System.out.println("Desenvolvido por: Danilo A. Damasceno");
		System.out.println("LinkedIn: https://www.linkedin.com/in/daniloadamasceno/");
		System.out.println("GitHub: https://github.com/DaniloADamasceno");
		System.out.println("link para acessar o SWAGGER: http://localhost:8080/swagger-ui.html");
		System.out.println("✅ ✅");
	}
}
