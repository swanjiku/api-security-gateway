# API Security Gateway

An API gateway built with Spring Boot, implementing advanced security features using JWT-based authentication, rate limiting with Bucket4j, and real-time threat detection capabilities.

## Features

- **JWT Authentication**: Secures API endpoints, allowing only authenticated users to access protected resources.
- **Rate Limiting**: Controls the number of requests a client can make within a certain time frame to prevent abuse.
- **Real-Time Threat Detection**: Detects suspicious activity by monitoring unusual access patterns and blocking potentially malicious IPs.

## Prerequisites

- **Java 17**
- **Maven 3.8+**
- **Spring Boot 3.3.5**
- **Redis** (optional, if distributed rate limiting or IP block listing is required)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/swanjiku/api-security-gateway.git
cd api-security-gateway
```
