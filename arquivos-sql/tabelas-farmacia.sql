-- MySQL Workbench Forward Engineering
-- drop database bdfarmacia;
-- -----------------------------------------------------
-- Schema farmacia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdfarmacia` DEFAULT CHARACTER SET utf8 ;
USE `bdfarmacia` ;

-- -----------------------------------------------------
-- Table `farmacia`.`farmacias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdfarmacia`.`Farmacia` (
  `id_farmacia` INT NOT NULL AUTO_INCREMENT,
  `nome_farmacia` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_farmacia`));


-- -----------------------------------------------------
-- Table `farmacia`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdfarmacia`.`Departamento` (
  `id_departamento` INT NOT NULL AUTO_INCREMENT,
  `nome_departamento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_departamento`));

-- -----------------------------------------------------
-- Table `farmacia`.`tipo_de_func`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdfarmacia`.`tipo_funcionario` (
  `id_tipo` INT NOT NULL AUTO_INCREMENT,
  `tipo_funcionario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo`));


-- -----------------------------------------------------
-- Table `farmacia`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdfarmacia`.`funcionario` (
  `id_funcionario` INT NOT NULL AUTO_INCREMENT,
  `nome_funcionario` VARCHAR(45) NOT NULL,
  `endereco_funcionario` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(14) NULL,
  `cpf` CHAR(11) NOT NULL,
  `data_de_nascimento` DATE NOT NULL,
  `data_de_admissao` DATE NOT NULL,
  `sexo` ENUM('Masculino', 'Feminino', 'N/A') NOT NULL,
  `login` VARCHAR(20) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `fk_id_departamento` INT NOT NULL,
  `fk_id_farmacia` INT NOT NULL,
  `fk_id_tipo_func` INT NOT NULL,
  `data_de_desligamento` DATE NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  UNIQUE INDEX `CPF_UNIQUE` (`CPF` ASC),
  INDEX `fk_id_departamento1_idx` (`fk_id_departamento` ASC),
  INDEX `fk_id_farmacia1_idx` (`fk_id_farmacia` ASC) ,
  INDEX `fk_id_tipo_func_idx` (`fk_id_tipo_func` ASC) ,
  FOREIGN KEY (`fk_id_departamento`)
        REFERENCES `bdfarmacia`.`Departamento` (`id_departamento`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`fk_id_farmacia`)
        REFERENCES `bdfarmacia`.`Farmacia` (`id_farmacia`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`fk_id_tipo_func`)
        REFERENCES `bdfarmacia`.`Tipo_Funcionario` (`id_tipo`)
        ON DELETE CASCADE ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Table `farmacia`.`tipo_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdfarmacia`.`tipo_produto` (
  `id_tipo_produto` INT NOT NULL AUTO_INCREMENT,
  `tipo_produto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo_produto`));


-- -----------------------------------------------------
-- Table `farmacia`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdfarmacia`.`Produto` (
  `id_produto` INT NOT NULL AUTO_INCREMENT,
  `nome_produto` VARCHAR(45) NULL,
  `fornecedor` VARCHAR(45) NULL,
  `lote` VARCHAR(45) NULL,
  `data_de_fabricacao` DATE NOT NULL,
  `data_de_validade` DATE NOT NULL,
  `codigo_de_barras` DOUBLE NOT NULL,
  `quantidade` INT NOT NULL,
  `tarja` VARCHAR(45) NULL,
  `preco` DECIMAL NULL,
  `fk_id_farmacia` INT NOT NULL,
  `status_produto` ENUM('RESERVADO', 'DISPONÍVEL') NULL,
  `fk_id_tipo_produto` INT NOT NULL,
  PRIMARY KEY (`id_produto`),
  INDEX `fk_produto_farmacias1_idx` (`fk_id_farmacia` ASC),
  INDEX `fk_produto_tipo_produto1_idx` (`fk_id_tipo_produto` ASC),
  CONSTRAINT `farmacia_id_farmacia_fk`
    FOREIGN KEY (`fk_id_farmacia`)
    REFERENCES `bdfarmacia`.`Farmacia` (`id_farmacia`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `tipo_produto_id_produto_fk`
    FOREIGN KEY (`fk_id_tipo_produto`)
    REFERENCES `bdfarmacia`.`tipo_produto` (`id_tipo_produto`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `farmacia`.`venda`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `bdfarmacia`.`Venda` (
  `id_venda` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `data_venda` DATE NULL,
  `tarja` VARCHAR(45),
  `tipo` enum("Medicamento", "Higiene", "Alimentação", "Cosméticos"),
  `status` ENUM("FINALIZADO", "EM ABERTO", "NO CAIXA") NULL,
  `quantidade` INT NULL,
  `total` DECIMAL NULL,
  `fk_id_produto` INT NOT NULL,
  `fk_id_farmacia` INT NOT NULL,
  `fk_id_funcionario` INT NOT NULL,
  INDEX `fk_table1_produto_idx` (`fk_id_produto` ASC),
  INDEX `fk_table1_farmacias1_idx` (`fk_id_farmacia` ASC),
  INDEX `fk_table1_funcionario1_idx` (`fk_id_funcionario` ASC),
  PRIMARY KEY (`id_venda`),
  FOREIGN KEY (`fk_id_produto`) 
  REFERENCES `bdfarmacia`.`produto` (`id_produto`)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (`fk_id_farmacia`)
	REFERENCES `bdfarmacia`.`farmacia` (`id_farmacia`)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (`fk_id_funcionario`)
	REFERENCES `bdfarmacia`.`funcionario` (`id_funcionario`)
	ON DELETE CASCADE
    ON UPDATE CASCADE
    );
    
CREATE TABLE IF NOT EXISTS `bdfarmacia`.`Reservas`(
	`id_reserva`INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`nome_cliente` VARCHAR(45) NOT NULL,
    `nome_produto` VARCHAR(45) NOT NULL,
    `telefone`VARCHAR(11) NOT NULL,
    `fk_id_farmacia` INT NOT NULL,
    `fk_id_produto` INT NOT NULL,
    CONSTRAINT `fk_id_produto1`
		FOREIGN KEY (`fk_id_produto`)
		REFERENCES `bdfarmacia`.`produto` (`id_produto`)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	CONSTRAINT `fk_id_farmacia1`
		FOREIGN KEY (`fk_id_farmacia`)
		REFERENCES `bdfarmacia`.`farmacia` (`id_farmacia`)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Table `farmacia`.`receita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdfarmacia`.`Receita` (
  `id_receita` INT NOT NULL AUTO_INCREMENT,
  `nome_paciente` VARCHAR(45) NOT NULL,
  `nome_profissional` VARCHAR(45) NOT NULL,
  `endereco_paciente` VARCHAR(45) NULL,
  `endereco_profissional` VARCHAR(45) NULL,
  `crm` VARCHAR(45) NULL,
  `cpf` VARCHAR(11) UNIQUE NOT NULL,
  `fk_id_funcionario` INT NOT NULL,
  `fk_id_farmacia` INT NOT NULL,
  PRIMARY KEY (`id_receita`),
  FOREIGN KEY (`fk_id_funcionario`)
	REFERENCES `bdfarmacia`.`funcionario` (`id_funcionario`)
    ON DELETE CASCADE 
    ON UPDATE CASCADE,
    FOREIGN KEY (`fk_id_farmacia`)
	REFERENCES `bdfarmacia`.`farmacia` (`id_farmacia`)
    ON DELETE CASCADE 
    ON UPDATE CASCADE
  );
  