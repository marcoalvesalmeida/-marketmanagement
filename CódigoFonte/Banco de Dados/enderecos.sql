create table if not exists enderecos (
	id int primary key auto_increment,
    rua varchar (50),
    cep varchar (8),
    numero int,
    bairro varchar (50),
    cidade varchar (50),
    uf varchar (2)   
);
