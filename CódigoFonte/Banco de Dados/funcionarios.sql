
create table if not exists funcionarios (
	id int primary key auto_increment,
    nome varchar (50),
	cpf varchar (11),  
	rg varchar(9),
    dataNascimento date,
    endereco int,
    telefone varchar (11),
	email varchar (50),
    salario numeric (8,2),
    cargaHoraria int,
    tipo int,
    senha varchar (20),
    cnh varchar (11),
    foreign key (endereco) references enderecos (id)    
);