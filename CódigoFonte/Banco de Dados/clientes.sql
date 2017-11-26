create table if not exists clientes (
	id int primary key auto_increment,
    nome varchar (50),
    dataNascimento date,
    cpf varchar(11),
    rg varchar(9),
    endereco int,
    telefone varchar (11),
    email varchar (50),
    foreign key (endereco) references enderecos (id)
);
