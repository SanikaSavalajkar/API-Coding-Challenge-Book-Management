package com.hexaware;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@SpringBootApplication
public class BookManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementApplication.class, args);
		System.out.println("Book Management App is Running.......");
	}
	
	@Bean
	public OpenAPI bookManagementOpenAPI() {
	    return new OpenAPI()
	        .info(new Info().title("Book Management API").version("1.0"))
	        .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
	        .components(new io.swagger.v3.oas.models.Components()
	            .addSecuritySchemes("bearerAuth",
	                new SecurityScheme()
	                    .name("Authorization")
	                    .type(SecurityScheme.Type.HTTP)
	                    .scheme("bearer")
	                    .bearerFormat("JWT")));
	}
	
	@Bean
	CommandLineRunner run() {
	    return args -> {
	        String encrypted = new BCryptPasswordEncoder().encode("admin123");
	        System.out.println("Encrypted password: " + encrypted);
	    };
	}

}
