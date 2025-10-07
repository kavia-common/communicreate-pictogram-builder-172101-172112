# Pictogram Builder Backend

Spring Boot backend service for the Pictogram Builder application.

## Setup

### Prerequisites
- Java 17 or higher
- MongoDB (running on port 5001)
- Gradle (included via wrapper)

### Environment Variables
Copy `.env.example` to `.env` and adjust values as needed:

```
MONGODB_URL=mongodb://localhost:5001
MONGODB_DB=pictogramdb
SERVER_PORT=3001
```

### Running the Application

1. Start MongoDB on port 5001
2. Run the application:
   ```bash
   ./gradlew bootRun
   ```

The service will start on port 3001 by default.

### API Documentation

- Swagger UI: http://localhost:3001/api/swagger-ui.html
- OpenAPI spec: http://localhost:3001/api/api-docs

## Features

- CRUD operations for:
  - Actors (children, parents, teachers)
  - Pictograms (visual stories)
  - Templates (reusable layouts)
  - Assets (images and media)
- Health and info endpoints
- MongoDB integration
- CORS configuration for frontend development

## Development

Build the project:
```bash
./gradlew build
```

Run tests:
```bash
./gradlew test
```

## API Endpoints

- GET /api/health - Health check
- GET /api/info - Application info
- GET /api/actors - List actors
- POST /api/actors - Create actor
- GET /api/actors/{id} - Get actor
- PUT /api/actors/{id} - Update actor
- DELETE /api/actors/{id} - Delete actor
- Similar CRUD endpoints for pictograms, templates, and assets
