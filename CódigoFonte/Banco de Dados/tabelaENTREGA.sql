create table entrega(
	id int auto_increment primary key,
    venda int, -- Chave Estrangeira de VENDA
    veiculo int, -- Chave Estrangeira de VEÍCULO (OK)
    endereco int,  -- Chave Estrangeira de ENDERECO
    motorista int, -- Chave Estrangeira de MOTORISTA
    foreign key(veiculo) references veiculo(id)
);
