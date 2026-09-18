# Secure Document Management REST API

A cloud-native RESTful API built with Java 17 and Spring Boot.

## Tech Stack
- Java 17
- Spring Boot (Spring Web, Spring Data JPA)
- H2 In-Memory Database
- Gradle & Lombok

## API Endpoints
- `POST /api/users` - Create a new user
- `GET /api/users` - Get all users
- `POST /api/documents/user/{userId}` - Create document for a user
- `GET /api/documents` - Retrieve all documents
- `DELETE /api/documents/{id}` - Delete a document
