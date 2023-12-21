# Task Service

The Task Service is a Spring Boot application that provides RESTful APIs for managing tasks.

## Features

- **CRUD Operations:** Allows the creation, retrieval, updating, and deletion of tasks.
- **Validation:** Implements proper error handling and validation for input data.
- **Persistence:** Uses a relational database to store task information.

## Getting Started

### Prerequisites

- Java 8 or later
- Maven
- Your preferred IDE (Eclipse, IntelliJ, etc.)
- Database (e.g., PostgreSQL)

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/task-service.git
    ```

2. Navigate to the project directory:

    ```bash
    cd task-service
    ```

3. Configure the database connection in `src/main/resources/application.properties`.

4. Build and run the project:

    ```bash
    mvn spring-boot:run
    ```

5. The application should be accessible at [http://localhost:8080](http://localhost:8080).

## API Endpoints

### Get All Tasks

```http
GET /tasks


