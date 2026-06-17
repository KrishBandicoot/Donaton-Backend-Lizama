Guía de Ejecución de Microservicios - Proyecto Donatón

Esta guía describe cómo levantar cada componente del sistema de forma independiente para su desarrollo y pruebas.
Requisitos Previos

    Java 21 instalado.

    MySQL y PostgreSQL corriendo en sus respectivos puertos.

    Maven instalado (o uso del script ./mvnw incluido en cada repositorio).

1. Microservicio de Usuarios (Puerto 8083)

Para ejecutar este microservicio, se recomienda el uso del entorno de desarrollo IntelliJ IDEA:

    Navega a la carpeta: Donaton-Backend-Usuarios-Lizama.

    Abre el proyecto en IntelliJ IDEA.

    Dirígete a la ruta: src/main/java/com/donaton/usuarios/UsuariosApplication.java.

    Localiza el método main dentro de la clase UsuariosApplication.

    Haz clic en el símbolo de "Play" (verde) ubicado en la esquina superior derecha del editor, justo al lado del número de línea de la declaración del método main.

    El servicio se iniciará automáticamente en el puerto 8083.

2. Microservicio de Donaciones (Puerto 8081)

Si prefieres usar la terminal (o si no tienes IntelliJ abierto), puedes levantar cualquier microservicio usando el script de Maven Wrapper:

    Navega a la carpeta: Donaton-Backend-Donaciones-Lizama.

    Ejecuta el siguiente comando en tu terminal:

        Windows: mvnw.cmd spring-boot:run

        Linux/Mac: ./mvnw spring-boot:run

    El servicio estará disponible en el puerto 8081.

3. Microservicio de Logística (Puerto 8082)

Este microservicio requiere conexión a PostgreSQL. Asegúrate de que tu base de datos esté activa.

    Navega a la carpeta: Donaton-Backend-Logistica-Lizama.

    Ejecuta el comando:

        Windows: mvnw.cmd spring-boot:run

        Linux/Mac: ./mvnw spring-boot:run

    El servicio se iniciará en el puerto 8082.
