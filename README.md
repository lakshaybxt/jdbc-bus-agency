# Bus Travelling Agency 🚍

A **Java console-based application** to manage bus schedules and passenger records with persistent storage using **MySQL**.

[![Made with Java](https://img.shields.io/badge/Made%20with-Java-007396?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![Database MySQL](https://img.shields.io/badge/Database-MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Status](https://img.shields.io/badge/Project-Completed-brightgreen?style=for-the-badge)]()

---

## ✨ Features

- Add, list, search, and delete buses.
- Book, list, search, and delete passengers.
- View available buses.
- Input validation for user inputs.
- Persistent data storage using **JDBC**.
- Modular and maintainable design using **OOP Principles**.

---

## 🛠️ Tech Stack

- Java
- MySQL
- JDBC (Java Database Connectivity)
- Object-Oriented Programming (OOP)

---

## 📂 Project Structure

├── model 
│     ├── Bus.java 
│     └── Passenger.java 
├── service 
│     ├── BusService.java 
│     └── PassengerService.java 
├── util 
│     └── InputHelper.java 
└── Main.java


---

## 🗄️ Database Schema

### `bus` Table
```sql
CREATE TABLE bus (
    busNo INT PRIMARY KEY,
    scheduleDate DATE NOT NULL,
    capacity INT NOT NULL,
    isAvailable TINYINT(1) DEFAULT 1,
    startingPoint VARCHAR(100),
    destinationPoint VARCHAR(100)
);
```
### `passenger` Table
```sql
CREATE TABLE passenger (
    passId INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10),
    contactNumber VARCHAR(15),
    dateBooked DATE NOT NULL,
    amountPaid DECIMAL(10,2) NOT NULL,
    boardingPoint VARCHAR(100) NOT NULL,
    destinationPoint VARCHAR(100) NOT NULL,
    busNo INT,
    FOREIGN KEY (busNo) REFERENCES bus(busNo)
);
```

## 📋How to Run
Set up a MySQL database and create the above tables.

Update JDBC connection details (URL, username, password) in your Java code if required.

Compile and run Main.java through any Java IDE (like IntelliJ, Eclipse) or using the command line.

Interact with the console-based menu to use features.