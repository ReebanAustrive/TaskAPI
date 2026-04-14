# Task Management API

A production-ready RESTful backend API for managing tasks and events, built with Java Spring Boot and PostgreSQL.

## Tech Stack

- **Language:** Java 21
- **Framework:** Spring Boot 4
- **Database:** PostgreSQL (Supabase)
- **ORM:** Hibernate JPA / Spring Data JPA
- **Security:** Spring Security (JWT — in progress)
- **Password Encryption:** BCrypt
- **Build Tool:** Gradle

## Project Structure

```
src/main/java/com/TaskTea/Task/
├── controller/        REST controllers
├── service/           Business logic layer
├── repository/        JPA repository interfaces
├── entity/            JPA entity models
├── dto/               Request/Response objects
├── enums/             Status enums
└── security/          Security configuration
```

## API Endpoints

### Auth
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/auth/register` | Register a new user | No |
| POST | `/api/auth/login` | Login with email & password | No |

### Tasks
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/tasks` | Create a new task | No* |
| GET | `/api/tasks/{userId}` | Get all tasks for a user | No* |
| GET | `/api/tasks/task/{taskId}` | Get task by ID | No* |
| PATCH | `/api/tasks/{taskId}` | Update a task | No* |
| DELETE | `/api/tasks/{taskId}` | Delete a task | No* |

### Events
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/events/create` | Create a new event | No* |
| GET | `/api/events/{userId}` | Get all events for a user | No* |
| GET | `/api/events/event/{eventId}` | Get event by ID | No* |
| PATCH | `/api/events/event/{eventId}` | Update an event | No* |
| DELETE | `/api/events/event/{eventId}` | Delete an event | No* |

*JWT authentication coming in next milestone.

## Request Examples

### Register
```json
POST /api/auth/register
{
  "username": "reeban",
  "email": "reeban@example.com",
  "password": "securepassword"
}
```

### Login
```json
POST /api/auth/login
{
  "email": "reeban@example.com",
  "password": "securepassword"
}
```

### Create Task
```json
POST /api/tasks
{
  "userId": 1,
  "title": "Complete backend roadmap",
  "description": "Finish all 6 milestones",
  "dueDate": "2026-06-01"
}
```

### Create Event
```json
POST /api/events/create
{
  "userId": 1,
  "title": "System Design Review",
  "description": "Deep dive into microservices architecture",
  "eventDate": "2026-04-20T14:30:00"
}
```

## Database Schema

### users
| Column | Type | Constraints |
|--------|------|-------------|
| id | int8 | Primary Key |
| username | varchar | Unique, Not Null |
| email | varchar | Unique, Not Null |
| password | varchar | Not Null (BCrypt hashed) |
| role | varchar | Default: USER |
| created_at | timestamp | Auto |

### tasks
| Column | Type | Constraints |
|--------|------|-------------|
| id | int8 | Primary Key |
| title | varchar | Not Null |
| description | varchar | Not Null |
| status | varchar | Default: TODO |
| due_date | date | Nullable |
| created_at | timestamp | Auto |
| updated_at | timestamp | Auto |
| user_id | int8 | Foreign Key → users |

### events
| Column | Type | Constraints |
|--------|------|-------------|
| id | int8 | Primary Key |
| title | varchar | Not Null |
| description | varchar | Not Null |
| status | varchar | Default: UPCOMING |
| event_date | timestamp | Not Null |
| reminder_sent | boolean | Default: false |
| created_at | timestamp | Auto |
| updated_at | timestamp | Auto |
| user_id | int8 | Foreign Key → users |

## Running Locally

### Prerequisites
- Java 21
- Gradle
- PostgreSQL database (or Supabase account)

### Setup

1. Clone the repository
```bash
git clone https://github.com/yourusername/task-api.git
cd task-api
```

2. Configure environment variables in `application.properties`
```properties
spring.datasource.url=jdbc:postgresql://YOUR_HOST:PORT/postgres
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

3. Run the application
```bash
./gradlew bootRun
```

4. API runs at `http://localhost:8081`

## Testing the API

Import the Bruno collection from `/docs/TaskAPI.json` to test all endpoints locally.

## Roadmap

- [x] User registration & login
- [x] BCrypt password encryption
- [x] Task CRUD endpoints
- [x] Event CRUD endpoints
- [ ] Goal CRUD endpoints
- [ ] JWT authentication
- [ ] Role-based access control
- [ ] Public deployment (Railway)

## Author

Reeban — Backend Developer in training, building towards Backend × AI Integration.
