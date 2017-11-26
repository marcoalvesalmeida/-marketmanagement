create table veiculo(
	id int auto_increment primary key,
    modelo varchar(30) not null,
    placa varchar(7) not null,
    chassi varchar(17) unique,
    tipo varchar(20),
    anoFab varchar(8),
    marca varchar(20),
    combustivel varchar(10),
    observacoes text
);