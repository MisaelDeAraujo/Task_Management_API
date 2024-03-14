### Task Management API

Este projeto é uma API REST para um sistema de gerenciamento de tarefas. Ele permite que os usuários executem operações básicas, como criar, visualizar, atualizar e excluir tarefas. Cada tarefa possui atributos como ID, titulo, descrição, data de criação e status TODO ou DONE.

### Tecnologias:

- Java 17
- Spring Boot
- Lombok
- Flyway Migration
- Validation
- Spring Data JPA with Hibernate
- H2 (for testing environments) and PostgreSQL (for production environments)
- Swagger
- Maven
- Spring Boot Test (JUnit)

### Documentação da API
Atenção, gere o .jar antes de executar o docker-compose, abra a raiz do projeto pelo terminal e use o comando \mvn clean install, após isso, execute o docker-compose (docker-compose up) e acesse a documentação da API utilizando o Swagger UI:

[Swagger UI](http://localhost:8080/swagger-ui/index.html)

### Desenvolvedor:
[MisaelDeAraujo](https://github.com/MisaelDeAraujo)
