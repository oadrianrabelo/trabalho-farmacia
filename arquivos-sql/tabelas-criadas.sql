create database bdfarmacia;
use bdfarmacia;

CREATE TABLE Farmacia (
    id_farmacia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome_farmacia VARCHAR(45),
    endereco VARCHAR(45)
);
drop table departamento;
drop table tipo_funcionario;
drop table farmacia;
drop table venda;

CREATE TABLE Funcionario (
    id_funcionario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome_funcionario VARCHAR(45),
    endereco_funcionario VARCHAR(45),
    rg VARCHAR(14) NOT NULL,
    cpf CHAR(11) UNIQUE NOT NULL,
    crm INT NOT NULL,
    data_de_nascimento DATE,
    data_de_admissao DATE,
    data_de_desligamento DATE,
    sexo ENUM('Masculino', 'Feminino'),
    login VARCHAR(45) UNIQUE NOT NULL,
    senha VARCHAR(45) NOT NULL,
    fk_id_departamento INT NOT NULL,
    fk_id_farmacia INT NOT NULL,
    fk_id_tipo_func INT NOT NULL,
    FOREIGN KEY (fk_id_departamento)
        REFERENCES Departamento (id_departamento)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (fk_id_farmacia)
        REFERENCES Farmacia (id_farmacia)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (fk_id_tipo_func)
        REFERENCES Tipo_Funcionario (id_tipo)
        ON DELETE CASCADE ON UPDATE CASCADE
);



CREATE TABLE Produto (
    id_produto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome_produto VARCHAR(45) NOT NULL,
    fornecedor VARCHAR(45) NOT NULL,
    lote VARCHAR(45) NOT NULL,
    data_de_fabricacao DATE NOT NULL,
    data_de_validade DATE NOT NULL,
    codigo_de_barras LONG NOT NULL UNIQUE,
    quantidade INT,
    tarja VARCHAR(45) NOT NULL,
    preco DECIMAL(5 , 2 ) NOT NULL,
    status_produto ENUM('Disponível', 'Reservado'),
    fk_id_tipo_produto INT NOT NULL REFERENCES Tipo_Produto (id_tipo_produto)
    ON DELETE CASCADE ON UPDATE CASCADE,
    fk_id_farmacia INT NOT NULL,
    FOREIGN KEY (fk_id_farmacia)
        REFERENCES Farmacia (id_farmacia)
        ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE Venda (
    id_venda INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    preco_venda DECIMAL(5 , 2 ),
    quantidade_produto INT,
    data_venda DATE,
    fk_id_farmacia INT NOT NULL REFERENCES Farmacia (id_farmacia)
    ON DELETE CASCADE ON UPDATE CASCADE,
    fk_id_funcionario INT NOT NULL REFERENCES Funcionario (id_funcionario)
    ON DELETE CASCADE ON UPDATE CASCADE,
    fk_id_produto INT NOT NULL REFERENCES Produto (id_produto)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Departamento (
    id_departamento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome_departamento VARCHAR(45)
);
CREATE TABLE Tipo_Funcionario (
    id_tipo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipo_funcionario VARCHAR(45)
);


CREATE TABLE Tipo_Produto (
    id_tipo_produto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipo_produto VARCHAR(45)
);

CREATE TABLE Entregas_Reservadas (
    id_entregas INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45),
    rg VARCHAR(14),
    cpf CHAR(11),
    endereco VARCHAR(45),
    complemento VARCHAR(50),
    fk_id_venda INT NOT NULL REFERENCES Venda (id_venda)
    ON DELETE CASCADE ON UPDATE CASCADE
);

    