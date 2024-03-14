### First Step:
```
Initialize Spring Boot Microservices Architecture with Docker Compose
```

### Description:

#### Overview
This Pull Request lays the foundational infrastructure for a robust Spring Boot microservices architecture, leveraging Docker Compose for container orchestration. It encompasses service setup, security configurations, service discovery, resilience mechanisms, distributed tracing, and monitoring.

#### Key Components:
- **Microservices**: Initialized core microservices including `Order Service`, `Product Service`, and `Inventory Service`, each with dedicated databases (`MongoDB` for Product and `Postgres` for Order and Inventory services).
- **API Gateway**: Setup an API Gateway to act as the single entry point for all service requests, enhancing security and simplifying client interactions.
- **Security**: Integrated `Keycloak` with OAuth 2.0 for secure authentication and authorization across services.
- **Service Discovery**: Employed `Eureka` for dynamic service discovery, enabling services to find and communicate with each other seamlessly.
- **Circuit Breaker**: Implemented Circuit Breaker patterns to ensure system resilience and fault tolerance.
- **Distributed Tracing**: Configured `Zipkin` and `Sleuth` for effective monitoring and troubleshooting of inter-service communications.
- **Monitoring**: Utilized `Prometheus` and `Grafana` for real-time monitoring and visualization of service health metrics.
- **Logging**: Established a centralized logging mechanism using `Kafka`, facilitating efficient log aggregation and analysis.
- **Containerization**: Defined `Docker Compose` configurations for each service, ensuring consistent environments across development, testing, and production stages.

#### Implementation Details:
The PR includes detailed `docker-compose.yml` configurations for setting up the entire infrastructure, Dockerfiles for containerization of each microservice, and initial Spring Boot application setups with necessary dependencies for web, security, JPA, MongoDB, Eureka client, and more.

Based on your Docker Compose file, I'll organize an endpoint documentation and a process flowchart to better understand and utilize your microservices architecture.

### Endpoint Documentation

#### Services and Their Endpoints

- **Postgres for Order Service**
  - **Internal Port**: 5431
  - **External Access Port**: 5431

- **Postgres for Inventory Service**
  - **Internal Port**: 5432
  - **External Access Port**: 5432

- **MongoDB for Product Service**
  - **Internal Port**: 27017
  - **External Access Port**: 27017

- **Keycloak (OAuth 2.0 Security)**
  - **Internal Port**: 8080
  - **External Access Port**: 8080

- **Eureka (Service Discovery)**
  - **Internal Port**: 8761
  - **External Access Port**: 8761

- **Zipkin (Distributed Tracing)**
  - **Internal Port**: 9411
  - **External Access Port**: 9411

- **API Gateway**
  - **Internal Port**: 8080
  - **External Access Port**: 8181

- **Kafka (Centralized Logging and Notification)**
  - **Internal Port**: 9092
  - **External Access Port**: 9092

- **Prometheus (Monitoring)**
  - **Internal Port**: 9090
  - **External Access Port**: 9090

- **Grafana (Monitoring Dashboard)**
  - **Internal Port**: 3000
  - **External Access Port**: 3000

### Process Flowchart

Next, I'll create a flowchart to show how these services interact and cooperate with each other.

- User requests enter the system through the **API Gateway**.
- **API Gateway** uses **Keycloak** for authentication and authorization.
- Authenticated requests are routed to the respective microservices (like **Order Service**, **Product Service**, **Inventory Service**).
- Microservices can discover each other through **Eureka** for inter-service communication.
- Inter-service communication can be traced using **Zipkin** and **Sleuth** for problem-solving and performance monitoring.
- **Prometheus** and **Grafana** provide health monitoring and visualization of the system.
- **Kafka** is used for centralized logging and notification systems, facilitating log management and event-driven message passing.
<img width="2210" alt="grafana-vitualize-prometheus" src="https://github.com/lisiCAO/Copyright-Book-Navigator/assets/137085653/8de4aa54-3109-4400-bcfc-bf209edf5c5e">

<img width="1137" alt="prometheus-targets" src="https://github.com/lisiCAO/Copyright-Book-Navigator/assets/137085653/b7e4bc62-e151-4c2b-a02d-a06748c54214">

<img width="1137" alt="eureka-services-discovery" src="https://github.com/lisiCAO/Copyright-Book-Navigator/assets/137085653/7b7452bb-4cb5-4bfd-be7a-cb0dffae3cff">

![distribute-tracing-logs](https://github.com/lisiCAO/Copyright-Book-Navigator/assets/137085653/bce4bb8f-1f8e-4cce-9b5f-6fe3e8b1bcdd)

<img width="2239" alt="kibana" src="https://github.com/lisiCAO/Copyright-Book-Navigator/assets/137085653/c113acf6-5d04-4b72-9e37-c57c4625e593">

<img width="851" alt="postman-place-order" src="https://github.com/lisiCAO/Copyright-Book-Navigator/assets/137085653/90d55612-032a-437b-b867-3705ef763cd1">

<img width="851" alt="postman-get-prodcuts" src="https://github.com/lisiCAO/Copyright-Book-Navigator/assets/137085653/ff114104-1ab0-44af-95ea-5c1727462b13">
<img width="1271" alt="postman-search" src="https://github.com/lisiCAO/Copyright-Book-Navigator/assets/137085653/14db8599-8599-4e82-9318-b34c896789bd">
