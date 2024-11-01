# Spring Boot Caching with Redis
This repository demonstrates the implementation of caching in a Spring Boot application using Redis as the caching provider. It covers best practices for configuring and utilizing Redis to improve application performance by reducing database load and speeding up data retrieval.

## Key Features
- Spring Boot Integration: Seamless integration of Redis with Spring Boot for easy setup and configuration.
- Cache Management: Implementing caching for method results, database queries, and more.
- Custom Cache Configurations: Setting up TTL (Time-to-Live) policies, cache evictions, and other advanced configurations.
- Cache Annotations: Practical examples using @Cacheable, @CachePut, and @CacheEvict annotations.
- Distributed Caching: How to use Redis for distributed caching in multi-instance environments.
- Cache Monitoring: Basic tools and strategies for monitoring cache performance and hit/miss ratios.
## Technologies Used
- Spring Boot: Core framework for building the application.
- Spring Data Redis: For integration and interaction with the Redis database.
- Redis: In-memory data structure store used as a database, cache, and message broker.
- Docker (optional): To run a Redis instance locally for development and testing.
## How to Run
- Clone the repository: git clone <repo-url>
- Navigate to the project directory.
- Run docker-compose up to start a local Redis instance.
- Start the Spring Boot application using your preferred IDE or ./mvnw spring-boot:run.
- Access the application and test cache behavior using predefined endpoints.
