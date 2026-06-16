# 🍳 Recipe UI

> The front-end face of the Recipe microservices platform — a Spring Boot web application that brings your recipes to
> life.

[![Test](https://github.com/askie01/recipe-ui/actions/workflows/test.yaml/badge.svg)](https://github.com/askie01/recipe-ui/actions/workflows/test.yaml)
[![Publish](https://github.com/askie01/recipe-ui/actions/workflows/publish.yaml/badge.svg)](https://github.com/askie01/recipe-ui/actions/workflows/publish.yaml)
[![Deploy](https://github.com/askie01/recipe-ui/actions/workflows/deploy.yaml/badge.svg)](https://github.com/askie01/recipe-ui/actions/workflows/deploy.yaml)

---

## 📖 What is this?

**Recipe UI** is the user-facing web service of the Askie Solutions recipe platform. Built with Spring Boot and
Thymeleaf, it delivers a clean, server-rendered experience for browsing, managing, and discovering recipes — secured out
of the box with Spring Security.

---

## 🛠️ Tech Stack

| Layer            | Technology                      |
|------------------|---------------------------------|
| ☕ Language       | Java 25                         |
| 🌱 Framework     | Spring Boot 4.0.6               |
| 🍃 Templating    | Thymeleaf                       |
| 🔒 Security      | Spring Security                 |
| 📊 Observability | Spring Actuator                 |
| 📦 Build         | Maven (via Maven Wrapper)       |
| 🐳 Container     | Docker (eclipse-temurin:25-jre) |
| 🎼 Orchestration | Docker Compose                  |
| ⚙️ CI/CD         | GitHub Actions                  |

---

## 🚀 Getting Started

### 📋 Prerequisites

- ☕ Java 25+
- 📦 Maven (or use the included `mvnw` wrapper)
- 🐳 Docker (optional, for containerised runs)

### 💻 Run locally

```bash
./mvnw spring-boot:run
```

The app starts at **http://localhost:8080/recipes**

### 🐳 Run with Docker

```bash
docker compose up
```

---

## 📁 Project Structure

```
src/main/
├── java/org/askiesolutions/recipeui/
│   ├── RecipeUiApplication.java       # 🚀 Entry point
│   ├── security/                      # 🔒 Security configuration
│   └── view/                          # 🖼️  MVC controllers
└── resources/
    ├── application.yaml               # ⚙️  App configuration
    ├── static/
    │   ├── css/                       # 🎨 Stylesheets
    │   └── images/                    # 🖼️  Static assets
    └── templates/
        ├── fragments/                 # 🧩 Reusable HTML fragments
        ├── layout/                    # 🏗️  Base layout template
        └── pages/                     # 📄 Page content
```

---

## ⚙️ CI/CD Pipeline

Three automated GitHub Actions workflows keep the pipeline running smooth:

| Workflow       | Trigger                            | What it does                                          |
|----------------|------------------------------------|-------------------------------------------------------|
| 🧪 **Test**    | Push / PR to `master`              | Runs unit and integration tests (Java 25 / Temurin)   |
| 📤 **Publish** | After Test succeeds                | Publishes JAR to GitHub Packages & image to `ghcr.io` |
| 🚢 **Deploy**  | After Publish succeeds (or manual) | SSH-deploys the new image to the production VPS       |

---

## 🔒 Security

- 🌐 Public routes: home page `/`, static assets (CSS, images)
- 🔐 All other routes require authentication
- 📝 Form-based login powered by Spring Security
- 👤 Runs as a non-root `appuser` inside the container

---

## 🏥 Health Check

Spring Actuator exposes a health endpoint used by Docker:

```
GET /recipe-ui/actuator/health
```

---

## 🌐 Part of the Askie Solutions Microservices Platform

This service is one piece of a larger microservices ecosystem. It communicates with backend services over the shared
`askie-solutions-network` Docker bridge network.

---

*🤍 Built with care by [Askie Solutions](https://github.com/askie01)*
