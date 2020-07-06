CREATE DATABASE  IF NOT EXISTS `bdfarmacia` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdfarmacia`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bdfarmacia
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `nome_departamento` varchar(45) NOT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Unidade de Controle de Estoque'),(2,'Unidade de Controle de Medicação'),(3,'Unidade de Relacionamento com o Cliente');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farmacia`
--

DROP TABLE IF EXISTS `farmacia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `farmacia` (
  `id_farmacia` int(11) NOT NULL AUTO_INCREMENT,
  `nome_farmacia` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  PRIMARY KEY (`id_farmacia`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farmacia`
--

LOCK TABLES `farmacia` WRITE;
/*!40000 ALTER TABLE `farmacia` DISABLE KEYS */;
INSERT INTO `farmacia` VALUES (1,'Farma Flora','Av da Penha ,952, Cristo rei'),(2,'Giga Farma','Av Campos Sales, 245, Planalto'),(3,'Farma Beta','Av Amazonas, 578, Centro');
/*!40000 ALTER TABLE `farmacia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `nome_funcionario` varchar(45) NOT NULL,
  `endereco_funcionario` varchar(45) NOT NULL,
  `rg` varchar(14) DEFAULT NULL,
  `cpf` char(11) NOT NULL,
  `data_de_nascimento` date NOT NULL,
  `data_de_admissao` date NOT NULL,
  `sexo` enum('Masculino','Feminino','N/A') NOT NULL,
  `login` varchar(20) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `fk_id_departamento` int(11) NOT NULL,
  `fk_id_farmacia` int(11) NOT NULL,
  `fk_id_tipo_func` int(11) NOT NULL,
  `data_de_desligamento` date DEFAULT NULL,
  PRIMARY KEY (`id_funcionario`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `CPF_UNIQUE` (`cpf`),
  KEY `fk_id_departamento1_idx` (`fk_id_departamento`),
  KEY `fk_id_farmacia1_idx` (`fk_id_farmacia`),
  KEY `fk_id_tipo_func_idx` (`fk_id_tipo_func`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`fk_id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `funcionario_ibfk_2` FOREIGN KEY (`fk_id_farmacia`) REFERENCES `farmacia` (`id_farmacia`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `funcionario_ibfk_3` FOREIGN KEY (`fk_id_tipo_func`) REFERENCES `tipo_funcionario` (`id_tipo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'ADMINISTRADOR','NULL','00000000000000','00000000000','0000-00-00','0000-00-00','N/A','LOG001','123',1,1,1,'0000-00-00'),(2,'FARMACÊUTICO','NULL','00000000000000','11111111111','0000-00-00','0000-00-00','N/A','LOG002','123',1,1,2,'0000-00-00'),(3,'CAIXA','NULL','00000000000000','22222222222','0000-00-00','0000-00-00','N/A','LOG003','123',1,1,3,'0000-00-00'),(4,'ESTOQUISTA','NULL','00000000000000','33333333333','0000-00-00','0000-00-00','N/A','LOG004','123',1,1,4,'0000-00-00'),(5,'VENDEDOR','NULL','00000000000000','44444444444','0000-00-00','0000-00-00','N/A','LOG005','123',1,1,5,'0000-00-00'),(16,'ADMINISTRADOR','NULL','00000000000000','55555555555','0000-00-00','0000-00-00','N/A','LOG006','123',1,2,1,'0000-00-00'),(17,'FARMACÊUTICO','NULL','00000000000000','66666666666','0000-00-00','0000-00-00','N/A','LOG007','123',1,2,2,'0000-00-00'),(18,'CAIXA','NULL','00000000000000','77777777777','0000-00-00','0000-00-00','N/A','LOG008','123',1,2,3,'0000-00-00'),(19,'ESTOQUISTA','NULL','00000000000000','88888888888','0000-00-00','0000-00-00','N/A','LOG009','123',1,2,4,'0000-00-00'),(20,'VENDEDOR','NULL','00000000000000','99999999999','0000-00-00','0000-00-00','N/A','LOG010','123',1,2,5,'0000-00-00');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `nome_produto` varchar(45) DEFAULT NULL,
  `fornecedor` varchar(45) DEFAULT NULL,
  `lote` varchar(45) DEFAULT NULL,
  `data_de_fabricacao` date NOT NULL,
  `data_de_validade` date NOT NULL,
  `codigo_de_barras` double NOT NULL,
  `quantidade` int(11) NOT NULL,
  `tarja` varchar(45) DEFAULT NULL,
  `preco` decimal(5,2) DEFAULT NULL,
  `fk_id_farmacia` int(11) NOT NULL,
  `status_produto` enum('RESERVADO','DISPONÍVEL') DEFAULT NULL,
  `fk_id_tipo_produto` int(11) NOT NULL,
  PRIMARY KEY (`id_produto`),
  KEY `fk_produto_farmacias1_idx` (`fk_id_farmacia`),
  KEY `fk_produto_tipo_produto1_idx` (`fk_id_tipo_produto`),
  CONSTRAINT `farmacia_id_farmacia_fk` FOREIGN KEY (`fk_id_farmacia`) REFERENCES `farmacia` (`id_farmacia`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tipo_produto_id_produto_fk` FOREIGN KEY (`fk_id_tipo_produto`) REFERENCES `tipo_produto` (`id_tipo_produto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receita`
--

DROP TABLE IF EXISTS `receita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receita` (
  `id_receita` int(11) NOT NULL AUTO_INCREMENT,
  `nome_paciente` varchar(45) NOT NULL,
  `nome_profissional` varchar(45) NOT NULL,
  `endereco_paciente` varchar(45) DEFAULT NULL,
  `endereco_profissional` varchar(45) DEFAULT NULL,
  `crm` varchar(45) DEFAULT NULL,
  `cpf` varchar(11) NOT NULL,
  `fk_id_funcionario` int(11) NOT NULL,
  `fk_id_farmacia` int(11) NOT NULL,
  PRIMARY KEY (`id_receita`),
  UNIQUE KEY `cpf` (`cpf`),
  KEY `fk_id_funcionario` (`fk_id_funcionario`),
  KEY `fk_id_farmacia` (`fk_id_farmacia`),
  CONSTRAINT `receita_ibfk_1` FOREIGN KEY (`fk_id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `receita_ibfk_2` FOREIGN KEY (`fk_id_farmacia`) REFERENCES `farmacia` (`id_farmacia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receita`
--

LOCK TABLES `receita` WRITE;
/*!40000 ALTER TABLE `receita` DISABLE KEYS */;
/*!40000 ALTER TABLE `receita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `id_reserva` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cliente` varchar(45) NOT NULL,
  `nome_produto` varchar(45) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `fk_id_farmacia` int(11) NOT NULL,
  `fk_id_produto` int(11) NOT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `fk_id_produto1` (`fk_id_produto`),
  KEY `fk_id_farmacia1` (`fk_id_farmacia`),
  CONSTRAINT `fk_id_farmacia1` FOREIGN KEY (`fk_id_farmacia`) REFERENCES `farmacia` (`id_farmacia`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_produto1` FOREIGN KEY (`fk_id_produto`) REFERENCES `produto` (`id_produto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_funcionario`
--

DROP TABLE IF EXISTS `tipo_funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_funcionario` (
  `id_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_funcionario` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_funcionario`
--

LOCK TABLES `tipo_funcionario` WRITE;
/*!40000 ALTER TABLE `tipo_funcionario` DISABLE KEYS */;
INSERT INTO `tipo_funcionario` VALUES (1,'Gerente'),(2,'Farmacêutico'),(3,'Caixa'),(4,'Estoquista'),(5,'Vendedor');
/*!40000 ALTER TABLE `tipo_funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_produto`
--

DROP TABLE IF EXISTS `tipo_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_produto` (
  `id_tipo_produto` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_produto` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_produto`
--

LOCK TABLES `tipo_produto` WRITE;
/*!40000 ALTER TABLE `tipo_produto` DISABLE KEYS */;
INSERT INTO `tipo_produto` VALUES (1,'Medicamento'),(2,'Higiene'),(3,'Alimentação'),(4,'Cosméticos');
/*!40000 ALTER TABLE `tipo_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda` (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `data_venda` date DEFAULT NULL,
  `tarja` varchar(45) DEFAULT NULL,
  `tipo` enum('Medicamento','Higiene','Alimentação','Cosméticos') DEFAULT NULL,
  `status` enum('FINALIZADO','EM ABERTO','NO CAIXA') DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `total` decimal(10,0) DEFAULT NULL,
  `fk_id_produto` int(11) NOT NULL,
  `fk_id_farmacia` int(11) NOT NULL,
  `fk_id_funcionario` int(11) NOT NULL,
  PRIMARY KEY (`id_venda`),
  KEY `fk_table1_produto_idx` (`fk_id_produto`),
  KEY `fk_table1_farmacias1_idx` (`fk_id_farmacia`),
  KEY `fk_table1_funcionario1_idx` (`fk_id_funcionario`),
  CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`fk_id_produto`) REFERENCES `produto` (`id_produto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`fk_id_farmacia`) REFERENCES `farmacia` (`id_farmacia`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `venda_ibfk_3` FOREIGN KEY (`fk_id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-06 18:00:19
