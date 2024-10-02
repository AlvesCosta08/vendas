CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL, -- Relaciona o cliente a um usuário
    documento VARCHAR(18) NOT NULL UNIQUE, -- CPF ou CNPJ
    endereco VARCHAR(255),
    cep VARCHAR(10),
    cidade VARCHAR(100),
    estado VARCHAR(100),
    telefone VARCHAR(15),
    data_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE
) COMMENT='Tabela para armazenar os clientes e suas informações de contato';

