package com.example.comp367_maven_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Comp367MavenAppApplication {

	public static void main(String[] args) {
        SpringApplication.run(Comp367MavenAppApplication.class, args);
    }

    @RestController
    class WelcomeController {
        @GetMapping("/")
        public String welcome() {
            return "Welcome to COMP367";
        }
    }
}
