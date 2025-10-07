package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * PUBLIC_INTERFACE
 * MongoConfig enables auditing for Mongo documents (createdAt/updatedAt).
 */
@Configuration
@EnableMongoAuditing
public class MongoConfig {
}
