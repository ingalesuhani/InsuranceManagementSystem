# Insurance Management System

This is a simple Java-based Insurance Management System built for the Hexaware Technologies Coding Challenge 4. The application follows object-oriented principles and demonstrates basic CRUD operations, database integration, and exception handling.

##  Features

- Manage policies: Create, update, delete, and retrieve policy records
- Handle client and claim information
- Connect to a database using JDBC
- Modular structure with clear separation of concerns
- Custom exceptions for specific error handling
- Menu-driven interface for smooth interaction

##  Project Structure

InsuranceManagementSystem/ │
├── dao/ # Interfaces and DB interaction logic 
├── entity/ # Data models (User, Client, Claim, etc.) 
├── exception/ # Custom user-defined exceptions 
├── util/ # Utility classes for DB connection and properties 
└── main/ # Main module to run the application


## ⚙️ Technologies Used

- Java (Core)
- JDBC
- MySQL (or any relational DB)
- Maven (optional)
- Git

##  How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/ingalesuhani/InsuranceManagementSystem.git

   Set up your database and update the property file with your DB config.

Compile and run the application from the main package.

 Notes
Make sure your MySQL server (or preferred RDBMS) is running.

DB connection details should be configured in the .properties file.

Exception handling is implemented where appropriate to ensure robustness.

 License
This project is part of a coding challenge submission and is not licensed for commercial use.


