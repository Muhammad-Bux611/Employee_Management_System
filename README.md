# 👨‍💼 Employee Management System REST API

A secure and scalable **Employee Management System** built using **Spring Boot**, **Spring Security**, **JWT Authentication**, **Spring Data JPA**, **Hibernate**, and **MySQL**. The application provides RESTful APIs for managing employees, departments, roles, and users with secure authentication and authorization.

---

# 🚀 Features

## 🔐 Authentication & Authorization

- User Registration
- User Login
- JWT Token Generation
- JWT Token Validation
- Spring Security Integration
- Password Encryption using BCrypt
- Stateless Authentication
- Protected REST APIs

---

## 👥 User Management

- Create User
- Update User
- Delete User
- Get User by ID
- Get All Users
- Secure User Authentication
- Role Assignment

---

## 🏢 Department Management

- Create Department
- Update Department
- Delete Department
- Get Department by ID
- Get All Departments

---

## 👨‍💼 Employee Management

- Add Employee
- Update Employee
- Delete Employee
- Get Employee by ID
- Get All Employees
- Assign Employee to Department
- Employee Information Management

---

## 🎭 Role Management

- Create Role
- Update Role
- Delete Role
- Get Role by ID
- Get All Roles
- Assign Roles to Users

---

## ⚠ Global Exception Handling

Custom exception handling has been implemented for consistent API responses.

Includes:

- ResourceNotFoundException
- Validation Exceptions
- Authentication Exceptions
- Unauthorized Access
- Custom Response Exceptions

---

# 🏗 Project Architecture

The application follows a clean layered architecture.

```
Controller
      │
      ▼
Service Interface
      │
      ▼
Service Implementation
      │
      ▼
Repository
      │
      ▼
Database
```

Project Structure

```
Controller
DTO
Entity
Repository
Service
Service Implementation
Security
Configuration
Exception
Payload
Resources
```

---

# 🔐 JWT Authentication Flow

```
User Login
      │
      ▼
Authentication Manager
      │
      ▼
Generate JWT Token
      │
      ▼
Client Stores JWT
      │
      ▼
Authorization Header

Bearer <JWT_TOKEN>

      │
      ▼
JWT Security Filter
      │
      ▼
Validate Token
      │
      ▼
Access Protected APIs
```

---

# 📚 REST APIs

## Authentication APIs

| Method | Endpoint |
|---------|----------|
| POST | /auth/register |
| POST | /auth/login |

---

## User APIs

| Method | Endpoint |
|---------|----------|
| POST | /users |
| GET | /users |
| GET | /users/{id} |
| PUT | /users/{id} |
| DELETE | /users/{id} |

---

## Employee APIs

| Method | Endpoint |
|---------|----------|
| POST | /employees |
| GET | /employees |
| GET | /employees/{id} |
| PUT | /employees/{id} |
| DELETE | /employees/{id} |

---

## Department APIs

| Method | Endpoint |
|---------|----------|
| POST | /departments |
| GET | /departments |
| GET | /departments/{id} |
| PUT | /departments/{id} |
| DELETE | /departments/{id} |

---

## Role APIs

| Method | Endpoint |
|---------|----------|
| POST | /roles |
| GET | /roles |
| GET | /roles/{id} |
| PUT | /roles/{id} |
| DELETE | /roles/{id} |

---

# 🔒 Security Features

- JWT Authentication
- Spring Security
- BCrypt Password Encryption
- Stateless Authentication
- Secure REST Endpoints
- Authentication Filter
- UserDetailsService Implementation

Authorization Header

```
Authorization: Bearer YOUR_JWT_TOKEN
```

---

# 🗄 Database

Database

```
MySQL
```

ORM

```
Hibernate
```

Persistence

```
Spring Data JPA
```

---

# 🛠 Technologies Used

- Java 17
- Spring Boot
- Spring MVC
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- REST APIs
- BCrypt Password Encoder

---

# 📂 Project Structure

```
src
 ├── main
 │
 ├── java
 │     └── com.erp
 │
 ├── configuration
 ├── controller
 ├── dto
 ├── entity
 ├── repositories
 ├── security
 ├── service
 ├── exception
 ├── payload
 └── resources
```

---

# ⚙ Configuration

Configure the database inside:

```
application.properties
```

Example

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management_system

spring.datasource.username=root

spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true
```

---

# ▶ Running the Application

## Clone Repository

```bash
git clone https://github.com/your-username/Employee_Management_System.git
```

## Navigate to Project

```bash
cd Employee_Management_System
```

## Build Project

```bash
mvn clean install
```

## Run Application

```bash
mvn spring-boot:run
```

or

```bash
./mvnw spring-boot:run
```

---

# 🧪 API Testing

You can test all APIs using:

- Postman
- Swagger (if configured)

---

# 📋 Best Practices Implemented

- Layered Architecture
- DTO Pattern
- Repository Pattern
- Dependency Injection
- Constructor Injection
- JWT Authentication
- Password Encryption
- RESTful API Design
- Global Exception Handling
- Clean Code Principles
- Separation of Concerns
- Validation
- Role-Based Security

---

# 🚀 Future Enhancements

- Refresh Token Authentication
- Pagination & Sorting
- Employee Search & Filtering
- File Upload (Employee Profile Images)
- Email Verification
- Password Reset
- Audit Logging
- Docker Support
- Unit Testing (JUnit & Mockito)
- Integration Testing
- CI/CD Pipeline
- Cloud Deployment
- API Documentation using Swagger/OpenAPI

---

# 👨‍💻 Author

**Muhammad Bux Baloch**

### Backend Java Developer

### Skills

- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Hibernate
- Spring Data JPA
- REST APIs
- MySQL
- Maven
- Git & GitHub

---
