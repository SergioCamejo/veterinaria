#  Sistema de Gestión Veterinaria

![Veterinaria](/src/main/docs/images/Veterinaria_banner.jpg)

### Descripción
Este proyecto es un **Sistema de Gestión Veterinaria** desarrollado en **Java** y **Spring Boot**, diseñado para ayudar a las clínicas veterinarias a gestionar de manera eficiente a sus clientes y sus mascotas. El sistema permite administrar clientes (dueños) y mascotas, incluyendo funcionalidades como agregar, actualizar y listar.

Este proyecto resalta mis habilidades en el **desarrollo backend**, especialmente con **Java**, **Spring Boot** y el diseño de **APIs REST**. También demuestra mi capacidad para manejar la persistencia de datos, gestionar relaciones entre entidades e implementar código limpio y mantenible.

#### Consideraciones
- El alta de un cliente se hará junto a su mascota.
- No se podrá dar de alta a un cliente con DNI repetido en la base de datos
- Se podrán dar de alta a nuevas mascotas y asociarlas a un cliente existente.
- Si se borra un cliente de la base de datos, se borran también a todas sus mascotas.
- Si se borran a todas las mascotas de un cliente, este seguirá dado de alta en sistema.
- Se podrán editar uno o varios atributos de clientes o de mascotas.

### Funcionalidades

-   **Gestión de Clientes**: Agregar, actualizar y administrar la información personal de los clientes.
-   **Gestión de Mascotas**: Registrar mascotas, asignarlas a sus dueños correspondientes y manejar múltiples mascotas por cliente.
-   **Manejo de Excepciones**: Excepciones personalizadas para diversos escenarios (Ej: querer dar de alta a un dueño sin mascota).
-   **Persistencia de Datos**: Operaciones CRUD completas utilizando **Spring Data JPA** y **Hibernate** para la interacción con la base de datos.

### Tecnologías Utilizadas

-   **Java 17**
-   **Spring Boot 3.1**
-   **Spring Data JPA**
-   **Hibernate**
-   **Maven**
-   **MySQL** como base de datos
-   **Postman** para pruebas de la API

### Configuración del proyecto

#### Requisitos previos

-   **MySQL**: Asegúrate de tener MySQL instalado y en funcionamiento.
-   **Variables de entorno**: Es necesario crear un archivo `.env` con las siguientes variables de configuración de la base de datos. Utiliza la plantilla `env.template` incluida en el repositorio.

```
SPRING_DATASOURCE_URL=database  
SPRING_DATASOURCE_USERNAME=  
SPRING_DATASOURCE_PASSWORD=  
SPRING_DATASOURCE_DB=
```
El archivo `application.properties` ya está configurado para utilizar estas variables:
```
spring.application.name=veterinaria  
spring.jpa.hibernate.ddl-auto=update  
spring.config.import=optional:file:.env[.properties]  
spring.datasource.url=${SPRING_DATASOURCE_URL}  
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}  
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}  
spring.jpa.database-plataform=org.hibernate.dialect.MySQL8Dialect
```

### Pasos para correr el proyecto

 1. **Clonar el repositorio**:

```
https://github.com/SergioCamejo/veterinaria.git
```

2. **Configurar el archivo `.env`**:
	-   Copiar el archivo `env.template` y renombrarlo a `.env`.
	-   Completar las variables con los datos de tu base de datos MySQL.
 
 3. **Compilar el proyecto**:
 ```
 mvn clean install
 ```
 
 4. **Ejecutar el proyecto**:
 ```
 mvn spring-boot:run
 ```

5. **Acceder a la aplicación:**
	-   **URL base de la API**: `http://localhost:8080/api`
	-   Usar Postman o cualquier cliente de API para interactuar con los endpoints.

### Endpoints de la API

Algunos de los endpoints clave son:

#### Endpoints de Clientes

-   **GET** `/api/clientes`: Obtener todos los clientes
-   **GET** `/api/clientes{id}`: Obtener los datos de un cliente y sus mascotas
-   **POST** `/api/clientes`: Crear un nuevo cliente
-   **PUT** `/api/clientes/{id}`: Actualizar un cliente existente
-   **DELETE** `/api/clientes/{id}`: Eliminar un cliente

#### Endpoints de Mascotas

-   **GET** `/api/mascotas`: Obtener todas las mascotas
-   **GET** `/api/mascotas{id}`: Obtener los datos de una mascota en particular
-   **POST** `/api/mascotas`: Agregar una nueva mascota
-   **PUT** `/api/mascotas/{id}`: Agregar una mascota existente o nueva a un cliente
-   **DELETE** `/api/mascotas/{id}`: Eliminar una mascota

### Ejemplos realizados en Postman

- El alta de un cliente se realiza junto a una mascota.
![Alta de nuevo cliente](/src/main/docs/images/alta_cliente.jpg)
- El alta de una nueva mascota se raaliza asocióndola a un cliente existente en la base de datos.
![Alta de nueva mascota](/src/main/docs/images/alta_nueva_mascota.jpg)
- El sistema no permite ingresar a un cliente con un DNI ya ingresado en la base de datos.
![Cliente ya ingresado](/src/main/docs/images/cliente_ya_creado.jpg)
- Se podrán editar uno o más atributos de mascotas o de clientes.
![Editar datos de una mascota](/src/main/docs/images/editar_mascota.jpg)

### Manejo de Excepciones

Excepciones personalizadas aseguran que el sistema maneje los errores de manera adecuada. Por ejemplo:

-   **DuenioSinMascotaException**: Se lanza cuando se intenta crear a un cliente sin mascota.

### Mejoras Futuras

- **Agendar citas**: Implementar la reserva de citas entre clientes y la clínica veterinaria.
- **Historial médico de mascotas**: Rastrear el historial médico, vacunaciones y tratamientos de cada mascota.

### Información de Contacto

¡No dudes en contactarme para cualquier pregunta o posibilidad de colaboración!

-   **Correo electrónico**: sergiofcamejo@gmail.com
-   **LinkedIn**: [Sergio Camejo](https://www.linkedin.com/in/sergiocamejo/)