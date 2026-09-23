# 🌐 Spring Boot REST Web Services & Domain Management

[![Java 25](https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://jdk.java.net/25/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4%2B%20%2F%204.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-ORM-59666C?style=for-the-badge)](https://spring.io/projects/spring-data-jpa)
[![H2 Database](https://img.shields.io/badge/Database-H2%20%2F%20In--Memory-004880?style=for-the-badge)](https://www.h2database.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)

> **Web API REST & Persistência Relacional com Bleeding-Edge Tech Stack**: API desenvolvida utilizando o ecossistema de ponta **Java 25** e **Spring Boot**, aplicando arquitetura em camadas (Controller, Service, Repository), ORM Jakarta JPA moderno e gerenciamento completo de domínios (Usuários, Pedidos, Categorias, Produtos e Pagamentos).

---

## 💡 Destaques de Arquitetura e Engenharia

Este projeto utiliza os recursos mais avançados da JVM e do ecossistema Spring:

- **Java 25 & Spring Ecosystem:** Aproveita ao máximo as inovações mais recentes da linguagem Java (Virtual Threads, Records, Pattern Matching, Scoped Values) acopladas ao Spring Framework.
- **Arquitetura em Camadas (Layered Architecture):** Separação estrita de responsabilidades entre as camadas de **Resource (REST Controllers)**, **Services (Regras de Negócio)** e **Repositories (Acesso a Dados)**.
- **Mapeamento Objeto-Relacional (Jakarta JPA / Hibernate 6+):** Estrutura de persistência moderna e otimizada para lidar com relacionamentos complexos (`1:1`, `1:N` e `N:N` com tabelas de junção).
- **Tratamento Global de Exceções (RFC 7807):** Uso de `@ControllerAdvice` e `ProblemDetail` para estruturar erros HTTP padronizados (`ResourceNotFoundException`, `DatabaseException`).
- **Database Seeding Automático:** População do banco H2 em memória via `@Configuration` e `CommandLineRunner` para ambientes de teste e validação.

---

## ⚙️ Funcionalidades e Recursos

- **Gestão de Usuários (Users):** CRUD completo com suporte ao histórico de pedidos vinculados.
- **Gestão de Pedidos (Orders):** Registro de compras associando usuário, estado do pedido (`OrderStatus`), itens agregados e comprovantes de pagamento.
- **Catálogo de Produtos e Categorias:** Associação *Muitos-para-Muitos* (`N:N`) entre produtos e suas respectivas categorias.
- **Processamento de Pagamento (Payment):** Mapeamento de relacionamento `1:1` dependente entre o Pedido e a transação financeira.

---

## 📐 Diagrama de Entidades e Relacionamentos (ER)

```mermaid
erDiagram
    USER ||--o{ ORDER : "makes"
    ORDER ||--o| PAYMENT : "has"
    ORDER ||--|{ ORDER_ITEM : "contains"
    PRODUCT ||--|{ ORDER_ITEM : "included in"
    PRODUCT }|--|{ CATEGORY : "belongs to"

    USER {
        Long id PK
        String name
        String email
        String phone
        String password
    }

    ORDER {
        Long id PK
        Instant moment
        Integer orderStatus
        Long client_id FK
    }

    PAYMENT {
        Long id PK
        Instant moment
        Long order_id FK
    }

    PRODUCT {
        Long id PK
        String name
        String description
        Double price
        String imgUrl
    }

    CATEGORY {
        Long id PK
        String name
    }

    ORDER_ITEM {
        Integer quantity
        Double price
        Long order_id PK, FK
        Long product_id PK, FK
    }
