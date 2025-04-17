# 🔴 LFC Tours – Backend (Spring Boot)

This is the backend service for **LFC Tours**, a fan club management platform for Liverpool FC supporters. The backend is built using Spring Boot and provides secure CRUD APIs for managing user groups, events, and authentication.

---

## 🚀 Features

- 🧾 CRUD operations for:
  - Users
  - Fan Groups
  - Events
- 🔐 OAuth2-based Authentication
- 🛠 In-memory H2 database for development
- ✅ Unit, Integration, Repository, and MVC (MockMvc) tests
- 🌱 Initial data loading via Spring Boot Initializer

---

## 📦 Tech Stack

- **Spring Boot**
- **Spring Data JPA**
- **Spring Security + OAuth2**
- **H2 Database**
- **Lombok**
- **JUnit 5**
- **MockMvc**
- **Maven**

---

## 📁 Entities & Relationships

```text

# 🔴 LFC Tours – Backend (Spring Boot)

**User**  
  **└── Owns → Group(s)**  
**Group**  
  **└── Has → Event(s)**  

---

**The project has thorough test coverage:**

| **Type**         | **Tool / Framework** | **Description**                            |
|------------------|----------------------|--------------------------------------------|
| **Unit Tests**   | **JUnit 5 + Mockito** | **Isolated service-layer logic**          |
| **Integration**  | **Spring Boot Test** | **Full context tests (API & service)**     |
| **Repository**   | **Spring Data JPA**  | **Query methods & persistence layer tests**|
| **Controller**   | **MockMvc**          | **REST API endpoint behavior tests**       |

**Run all tests with:**

```bash
mvn test
```

---

**📄 API Overview**

| **Resource** | **Endpoints**             | **Description**                         |
|--------------|---------------------------|-----------------------------------------|
| **Users**    | `GET /api/user`           | **Get the user**                        |
| **Groups**   | `POST /api/groups`        | **Create a new fan group**              |
|              | `GET /api/groups`         | **Get all groups**                      |
|              | `GET /api/group/{id}`     | **Get group with particular ID**        |
|              | `DELETE /api/group/{id}`  | **Delete group with particular ID**     |
|              | `PUT /api/group/{id}`     | **Modify group with particular ID**     |

---

**🛠 Development Setup**

**Prerequisites**

- **Java 17+**
- **Maven**

**Run Locally**

```bash
git clone https://github.com/ashkshenoy/lfctours-backend.git
cd lfctours-backend
mvn spring-boot:run
```

**App runs at:** `http://localhost:8080`

---

**H2 Console**

**Access H2 at:** `http://localhost:8080/h2-console`  
(**JDBC URL:** `jdbc:h2:mem:testdb`, **Username:** `sa`, **password:** `password`)

---

**🔐 Authentication (OAuth2)**

**OAuth2 login is enabled for user-level access control.**  
**You can configure OAuth2 providers (e.g., Google, GitHub) in `application.yml`.**
