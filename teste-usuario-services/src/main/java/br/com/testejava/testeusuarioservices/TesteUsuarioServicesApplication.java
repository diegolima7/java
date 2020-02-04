package br.com.testejava.testeusuarioservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "br.com.testejava.testeusuarioservices")
public class TesteUsuarioServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteUsuarioServicesApplication.class, args);
	}

}
