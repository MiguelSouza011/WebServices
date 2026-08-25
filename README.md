# WebServices

Projeto desenvolvido em Java com **Spring Boot** para praticar o desenvolvimento de uma **API REST**, utilizando **Spring Data JPA**, **Hibernate** e **H2 Database**.

## Tecnologias

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- IntelliJ IDEA

## Conceitos praticados

- Criação de API REST
- Spring Boot
- Injeção de dependência
- Spring Data JPA
- Hibernate
- Mapeamento objeto-relacional (ORM)
- Entidades JPA
- Repositories
- Service Layer
- Operações CRUD
- Relacionamentos entre entidades
- `@OneToMany`
- `@ManyToOne`
- `@ManyToMany`
- `@OneToOne`
- `@JoinTable`
- `@JoinColumn`
- `Enum`
- `Instant`
- ISO 8601
- H2 Database
- Database seeding
- Tratamento de exceções

## Entidades

O projeto trabalha principalmente com:

- **User**
- **Category**
- **Product**
- **Order**
- **OrderItem**
- **Payment**

As entidades possuem relacionamentos entre si para representar a estrutura de um sistema de pedidos.

## Relacionamentos

### User e Order

Um usuário pode possuir vários pedidos.

```text
User 1 ------ N Order
