DROP DATABASE IF EXISTS PROJ_DIARISTA;
CREATE DATABASE PROJ_DIARISTA;
USE PROJ_DIARISTA;


CREATE TABLE DIARISTA (
	num_reg INT PRIMARY KEY NOT NULL auto_increment,
    nome VARCHAR (50) NOT NULL,
    cpf_diarista VARCHAR (20) NOT NULL,
    telefone VARCHAR (20) NOT NULL,
    nascimento VARCHAR (15)NOT NULL,
    endereco VARCHAR (100) NOT NULL
);


CREATE TABLE CLIENTE (
	id_cliente INT PRIMARY KEY NOT NULL auto_increment,
    cpf_cliente VARCHAR (20) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    FK_RESIDENCIA_id_residencia NUMERIC NOT NULL
);


CREATE TABLE RESIDENCIA (
    logradouro VARCHAR (100) NOT NULL,
    cep NUMERIC (15) NOT NULL,
    bairro VARCHAR (30) NOT NULL,
    cidade VARCHAR (50) NOT NULL,
    id_residencia  INT PRIMARY KEY NOT NULL auto_increment,
    tamanho_total INT NOT NULL,
    complemento VARCHAR (100) NULL
);


CREATE TABLE SERVICO (
    ordem_serv INT PRIMARY KEY NOT NULL auto_increment,
    tempo INTEGER NOT NULL,
    data_inicial VARCHAR(20) NOT NULL,
    data_final VARCHAR(20) NOT NULL,
    transporte DECIMAL(10,2),
    taxa DECIMAL(10,2)
);


CREATE TABLE AVALIA (
    id_avalia INT PRIMARY KEY NOT NULL auto_increment,
    nota_cliente INTEGER NOT NULL,
    nota_diarista INTEGER NOT NULL,
    descricao VARCHAR(100) NULL,
    FK_CLIENTE_id_cliente INT,
    FK_DIARISTA_num_reg INT,
    FK_SERVICO_ordem_serv NUMERIC
);


CREATE TABLE _AGENDA_CLIENTE_SERVICO_DIARISTA (
    FK_CLIENTE_cpf_cliente NUMERIC,
    FK_SERVICO_ordem_serv NUMERIC,
    FK_DIARISTA_num_reg NUMERIC
);


CREATE TABLE PASSAR_ROUPA (
    id_passar_roupa INT PRIMARY KEY NOT NULL auto_increment,
    quantidade NUMERIC(10) NOT NULL,
    descricao VARCHAR(100) NULL,
	valor_serv DECIMAL(10,2),
    FK_SERVICO_ordem_serv NUMERIC
);


CREATE TABLE LIMPEZA (
    id_limpeza INT PRIMARY KEY NOT NULL auto_increment,
    num_comodo INT NOT NULL,
    num_banheiro INT NOT NULL,
    num_quarto INT NOT NULL,
    FK_SERVICO_ordem_serv NUMERIC
);
