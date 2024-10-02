CREATE TABLE pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    data_pedido DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    valor_total DECIMAL(10, 2) NOT NULL CHECK (valor_total >= 0),
    status VARCHAR(20) NOT NULL DEFAULT 'PENDENTE', -- Ex: PENDENTE, FINALIZADO, CANCELADO
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE CASCADE
) COMMENT='Tabela para armazenar os pedidos realizados pelos clientes';
