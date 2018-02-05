create table if not exists fornecedores (
	id int primary key auto_increment,
	cnpj varchar (14),
    razaoSocial varchar (50),
    endereco int,
    telefone varchar (11),
    telefone2 varchar (12),
	email varchar (50),
	informacoesAdicionais text,
	ativo boolean,
    foreign key (endereco) references enderecos (id) on delete cascade  
);
