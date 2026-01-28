
# financial_api


# API REST – Sistema Bancário

## Sobre o projeto

Este projeto consiste em uma **API RESTful para um sistema bancário**, desenvolvida como parte de um **teste técnico para uma vaga**, servindo também como **projeto de estudo**.

O foco principal da aplicação está na **implementação das regras de negócio**, validações e organização da arquitetura backend, simulando operações básicas de um sistema bancário.

A aplicação **não possui interface gráfica**, sendo consumida por meio de ferramentas de requisição HTTP, como o Postman.

---

## Funcionalidades

### Funcionalidades principais (requisitos do teste)

* Cadastro de clientes com **validação de CPF único**
* Criação de contas bancárias vinculadas a clientes

  * Um cliente pode possuir **múltiplas contas**
  * Uma conta pertence a **apenas um cliente**
* Realização de **transferências entre contas**

  * São permitidas apenas transferências entre contas do **mesmo cliente**
  * Validação para impedir que o saldo fique negativo

### Funcionalidades auxiliares (apoio a testes)

* Buscar cliente por ID
* Adicionar saldo a uma conta
* Remover saldo de uma conta
* Exclusão de cliente

---

## Arquitetura do projeto

O projeto segue uma arquitetura em camadas, visando a separação de responsabilidades:

* **controller** – Camada responsável pela exposição dos endpoints REST
* **services** – Camada de regras de negócio
* **repositories** – Camada de acesso a dados
* **domain** – Entidades e modelos de domínio
* **exceptions** – Tratamento centralizado de exceções com `@ControllerAdvice`
* **DTOs** – Utilizados para transferência de dados entre camadas

---

## Tecnologias utilizadas

* Java 17
* Spring Boot 3.5.7
* Maven
* H2 Database (uso experimental)
* MongoDB (uso experimental)
* Postman

---

## Persistência de dados

A persistência de dados foi utilizada de forma **experimental**, com foco em testes e aprendizado.

Atualmente:

* Os dados **não são persistidos permanentemente**
* As informações são perdidas ao reiniciar a aplicação
* O foco do projeto está na **lógica de negócio e validações**, não na camada de persistência

---

## Como executar o projeto

### Pré-requisitos

* Java 17
* Maven

### Execução

1. Baixe o projeto (ZIP) ou clone o repositório
2. Importe o projeto em uma IDE de sua preferência (IntelliJ, Eclipse, VS Code)
3. Execute a aplicação via IDE ou pelo terminal com o comando:

   ```bash
   mvn spring-boot:run
   ```
4. A aplicação será iniciada utilizando a configuração padrão do Spring Boot

---

## Testes

Os testes da API foram realizados manualmente por meio do **Postman**, consumindo diretamente os endpoints disponíveis.

---

## Observações finais

Este projeto foi desenvolvido com foco em:

* Prática com Spring Boot
* Estruturação de uma API REST
* Implementação de regras de negócio
* Tratamento centralizado de exceções
* Organização de um projeto backend para teste técnico

---

## Possíveis melhorias futuras

* Persistência completa com banco de dados
* Documentação automática com Swagger/OpenAPI
* Implementação de testes automatizados
* Padronização de DTOs em Request e Response


