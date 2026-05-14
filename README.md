#  Módulo de Incidencias — Guerra de los Testers

---

#  Descripción del Proyecto

El presente proyecto consiste en el desarrollo de un módulo web de gestión de incidencias implementado con Spring Boot y PostgreSQL.

El sistema fue desarrollado para el laboratorio **“Guerra de los Testers”**, permitiendo gestionar incidencias mediante operaciones CRUD, autenticación básica, generación de reportes PDF, dashboard estadístico, auditoría y testing automatizado.

---

#  Tecnologías Utilizadas

## Backend

- Java 17
- Spring Boot 3.5.0
- Spring MVC
- Spring Data JPA
- Hibernate
- Maven

## Frontend

- HTML5
- CSS3
- JavaScript
- Bootstrap 5
- Thymeleaf
- Chart.js

## Base de Datos

- PostgreSQL
- Supabase
- H2 Database (Testing)

## Testing

- JUnit 5
- MockMvc
- Postman

## Control de Versiones

- Git
- GitHub

---

#  Funcionalidades Implementadas

##  Gestión de Incidencias

- Registrar incidencias
- Listar incidencias
- Actualizar incidencias
- Eliminar incidencias
- Filtrar incidencias
- Buscar incidencias

##  Dashboard

- Estadísticas de incidencias
- Gráficos dinámicos con Chart.js

##  Seguridad

- Login básico
- Roles ADMIN y USER
- Restricción de edición para USER

##  Auditoría

- Historial de acciones
- Registro de logs
- Trazabilidad de operaciones

##  Reportes

- Exportación PDF

##  Testing

- Pruebas unitarias
- Pruebas integración
- Testing REST API
- Testing Repository
- Testing PDF
- Testing Logs

---

#  Estructura del Proyecto

```text
src
 ├── main
 │    ├── java
 │    │     └── com.incidencias.guerra_testers
 │    │            ├── controller
 │    │            ├── model
 │    │            ├── repository
 │    │            ├── service
 │    │            └── GuerraTestersApplication
 │    │
 │    └── resources
 │          ├── static
 │          ├── templates
 │          ├── logs
 │          └── application.properties
 │
 └── test
      ├── java
      │     └── com.incidencias.guerra_testers
      │            ├── IncidenciaControllerTest
      │            ├── IncidenciaRepositoryTest
      │            ├── LoginTest
      │            ├── PdfServiceTest
      │            └── LogServiceTest
      │
      └── resources
            └── application-test.properties
```

---

#  Configuración del Proyecto

##  Requisitos Previos

Antes de ejecutar el proyecto se debe tener instalado:

- Java 17
- Git
- VSCode (recomendado)
- Extension Pack for Java

No es necesario instalar Maven manualmente ya que el proyecto utiliza Maven Wrapper (`mvnw.cmd`).

---

#  Ejecución del Proyecto

## 1️ Clonar repositorio

```bash
git clone https://github.com/Angelou687/guerra-testers-incidencias.git
```

---
## 2 Ingresar a la carpeta
```bash
cd guerra-testers-incidencias
```

---

## 2️ Ingresar al proyecto

```bash
cd guerra-testers
```

---

## 3️ Abrir en VSCode

```bash
code .
```

---

## 4️ Ejecutar aplicación

```bash
.\mvnw.cmd spring-boot:run
```

---

## 5️ Ejecutar tests

```bash
.\mvnw.cmd test
```

---

#  Acceso al Sistema

```text
http://localhost:8080
```

---

#  Credenciales

## ADMIN

```text
Usuario: admin
Contraseña: 123
```

## USER

```text
Usuario: user
Contraseña: 123
```

---

#  Dashboard

El sistema incluye dashboard dinámico con:

- Total incidencias
- Incidencias por prioridad
- Estadísticas visuales
- Gráficos Chart.js

---

#  Exportación PDF

El sistema permite exportar reportes PDF con:

- Título
- Descripción
- Prioridad
- Estado
- Sucursal
- Usuario

---

#  Logs y Auditoría

Las operaciones CRUD generan registros automáticos.

```text
2026-05-13T12:05 -> Incidencia creada: Error Login
2026-05-13T12:06 -> Incidencia actualizada: Pago Fallido
2026-05-13T12:07 -> Incidencia eliminada: Error Base Datos
```

Ubicación:

```text
src/main/resources/logs/logs.txt
```

---

#  Testing Implementado

## Tests Automatizados

- Repository Tests
- Controller Tests
- Login Tests
- PDF Tests
- Log Tests
- Integration Tests

---

## Ejecutar Testing

```bash
.\mvnw.cmd test
```

---

#  Arquitectura Utilizada

El proyecto utiliza arquitectura MVC:

- Model
- View
- Controller

Implementando separación de responsabilidades y buenas prácticas de desarrollo.

---

#  Flujo del Sistema

1. Usuario inicia sesión
2. Se valida rol
3. Se gestionan incidencias
4. Los cambios se almacenan en PostgreSQL
5. Se registran logs automáticamente
6. Se actualiza dashboard
7. Se pueden exportar reportes PDF

---

#  Características Destacadas

 CRUD completo

 Persistencia real PostgreSQL

 Supabase Cloud Database

 Dashboard interactivo

 Exportación PDF

 Auditoría y logs

 Roles y autenticación

 Testing automatizado

 API REST

 Git y GitHub

---


#  Integrantes

- Cruz Torres, Angel Fernando
- Huaypuna Bernal, Rafael Maximiliano
- Montoya Magallanes, Alvaro Fabrizio

---

#  Conclusiones

- Se logró implementar un sistema web funcional utilizando Spring Boot.
- Se aplicaron pruebas automatizadas para validar funcionalidades críticas.
- Se utilizó PostgreSQL en la nube mediante Supabase.
- Se implementó trazabilidad mediante logs y auditoría.
- El sistema cumple con los requerimientos del laboratorio Guerra de los Testers.

---

#  Referencias

- https://spring.io/projects/spring-boot
- https://supabase.com/
- https://www.postgresql.org/
- https://junit.org/junit5/
- https://www.chartjs.org/
- https://getbootstrap.com/
- https://maven.apache.org/

---

#  Estado del Proyecto

 Proyecto funcional y operativo.
