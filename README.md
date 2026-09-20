# 📚 Library Management System

A console-based **Library Management System** developed using **Java, JDBC, and MySQL**.

This mini project demonstrates how a Java application can connect with a relational MySQL database and perform common library operations such as adding books, viewing books, managing users, borrowing books, and returning books.

---

## 🚀 Features

- ➕ Add Book
- 📖 View Books
- 👤 Add User
- 👥 View Users
- 📕 Borrow Book
- 🔄 Return Book
- 🗄️ MySQL database storage
- 🔌 JDBC database connectivity
- 🖥️ Menu-driven console interface

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application development |
| JDBC | Java-MySQL connectivity |
| MySQL | Database management |
| MySQL Workbench | Database creation and verification |
| IntelliJ IDEA | Development environment |
| Maven | Project structure and dependency management |

---

## 🏗️ Project Structure

```text
LibraryManagementSystem/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── library/
│                   ├── Main.java
│                   ├── Book.java
│                   ├── User.java
│                   ├── Person.java
│                   ├── Library.java
│                   ├── BookDAO.java
│                   ├── UserDAO.java
│                   ├── BorrowDAO.java
│                   └── DatabaseConnection.java
│
├── pom.xml
└── README.md
