-- Criar tabela de roles
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE  -- Adicionado UNIQUE para garantir que os nomes de roles sejam únicos
) ENGINE=InnoDB;

-- Criar tabela de usuários com id_usuario
CREATE TABLE usuario (
    id_usuario BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

-- Criar tabela de relacionamento entre usuários e roles
CREATE TABLE usuario_roles (
    usuario_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (usuario_id, role_id),
    CONSTRAINT fk_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuario(id_usuario)
        ON DELETE CASCADE,
    CONSTRAINT fk_role
        FOREIGN KEY (role_id) REFERENCES roles(id)
        ON DELETE CASCADE
) ENGINE=InnoDB;


