
create table if not exists produtos (
	id int primary key auto_increment,
    descricao varchar (25),
    categoria int,
    valorCusto numeric (8,2),
    valorVarejo numeric (8,2),
    valorAtacado numeric (8,2),
    pontuacao int,
    unidadeMedida varchar (20),
    codigo int,
    estoqueMinimo int,
    estoqueAtual int,
    ativo boolean,
    informacoesAdicionais varchar (50),
    fracionar boolean,
    fornecedor int,
    foreign key (fornecedor) references fornecedores (id) ,
    foreign key (categoria) references categorias (id) 
);
