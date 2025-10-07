package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * PUBLIC_INTERFACE
 * HealthController exposes health and basic application info endpoints.
 */
@RestController
@RequestMapping("/")
@Tag(name = "Health", description = "Service health and metadata")
public class HelloController {

    // PUBLIC_INTERFACE
    @GetMapping("health")
    @Operation(summary = "Health check", description = "Returns application health status")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    // PUBLIC_INTERFACE
    @GetMapping("info")
    @Operation(summary = "Application info", description = "Returns basic application information")
    public Map<String, String> info() {
        return Map.of(
            "name", "Pictogram Builder API",
            "version", "0.1.0"
        );
    }
}