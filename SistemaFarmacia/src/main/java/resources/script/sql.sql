create table if not exists categoria(id int not null, nome varchar(30) not null, primary key (id));

create table pagamento(codigo int not null, nome varchar(30) not null, primary key(codigo));

create table fabricante(codigo int not null, nome varchar(45) not null, primary key(codigo));

create table uf(codigo int not null, nome varchar(2) not null, primary key(codigo));

create  table if not exists produto (codigo int not null, nome varchar(50) not null, fabricante int not null, quantidade int not null, descricao varchar(100), valor decimal(11,2) not null,
									 categoria int not null,
    primary key(codigo), foreign key(categoria) references categoria(id),
foreign key (fabricante) references fabricante(codigo));

create table if not exists funcao(codigo int not null, descricao varchar(45) not null, primary key (codigo));

create  table if not exists funcionario (CPF Bigint not null, nome varchar(50) not null, hash varchar(150) not null,nascimento date not null, setor varchar(45) not null, funcao varchar(45), data_admissao date not null, sexo varchar(1) not null, admin boolean not null,
    primary key(CPF));
	
create table if not exists cidades(id int not null, nome varchar(50) not null, uf int not null
 ,primary key(id), foreign key (uf) references uf(codigo));

create table jornada(inicio timestamp not null, final timestamp not null, cpf bigint not null, nome varchar(50) not null,
					foreign key(cpf) references funcionario(cpf));

create table if not exists cliente (CPF Bigint not null, nome varchar(50) not null, telefone varchar(20) not null, email varchar(70),
									data_cadastro timestamp not null, 
									sexo varchar(1) not null,
									cidade int not null,
    primary key(CPF),foreign key (cidade) references cidades(id));

create  table if not exists vendas ( id_venda serial not null, cpf_func Bigint not null, cpf_cli Bigint not null, data date not null, pagamento int not null,
    primary key (id_venda),
foreign key(pagamento) references pagamento(codigo),
   foreign key(cpf_func) references funcionario(CPF),
    foreign key(cpf_cli)references cliente(CPF));
	
create  table if not exists setor(codigo int not null, descricao varchar(100) not null,
primary key(codigo));

create  table if not exists func_setor(cod_set int not null, cpf_func Bigint not null,
primary key(cod_set, cpf_func), 
foreign key(cpf_func)references funcionario(CPF),
foreign key(cod_set)references setor(codigo));

create table if not exists func_funcao (cod_func int not null, cpf_func Bigint not null,
 primary key(cod_func, cpf_func),
 foreign key (cpf_func) references funcionario(cpf),
 foreign key (cod_func) references funcao(codigo));

create table if not exists itensVenda(idVenda integer not null, cod_Prod int not null, quantidade int not null, valor decimal(11,2) not null, desconto decimal(11,2),
                foreign key(idVenda) references vendas(id_venda),
	foreign key (cod_Prod) references produto(codigo));

create table compraestoque (codigo serial not null, codProd int not null, quantidade int not null, valor decimal(11,2) not null, cpfFuncionario bigint not null, fabricante int not null,
  primary key(codigo), foreign key(codProd) references produto(codigo),
   foreign key (fabricante) references fabricante(codigo),
   foreign key (cpfFuncionario) references funcionario(cpf));

 INSERT INTO funcionario VALUES ( '11111111111', 
'admin', 
'15FD34AFD0312E9DCE7A242B7BFEE8358D7D61C203A7FF2182B141A9C9B32158',
'01/01/1000',
'admin',
'admin',
'01/01/1000',
'm',
true ) ON CONFLICT DO NOTHING;

INSERT INTO uf VALUES
(1,'AC'),
(2,'AL'),
(3,'AM'),
(4,'AP'),
(5,'BA'),
(6,'CE'),
(7,'DF'),
(8,'ES'),
(9,'GO'),
(10,'MA'),
(11,'MG'),
(12,'MS'),
(13,'MT'),
(14,'PA'),
(15,'PB'),
(16,'PE'),
(17,'PI'),
(18,'PR'),
(19,'RJ'),
(20,'RN'),
(21,'RO'),
(22,'RR'),
(23,'RS'),
(24,'SC'),
(25,'SE'),
(26,'SP'),
(27,'TO');
