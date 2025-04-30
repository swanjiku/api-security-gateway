# API Security Gateway

A secure API gateway built with Spring Boot, designed to enhance API security and efficiency. This gateway implements JWT-based authentication, rate limiting using Bucket4j, and real-time threat detection for robust protection against malicious activities.

## Features

- **JWT Authentication**: Protects API endpoints by allowing access only to authenticated users.
- **Rate Limiting**: Uses Bucket4j to limit the number of requests a client can make within a specified timeframe, preventing abuse and ensuring fair usage.
- **Real-Time Threat Detection**: Monitors unusual access patterns, identifies suspicious activities, and blocks potentially malicious IPs to safeguard the system.
- **OpenAPI Documentation**: Integrated with Springdoc OpenAPI for interactive API docs.

## Prerequisites

- **Java**: Version 17 or later
- **Maven**: Version 3.8+
- **Spring Boot**: Version 3.3.5
- **Redis** (optional): Required if using distributed rate limiting or IP blocklisting

## Getting Started

### Setup Instructions

1. Clone the repository:

   ```bash
   git clone https://github.com/swanjiku/api-security-gateway.git
   ```
2. Navigate to the project directory:

   ```bash
   cd api-security-gateway
   ```
3. Build the project using Maven:

   ```bash
   mvn clean install
   ```
4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

5. (Optional) Configure Redis if you want distributed rate limiting or IP blocklisting. Update your application properties as needed.

## Project Structure

- `src/main/java/com/api/securityGateway/`
  - **SecurityGatewayApplication.java**: Main Spring Boot entry point.
  - **auth/**: Authentication logic, controllers, and DTOs.
  - **config/**: Security, JWT, rate limiting, and OpenAPI configuration.
  - **token/**: Token entity and management.
  - **user/**: User entity, service, controller, and DTOs.
  - **util/**: Utility classes (e.g., standardized API responses).

## API Documentation

After starting the application, access the interactive API documentation at:

```
http://localhost:8080/swagger-ui.html
```

## Key Endpoints

- `/api/auth/register` – Register a new user
- `/api/auth/authenticate` – Authenticate and receive a JWT
- `/api/user/profile` – Get user profile (secured)

## Security Features

- JWT-based authentication for all secured endpoints
- Rate limiting using Bucket4j
- Real-time threat detection and IP blocklisting
