# Experiencia-2-Backend-Fullstack-III
# Experiencia-2-Backend-Fullstack-III
# Donaton Backend - Microservicios (Donaciones & Logística)

Este repositorio contiene los microservicios centrales del proyecto Donaton, encargados de la persistencia y gestión de datos humanitarios. 

## Arquitectura y Tecnologías
- **Lenguaje:** Java 21
- **Framework:** Spring Boot 3.x
- **Bases de Datos:** MySQL (Donaciones) y PostgreSQL (Logística)
- **Patrones implementados:** Repository Pattern, Factory Method.

## Requisitos Previos
- Java 21 (JDK) instalado.
- Maven instalado o usar el wrapper (`mvnw`).
- Motores de bases de datos operando en local (XAMPP para MySQL puerto 3306, y PostgreSQL en puerto 5432).

## Configuración y Ejecución
1. Clonar el repositorio.
2. Navegar a la carpeta del microservicio deseado (`Donaton-Backend-Donaciones-Lizama` o `Donaton-Backend-Logistica-Lizama`).
3. Para Donaciones, la base de datos `donaton_db` se crea automáticamente, pero tienes abrir xammp y darle start a MySQL. Para Logística, crear manualmente una base de datos vacía llamada `donaton_logistica` en PostgreSQL.
4. Ejecutar el servidor con el comando:
   ```bash
   .\mvnw spring-boot:run
5. Alternativamente se puede ir al Spring Boot Dashbboard y ejecutar desde ahi
