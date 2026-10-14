# Spring Boot CRUD



## Package Layout

```text
src/main/java/com/example/test/
│
├── TestApplication.java                      # Main Application Class & ModelMapper Bean Configuration
│
├── controller/
│   └── UserController.java                   # REST Controller handling user endpoints (@CrossOrigin, /api/v1/)
│
├── service/
│   └── UserService.java                      # Business logic layer & DTO-Entity conversion using ModelMapper
│
├── repo/
│   └── UserRepo.java                         # Spring Data JPA Repository interface for User entity
│
├── model/
│   └── User.java                             # JPA Entity mapped to MySQL database table
│
└── dto/
    └── UserDTO.java                          # Data Transfer Object (DTO) for user data
```

---

## Database Architecture & Configuration

### Schema Layout
```text
testDb (MySQL)
└── user
    ├── id                                    # INT (Primary Key)
    └── name                                  # VARCHAR (User Name)
```

### Table Auto-Generation
Hibernate is configured with `ddl-auto: update`, which automatically creates or updates the `user` table structure upon application startup based on the `@Entity` definition in `User.java`.

---

## Prerequisites & Setup

### Prerequisites
- **Java:** JDK 17+ installed (`java -version`)
- **Database:** MySQL 8.0+ running locally on port `3306`
- **Build Tool:** Maven Wrapper (bundled inside repository)

### 1. Database Creation
The connection string is configured with `createDatabaseIfNotExist=true`. Alternatively, you can create the database manually in MySQL:
```sql
CREATE DATABASE IF NOT EXISTS testDb;
```

### 2. Configure Credentials
Update your database credentials in `src/main/resources/application.properties` to match your local MySQL configuration:

```properties
spring.application.name=test
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/testDb?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
```

### 3. Build & Run
Run the application using the Maven wrapper:

**Windows (PowerShell / Command Prompt):**
```cmd
.\mvnw.cmd spring-boot:run
```

**macOS / Linux:**
```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

---

## API Specification & Verification

Base URL: `http://localhost:8080/api/v1`

### 1. Get All Users
- **Endpoint:** `GET /api/v1/getuser`
- **Method:** `GET`
- **Response (`200 OK`):**
  ```json
  [
    {
      "id": 1,
      "name": "Kasun Perera"
    }
  ]
  ```

---

### 2. Get User by ID
- **Endpoint:** `GET /api/v1/getuser/{userId}`
- **Method:** `GET`
- **Example Request:** `GET /api/v1/getuser/1`
- **Response (`200 OK`):**
  ```json
  {
    "id": 1,
    "name": "Kasun Perera"
  }
  ```

---

### 3. Add a New User
- **Endpoint:** `POST /api/v1/adduser`
- **Method:** `POST`
- **Headers:** `Content-Type: application/json`
- **Request Body:**
  ```json
  {
    "id": 1,
    "name": "Kasun Perera"
  }
  ```
- **Response (`200 OK`):**
  ```json
  {
    "id": 1,
    "name": "Kasun Perera"
  }
  ```

---

### 4. Update an Existing User
- **Endpoint:** `PUT /api/v1/updateuser`
- **Method:** `PUT`
- **Headers:** `Content-Type: application/json`
- **Request Body:**
  ```json
  {
    "id": 1,
    "name": "Kasun Perera Updated"
  }
  ```
- **Response (`200 OK`):**
  ```json
  {
    "id": 1,
    "name": "Kasun Perera Updated"
  }
  ```

---

### 5. Delete a User
- **Endpoint:** `DELETE /api/v1/deleteuser/{userId}`
- **Method:** `DELETE`
- **Example Request:** `DELETE /api/v1/deleteuser/1`
- **Response (`200 OK`):**
  ```text
  User deleted successfully
  ```
