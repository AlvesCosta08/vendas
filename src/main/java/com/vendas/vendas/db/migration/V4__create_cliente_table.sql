CREATE TABLE cliente (
    id_cliente BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(15),
    endereco_id BIGINT,
    tipo_cliente VARCHAR(50) NOT NULL,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id_endereco) ON DELETE SET NULL
);

