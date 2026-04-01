# 🎓 Student Management System (Backend)

## 🚀 Overview

This is a backend application for managing students and colleges, built using Spring Boot. It provides REST APIs to perform CRUD operations and manage relationships between students and colleges.

---

## 🛠 Tech Stack

* Java
* Spring Boot
* Spring Data JPA (Hibernate)
* PostgreSQL
* REST APIs

---

## 📌 Features

* Create, update, delete, and fetch students
* Manage college details
* Establish Student–College relationship (Many-to-One)
* Layered architecture (Controller, Service, Repository)
* Global Exception Handling
* Clean REST API design

---

## 🧠 Concepts Used

* MVC Architecture
* JPA & Hibernate ORM
* Entity Relationships (Many-to-One)
* Exception Handling using `@RestControllerAdvice`
* DTO Pattern (Recommended)

---

## 📂 Project Structure

```
student-management-system-backend/
 ├── controller/
 ├── service/
 ├── repository/
 ├── entity/
 ├── dto/
 ├── exception/
 └── main application class
```

---

## 🔗 API Endpoints

### Student APIs

| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| POST   | /students      | Create student    |
| GET    | /students      | Get all students  |
| GET    | /students/{id} | Get student by ID |
| PUT    | /students/{id} | Update student    |
| DELETE | /students/{id} | Delete student    |

---

### College APIs

| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| POST   | /colleges      | Create college    |
| GET    | /colleges      | Get all colleges  |
| GET    | /colleges/{id} | Get college by ID |

---

## 🔐 Sample Relationship

* One College → Many Students
* Each Student belongs to one College

---

## ▶️ How to Run

1. Clone the repository
2. Open in Eclipse / IntelliJ
3. Configure PostgreSQL in `application.properties`
4. Run the Spring Boot application
5. Test APIs using Postman

---

## 🛠 Tools Used

* Postman (API Testing)
* Eclipse IDE
* Git & GitHub

---

## 🚀 Future Improvements

* Add Spring Security & JWT Authentication
* Add Pagination & Sorting
* Add Swagger API Documentation
* Build Frontend using React

---

## 👨‍💻 Author

Swapnil Devkar
