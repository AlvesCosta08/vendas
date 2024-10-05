CREATE TABLE pedido_produto (
    id_pedido_produto INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL CHECK (quantidade > 0), -- Quantidade de cada produto no pedido
    valor_unitario DECIMAL(10, 2) NOT NULL CHECK (valor_unitario >= 0), -- Valor por unidade do produto no momento do pedido
    sub_total DECIMAL(10, 2) GENERATED ALWAYS AS (quantidade * valor_unitario) STORED, -- Subtotal calculado
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido) ON DELETE CASCADE,
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto) ON DELETE CASCADE
);

COMMENT ON TABLE pedido_produto IS 'Tabela intermediária para armazenar a relação entre pedidos e produtos';

