# Hexagonal Architecture

This repository was made with the purpose of studying better about Hexagonal Architecture, it is not made to be a big
project with complex Business Logic, just a basic implementation to practice about.

## Project Structure

```
├── adapter/
│   ├── mapper/        # DTOs and mapping logic between Domain and Persistence
│   ├── persistence/   # Database adapters
│   └── utils/         # Utility classes
├── application/
│   ├── factory/       # Object factories
│   ├── gateway/       # Gateways (controllers, etc)
│   └── config/        # Application configurations
└── domain/
    ├── common/        # Shared domain components
    ├── entity/        # Domain entities
    ├── port/          # Ports (interfaces)
    └── usecase/       # Business logic use cases
```

## Architecture Overview

The project implements basic concepts of Hexagonal Architecture:

- **Domain Layer**: Core business logic
- **Ports**: Interfaces for external communication
- **Adapters**: Technical implementations
- **Application Layer**: Orchestration and use cases

## Getting Started

### Prerequisites

- Java 17
- Spring Boot

### Running

```bash
mvn spring-boot:run
```

## Study Notes

This is a learning project focused on understanding:

- How to structure a project using Hexagonal Architecture
- Separation of concerns between layers
- Implementation of ports and adapters
- Basic dependency inversion principles

Feel free to use this as a reference for studying Hexagonal Architecture concepts.