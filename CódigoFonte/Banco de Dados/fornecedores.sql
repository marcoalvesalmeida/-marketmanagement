create table if not exists fornecedores (
	id int primary key auto_increment,
	cnpj varchar (14),
    razaoSocial varchar (50),
    endereco int,
    telefone varchar (11),
	email varchar (50),
    foreign key (endereco) references enderecos (id)    
);