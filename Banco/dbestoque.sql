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

insert into usuarios(usuario, login, senha, perfil)
values ('Karen Oliveira', 'karen', md5('1234'), 'user');

insert into usuarios(usuario, login, senha, perfil)
values ('Administrador', 'admin', md5('admin'), 'admin');


-- READ 1 (selecionar todos os usuários)
select * from usuarios;

-- login 

select * from usuarios where login = 'sisa' and senha = md5('123@senac');

select * from usuarios;

select * from usuarios where login = 'admin';


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
insert into fornecedores (razaoSocial,fantasia,cnpj, ie, cep, endereco, numero, bairro, cidade, uf, nomeContato, fone, email)
values ('Antonio e Analu Locações de Automóveis ME', 'AA Locações de Automóveis ME', '35996370000105', '109474023', '72922366', 'Quadra Quadra 11', '387', 'Jardim América II', 'Águas Lindas de Goiás', 'GO', 'Analu', '6125600190', '61985492193');

-- pesquisa avançada filtrando letras
-- as é um "apelido"
select idFor as ID, fantasia as Fornecedor , fone, nomeContato as contato from fornecedores where fantasia like ('de%');

drop table clientes;

create table clientes (
 
 idCli int primary key auto_increment,
 nome varchar (50) not null, 
 cpf  varchar (20) unique,
email varchar (50) not null, 
 cep varchar (10) not null,
 endereco varchar (50) not null,
 numero varchar (6) not null, 
 complemento varchar (20),
  bairro varchar (50) not null,
  cidade varchar (50) not null, 
  uf char (2) not null, 
  nomeContato varchar (30) not null,
 fone varchar (15) not null,
 whatsapp varchar (15)
  
 );
 insert into clientes (nome, cpf, email, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone, whatsapp) values ('Karen Oliveira da Silva','49375488809', 'karensoliveiradasilva@gmail.com', '08582050', 'Rua Rosario do Sul', '114', 'B', 'Parque Viviane', 'Itaquaquecetuba', 'SP', 'Karen', '9999-8888', '88888-9999');
 
 select idCli as ID, nome as Cliente, fone as Contato, email as Email from clientes where email like "k%";

 describe clientes;
 select * from clientes;
 
 insert into clientes (nome, cpf, nomeContato, fone, whatsapp, email, cep, endereco, numero, complemento, bairro, cidade, uf)
values ('Karen', '49249249299', 'Karen Silva','1198525852','119252445','karen@karen.com','08450540', 'rua freitas de azevedo', '3', 'b', 'jd fanganiello', 'são paulo', 'sp');
insert into clientes (nome, cpf, nomeContato, fone, whatsapp, email, cep, endereco, numero, complemento, bairro, cidade, uf)
values ('Caio', '458224545', 'caio Silva','1198525852','119252445','caio@caoi.com','08450540', 'rua freitas de azevedo', '3', 'b', 'jd fanganiello', 'são paulo', 'sp');
/*
relacionamento de tavelas 1 - n (um pra muitos)
chave estrangeira (fk) - (pk)
id for (chave estrangeira) usar mesmo nome e tipo de dados da chave

*/

-- timestamp default current_timestamp (obtem automaticamente a data e hora)
-- date (tipo de dados relacionado a data)
-- custo decimal (10,2) (tipo de dados a relacionado a numeros nao inteiros 
-- custo decimal (10,2) (10 digitos com 2 casas decimais) 
use dbestoque;
 create table produtos(
 codigo int primary key auto_increment,
 barcode varchar (255) unique,
 produto varchar (50) not null,
 descricao varchar (255), 
 fabricante varchar (50) not null,
 datacad timestamp default current_timestamp,
 dataval date, 
 estoque int not null,
 estoquemin int not null, 
 unidade char (2) not null,
 localizacao varchar (50),
 custo decimal (10,2) not null,
 lucro decimal (10,2),
 idFor int not null,
 foreign key(idFor) references fornecedores(idFor)
 );
 describe produtos;
 insert into produtos (barcode, produto, descricao, fabricante, dataval,estoque, estoquemin,unidade,localizacao, custo, lucro, idFor) values ('11111111','Caneta BIC Azul','Caneta BIC cor azul, ponta fina CX 50','BIC',20231122,20,5,'CX','Prateleira 2',38.50,20, 4); 
 delete from produtos where codigo = 1;
 select * from produtos;
 insert into produtos (barcode, produto, descricao, fabricante, dataval,estoque, estoquemin,unidade,localizacao, custo, lucro, idFor) values ('22222222','Caneta BIC Vermelha','Caneta BIC cor vermelha, ponta fina CX 50','BIC',20231122,20,5,'CX','Prateleira 2',38.50,20, 5); 
 insert into produtos (barcode, produto, descricao, fabricante, dataval,estoque, estoquemin,unidade,localizacao, custo, lucro, idFor) values ('33333333','Caneta BIC Preta','Caneta BIC cor preta, ponta fina CX 50','BIC',20231122,20,5,'CX','Prateleira 2',38.50,20, 5);
 insert into produtos (barcode, produto, descricao, fabricante, dataval,estoque, estoquemin,unidade,localizacao, custo, lucro, idFor) values ('44444444','Caneta BIC Verde','Caneta BIC cor verde, ponta fina CX 50','BIC',20231122,20,5,'CX','Prateleira 2',38.50,20, 4);
 insert into produtos (barcode, produto, descricao, fabricante, dataval,estoque, estoquemin,unidade,localizacao, custo, lucro, idFor) values ('55555555','Lapis','Lapis Faber Castell','Faber Castell',20231128,10,5,'CX','Prateleira 4',38.50,20, 4);
 insert into produtos (barcode, produto, descricao, fabricante, dataval,estoque, estoquemin,unidade,localizacao, custo, lucro, idFor) values ('66666666','Cola bastão pritt','Cola bastão marca Pritt','Pritt',20221002,10,2,'UN','Prateleira 3',1.25,50, 4);
insert into produtos (barcode, produto, descricao, fabricante, dataval,estoque, estoquemin,unidade,localizacao, custo, lucro, idFor) values  ('77777777','Teclado','Teclado Gamer (Branco)','Asus',20231122,2,5,'UN','Prateleira 1',50.00,50, 4);
insert into produtos (barcode, produto, descricao, fabricante, dataval,estoque, estoquemin,unidade,localizacao, custo, lucro, idFor) values  ('99999999','Cola','Cola','Pritt',20211002,50,5,'CX','Prateleira 2',40.50,100.0, 4);
 
 
 /*
 Relatorios  (select especial)
 */ 
 -- relatorio 1 (unificar produtos com fornecedores)alter
 -- produtos.idFor é a chave estrangeira (FK) // fornecedores.idFor(PK)
 select * from produtos inner join fornecedores
 on produtos.idFor = fornecedores.idFor; 
 
 -- relatorio 2 (fornecedor relacionado ao produto)
 select produtos.codigo as Código, produtos.produto, 
 fornecedores.fantasia as Fornecedor 
 from produtos 
 inner join fornecedores on produtos.idFor = fornecedores.idFor;
 
 -- relatorio 3 (inventario do estoque)
 
  select sum(estoque * custo) as Total from produtos;
  
  -- relatorio 4 (calcular o preço de venda)
  
select codigo as Código, produto, custo, (custo + (custo * lucro) /100) as venda from produtos;

-- relatorio 5 (reposição de estoque)
-- '%d/%m/%Y' (dd/mm/aaaa '%d/%m/%Y' (dd/mm/aa)
select codigo as código, produto, date_format (dataval, '%d/%m/%Y') as data_validade, estoque, estoquemin as estoque_mínimo from produtos where estoque < estoquemin;
 
 -- relatorio 6 (produtos vencidos)]
 select codigo as código, produto, localizacao as localização, date_format (dataval, '%d/%m/%Y') as data_validade, datediff(dataval, curdate()) as dias_vencidos from produtos where datediff(dataval, curdate()) < 0; 
