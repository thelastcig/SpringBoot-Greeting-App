# SpringBoot Greeting App

## Overview

The **SpringBoot Greeting App** is a REST API built using Spring Boot that provides different HTTP methods to handle greeting messages. It supports personalized greetings, storing messages in an H2 database, updating, retrieving, and deleting messages.

## Features

- **Basic Greeting API**: Supports `GET`, `POST`, `PUT`, and `DELETE` methods.
- **Service Layer Integration**: Fetches simple and personalized greetings.
- **H2 Database Integration**: Stores greetings with an auto-generated ID.
- **CRUD Operations**: Supports create, read, update, and delete functionalities for greeting messages.
- **Find Greetings by ID**: Retrieves messages by unique ID.
- **List All Greetings**: Fetches all stored greeting messages.

---

## Installation and Setup

### Prerequisites

- Java 17+
- Maven
- Spring Boot
- H2 Database (in-memory)

### Clone the Repository

```sh
git clone https://github.com/your-repo-url/greeting-app.git
cd greeting-app
```

### Build and Run the Application

```sh
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

---

## API Endpoints

### 1. Basic Greeting Messages (UC-1)

| Method  | Endpoint       | Description                      |
|---------|---------------|----------------------------------|
| `GET`   | `/greetings`  | Returns a basic greeting message. |
| `POST`  | `/greetings`  | Handles a POST request.         |
| `PUT`   | `/greetings`  | Handles a PUT request.          |
| `DELETE`| `/greetings`  | Handles a DELETE request.       |

#### Example Request (GET):

```sh
curl -X GET http://localhost:8080/greetings
```

#### Response:

```json
{"message": "Hello, GET request received!"}
```

---

### 2. Get Simple Greeting (UC-2)

| Method  | Endpoint             | Description         |
|---------|---------------------|---------------------|
| `GET`   | `/greetings/simple` | Returns "Hello World". |

```sh
curl -X GET http://localhost:8080/greetings/simple
```

---

### 3. Personalized Greeting (UC-3)

| Method  | Endpoint  | Description  |
|---------|---------------------------|--------------------------|
| `GET`   | `/greetings/personalized?firstName=Sonu&lastName=Sharma` | Returns a personalized greeting. |

```sh
curl -X GET "http://localhost:8080/greetings/personalized?firstName=Sonu&lastName=Sharma"
```

---

### 4. Save Personalized Greeting (UC-4)

| Method  | Endpoint | Description |
|---------|-------------------------------------------------|--------------------------------|
| `GET`   | `/greetings/personalized/save?firstName=Sonu&lastName=Sharma` | Saves a personalized greeting in the database. |

```sh
curl -X GET "http://localhost:8080/greetings/personalized/save?firstName=Sonu&lastName=Sharma"
```

---

### 5. Get Greeting by ID (UC-5)

| Method  | Endpoint        | Description |
|---------|----------------|-------------|
| `GET`   | `/greetings/{id}` | Fetches a greeting by its ID. |

```sh
curl -X GET http://localhost:8080/greetings/1
```

---

### 6. List All Greetings (UC-6)

| Method  | Endpoint         | Description |
|---------|-----------------|-------------|
| `GET`   | `/greetings/all` | Lists all stored greetings. |

```sh
curl -X GET http://localhost:8080/greetings/all
```

---

### 7. Update a Greeting (UC-7)

| Method  | Endpoint         | Description |
|---------|-----------------|-------------|
| `PUT`   | `/greetings/edit/{id}` | Updates a stored greeting. |

```sh
curl -X PUT "http://localhost:8080/greetings/edit/2" --data-urlencode "message=Hello, Aryaman Sharma!"
```

---

### 8. Delete a Greeting (UC-8)

| Method  | Endpoint         | Description |
|---------|-----------------|-------------|
| `DELETE`| `/greetings/delete/{id}` | Deletes a stored greeting. |

```sh
curl -X DELETE "http://localhost:8080/greetings/delete/1"
```

---

## H2 Database Console

To view stored greetings in the H2 database:

1. Open a browser and go to:  
   ```
   http://localhost:8080/h2-console
   ```
2. Use the following credentials:
   - **JDBC URL**: `jdbc:h2:mem:greetingsdb`
   - **Username**: `sa`
   - **Password**: *(leave empty)*

---

## Project Structure

```sh
greeting-app/
│-- src/main/java/com/greetings_app
│   │-- greeting_app/GreetingController.java
│   │-- model/Greeting.java
│   │-- repository/GreetingRepository.java
│   │-- service/GreetingService.java
│-- src/main/resources/
│   │-- application.properties
│-- pom.xml
│-- .gitignore
│-- README.md
```

---

## Technologies Used

- **Spring Boot** - Core framework
- **Spring Web** - For building REST APIs
- **Spring Data JPA** - For database interactions
- **H2 Database** - In-memory database for storage
- **Lombok** - Reduces boilerplate code
- **Maven** - Dependency management

---

## Author

[Sonu Sharma](https://github.com/thelastcig)

---

## License

This project is licensed under the **MIT License**.

```
Feel free to modify and contribute!
```

