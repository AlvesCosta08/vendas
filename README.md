# Projeto Vendas

Este projeto é uma aplicação de vendas, organizada de forma a facilitar a manutenção e a escalabilidade. Abaixo está a estrutura de diretórios do projeto, incluindo configurações para Docker, Flyway e a organização do código fonte.

## Estrutura de Diretórios

```plaintext
vendas/
├── .github/                             # Configurações para GitHub Actions
│   └── workflows/                       # Fluxos de trabalho automatizados
├── src/                                  # Código fonte da aplicação
│   ├── main/                             # Código principal
│   │   ├── java/                         # Código Java
│   │   │   └── com/                      # Pacote da aplicação
│   │   │       └── vendas/               # Pacote 'vendas'
│   │   │           ├── models/           # Modelos de dados
│   │   │           │   ├── Categoria.java
│   │   │           │   ├── Cliente.java
│   │   │           │   ├── Endereco.java
│   │   │           │   ├── Pedido.java
│   │   │           │   ├── PedidoProduto.java
│   │   │           │   ├── PessoaFisica.java
│   │   │           │   ├── PessoaJuridica.java
│   │   │           │   ├── Produto.java
│   │   │           │   └── Usuario.java
│   │   │           ├── db/               # Scripts de migração de banco de dados
│   │   │           │   ├── migrate/      # Scripts de migração
│   │   │           │   └── V1__create_categoria_table.sql # Script de criação da tabela de categoria
│   │   │           ├── dto/              # Data Transfer Objects (DTOs)
│   │   │           │   ├── ProdutoDTO.java                   # DTO para produtos
│   │   │           │   └── ClienteDTO.java                   # DTO para clientes
│   │   │           ├── exceptions/       # Classes de exceções personalizadas
│   │   │           │   ├── PedidoNotFoundException.java      # Exceção para pedidos não encontrados
│   │   │           │   └── ValidationException.java          # Exceção de validação
│   │   │           ├── utils/            # Funções utilitárias e helpers
│   │   │           │   ├── DataUtils.java                    # Classe para manipulação de dados
│   │   │           │   └── ValidationUtils.java              # Classe para validação de dados
│   │   │           ├── controllers/      # Controladores da aplicação
│   │   │           │   ├── ProdutoController.java
│   │   │           │   └── ClienteController.java
│   │   │           ├── repositories/      # Repositórios para acesso a dados
│   │   │           │   ├── ProdutoRepository.java
│   │   │           │   └── ClienteRepository.java
│   │   │           ├── services/         # Serviços da aplicação
│   │   │           │   ├── ProdutoService.java
│   │   │           │   └── ClienteService.java
│   │   │           └── config/           # Configurações da aplicação
│   │   │               └── AppConfig.java
│   │   └── resources/                    # Recursos da aplicação
│   └── test/                             # Testes da aplicação
│       └── java/                         # Testes em Java
└── README.md                             # Documentação do projeto

```                        
## Tecnologias Utilizadas
- **Spring Boot**: Framework para desenvolvimento rápido de aplicações Java.
- **Spring Security**: Implementa a segurança da aplicação, configurando a proteção dos endpoints e a autenticação JWT.
- **JWT (JSON Web Token)**: Método para autenticação sem estado (stateless) entre cliente e servidor.
- **JPA (Java Persistence API)**: Para interação com o banco de dados, mapeamento de entidades e execução de operações de CRUD.
- **BCrypt**: Algoritmo para codificação segura de senhas.

## Endpoints Principais
- `POST /auth/register`: Registro de novos usuários.
- `POST /auth/login`: Autenticação de usuários e geração de token JWT.
- `GET /usuarios`: Listar todos os usuários (requer autenticação JWT).
- `GET /usuarios/{email}`: Buscar usuário pelo email (requer autenticação JWT).
- `DELETE /usuarios/{id}`: Excluir usuário pelo ID (requer autenticação JWT).

## Segurança
A API usa **Spring Security** para autenticação e autorização, onde:
- Usuários autenticam-se via email e senha no endpoint de login.
- Um **token JWT** é gerado e usado para autenticar requisições subsequentes, enviado no cabeçalho `Authorization` como "Bearer {token}".
