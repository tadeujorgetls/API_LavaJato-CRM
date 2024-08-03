create table clientes(

    id bigint not null auto_increment,
    nome varchar(100) not null,
	telefone varchar(20) not null,
    data_de_nascimento date null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    numero varchar(20),
    complemento varchar(100),
    uf char(2) not null,
    cidade varchar(100) not null,
    cep varchar(9) not null,
    email varchar(100) not null unique,
    cpf varchar(11) not null unique,

    primary key(id)
    
);