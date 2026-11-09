# Actividad 2. Spring MVC - Vistas con Thymeleaf, DTOs y Manejo de Peticiones

**Materia:** Programación Web  
**Docente:** Adelina Martínez  
**Alumno:** Uriel Eduardo Guzmán Ramírez  
**Carrera:** Ingeniería en Sistemas Computacionales  
**Proyecto:** Catálogo de Productos  
**Tecnología principal:** Java y Spring Boot

---

## 1. Introducción

En esta actividad se desarrolló una aplicación web utilizando Spring Boot y el patrón MVC (Modelo, Vista y Controlador). El proyecto consiste en un catálogo básico de productos que permite visualizar información, filtrar por categoría, consultar detalles y registrar nuevos productos mediante un formulario.

También se implementó Thymeleaf para mostrar las páginas HTML, una clase DTO para organizar los datos y un endpoint REST para realizar peticiones POST desde Postman.

Este proyecto se realizó a partir de una copia de la Actividad 1, conservando ambos proyectos de forma independiente.

## 2. Objetivo

Comprender el funcionamiento del patrón MVC en Spring Boot mediante la creación de controladores, vistas HTML con Thymeleaf y clases DTO, además de practicar el manejo de peticiones HTTP GET y POST.

## 3. Tecnologías utilizadas

- Java 21
- Spring Boot 4.1.2
- Spring Web MVC
- Thymeleaf
- Maven
- HTML y CSS
- Visual Studio Code
- Postman
- Git y GitHub
- Ubuntu VPS

## 4. Desarrollo del proyecto

Se desarrolló un catálogo de productos utilizando datos simulados, sin conexión a una base de datos.

El proyecto cuenta con las siguientes funciones:

- Visualización de una lista de productos mediante `Model` y `th:each`.
- Registro de productos mediante un formulario y `@ModelAttribute`.
- Filtrado de productos por categoría utilizando `@RequestParam`.
- Consulta de detalles por ID utilizando `@PathVariable`.
- Lectura del nombre del proyecto desde `application.properties` mediante `@Value`.
- Recepción de información JSON mediante una petición POST con `@RequestBody`.

### Patrón MVC

**Modelo:** `ProductoDTO.java`, clase que organiza los datos de los productos, como ID, nombre, categoría y precio.

**Vista:** archivos HTML desarrollados con Thymeleaf (`productos.html`, `formulario.html` y `detalle.html`).

**Controlador:** `ProductosController.java`, encargado de recibir las peticiones, procesar los datos y enviar la información a las vistas.

También se utilizó `ProductoRestController.java` para recibir peticiones POST y devolver respuestas JSON.

## 5. Endpoints implementados

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/productos` | Muestra la lista de productos |
| GET | `/productos/nuevo` | Muestra el formulario |
| POST | `/productos/guardar` | Recibe y registra un producto |
| GET | `/productos?categoria=Papeleria` | Filtra productos por categoría |
| GET | `/productos/2` | Muestra el detalle de un producto |
| POST | `/api/productos` | Recibe un producto JSON desde Postman |

### Ejemplo de petición POST

Se realizó una petición en Postman utilizando el siguiente JSON:

```json
{
  "id": 4,
  "nombre": "Regla",
  "categoria": "Papeleria",
  "precio": 15.0
}
```

El servidor respondió correctamente con el código HTTP `200 OK`, devolviendo los datos enviados.

## 6. Evidencias de funcionamiento

### 6.1. Listado de productos con Thymeleaf

Se muestra una tabla que utiliza la directiva `th:each` para recorrer la lista de productos enviada desde el controlador.

<img width="1291" height="682" alt="image" src="https://github.com/user-attachments/assets/2a5c2e0c-a803-409d-98b2-4316be7c6620" />


### 6.2. Formulario con @ModelAttribute

Se implementó un formulario para registrar productos utilizando los campos nombre, categoría y precio.

<img width="1083" height="298" alt="image" src="https://github.com/user-attachments/assets/19a1bcfa-cb7f-4f30-874d-ace82a992b98" />


### 6.3. Filtro con @RequestParam

Se utilizó `@RequestParam` para filtrar los productos mediante el parámetro de categoría.

<img width="1154" height="607" alt="image" src="https://github.com/user-attachments/assets/7f00861c-650e-4223-9651-9ad72f2aebe7" />


### 6.4. Detalle con @PathVariable

Se implementó una ruta que recibe el ID del producto y muestra sus datos correspondientes.

<img width="769" height="443" alt="image" src="https://github.com/user-attachments/assets/e64ad9d5-66cd-4850-ba43-666ab2a21e64" />


### 6.5. Petición POST en Postman

Se comprobó el funcionamiento del endpoint `/api/productos`, enviando un objeto JSON y obteniendo una respuesta exitosa.

<img width="1202" height="672" alt="image" src="https://github.com/user-attachments/assets/eec385ea-89aa-4576-bff2-80a144e5b3d5" />


## 7. Ejecución local

Para ejecutar el proyecto desde la terminal de Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Una vez iniciado el servidor, se puede acceder al catálogo mediante:

http://localhost:8080/productos

Para generar el archivo ejecutable:

```powershell
.\mvnw.cmd clean package
```

## 8. Despliegue en VPS

La aplicación fue compilada en un archivo `.jar` y transferida al VPS mediante SCP.

Se ejecutó en el puerto **8084**, utilizando una carpeta independiente para no sobrescribir la Actividad 1.

El comando utilizado fue:

```bash
nohup java -jar grueact2t4-0.0.1-SNAPSHOT.jar --server.port=8084 > spring.log 2>&1 &
```

Se comprobó su funcionamiento dentro del VPS mediante `curl`, obteniendo correctamente la página HTML del catálogo.

**Dirección de la Actividad 2:**

http://52.159.103.236:8084/productos


## 9. Conclusión

Con esta práctica aprendí a utilizar el patrón MVC en Spring Boot, comprendiendo cómo se relacionan los controladores, los datos y las vistas HTML.

También aprendí a utilizar Thymeleaf para mostrar información dinámica, recibir datos desde formularios y manejar parámetros mediante diferentes anotaciones.

Finalmente, reforcé el uso de Postman para probar peticiones POST y la ejecución de aplicaciones Java en un VPS utilizando puertos independientes.

---

**Actividad 2 — Programación Web — Spring Boot**
