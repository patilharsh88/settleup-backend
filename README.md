# SettleUp - Expense Sharing Management System

## Overview

SettleUp is a Spring Boot REST API project for managing shared expenses among a group of users. It allows users to create groups, add expense categories, record expenses, and manage users through CRUD operations.

This project follows a simple layered architecture using Spring Boot, Spring Data JPA, and MySQL.

---

# Features

* User Management

  * Create User
  * View User
  * Update User
  * Delete User

* Group Management

  * Create Group
  * View Groups
  * Update Group
  * Delete Group

* Category Management

  * Create Category
  * View Categories
  * Update Category
  * Delete Category

* Expense Management

  * Create Expense
  * View Expenses
  * View Expenses by Group
  * Update Expense
  * Delete Expense

---

# Technologies Used

* Java 8
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Maven

---

# Project Structure

```
com.SettleUp
│
├── Controller
│   ├── UserController
│   ├── GroupController
│   ├── ExpenseController
│   └── CategoryController
│
├── Entity
│   ├── BaseEntity
│   ├── Users
│   ├── Group
│   ├── Expense
│   └── Category
│
├── Repository
│   ├── UserRepository
│   ├── GroupRepository
│   ├── ExpenseRepository
│   └── CategoryRepository
│
├── Service
│   ├── UserService
│   ├── GroupService
│   ├── ExpenseService
│   └── CategoryService
│
└── SettleUpApplication
```

---

# Entity Relationships

### Users

* A user can belong to multiple groups.
* A user can create groups.
* A user can create categories.
* A user can pay expenses.

### Group

* A group contains multiple members.
* A group contains multiple expenses.
* A group contains multiple categories.

### Category

* Each category belongs to one group.
* Each category is created by one user.

### Expense

* Each expense belongs to one group.
* Each expense belongs to one category.
* Each expense is paid by one user.

---

# Database Tables

* users
* groups
* group_members
* expenses
* categories

---

# REST API Endpoints

## User APIs

| Method | Endpoint          | Description    |
| ------ | ----------------- | -------------- |
| POST   | `/api/users`      | Create User    |
| GET    | `/api/users`      | Get All Users  |
| GET    | `/api/users/{id}` | Get User By Id |
| PUT    | `/api/users/{id}` | Update User    |
| DELETE | `/api/users/{id}` | Delete User    |

---

## Group APIs

| Method | Endpoint                    | Description     |
| ------ | --------------------------- | --------------- |
| POST   | `/api/groups/{createdById}` | Create Group    |
| GET    | `/api/groups`               | Get All Groups  |
| GET    | `/api/groups/{id}`          | Get Group By Id |
| PUT    | `/api/groups/{id}`          | Update Group    |
| DELETE | `/api/groups/{id}`          | Delete Group    |

---

## Category APIs

| Method | Endpoint                             | Description        |
| ------ | ------------------------------------ | ------------------ |
| POST   | `/api/categories/{groupId}/{userId}` | Create Category    |
| GET    | `/api/categories/allCategory`        | Get All Categories |
| GET    | `/api/categories/{id}`               | Get Category By Id |
| PUT    | `/api/categories/{id}`               | Update Category    |
| DELETE | `/api/categories/{id}`               | Delete Category    |

---

## Expense APIs

| Method | Endpoint                                          | Description           |
| ------ | ------------------------------------------------- | --------------------- |
| POST   | `/api/expenses/{paidById}/{groupId}/{categoryId}` | Create Expense        |
| GET    | `/api/expenses`                                   | Get All Expenses      |
| GET    | `/api/expenses/{id}`                              | Get Expense By Id     |
| GET    | `/api/expenses/group/{groupId}`                   | Get Expenses By Group |
| PUT    | `/api/expenses/{id}`                              | Update Expense        |
| DELETE | `/api/expenses/{id}`                              | Delete Expense        |

---

# CRUD Operations

## Users

* Create User
* Read User
* Update User
* Delete User

## Groups

* Create Group
* Read Group
* Update Group
* Delete Group

## Categories

* Create Category
* Read Category
* Update Category
* Delete Category

## Expenses

* Create Expense
* Read Expense
* Update Expense
* Delete Expense

---

# Validation Implemented

* Duplicate email is not allowed while creating a user.
* Group must exist before creating a category.
* User must exist before creating a category.
* User must exist before creating an expense.
* Group must exist before creating an expense.
* Category must exist before creating an expense.

---

# Exception Handling

The application throws `RuntimeException` when:

* User is not found.
* Group is not found.
* Category is not found.
* Expense is not found.
* Email already exists.

---

# How to Run

1. Clone the repository.
2. Open the project in your preferred IDE.
3. Configure the MySQL database in `application.properties`.
4. Create the required database.
5. Run the Spring Boot application.
6. Test the APIs using Postman.

---

# Future Enhancements

* Spring Security with JWT Authentication
* Role-Based Authorization
* Global Exception Handling
* DTO Pattern
* Input Validation
* Pagination and Sorting
* Expense Split Calculation
* Settlement History
* Swagger/OpenAPI Documentation

---

# Author

**Name:** Harshwardhan Patil

**Project:** SettleUp - Expense Sharing Management System

**Technology Stack:** Java, Spring Boot, Spring Data JPA, Hibernate, MySQL
