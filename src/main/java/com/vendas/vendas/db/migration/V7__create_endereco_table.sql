CREATE TABLE endereco (
    id_endereco BIGINT AUTO_INCREMENT PRIMARY KEY,
    logradouro VARCHAR(200),
    cidade VARCHAR(100),
    uf VARCHAR(2),
    cep VARCHAR(9)
);

-- Alteração da tabela cliente para adicionar a coluna endereco_id
ALTER TABLE cliente
ADD COLUMN endereco_id BIGINT,
ADD CONSTRAINT fk_cliente_endereco
    FOREIGN KEY (endereco_id)
    REFERENCES endereco(id_endereco)
    ON DELETE SET NULL; -- Define o comportamento de exclusão

