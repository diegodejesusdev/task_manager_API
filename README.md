# ✅ Task Manager API

API REST para gestionar **proyectos, tareas, usuarios y etiquetas**, construida con **Java 21 + Spring Boot 3.4** y **MySQL**. Fue el backend de una aplicación de gestión de tareas (frontend en React, en el repo archivado `task_manager_Frontend`).

![Java](https://img.shields.io/badge/Java_21-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_3.4-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white)

## ¿Qué hace?

- Crea y lista **proyectos** con fechas de inicio y fin, y devuelve las tareas de cada proyecto.
- Crea, lista y elimina **tareas** con descripción, fecha de vencimiento, estado (`Pendiente`, `En_Proceso`, `Terminada`), prioridad y proyecto.
- **Asigna usuarios** a una tarea y consulta quiénes están asignados.
- Crea **etiquetas** y las asocia a tareas (relación muchos a muchos).
- Registra, busca por correo y elimina **usuarios**.

## Modelo de datos

```
Project 1 ──── * Task * ──── * User      (asignaciones)
                 │ *
                 ├──── * Tag              (task_tag)
                 └──── 1 Priority
```

Entidades JPA en `persistence/entity`: `ProjectEntity`, `TaskEntity`, `UserEntity`, `TagEntity`, `PriorityEntity`, `AssigmentEntity`, `TaskTagEntity` y el enum `Status`.

## Arquitectura

```
web/            Controladores REST (Project, Task, User, Tag) + configuración CORS
services/       Lógica de negocio
persistence/    Entidades JPA y repositorios Spring Data
```

Todas las rutas cuelgan de `/taskmanager` (`spring.mvc.servlet.path`).

## Endpoints

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/project/all` | Lista todos los proyectos |
| GET | `/project/name?name=` | Busca un proyecto por nombre |
| POST | `/project/save` | Crea o actualiza un proyecto |
| GET | `/project/{id}/tasks` | Tareas de un proyecto |
| GET | `/task/all` | Lista todas las tareas |
| POST | `/task/save` | Crea o actualiza una tarea |
| GET | `/task/{taskId}/users` | Usuarios asignados a una tarea |
| POST | `/task/{taskId}/assign/{userId}` | Asigna un usuario a una tarea |
| POST | `/task/{taskId}/tag/{tagId}` | Agrega una etiqueta a una tarea |
| DELETE | `/task/delete/{id}` | Elimina una tarea |
| GET | `/user/all` | Lista los usuarios |
| GET | `/user/email?email=` | Busca un usuario por correo |
| POST | `/user/save` | Crea o actualiza un usuario |
| DELETE | `/user/delete/{id}` | Elimina un usuario |
| GET | `/tag/all` | Lista las etiquetas |
| POST | `/tag/save` | Crea una etiqueta |

Ejemplo — crear un proyecto:

```bash
curl -X POST http://localhost:8080/taskmanager/project/save \
  -H "Content-Type: application/json" \
  -d '{"nameProject":"Trabajo Final","descriptionProject":"Electiva IV","startDateProject":"2024-11-25","endDateProject":"2024-11-28"}'
```

## Cómo ejecutarlo

Requisitos: JDK 21, Maven y MySQL 8 con una base `task_manager`.

```bash
# Credenciales por variables de entorno (valores por defecto: localhost, root, sin contraseña)
export DATABASE_URL=jdbc:mysql://localhost:3306/task_manager
export DATABASE_USER=root
export DATABASE_PASSWORD=tu_password

./mvnw spring-boot:run
# API en http://localhost:8080/taskmanager
```

Con Docker (el `Dockerfile` copia el JAR ya compilado):

```bash
./mvnw clean package
cp target/TaskManager-0.0.1-SNAPSHOT.jar target/TaskManager.jar
docker build -t task-manager .
docker run -p 8080:8080 -e DATABASE_URL=... -e DATABASE_USER=... -e DATABASE_PASSWORD=... task-manager
```

El CORS solo permite `http://localhost:5173` (el frontend con Vite). La API estuvo desplegada en Render en `https://task-manager2-latest.onrender.com/taskmanager`.

## Pendientes conocidos

- No tiene autenticación ni validación de datos de entrada.
- El `Dockerfile` espera `target/TaskManager.jar`, pero Maven genera `TaskManager-0.0.1-SNAPSHOT.jar` (falta `<finalName>` en el `pom.xml`).
- No tiene pruebas más allá del test de arranque de Spring.
