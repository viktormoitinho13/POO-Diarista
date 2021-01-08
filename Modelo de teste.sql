drop database if exists pood3_db_teste;
create database pood3_db_teste;
use pood3_db_teste;

create table cadastro(
	codigo int not null auto_increment,
    nome varchar(30),
    email varchar(50),
    
	constraint cadastro_pk primary key(codigo)
);