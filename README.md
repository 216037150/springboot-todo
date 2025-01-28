# springboot-todo

## Todo App API

This is a simple Todo Application backend built using Spring Boot. It exposes a RESTful API for managing todo items. Users can create, read, update, and delete todo items.

### Features
- **Create** a new todo item.
- **Read** a list of all todo items.
- **Update** an existing todo item.
- **Delete** a todo item by ID.

### Technology Stack
- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

### Endpoints

#### 1. **GET /api/todos**
Fetches a list of all todo items.

**Response:**
- `200 OK` - Returns a list of all todo items in the database.

#### 2. **POST /api/todos/post**
Creates a new todo item.

**Request Body:**
```json
{
  "title": "Buy groceries",
  "isDone": false
}
