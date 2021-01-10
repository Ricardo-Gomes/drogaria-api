--create schema drogaria
--create schema controle_acesso

create table controle_acesso.cliente(
	id bigserial not null primary key,
	dt_cadastro timestamp without time zone,
	nome varchar(150) not null,
	cpf	varchar(14) not null,
	rg varchar(16) not null,
	estado_civil varchar(15) not null,
	sexo varchar(10) not null,
	dt_nascimento timestamp without time zone not null,
	telefone varchar(13),
	celular varchar(14) not null,
	email varchar(100) not null,
	endereco varchar(100) not null,
	numero varchar(10) not null,
	complemento varchar(30),
	cep varchar(10) not null,
	bairro varchar(100) not null,
	cidade varchar(50) not null,
	estado varchar(2) not null
);

create table drogaria.fabricante(
	id bigserial not null primary key,
	dt_cadastro timestamp without time zone,
	nome varchar(150) not null,
	inscricao_estadual varchar(15) not null,
	cnpj varchar(18) not null,
	categoria varchar(50) not null,
	telefone varchar(13),
	celular varchar(14) not null,
	email varchar(100) not null,
	endereco varchar(100) not null,
	numero varchar(10) not null,
	complemento varchar(30),
	cep varchar(10) not null,
	bairro varchar(100) not null,
	cidade varchar(50) not null,
	estado varchar(2) not null
);

create table controle_acesso.funcionario(
	id bigserial not null primary key,
	dt_cadastro timestamp without time zone,
	nome varchar(150) not null,
	cpf	varchar(14) not null,
	rg varchar(16) not null,
	estado_civil varchar(15) not null,
	sexo varchar(10) not null,
	dt_nascimento timestamp without time zone not null,
	telefone varchar(13),
	celular varchar(14) not null,
	email varchar(100) not null,
	endereco varchar(100) not null,
	numero varchar(10) not null,
	complemento varchar(30),
	cep varchar(10) not null,
	bairro varchar(100) not null,
	cidade varchar(50) not null,
	estado varchar(2) not null,
	dt_admissao timestamp without time zone not null,
	matricula varchar(10) not null,
	funcao varchar(20) not null,
	tipo_contrato varchar(10) not null,
	carteira_trabalho varchar(15) not null
);

create table drogaria.caixa(
	id bigserial not null primary key,
	dt_abertura timestamp without time zone not null,
	dt_fechamento timestamp without time zone not null,
	vl_abertura numeric not null,
	fk_funcionario bigint references controle_acesso.funcionario(id)
);

create table drogaria.produto(
	id bigserial not null primary key,
	dt_cadastro timestamp without time zone,
	nome varchar(150) not null,
	descricao varchar(50),
	estoque numeric not null,
	categoria varchar(50) not null,
	marca varchar(50) not null,
	vl_venda numeric not null,
	vl_custo numeric not null,
	fk_fabricante bigint references drogaria.fabricante(id)
);

create table drogaria.venda(
	id bigserial not null primary key,
	dt_venda timestamp without time zone,
	vl_total numeric not null,
	fk_funcionario bigint references controle_acesso.funcionario(id),
	fk_cliente bigint references controle_acesso.cliente(id)
);

create table drogaria.item(
	id bigserial not null primary key,
	qtd numeric not null,
	preco_produto numeric not null,
	preco_total numeric not null,
	fk_produto bigint references drogaria.produto(id),
	fk_venda bigint references drogaria.venda(id)
);

create table controle_acesso.usuario(
	id bigserial not null primary key,
	login varchar(30) not null,
	senha varchar (250) not null,
	dt_cadastro timestamp without time zone
)
