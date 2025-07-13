# 📦 Produto API

API REST de gerenciamento de produtos com integração Kafka, desenvolvida com Spring Boot e arquitetura hexagonal (ports & adapters).

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
  - Spring Web
  - Spring Data JPA
  - Spring Kafka
- **Apache Kafka**
- **PostgreSQL**
- **Docker + Docker Compose**
- **Lombok**
- **MapStruct**
- **Arquitetura Hexagonal (Ports & Adapters)**

---

## 📚 Descrição

Esta aplicação permite:

- Criar, listar e remover produtos.
- Publicar eventos no Kafka quando um produto é criado.
- Consumir eventos de criação de produto através de listener Kafka.

---

## ⚙️ Executando o projeto com Docker

### Pré-requisitos

- Docker
- Docker Compose

### Subindo os serviços

```bash
docker-compose up --build
```

A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

---

## 📡 Endpoints

### Criar Produto

`POST /produtos`

```json
{
  "nome": "Notebook",
  "preco": 3500.00,
  "descricao": "Notebook Dell Inspiron"
}
```

### Listar Produtos

`GET /produtos`

### Remover Produto

`DELETE /produtos/{id}`

---

## 🧪 Integração com Kafka

- Tópico de envio: `produtos-criados`
- Produtor: envia evento ao salvar novo produto
- Consumidor: escuta o tópico e exibe o produto recebido

---

## 🧰 Estrutura de Pastas (Hexagonal)

```
src
└── main
    ├── application
    │   └── service                # Lógica de negócio (use case)
    ├── domain
    │   ├── model                  # Entidades do domínio
    │   └── ports                  # Interfaces (Ports)
    ├── infrastructure
    │   ├── repository             # Adaptadores de persistência
    │   └── messaging              # Adaptadores Kafka (Producer/Consumer)
    └── web                       # Controllers REST
```

---

## 🔐 Autenticação

A autenticação é feita via JWT:

### Endpoint de login

`POST /auth/login`

```json
{
  "username": "admin",
  "password": "1234"
}
```

**Resposta:**

```json
{
  "token": "Bearer eyJhbGciOiJIUzI1NiIs..."
}
```

---

## 👨‍💻 Autor

- **Neemias Jr.**
- [https://github.com/neemiasjr](https://github.com/neemiasjr)

---

## 📌 Licença

Este projeto está licenciado sob a MIT License.
