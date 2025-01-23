# API Security Gateway

A secure API gateway built with Spring Boot, designed to enhance API security and efficiency. This gateway implements JWT-based authentication, rate limiting using Bucket4j, and real-time threat detection for robust protection against malicious activities.

## Features

- **JWT Authentication**: Protects API endpoints by allowing access only to authenticated users.
- **Rate Limiting**: Uses Bucket4j to limit the number of requests a client can make within a specified timeframe, preventing abuse and ensuring fair usage.
- **Real-Time Threat Detection**: Monitors unusual access patterns, identifies suspicious activities, and blocks potentially malicious IPs to safeguard the system.

## Prerequisites

- **Java**: Version 17 or later
- **Maven**: Version 3.8+
- **Spring Boot**: Version 3.3.5
- **Redis**(optional): Required if using distributed rate limiting or IP blocklisting

## Getting Started

### Setup Instructions

1. Clone the Repository

```bash
git clone https://github.com/swanjiku/api-security-gateway.git
```
2. Navigate to the project directory:

  ```bash
  cd api-security-gateway
  ```
