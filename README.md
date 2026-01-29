
# financial_api


# API REST – Sistema Bancário

API RESTful desenvolvida em Java 17 + Spring Boot + MongoDB, como parte de um teste técnico, com foco em regras de negócio, organização de arquitetura e boas práticas backend.

A aplicação expõe endpoints para gerenciamento de clientes, contas bancárias e movimentações financeiras, seguindo os requisitos propostos no enunciado.

## Funcionalidades

### Funcionalidades principais (requisitos do teste)

* Cadastro de clientes
* Validação de CPF Único
* Criação de contas bancárias para clientes existentes
* Número de conta gerado automaticamente
* Saldo inicial igual a 0.0
* Consulta de saldo da conta
* Transferência entre contas
* Validação de saldo suficiente
* Atualização do saldo das contas envolvidas
* Consulta de extrato por período

### Funcionalidades auxiliares (apoio a testes)

* Endpoint de depósito, criado exclusivamente para viabilizar testes de trânsferencia 
* Consulta detalhada de movimentações por conta

---

## Arquitetura do projeto

O projeto segue uma arquitetura em camadas, visando a separação de responsabilidades:

* **controller** – Camada responsável pela exposição dos endpoints REST
* **services** – Camada de regras de negócio
* **repositories** – Camada de acesso a dados via Spring Data e MongoDB
* **domain** – Entidades e enums do domínio
* **exceptions** – Tratamento centralizado de exceções com `@ControllerAdvice`
* **DTOs** – Utilizados para transferência de dados entre camadas

---

## Tecnologias utilizadas

* Java 17
* Spring Boot 3+
* Spring Data MongoDB
* MongoDB
* Bean Validation
* Maven
* Postman

---

## Versionamento da API 

Todos os endpoints seguem o padrão:
```bash
/api/v1
```

---

## Documentação da API

A documentação dos endpoints foi realizada utilizando Postman, contendo:

* Exemplos de requisição
* Exemplos de resposta
* Códigos HTTP
* Possíveis erros

---

## Padrão de erro

Todas as exceções seguem um padrão unificado:
```bash
{
  "timestamp": "2026-01-29T18:40:00Z",
  "status": 404,
  "error": "Recurso não encontrado",
  "message": "Conta não encontrada",
  "path": "/api/v1/accounts/123"
}

```

---

## Como executar o projeto

### Pré-requisitos

* Java 17
* MongoDB em execução
* Maven

### Execução

1. Baixe o projeto (ZIP) ou clone o repositório
2. Importe o projeto em uma IDE de sua preferência (IntelliJ, Eclipse, VS Code)
3. Execute a aplicação via IDE ou pelo terminal com o comando:

   ```bash
   mvn spring-boot:run
   ```
4. A aplicação será iniciada em
   ```bash
  http://localhost:8080
   ```


---

## Testes

Os testes da API foram realizados manualmente por meio do **Postman**, validando:

* Fluxo completo de criação de cliente
* Criação de conta
* Depósito
* Transferência
* Consulta de saldo
* Consulta de extrato

---

## Observações finais

Este projeto foi desenvolvido com foco em:

* Prática com Spring Boot
* Estruturação de uma API REST
* Implementação de regras de negócio
* Tratamento centralizado de exceções
* Organização de um projeto backend para teste técnico

---



