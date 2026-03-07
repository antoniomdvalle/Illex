
# ILLEX BACKEND DEVELOPMENT PLAN


```text
ILLEX
The Intelligent Bank
Backend Development Roadmap
Stack:
- Java 21
- Spring Boot
- Spring Security
- PostgreSQL
- Maven
- JWT
```

---

# PHASE 1 — ARCHITECTURE FOUNDATION

Goal: turn the project into a professional backend structure.

## Step 1 — Fix Project Structure

Create packages:

```
src/main/java/com/example/illex

config
controller
service
repository
model
dto
security
exception
mapper
```

Final structure:

```
illex
│
├── config
│
├── controller
│   ├── AuthController
│   ├── TransactionController
│   ├── GoalController
│   └── DashboardController
│
├── service
│   ├── AuthService
│   ├── UserService
│   ├── TransactionService
│   ├── GoalService
│   └── DashboardService
│
├── repository
│   ├── UserRepository
│   ├── TransactionRepository
│   └── GoalRepository
│
├── model
│   ├── User
│   ├── Transaction
│   ├── Goal
│   └── TransactionType (enum)
│
├── dto
│   ├── auth
│   │   ├── RegisterRequest
│   │   └── LoginRequest
│   │
│   ├── transaction
│   │   └── TransactionDTO
│   │
│   ├── goal
│   │   └── GoalDTO
│   │
│   └── dashboard
│       └── DashboardResponse
│
├── mapper
│   ├── TransactionMapper
│   └── GoalMapper
│
├── security
│   ├── JwtService
│   ├── JwtFilter
│   └── CustomUserDetailsService
│
├── exception
│   ├── GlobalExceptionHandler
│   └── ResourceNotFoundException
│
└── IllexApplication
```

---

# PHASE 2 — DOMAIN IMPROVEMENTS

## Step 2 — Create TransactionType Enum

Replace:

```
private String type;
```

with:

```
TransactionType type;
```

Enum:

```
INCOME
EXPENSE
```

Reason:
Prevents invalid values.

---

# PHASE 3 — SERVICE LAYER

Goal: move **business logic out of controllers**.

Controllers must NEVER access repositories.

Flow:

```
Controller
   ↓
Service
   ↓
Repository
   ↓
Database
```

Services to create:

```
UserService
TransactionService
GoalService
AuthService
DashboardService
```

Example responsibilities:

### TransactionService

```
createTransaction()
getUserTransactions()
deleteTransaction()
```

### GoalService

```
createGoal()
updateGoal()
deleteGoal()
listGoals()
```

---

# PHASE 4 — REST API

Create controllers.

## Auth

```
POST /auth/register
POST /auth/login
```

## Transactions

```
GET /transactions
POST /transactions
DELETE /transactions/{id}
```

## Goals

```
GET /goals
POST /goals
PUT /goals/{id}
DELETE /goals/{id}
```

## Dashboard

```
GET /dashboard
```

Returns:

```
{
 income: 5000,
 expenses: 3200,
 balance: 1800,
 goals: 3
}
```

---

# PHASE 5 — SECURITY

Implement authentication using **JSON Web Token**.

Components:

```
JwtService
JwtFilter
SecurityConfig
CustomUserDetailsService
```

Flow:

```
login
 ↓
generate JWT
 ↓
client stores token
 ↓
request with Authorization header
 ↓
JwtFilter validates
 ↓
request allowed
```

---

# PHASE 6 — PASSWORD SECURITY

Passwords must be hashed.

Use:

```
BCryptPasswordEncoder
```

Example:

```
passwordEncoder.encode(password)
```

Never store raw passwords.

---

# PHASE 7 — DTO LAYER

Never expose Entities.

Entities represent database.

DTOs represent API.

Create:

```
RegisterRequest
LoginRequest
TransactionDTO
GoalDTO
DashboardResponse
```

Example:

```
TransactionDTO
- type
- category
- description
- amount
- date
```

---

# PHASE 8 — MAPPERS

Convert:

```
Entity ↔ DTO
```

Example:

```
TransactionMapper
GoalMapper
```

Example method:

```
TransactionDTO toDTO(Transaction t)
Transaction toEntity(TransactionDTO dto)
```

---

# PHASE 9 — VALIDATION

Add validation using:

```
jakarta.validation
```

Examples:

```
@NotNull
@NotBlank
@Positive
@Email
```

Applied to DTOs.

---

# PHASE 10 — ERROR HANDLING

Create:

```
GlobalExceptionHandler
```

Return standard error JSON.

Example:

```
{
 "error": "Transaction not found"
}
```

---

# PHASE 11 — DASHBOARD LOGIC

Important backend exercise.

DashboardService calculates:

```
Total income
Total expenses
Balance
Number of active goals
```

Using repository queries.

---

# PHASE 12 — API DOCUMENTATION

Add **Swagger OpenAPI**.

Endpoint:

```
/swagger-ui
```

Shows:

* all endpoints
* request bodies
* responses

This is expected in professional APIs.

---

# PHASE 13 — TESTING

Create tests using **JUnit**.

Test:

```
Service layer
Controller endpoints
```

---

# PHASE 14 — DEPLOYMENT

Containerize using **Docker**.

Deploy options:

```
Render
Railway
Fly.io
```

Database:

```
PostgreSQL cloud
```

Final API example:

```
https://illex-api.onrender.com
```

---

# PHASE 15 — ANALYTICS (FUTURE)

Python analytics engine.

Using:

```
pandas
numpy
```

Features:

```
spending patterns
monthly predictions
financial health score
```

---

# FINAL PROJECT CHECKLIST

When Illex has:

```
✔ JWT authentication
✔ Layered architecture
✔ DTO structure
✔ CRUD operations
✔ Dashboard logic
✔ Validation
✔ Error handling
✔ Swagger docs
✔ PostgreSQL integration
✔ Docker deployment
```

It becomes a **strong junior backend portfolio project**.

---

# FINAL EXERCISE (CRITICAL)

After finishing Illex:

Build another API **from scratch without looking at the code**.

Example:

```
Task Management API
```

Features:

```
Auth
Users
Projects
Tasks
CRUD
JWT
Dashboard
```

If you can do it without help, backend is internalized.

---
