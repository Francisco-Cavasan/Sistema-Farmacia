create database SistemaFarmacia with owner = postgres enconding = 'UTF8' CONNECTION LIMIT = -1;

create  table if not exists produto (codigo int not null, nome varchar(50) not null, fabricante varchar(45) not null, quantidade int not null, descricao varchar(100), valor decimal(11,3) not null,
    primary key(codigo));

create  table if not exists funcionario (CPF Bigint not null, nome varchar(50) not null, hash varchar(150) not null,nascimento date not null, setor varchar(45) not null, funcao varchar(45), data_admissao date not null, sexo varchar(1) not null, admin boolean not null,
    primary key(CPF));

create table if not exists cliente (CPF Bigint not null, nome varchar(50) not null, telefone varchar(20) not null, email varchar(70), data_cadastro timestamp not null, sexo varchar(1) not null,
    primary key(CPF));

create  table if not exists vendas (cpf_func Bigint not null, id_prod int not null, cpf_cli Bigint not null, valor decimal(11,3), data date not null, quantidade int not null,
    primary key(cpf_func, id_prod, cpf_cli),
    foreign key(cpf_func) references funcionario(CPF),
    foreign key(id_prod) references produto(codigo),
    foreign key(cpf_cli)references cliente(CPF));

create  table if not exists setor(codigo int not null, descricao varchar(100) not null,
primary key(codigo));

create  table if not exists func_setor(cod_set int not null, cpf_func Bigint not null,
primary key(cod_set, cpf_func), 
foreign key(cpf_func)references funcionario(CPF),
foreign key(cod_set)references setor(codigo));

create  table if not exists funcao (codigo int not null, descricao varchar(45) not null,
 primary key (codigo))

create table if not exists func_funcao (cod_func int not null, cpf_func Bigint not null,
 primary key(cod_func, cpf_func),
 foreign key (cpf_func) references funcionario(cpf),
 foreign key (cod_func) references funcao(codigo))

INSERT INTO funcionario VALUES ( '11111111111', 
'admin', 
'15FD34AFD0312E9DCE7A242B7BFEE8358D7D61C203A7FF2182B141A9C9B32158',
'01/01/1000',
'admin',
'admin',
'01/01/1000',
'm',
true ) ON CONFLICT DO NOTHING;