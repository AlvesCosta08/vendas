CREATE TABLE pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    data_pedido DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    referencia VARCHAR(50), -- Referência do pedido
    quantidade INT NOT NULL CHECK (quantidade > 0), -- Quantidade de itens
    un_medida VARCHAR(10), -- Unidade de medida (ex: kg, un)
    valor_unitario DECIMAL(10, 2) NOT NULL CHECK (valor_unitario >= 0), -- Valor por unidade do item
    sub_total DECIMAL(10, 2) GENERATED ALWAYS AS (quantidade * valor_unitario) STORED, -- Subtotal calculado
    forma_pagamento VARCHAR(50) NOT NULL, -- Ex: Cartão, Boleto, etc.
    valor_total DECIMAL(10, 2) NOT NULL CHECK (valor_total >= 0), -- Total do pedido
    status VARCHAR(20) NOT NULL DEFAULT 'PENDENTE', -- Status do pedido: PENDENTE, FINALIZADO, CANCELADO
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE CASCADE
) COMMENT='Tabela para armazenar os pedidos realizados pelos clientes';

