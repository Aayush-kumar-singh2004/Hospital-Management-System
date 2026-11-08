# Hospital Management System

A console-based Hospital Management System developed using **Core Java, JDBC, and Oracle Database 11g XE**. This application helps manage patient records, view doctor details, and book appointments through a menu-driven console.

## Technologies Used

- Core Java
- JDBC (Java Database Connectivity)
- Oracle Database 11g Express Edition
- SQL
- Eclipse IDE
- Oracle JDBC Driver (`ojdbc6.jar`)

## Features

1. **Add Patient** – Register a patient with an ID, name, age, gender, phone number, and address.
2. **View Patients** – Display all registered patient records.
3. **View Doctors** – Display available doctor details.
4. **Book Appointment** – Book an appointment using a patient ID, doctor ID, and appointment date.
5. **Doctor Availability Check** – Check whether the selected doctor already has an appointment on the requested date.
6. **Patient and Doctor Validation** – Verify that the entered patient and doctor IDs exist before booking an appointment.

## Database Structure

The application uses three tables in the Oracle `HOSPITAL` schema.

### PATIENTS

| Column | Data Type |
|---|---|
| ID | `VARCHAR2(200)` |
| NAME | `VARCHAR2(200)` |
| AGE | `NUMBER(10)` |
| GENDER | `VARCHAR2(50)` |
| PHONE | `VARCHAR2(10)` |
| ADDRESS | `VARCHAR2(200)` |

### DOCTORS

| Column | Data Type |
|---|---|
| ID | `VARCHAR2(50)` |
| NAME | `VARCHAR2(200)` |
| SPECIALIZATION | `VARCHAR2(255)` |
| PHONE | `VARCHAR2(10)` |

### APPOINTMENTS

| Column | Data Type |
|---|---|
| ID | `VARCHAR2(200)` |
| PATIENT_ID | `VARCHAR2(200)` |
| DOCTOR_ID | `VARCHAR2(200)` |
| APPOINTMENT_DATE | `DATE` |

## SQL Concepts Covered

This project provides practical exposure to the five major categories of SQL commands:

- **DDL (Data Definition Language)** – Create and manage database tables using commands such as `CREATE`, `ALTER`, `TRUNCATE`, and `DROP`.
- **DML (Data Manipulation Language)** – Insert, update, and delete patient, doctor, and appointment records using `INSERT`, `UPDATE`, and `DELETE`.
- **DQL (Data Query Language)** – Retrieve and display records using the `SELECT` statement.
- **DCL (Data Control Language)** – Understand database access permissions using `GRANT` and `REVOKE`.
- **TCL (Transaction Control Language)** – Understand transaction management using `COMMIT`, `ROLLBACK`, and `SAVEPOINT`.

## Project Structure

```text
HospitalManagementSystem/
├── src/
│   └── hospitalmanagement/
│       ├── DBConnection.java
│       ├── Patient.java
│       ├── Doctor.java
│       ├── Appointment.java
│       └── HospitalManagementSystem.java
├── README.md
├── .gitignore
└── .env                 # Create locally; do not upload to GitHub
```

The Oracle JDBC driver must be added to the project's Eclipse Build Path. It can be stored outside the repository.

## Database Setup

1. Install and start Oracle Database 11g XE.
2. Create an Oracle database user/schema for this project (for example, `HOSPITAL`).
3. Connect to that schema using SQL*Plus or another Oracle SQL client.
4. Create the `PATIENTS`, `DOCTORS`, and `APPOINTMENTS` tables using the column definitions above.
5. Configure primary keys and required `NOT NULL` constraints.
6. Insert doctor records for testing the application.

## Database Configuration

The application reads database credentials from a local `.env` file in the project root.

Create a `.env` file with your own Oracle credentials:

```properties
DB_USERNAME=YOUR_ORACLE_USERNAME
DB_PASSWORD=YOUR_ORACLE_PASSWORD
```

The JDBC URL used by the application is:

```java
jdbc:oracle:thin:@localhost:1521:XE
```

**Important:** Do not upload your `.env` file to GitHub because it contains your database credentials. Make sure `.env` is included in `.gitignore`.

## How to Run

1. Clone or download this repository.
2. Import the project into Eclipse as an existing Java project.
3. Add the Oracle JDBC driver (`ojdbc6.jar`) to the project's Build Path.
4. Create the Oracle schema and the three required tables.
5. Create the local `.env` file and enter your Oracle database credentials.
6. Open `HospitalManagementSystem.java`.
7. Run it as a **Java Application**.
8. Follow the console menu to add patients, view patients and doctors, or book appointments.

## Learning Outcomes

- Applied Object-Oriented Programming concepts in a Java application.
- Connected a Java application to Oracle Database using JDBC.
- Used `PreparedStatement` to execute parameterized SQL queries.
- Practiced database operations such as `INSERT` and `SELECT`.
- Implemented patient and doctor validation.
- Implemented doctor appointment availability checking.
- Gained practical understanding of DDL, DML, DQL, DCL, and TCL commands.
- Learned how Java applications interact with relational databases.

## Author

**Aayush Kumar Singh**