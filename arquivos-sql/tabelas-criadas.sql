create database bdfarmacia;
use bdfarmacia;
CREATE TABLE Farmacia (
	id_farmacia INT primary key not null,
    nome_farmacia VARCHAR(45),
    endereco VARCHAR(45)
);

CREATE TABLE Funcionario (
	id_funcionario INT primary key not null,
    nome_funcionario VARCHAR(45),
    endereco_funcionario VARCHAR(45),
    rg varchar(14) not null,
    cpf char(11) unique not null,
    data_de_nascimento date,
    data_de_admissao date,
    sexo enum('Masculino', 'Feminino'),
    login varchar(45) unique not null,
    senha varchar(45) unique not null,
    funcao varchar(45),
    fk_id_departamento int not null,
    fk_id_farmacia int not null,
    fk_id_tipo_func int not null,
    foreign key (fk_id_departamento)
		references Departamento(id_departamento)
			on delete cascade
            on update cascade,
	foreign key (fk_id_farmacia)
		references Farmacia(id_farmacia)
			on delete cascade
            on update cascade,
	foreign key (fk_id_tipo_func)
		references Tipo_De_Funcionario(id_tipo)
			on delete cascade
            on update cascade
    );
create table Produto (
	id_produto int primary key not null,
    nome_produto varchar(45) not null,
    fornecedor varchar(45) not null,
    lote varchar(45) not null,
    data_de_fabricacao date not null,
    data_de_validade date not null,
    codigo_de_barras double not null unique,
    quantidade int,
    tipo varchar(45),
    tarja varchar(45) not null,
    preco decimal(5,2) not null,
    status enum('livre', 'reservado'),
    obs_status varchar(255),
    fk_id_farmacia int not null,
    foreign key (fk_id_farmacia)
		references Farmacia(id_farmacia)
        on delete cascade
        on update cascade
);
create table Departamento ( 
	id_departamento int primary key not null,
    nome_departamento varchar(45)
    );
CREATE TABLE Tipo_De_Funcionario (
	id_tipo int primary key not null,
	tipo_de_funcionario varchar(45)
    );
    drop table tipo_de_funcionario;
    drop table funcionario;
    