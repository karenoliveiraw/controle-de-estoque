/**
 * Projeto de um sistema para gestão de estoque
 * @authora Karen Oliveira
 * @version 1.0
 */
 
 create database dbestoque;
 use dbestoque;
 
 create table usuarios (
	id int primary key auto_increment,
    usuario varchar(50) not null,
    login varchar(20) not null,
    senha varchar(250) not null
);

describe usuarios;

/************** CRUD *****************/

-- CREATE (inserir 5 usuários)

insert into usuarios (usuario, login, senha)
values ('Bernando Silva', 'bsilva', '123@#senac');
insert into usuarios (usuario, login, senha)
values ('Karen Silva', 'karensilva', '123@#senac');
insert into usuarios (usuario, login, senha)
values ('Sabrina Leticia', 'sabrinasilva', '123@#senac');
insert into usuarios (usuario, login, senha)
values ('Caio Silva', 'caiosilva', '123@#senac');

-- READ 1 (selecionar todos os usuários)
select * from usuarios;
-- READ 2 (selecionar um usuário específico por id)
select * from usuarios where id = '4';
-- UPDATE (alterar todos os dados de um usuário específico)
update usuarios set usuario = 'Caio Silva', login = 'caiosilva' where id =4;
-- DELETE (excluir um usuário específico)
delete from contatos where id = 1; 
-- Gerar a documentação - Modelo ER (engenharia reversa)
 