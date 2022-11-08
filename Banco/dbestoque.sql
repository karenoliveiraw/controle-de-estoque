/**
 * Projeto de um sistema para gestão de estoque
 * @authora Karen Oliveira
 * @version 1.2
 */
 
 create database dbestoque;
 use dbestoque;
 
 create table usuarios (
	id int primary key auto_increment,
    usuario varchar(50) not null,
    login varchar(20) not null unique,
    senha varchar(250) not null,
    perfil varchar (250) not null
);

describe usuarios;


/************** CRUD *****************/

-- CREATE (inserir 5 usuários)

-- inserindo uma senha criptografada com md5

insert into usuarios(usuario, login, senha, perfil)
values ('Jose de Assis', 'josedeassis', md5('123@#senac'), 'user');

insert into usuarios(usuario, login, senha, perfil)
values ('Sirlene Sanches', 'sisa', md5('123@#senac'), 'user');

insert into usuarios(usuario, login, senha, perfil)
values ('Robson Vaamonde', 'vava', md5('123@#senac'), 'user');

insert into usuarios(usuario, login, senha, perfil)
values ('Leandro Ramos', 'ramos', md5('123@#senac'), 'admin');

insert into usuarios(usuario, login, senha, perfil)
values ('Karen Oliveira', 'karen', md5('1234'), 'user');


-- READ 1 (selecionar todos os usuários)
select * from usuarios;

-- login 

select * from usuarios where login = 'sisa' and senha = md5('123@senac');

select * from usuarios;

-- READ 2 (selecionar um usuário específico por id)
select * from usuarios where id = '1';
-- UPDATE (alterar todos os dados de um usuário específico)
update usuarios set usuario = 'Caio Silva', login = 'caiosilva' where id =4;
-- DELETE (excluir um usuário específico)
delete from contatos where id = 1; 
-- Gerar a documentação - Modelo ER (engenharia reversa)

-- criando uma tabela para os fornecedores 
 
 create table fornecedores (
 
 idFor int primary key auto_increment,
 razaoSocial varchar (50) not null, 
 fantasia varchar (50) not null, 
 cnpj varchar (20) unique, 
 ie varchar (20) null,
 cep varchar (10) not null,
 endereco varchar (50) not null,
 numero varchar (6) not null, 
 complemento varchar (20),
  bairro varchar (50) not null,
  cidade varchar (50) not null, 
  uf char (2) not null, 
  nomeContato varchar (30) not null,
 fone varchar (15) not null,
 whatsapp varchar (15),
  email varchar (50) not null, 
  site varchar (50),/**
 * Projeto de um sistema para gestão de estoque
 * @authora Karen Oliveira
 * @version 1.2
 */
 
 create database dbestoque;
 use dbestoque;
 
 create table usuarios (
	id int primary key auto_increment,
    usuario varchar(50) not null,
    login varchar(20) not null unique,
    senha varchar(250) not null,
    perfil varchar (250) not null
);

describe usuarios;


/************** CRUD *****************/

-- CREATE (inserir 5 usuários)

-- inserindo uma senha criptografada com md5

insert into usuarios(usuario, login, senha, perfil)
values ('Jose de Assis', 'josedeassis', md5('123@#senac'), 'user');

insert into usuarios(usuario, login, senha, perfil)
values ('Sirlene Sanches', 'sisa', md5('123@#senac'), 'user');

insert into usuarios(usuario, login, senha, perfil)
values ('Robson Vaamonde', 'vava', md5('123@#senac'), 'user');

insert into usuarios(usuario, login, senha, perfil)
values ('Leandro Ramos', 'ramos', md5('123@#senac'), 'admin');

insert into usuarios(usuario, login, senha, perfil)
values ('Karen Oliveira', 'karen', md5('1234'), 'user');


-- READ 1 (selecionar todos os usuários)
select * from usuarios;

-- login 

select * from usuarios where login = 'sisa' and senha = md5('123@senac');

select * from usuarios;

-- READ 2 (selecionar um usuário específico por id)
select * from usuarios where id = '1';
-- UPDATE (alterar todos os dados de um usuário específico)
update usuarios set usuario = 'Caio Silva', login = 'caiosilva' where id =4;
-- DELETE (excluir um usuário específico)
delete from contatos where id = 1; 
-- Gerar a documentação - Modelo ER (engenharia reversa)

-- criando uma tabela para os fornecedores 
 
 create table fornecedores (
 
 idFor int primary key auto_increment,
 razaoSocial varchar (50) not null, 
 fantasia varchar (50) not null, 
 cnpj varchar (20) unique, 
 ie varchar (20) null,
 cep varchar (10) not null,
 endereco varchar (50) not null,
 numero varchar (6) not null, 
 complemento varchar (20),
  bairro varchar (50) not null,
  cidade varchar (50) not null, 
  uf char (2) not null, 
  nomeContato varchar (30) not null,
 fone varchar (15) not null,
 whatsapp varchar (15),
  email varchar (50) not null, 
  site varchar (50),
  obs varchar (250)
  
 );
 describe fornecedores;
 select * from fornecedores;
 insert into fornecedores (razaoSocial,fantasia,cnpj, ie, cep, endereco, numero, bairro, cidade, uf, nomeContato, fone, email)
values ('Daniela e Elaine Joalheria Ltda', 'Daniela e Elaine Joalheria', '88451682000108', '989816769061', '13146030', 'Avenida A', '871', 'Cascata', 'Paulínia', 'SP', 'Elaine', '1938934179', 'suporte@danielaeelainejoalherialtda.com.br');
insert into fornecedores (razaoSocial,fantasia,cnpj, ie, cep, endereco, numero, bairro, cidade, uf, nomeContato, fone, email)
values ('Débora e Ryan Limpeza ME', 'Débora e Ryan Limpeza', '22648832000151', '000490230623', '08820120', 'Rua Frei Caneca', '988', 'Vila Paulicea', 'Mogi das Cruzes', 'SP', 'Elaine', '1135137886', 'contabil@deboraeryanlimpezame.com.brr');

insert into fornecedores (razaoSocial,fantasia,cnpj, ie, cep, endereco, numero, bairro, cidade, uf, nomeContato, fone, email)
values ('Débora e Alexandre Entregas Expressas ME', 'Débora e Alexandre Entregas Expressas', '53721988000144', '187777607701', '08820120', 'Rua Frei Caneca', '988', 'Vila Paulicea', 'Mogi das Cruzes', 'SP', 'Elaine', '1135137886', 'contabil@deboraeryanlimpezame.com.brr');

insert into fornecedores (razaoSocial,fantasia,cnpj, ie, cep, endereco, numero, bairro, cidade, uf, nomeContato, fone, email)
values ('Danilo e Carlos Eduardo Casa Noturna ME', 'Danilo e Carlos Eduardo Casa Noturna', '10807369000164', '534218875636', '11347090', 'Rua Professora Júlia de Almeida Pires', '566', 'Jardim Rio Branco', 'São Vicente', 'SP', 'Danilo', '1337654228', 'daniloecarloseduardocasanoturname.com.br');

insert into fornecedores (razaoSocial,fantasia,cnpj, ie, cep, endereco, numero, bairro, cidade, uf, nomeContato, fone, email)
values ('Débora e Ryan Limpeza ME', 'Débora e Ryan Limpeza', '22648832000151', '000490230623', '08543160', 'Rua José Mazzuca', '577', 'Vila Santa Margarida', 'Ferraz de Vasconcelos', 'SP', 'Débora', '1135137886', 'www.deboraealexandreentregasexpressasme.com.br');

insert into fornecedores (razaoSocial,fantasia,cnpj, ie, cep, endereco, numero, bairro, cidade, uf, nomeContato, fone, email)
values ('Benício e João Adega Ltda', 'Benício e João Adega', '06039265000180', '512880478760', '05419010', 'Rua Lélis Vieira', '795', 'Pinheiros', 'São Paulo', 'SP', 'Débora', 'Benicio', 'juridico@benicioejoaoadegaltda.com.br');


 
  obs varchar (250)
 );
 
 
