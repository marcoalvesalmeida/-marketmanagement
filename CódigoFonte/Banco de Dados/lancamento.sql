-- Criação da tabela Lançamento
create table lancamento(
    id int auto_increment PRIMARY KEY,
    data_lancamento datetime,
    tipolancamento varchar(30),
    valor decimal(6,2),
    acrescimo int,
    desconto int,
    valortotal decimal(6,2),
    cliente int, -- Chave Estrangeira de Cliente
    planejamento varchar(30),
    formaPagamento varchar(30),
    tipoPagamento varchar(30),
    foreign key(cliente) references clientes(id)
);
