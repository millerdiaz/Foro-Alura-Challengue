# Foro Alura Challengue

## Descripción del Proyecto
Este proyecto es un foro desarrollado como parte del desafío "Challengue Alura Latam", enfocado específicamente en la creación de un foro funcional. Su principal objetivo es permitir la gestión completa de tópicos, cursos, perfiles, usuarios y respuestas, con un sistema de verificación mediante tokens JWT que garantiza la seguridad.

## Funcionalidades
- CRUD completo para tópicos, cursos, perfiles, usuarios y respuestas.
- Verificación de seguridad con JWT.
- Configuración para conectarse a una base de datos MySQL.
- Tratamiento de errores centralizado.
- Configuración de CORS.

### Configuración de Variables de Entorno
Para que el proyecto funcione correctamente, es indispensable configurar las variables de entorno necesarias y las demás propiedades en el archivo `application.properties` del proyecto. 
Estas variables permiten establecer las credenciales de la base de datos y otros parámetros clave para la ejecución del sistema:

```
spring.application.name=foroAlura
spring.datasource.username=${DB_USERNAME_SQL}
spring.datasource.password=${DB_PASSWORD_SQL}
spring.datasource.url=jdbc:mysql://localhost:3306/${DB_NAME_CHALLENGUE}

#spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

#Hibernate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate=warn
logging.level.com.zaxxer.hikari=warn

api.security.secret=${JWT_SECRET}
spring.flyway.baselineOnMigrate=true
```

Es imprescindible que estas variables sean configuradas correctamente para que el sistema pueda conectarse a la base de datos y funcionar adecuadamente.

## Tecnologías Usadas
- **Java**: Lenguaje principal del proyecto.
- **Spring Boot**: Framework para el desarrollo de aplicaciones Java.
- **MySQL**: Base de datos utilizada para almacenar la información.
- **Hibernate**: Framework de ORM para interactuar con la base de datos.
- **JWT (JSON Web Token)**: Utilizado para la autenticación y autorización.
- **Flyway**: Herramienta para la migración de base de datos.

## Cómo Pueden Usarlo los Usuarios
1. Clonar este repositorio:
   ```bash
   git clone https://github.com/millerdiaz/Foro-Alura-Challengue.git
   ```
2. Configurar las variables de entorno en el archivo `application.properties` como se mencionó anteriormente.
3. Ejecutar el proyecto:
   ```bash
   mvn spring-boot:run
   ```
4. Acceder a las funcionalidades del foro a través de las rutas configuradas en los controladores.

## Autores del Proyecto
- **Miller Peña**
  - GitHub: [millerdiaz](https://github.com/millerdiaz)

---
¡Gracias por revisar este proyecto! Si tienes algún comentario o sugerencia, no dudes en compartirlo.
