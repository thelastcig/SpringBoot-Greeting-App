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
