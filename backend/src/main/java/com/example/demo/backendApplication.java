package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Pictogram Builder API",
                version = "0.1.0",
                description = "Initial API for Actors and Pictograms"
        ),
        tags = {
                @Tag(name = "Health", description = "Service health and metadata"),
                @Tag(name = "Actors", description = "Manage actors like children, parents, teachers"),
                @Tag(name = "Pictograms", description = "Manage pictograms and their metadata")
        }
)
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
