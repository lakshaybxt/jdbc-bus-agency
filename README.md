Bus Travelling Agency 🚍
A Java console-based application to manage bus schedules and passenger records with persistent storage using MySQL.

✨ Features
Add, list, search, and delete buses.

Book, list, search, and delete passengers.

View available buses.

Input validation for all user inputs.

Interactive and user-friendly menu-driven system.

Persistent data storage using JDBC with MySQL database.

🛠️ Tech Stack
Java

MySQL

JDBC (Java Database Connectivity)

Object-Oriented Programming (OOP) principles

📂 Project Structure
css
Copy
Edit
├── model
│   ├── Bus.java
│   └── Passenger.java
├── service
│   ├── BusService.java
│   └── PassengerService.java
├── util
│   └── InputHelper.java
└── Main.java
🗄️ Database Schema
bus Table
sql
Copy
Edit
CREATE TABLE bus (
busNo INT PRIMARY KEY,
scheduleDate DATE NOT NULL,
capacity INT NOT NULL,
isAvailable TINYINT(1) DEFAULT 1,
startingPoint VARCHAR(100),
destinationPoint VARCHAR(100)
);
passenger Table
sql
Copy
Edit
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
📋 How to Run
Set up a MySQL database and create the above tables.

Update your JDBC connection settings in the project if needed (URL, username, password).

Compile and run Main.java using your favorite IDE or command line.

Follow the console prompts to use the application.