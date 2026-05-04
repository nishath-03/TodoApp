# 📝 Todo Manager Application

## 💡 Learning Outcome

This project was built from scratch with a strong focus on understanding core concepts and system design rather than relying on generated solutions.

Key takeaways:
- Deep understanding of Spring Boot architecture and layers
- Designing and implementing RESTful APIs
- Working with JPA and database interactions
- Building responsive UI and integrating with backend
- Deploying a full-stack application using Docker and cloud platforms

🔗 Live Demo: https://todoapp-p0dp.onrender.com

---

## 🚀 Features

- ➕ Add new tasks with title, description, and priority
- 📋 View all tasks in a structured layout
- ✅ Mark tasks as completed / pending
- ❌ Delete tasks
- 🎯 Priority-based task management (Low, Medium, High)
- 📱 Responsive UI using Bootstrap
- ⚡ Real-time updates without page reload

---

## 🛠️ Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (in-memory)

### Frontend
- HTML
- CSS
- Bootstrap 5
- Vanilla JavaScript (Fetch API)

### Deployment
- Docker
- Render (Cloud Hosting)

---


## ⚙️ API Endpoints

| Method | Endpoint        | Description        |
|-------|----------------|--------------------|
| GET   | /todos         | Get all tasks      |
| POST  | /todos         | Add new task       |
| PUT   | /todos/{id}    | Update task        |
| DELETE| /todos/{id}    | Delete task        |

---

## ▶️ Run Locally

### 1. Clone the repository
```bash
git clone https://github.com/your-username/TodoApp.git
cd TodoApp

2. Run the application
./mvnw spring-boot:run

3. Open in browser
http://localhost:8080

🐳 Run with Docker
docker build -t todo-app .
docker run -p 8080:8080 todo-app
