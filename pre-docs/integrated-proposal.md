# Integrated Microservices Architecture Project Proposal

## Overview
This project aims to construct a scalable and efficient enterprise-level application using a Spring Boot-based microservices architecture. The ultimate goal is to transition from an e-commerce centric framework to a Copyright Book Navigator (CBN) system, leveraging advanced features such as asynchronous messaging, service discovery, and performance monitoring.

## Phase 1: Foundation and E-Commerce Microservices

### Architectural Components
- **API Gateway**: Serves as the unified entry point for routing, balancing, and authentication.
- **Auth Server**: Implements OAuth2 authentication for securing API access.
- **Product Service**: Manages product information using MongoDB for NoSQL storage.
- **Order Service**: Processes orders, employing MySQL for order data storage.
- **Inventory Service**: Manages inventory status, also using MySQL.
- **Notification Service**: Sends asynchronous messages about order and inventory updates.
- **Service Discovery**: Utilizes Eureka for service registration and finding.
- **Config Server**: Manages centralized configuration with secure storage for sensitive settings.

### Timeline for Phase 1
- Project kickoff and requirement confirmation: Week 1.
- System design and planning: Weeks 2-3.
- Environment setup and basic service development: Weeks 4-6.
- Core service development and integration: Weeks 7-12.
- Testing, optimization, and documentation: Weeks 13-15.
- User Acceptance Testing (UAT) and deployment: Weeks 16-17.

## Phase 2: Transition to Copyright Book Navigator (CBN)

### Additional Architectural Adjustments
- **Book Information Service**: Refactor Product Service to manage book metadata.
- **Search Indexing Service**: Develop a new service for handling search operations, potentially integrating with Elasticsearch.
- **Book Recommendation Service**: Create a service for recommending books based on user queries and history.
- **Copyright Query Service**: Integrate with external copyright databases or APIs.

### Timeline for Phase 2
- Detailed requirement analysis for CBN: Weeks 18-20.
- Design and planning for new services: Weeks 21-23.
- Development of new services and integration with existing ones: Weeks 24-30.
- Testing and refinement of new functionalities: Weeks 31-33.
- Final integration, UAT, and deployment of CBN system: Weeks 34-36.

### Budget Estimate
A detailed budget will be provided following further requirements analysis and resource planning at the end of Phase 1 and the initial stages of Phase 2.
