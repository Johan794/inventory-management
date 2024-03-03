# Inventory Management Application

This Java application is designed to manage inventories using a PostgreSQL database backend.

## Features

- **Inventory Management**: Add, update, delete, and view inventory items.
- **User Authentication**: Secure login system for authorized users.
- **Database Integration**: Utilizes PostgreSQL for data storage and retrieval.
- **User Permissions**: Different levels of access for administrators and regular users.
- **Logging**: Tracks important actions and events for auditing purposes.
- **External integration**: Integrate de app with any api 

## Requirements

- Java Development Kit (JDK) 17 or higher
- PostgreSQL database
- JDBC driver for PostgreSQL
- Apache Maven (for building)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/Johan794/inventory-management.git
```

## Variables configuration

In your application's configuration file (`application.properties`), you have used several placeholders. Below is an explanation of what each placeholder represents and what value it should be replaced with:

- **`${POSTGRES_HOST}`**: This should be replaced with the hostname or IP address of your PostgreSQL server where the database is hosted.

- **`${DB_NAME}`**: Replace this with the name of the PostgreSQL database you want to connect to.

- **`${POSTGRES_USER}`**: Provide the username used to authenticate and access the PostgreSQL database.

- **`${POSTGRES_PASS}`**: Replace this with the corresponding password for the PostgreSQL user specified above.

- **`${EXTERNAL_API}`**: This placeholder should be replaced with the base URL of any external API that your application might interact with.

- **`${CORS_ORIGIN}`**: Specify the allowed origin (domain) for Cross-Origin Resource Sharing (CORS). This determines which domains are allowed to access your API.

- **`${CORS_METHOD}`**: Define the HTTP methods allowed for CORS requests (e.g., GET, POST, PUT, DELETE).

- **`${CORS_HEADER}`**: Specify the allowed headers for CORS requests. These are additional HTTP headers allowed to be sent by the browser in the actual request.

- **`${CORS_ORIGIN_PATTERN}`**: Define a pattern for allowed origins, useful when you want to allow multiple origins based on a common pattern.

- **`${CORS_SOURCE_PATTERN}`**: This is similar to `${CORS_ORIGIN_PATTERN}`, but it's used for configuring the source pattern for CORS.

- **`${JWT_SECRET}`**: Provide a secret key for JSON Web Token (JWT) generation and validation. This key should be kept secure and known only to your application.

Make sure to replace each placeholder with the appropriate value according to your specific setup and requirements.


## Build the project

```bash
mvn clean package
```

## Run the project
```bash
java -jar target/inventory-management.jar
```

## Documentation

### Entity relation diagram
![entity_relation.png](docs%2Fentity_relation.png)


### Sequence diagram 

![secuense_diagram_app.png](docs%2Fsecuense_diagram_app.png)

