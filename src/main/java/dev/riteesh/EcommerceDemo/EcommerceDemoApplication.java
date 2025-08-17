package dev.riteesh.EcommerceDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.riteesh.EcommerceDemo"})
public class EcommerceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoApplication.class, args);
	}

}
