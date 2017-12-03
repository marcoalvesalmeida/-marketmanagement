create table if not exists fornecedores (
	id int primary key auto_increment,
	cnpj varchar (14),
    razaoSocial varchar (50),
    inscricaoSocial varchar (11),
    endereco int,
    telefone varchar (11),
    telefone2 varchar (11),
	email varchar (50),
	informacoesAdicionais text,
	ativo boolean,
    foreign key (endereco) references enderecos (id)    
);
