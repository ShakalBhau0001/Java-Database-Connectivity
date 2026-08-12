# 💾 JDBC (Java DataBase Connectivity)

## 📘 Overview
**JDBC (Java Database Connectivity)** is a Java API that enables Java programs to interact with databases.  
It allows executing SQL statements, retrieving data, and managing database connections.
This guide explains how to **set up Eclipse IDE**, **configure JDBC libraries**, and **execute a simple JDBC program**.

---

## 🧰 Prerequisites
- **Java JDK** installed (version 8 or above)  
- **Eclipse IDE for Enterprise Java and Web Developers**  
- **Oracle Database** or any other relational DB  
- **`ojdbc8.jar`** JDBC driver  

---

## ⚙️ Step-by-Step Setup Guide

### 🪄 1. Install Eclipse IDE
1. Download **Eclipse IDE for Enterprise Java and Web Developers**  
   👉 [Eclipse Download Link](https://www.eclipse.org/downloads/packages/release/2026-06/r)
2. Select **Windows x86_64** and download the ZIP version.
3. After downloading, locate this file:  
   ```
   eclipse-java-2025-12-R-win32-x86_64.zip
   ```
4. Extract the ZIP file:
   - Right-click on it  
   - Choose **“Extract All…”**
   - You’ll get a folder named **`eclipse`**
5. Open the folder and **double-click `eclipse.exe`** to launch the IDE.

---

### 💡 2. Create a New Java Project
1. In Eclipse, go to the **Menu Bar → File → New → Java Project**
2. Enter a project name (for example: `jdbc`)
3. Click **Finish** and your project will be created.

---

### ✍️ 3. Write JDBC Code
Inside your project, create a new Java class file (e.g., `ConnectionEstablish.java`) and write your **JDBC code** for connecting and executing SQL queries.

#### Example:
```java
ConnectionEstablish.java

import java.sql.*;
import oracle.jdbc.OracleDriver;

public class ConnectionEstablish {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","test","test");
    System.out.println("Connection Established Successfully");
		con.close();
	}
}
```

---

### 🧩 4. Add `ojdbc8.jar` Library
To run your JDBC program, you must add the Oracle JDBC driver JAR file.

**Steps:**
1. Go to **Package Explorer** → Right-click your project (`jdbc`)
2. Choose **Build Path → Configure Build Path**
3. Click on the **Libraries** tab → **Classpath**
4. Select **Add External JARs**
5. Browse and add the JAR file:
   ```
   ojdbc8.jar
   ```
6. Click **Apply and Close**

---

### ▶️ 5. Run the Program
- Press **CTRL + F11** or click the **Run** button in Eclipse.
- Your JDBC program will compile and connect to the database successfully.

---

## 🧠 SQL Commands
Before running the Java code, create a user in Oracle Database:

```sql
CREATE USER test IDENTIFIED BY test;
GRANT dba TO test;
```

---

## ✅ Summary

| Step | Description |
|------|--------------|
| 1️⃣ | Install Eclipse IDE |
| 2️⃣ | Create Java Project |
| 3️⃣ | Write JDBC Code |
| 4️⃣ | Add `ojdbc8.jar` file |
| 5️⃣ | Run the Program |
| 💾 | SQL User Setup in Oracle |

---

## 👨‍💻 Author

> **Developed by:** [Shakal Bhau]  
> **GitHub:**  [ShakalBhau0001](https://github.com/ShakalBhau0001)
