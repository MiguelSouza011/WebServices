# 🌐 Web Services

API REST desenvolvida com **Java 25** e **Spring Boot**, utilizando **Spring Data JPA / Hibernate** para persistência de dados e gerenciamento de relacionamentos entre entidades.

O projeto foi desenvolvido com foco no aprendizado e aplicação prática de conceitos fundamentais de desenvolvimento **Backend Java**, incluindo arquitetura em camadas, APIs REST, persistência relacional, relacionamentos JPA, tratamento de exceções e regras de negócio.

---

## 🎯 Objetivos do projeto

O principal objetivo é praticar o desenvolvimento de uma aplicação backend utilizando o ecossistema Spring.

Durante o desenvolvimento foram trabalhados conceitos como:

- Desenvolvimento de APIs REST
- Arquitetura em camadas
- Spring Boot
- Spring Data JPA
- Hibernate
- Jakarta Persistence (JPA)
- CRUD
- Relacionamentos entre entidades
- Persistência de dados
- Tratamento de exceções
- Banco de dados H2
- Seed inicial de dados
- Maven
- Git
- GitHub

---

## 🛠️ Tecnologias utilizadas

- **Java 25**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **Jakarta Persistence**
- **H2 Database**
- **Maven**
- **Git**
- **GitHub**

---

## 🏗️ Arquitetura

O projeto utiliza uma arquitetura em camadas para separar as responsabilidades da aplicação.

```text
                 Cliente
                    │
                    ▼
          ┌──────────────────┐
          │    Controller    │
          │   REST / HTTP    │
          └────────┬─────────┘
                   │
                   ▼
          ┌──────────────────┐
          │     Service      │
          │ Regras de negócio│
          └────────┬─────────┘
                   │
                   ▼
          ┌──────────────────┐
          │    Repository    │
          │  Acesso aos dados│
          └────────┬─────────┘
                   │
                   ▼
          ┌──────────────────┐
          │   JPA / Hibernate│
          └────────┬─────────┘
                   │
                   ▼
              Banco de Dados
```

---

## 📂 Estrutura do projeto

```text
src
└── main
    ├── java
    │   └── com.miguelsouza.webservices
    │       ├── config
    │       ├── entities
    │       ├── repositories
    │       ├── resources
    │       └── services
    │
    └── resources
        └── application.properties
```

---

## 👤 Usuários

A entidade `User` representa os usuários cadastrados na aplicação.

Entre os dados trabalhados estão:

```text
id
name
email
phone
password
```

A aplicação permite trabalhar com operações de criação, consulta, atualização e exclusão de usuários.

---

## 🛒 Pedidos

A entidade `Order` representa os pedidos realizados pelos usuários.

Principais informações:

```text
id
moment
orderStatus
client
```

O pedido possui relacionamento com o usuário responsável pela compra.

```text
User
  │
  │ 1
  │
  └────────── N
             │
           Order
```

---

## 💳 Pagamentos

A entidade `Payment` representa o pagamento relacionado a um pedido.

O relacionamento utilizado é:

```text
Order
  │
  │ 1
  │
  └────────── 1
             │
          Payment
```

O pagamento possui informações relacionadas ao momento da transação.

---

## 📦 Produtos

A entidade `Product` representa os produtos disponíveis no catálogo.

Principais atributos:

```text
id
name
description
price
imgUrl
```

Os produtos também participam do relacionamento com:

- Categorias
- Itens do pedido

---

## 🏷️ Categorias

A entidade `Category` representa as categorias dos produtos.

```text
Category
    │
    │ N
    │
    ▼
Product
```

O projeto utiliza um relacionamento **Many-to-Many (N:N)** entre produtos e categorias.

---

## 🧾 Itens do pedido

A entidade `OrderItem` representa os produtos que fazem parte de cada pedido.

Principais informações:

```text
quantity
price
order
product
```

O relacionamento pode ser representado da seguinte forma:

```text
Order
  │
  │ 1
  │
  └────── N ────── OrderItem ────── N ────── 1
                                                │
                                             Product
```

O `OrderItem` utiliza uma chave composta formada pelo pedido e pelo produto.

---

## 🔗 Relacionamentos JPA

O projeto trabalha diferentes tipos de relacionamentos utilizando JPA/Hibernate.

### User → Order

```text
1 : N
```

Um usuário pode possuir vários pedidos.

### Order → Payment

```text
1 : 1
```

Um pedido possui um pagamento associado.

### Order → OrderItem

```text
1 : N
```

Um pedido possui vários itens.

### Product → OrderItem

```text
1 : N
```

Um produto pode estar presente em vários itens de pedidos.

### Product → Category

```text
N : N
```

Um produto pode pertencer a várias categorias e uma categoria pode possuir vários produtos.

---

## 📊 Modelo de relacionamento

```text
                    ┌──────────────┐
                    │     USER     │
                    └──────┬───────┘
                           │
                           │ 1:N
                           ▼
                    ┌──────────────┐
                    │     ORDER    │
                    └──────┬───────┘
                           │
             ┌─────────────┼─────────────┐
             │             │             │
             │ 1:1         │ 1:N         │
             ▼             ▼             │
      ┌─────────────┐ ┌─────────────┐    │
      │   PAYMENT   │ │ ORDER_ITEM  │    │
      └─────────────┘ └──────┬──────┘    │
                             │            │
                             │ N:1        │
                             ▼            │
                      ┌─────────────┐     │
                      │   PRODUCT   │◄────┘
                      └──────┬──────┘
                             │
                             │ N:N
                             ▼
                      ┌─────────────┐
                      │  CATEGORY   │
                      └─────────────┘
```

---

## 🔄 Operações CRUD

A API trabalha com as principais operações HTTP:

| Método | Operação |
|--------|----------|
| `GET` | Buscar recursos |
| `POST` | Criar recursos |
| `PUT` | Atualizar recursos |
| `DELETE` | Excluir recursos |

---

## ⚠️ Tratamento de exceções

O projeto possui tratamento de exceções para situações como:

- Recurso não encontrado
- Erros relacionados ao banco de dados
- Exceções durante operações da API

O tratamento é centralizado utilizando recursos do Spring para retornar respostas HTTP apropriadas.

---

## 🚨 ProblemDetail

O projeto utiliza `ProblemDetail` para estruturar respostas de erro HTTP.

Exemplo:

```json
{
  "status": 404,
  "detail": "Resource not found",
  "instance": "/users/10"
}
```

Isso permite que a API tenha respostas de erro mais padronizadas.

---

## 🗄️ Persistência de dados

A persistência é realizada utilizando:

```text
Spring Data JPA
        ↓
    Hibernate
        ↓
 Jakarta Persistence
        ↓
   Banco de dados
```

Os objetos Java são mapeados para estruturas relacionais utilizando anotações JPA.

---

## 🧪 H2 Database

Durante o desenvolvimento, o projeto utiliza o **H2 Database** para facilitar os testes e a execução da aplicação.

O banco em memória permite executar a aplicação sem a necessidade de configurar um banco externo para o ambiente de desenvolvimento.

---

## 🌱 Seed inicial

O projeto possui uma configuração para popular automaticamente o banco com dados iniciais.

O processo utiliza recursos como:

```text
@Configuration
CommandLineRunner
```

Isso permite que a aplicação seja iniciada já contendo dados para testes dos endpoints.

---

## 📡 API REST

A aplicação disponibiliza recursos através de endpoints HTTP.

Exemplo:

```http
GET /users
```

```http
GET /users/{id}
```

```http
POST /users
```

```http
PUT /users/{id}
```

```http
DELETE /users/{id}
```

A mesma abordagem é utilizada para os demais recursos da aplicação.

---

## 🧠 Conceitos praticados

### Java

- Orientação a Objetos
- Classes
- Interfaces
- Enum
- Collections
- Exceptions
- Datas
- Tipos enumerados

### Spring Boot

- Injeção de dependências
- Controllers
- Services
- Repositories
- Beans
- Configurações

### Spring Data JPA

- Entities
- Repositories
- Persistência
- Queries
- Relacionamentos
- JPA
- Hibernate

### REST

- HTTP
- JSON
- CRUD
- Status Codes
- Request
- Response
- Endpoints

### Banco de dados

- H2
- Mapeamento objeto-relacional
- Chaves primárias
- Chaves estrangeiras
- Relacionamentos

---

## 📈 Evolução do projeto

O projeto representa uma etapa importante do aprendizado em desenvolvimento backend Java.

A evolução pode ser representada:

```text
Java
  ↓
Spring Boot
  ↓
API REST
  ↓
Spring Data JPA
  ↓
Hibernate
  ↓
Banco de dados
  ↓
Relacionamentos
  ↓
CRUD
  ↓
Regras de negócio
  ↓
Tratamento de exceções
  ↓
API Backend
```

---

## 🚀 Como executar

### 1. Clonar o projeto

```bash
git clone https://github.com/MiguelSouza011/WebServices.git
```

### 2. Entrar na pasta

```bash
cd WebServices
```

### 3. Executar com Maven

No Windows:

```bash
mvnw.cmd spring-boot:run
```

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

Também é possível executar o projeto diretamente através do IntelliJ IDEA.

---

## 💻 Ambiente de desenvolvimento

Projeto desenvolvido utilizando:

```text
Java 25
Spring Boot
Maven
IntelliJ IDEA
Git
GitHub
```

---

## 👨‍💻 Autor

**Miguel Souza**

Estudante de Engenharia de Software com foco em desenvolvimento backend Java.

### Atualmente estudando

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Docker
- APIs REST
- Arquitetura de software

---

## 🔗 Repositório

[GitHub - WebServices](https://github.com/MiguelSouza011/WebServices)

---

## 📌 Status

🚧 **Projeto desenvolvido para fins de estudo e evolução prática em desenvolvimento Backend Java.**

O projeto representa uma das etapas da minha jornada de aprendizado com **Java, Spring Boot, APIs REST, JPA/Hibernate e bancos de dados relacionais**.
