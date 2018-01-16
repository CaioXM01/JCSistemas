create database jcsistemas;
use jcsistemas;
create table enderecos(
	idEndereco bigint not null auto_increment,
    cidade varchar(200),
	rua varchar(300),
	complemento varchar(100),
    estado varchar(100),
    numero int,
    bairro varchar(200),
    cep varchar(30),
    primary key(idEndereco)
);
create table clientes(
	idCliente bigint not null auto_increment,
    nomeCliente varchar(300),
    cpf varchar(30),
    registro varchar(30),
    dataNascimento date,
    email varchar(300),
    telefone varchar(25),
    endereco bigint,
    primary key(idCliente),
    foreign key(endereco) references enderecos(idEndereco)ON DELETE CASCADE
    
);
create table funcionarios(
	idFuncionario bigint not null auto_increment,
    nomeFuncionario varchar(300),
    cpf varchar(30),
    registro varchar(30),
    dataNascimento date,
    email varchar(300),
    telefone varchar(25),
    senha varchar(100),
    cargo varchar(200),
    salario numeric(8,2), 
	endereco bigint,
    primary key(idFuncionario),
    foreign key(endereco) references enderecos(idEndereco) ON DELETE CASCADE ON UPDATE CASCADE
);
create table fornecedores(
	idFornecedor bigint not null auto_increment,
    nomeFornecedor varchar(300),
    cnpj varchar(30),
    registro varchar(30),
    dataNascimento date,
    email varchar(300),
    telefone varchar(25),
	endereco bigint,
    primary key(idFornecedor),
    foreign key(endereco) references enderecos(idEndereco) ON DELETE CASCADE
);
