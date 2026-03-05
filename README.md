# 🛰️ SLOM - Satellite Launch and Orbit Manager

A Java + MySQL console application to manage satellite launches and orbits.
Built as a learning project to understand Core Java, JDBC, and SQL.

---

## 💡 Problem Statement

Managing satellite data manually is complex. SLOM solves the following:
- Which satellite is being launched?
- When and from where is it being launched?
- Which orbit is the satellite going to?

---

## ⚙️ Tech Stack

| Technology | Usage |
|---|---|
| Java | Core application logic |
| MySQL | Database to store satellite, orbit and launch data |
| JDBC | Connecting Java to MySQL |
| Maven | Dependency management |
| IntelliJ IDEA | Development environment |

---

## 🗄️ Database Schema

**Table 1 — Satellites**
| Column | Type | Constraint |
|---|---|---|
| sat_id | BIGINT | PRIMARY KEY |
| name | VARCHAR(200) | NOT NULL, UNIQUE |
| type | VARCHAR(400) | NOT NULL |
| manufacturer | VARCHAR(400) | NOT NULL |

**Table 2 — Orbit**
| Column | Type | Constraint |
|---|---|---|
| orbit_id | BIGINT | PRIMARY KEY |
| orbit_type | VARCHAR(200) | NOT NULL, UNIQUE |
| altitude | DOUBLE | NOT NULL |

**Table 3 — Launches**
| Column | Type | Constraint |
|---|---|---|
| launch_id | BIGINT | PRIMARY KEY |
| launch_date | TIMESTAMP | NOT NULL |
| launch_site | VARCHAR(400) | NOT NULL |
| sat_id | BIGINT | FOREIGN KEY → Satellites |
| orbit_id | BIGINT | FOREIGN KEY → Orbit |

---

## 📁 Project Structure
```
src/
└── main/
    └── java/
        ├── com.slom.model        → Data classes (Satellites, Orbit, Launches)
        ├── com.slom.dao          → Database access (SatelliteDAO, OrbitDAO, LaunchDAO)
        └── com.slom.main         → Entry point (Main.java, DBConnection.java)
```

---

## ✨ Features

- ➕ Add a new satellite
- ➕ Add a new orbit
- ➕ Add a new launch
- 📋 View all satellites
- 📋 View all orbits
- 📋 View full launch history
- 🔍 View satellites by orbit type

---

## 🏗️ Architecture

This project follows the **DAO (Data Access Object)** pattern:
```
Main.java        →  Collects user input via Scanner
Model Classes    →  Hold the data as objects
DAO Classes      →  Send data to MySQL using JDBC
MySQL Database   →  Stores all data persistently
```

---

## 🚀 How to Run

1. Clone the repository
```bash
git clone https://github.com/yourusername/Satellite-Launch-and-Orbit-Manager.git
```

2. Create the MySQL database
```sql
CREATE DATABASE SLOM;
USE SLOM;
```

3. Create the tables using the schema above

4. Update `DBConnection.java` with your MySQL credentials
```java
private static final String USER = "root";
private static final String PASSWORD = "yourpassword";
```

5. Run `Main.java` in IntelliJ IDEA

---

## 📚 What I Learned

- Java OOP — classes, objects, encapsulation
- JDBC — connecting Java to a real database
- SQL — DDL, DML, joins, foreign keys
- DAO design pattern
- Maven dependency management
- Git and GitHub version control

