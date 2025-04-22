# 📚 Gerenciamento de Pessoas/Endereco - Spring Boot + MySQL + Docker

Este projeto é uma API REST simples, construída com **Spring Boot**, com foco no **estudo de testes unitários**. O objetivo principal foi criar uma estrutura básica para gerenciar **Pessoas** e seus **Endereços**, com funcionalidades de CRUD, e realizar testes para garantir a qualidade do código.

## 🚀 Tecnologias Utilizadas

- **Java 21** - Linguagem base para o desenvolvimento.
- **Spring Boot** - Framework para desenvolvimento de APIs REST.
- **JPA/Hibernate** - Para mapeamento objeto-relacional (ORM).
- **MySQL** - Banco de dados utilizado.
- **Docker** - Para criar um ambiente de banco de dados isolado de forma simples e rápida.
- **JUnit** e **Mockito** - Para testes unitários e mocks.

## 🎯 Objetivo

O projeto foi criado com a intenção de estudar e praticar **testes unitários** em um ambiente de backend com Spring Boot. A finalidade era criar um sistema básico para cadastro de **Pessoas** e **Endereços**, utilizando boas práticas de desenvolvimento e testes.

## 📦 Funcionalidades

- **Cadastro de Pessoas**: Cadastro de informações como nome, data de nascimento, etc.
- **Cadastro de Endereços**: Relacionamento entre Pessoa e Endereço (OneToMany).
- **Listagem de Pessoas**: Rota para listar todas as pessoas cadastradas.
- **Listagem de Endereços**: Rota para listar os endereços de uma pessoa específica.
- **Testes Unitários**: Cobertura de testes com JUnit e Mockito para validar a lógica dos serviços.

## 🛠️ Como Rodar o Projeto

### 1. Clonar o Repositório

```bash
git clone https://github.com/warleyramires/testes-unitarios.git
cd testes-unitarios
```

### 2. Subir o Banco de Dados com Docker
   Este projeto utiliza MySQL como banco de dados, e o Docker facilita o processo de configuração. Utilize o comando abaixo para rodar o container MySQL:
   ```bash
      cd local
      docker compose up
   ```

### 3. Configuração da Aplicação
- Certifique-se de ter o Java 21 instalado em sua máquina.
- A aplicação utiliza o Spring Boot para rodar.

### 4. Acessar a API

- Cadastro de Pessoa (POST): http://localhost:8080/api/pessoas
- Listar Pessoas (GET): http://localhost:8080/api/pessoas
- Cadastro de Endereço (POST): http://localhost:8080/api/enderecos/{pessoaId}
- Listar Endereços (GET): http://localhost:8080/api/enderecos/{pessoaId}
- Listar Todos Endereços (GET): http://localhost:8080/api/enderecos

## 🧪 Testes
  Este projeto conta com testes unitários para validar a lógica da aplicação.
  Os testes estão localizados na pasta src/test/java, e utilizam JUnit e Mockito para simular os comportamentos dos repositórios e serviços.

## 📸 Exemplos de Requisições
1. Criar Pessoa
   Endpoint: POST /api/pessoas

```bash
Request:
{
    "nome": "João Silva",
    "dataNascimento": "1990-01-01"
}
```
```bash
Response:
{
    "id": 1,
    "nome": "João Silva",
    "dataNascimento": "1990-01-01"
}
```

2. Criar Endereço
   Endpoint: POST /api/enderecos/{pessoaId}

```bash
Request:
{
    "logradouro": "Rua do Porto",
    "cep": "12345-678",
    "numero": "123",
    "bairro": "Centro",
    "cidade": "Recife"
}
```

```bash
Response:
{
    "id": 1,
    "logradouro": "Rua do Porto",
    "cep": "12345-678",
    "numero": "123",
    "bairro": "Centro",
    "cidade": "Recife"
}
```
3. Listar Endereço por Pessoa Endpoint: GET /api/enderecos/{pessoaId}

```bash
Response:
[
    {
        "id": 1,
        "logradouro": "Rua do Porto",
        "cep": "12345-678",
        "numero": "123",
        "bairro": "Centro",
        "cidade": "Recife"
    },
    {
        "id": 2,
        "logradouro": "Avenida Paulista",
        "cep": "98765-432",
        "numero": "1000",
        "bairro": "Bela Vista",
        "cidade": "São Paulo"
    }
]
```
