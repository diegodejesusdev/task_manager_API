## Documentación de Endpoints

## Endpoints de Project Controller

### GET 
#### /project/all

Este endpoint devuelve todos los proyectos que se encuentran en la base de datos.

- URL: https://task-manager2-latest.onrender.com/taskmanager/project/all


### POST
#### /project/save

Este endpoint permite guardar un proyecto en la base de datos.

- URL: https://task-manager2-latest.onrender.com/taskmanager/project/save
- Body: 
```json
{
  "nameProject":"Trabajo Final Electiva IV",
  "descriptionProject":"Trabajo final",
  "startDateProject":"2024-11-25",
  "endDateProject":"2024-11-28"
}
```
### GET
#### /project/{idProject}/tasks

Este endpoint devuelve todas las tareas que se encuentran en un proyecto específico.

- URL: https://task-manager2-latest.onrender.com/taskmanager/project/1/tasks

## Endpoints de User Controller

### GET
#### /user/all

Este endpoint devuelve todos los usuarios que se encuentran en la base de datos.

- URL: https://task-manager2-latest.onrender.com/taskmanager/user/all

### POST
#### /user/save

Este endpoint permite guardar un usuario en la base de datos.

- URL: https://task-manager2-latest.onrender.com/taskmanager/user/save
- Body:
```json
{
  "nameUser": "Jean Pierre Castrillon",
  "emailUser": "jean@gmail.com"
}
```
### DELETE
#### /user/delete/{idUser}

Este endpoint permite eliminar un usuario de la base de datos.

- URL: https://task-manager2-latest.onrender.com/taskmanager/user/delete/2

## Endpoints de Task Controller

### GET
#### /task/all

Este endpoint devuelve todas las tareas que se encuentran en la base de datos.

- URL: https://task-manager2-latest.onrender.com/taskmanager/task/all

### POST
#### /task/save

Este endpoint permite guardar una tarea en la base de datos.

- URL: https://task-manager2-latest.onrender.com/taskmanager/task/save
- Body:
```json
{
  "nameTask": "Crear repositorio en GitHub",
  "descriptionTask": "Jajajaja",
  "expirationDateTask": "2024-11-24",
  "statusTask": "Pendiente",
  "priorityTask": {
    "idPriority": 2
  },
  "projectTask": {
    "idProject": 2
  }
}
```

### GET
#### /task/{idTask}/users

Este endpoint devuelve todos los usuarios que se encuentran asignados a una tarea específica.

- URL: https://task-manager2-latest.onrender.com/taskmanager/task/2/users

### POST
#### /task/{idTask}/assign/{idUser}

Este endpoint permite asignar un usuario a una tarea.

- URL: https://task-manager2-latest.onrender.com/taskmanager/task/2/assign/3

### POST
#### /task/{idTask}/tag/{idTag}

Este endpoint permite asignar etiquetas a una tarea.

- URL: https://task-manager2-latest.onrender.com/taskmanager/task/2/tag/4

## Endpoints de Tag Controller

### POST
#### /tag/save

Este endpoint permite guardar una etiqueta en la base de datos.

- URL: https://task-manager2-latest.onrender.com/taskmanager/tag/save

```json
{
  "nameTag":"Social"
}
```