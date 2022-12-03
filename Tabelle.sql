CREATE DATABASE  IF NOT EXISTS `negozio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `negozio`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: negozio
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `azienda`
--

DROP TABLE IF EXISTS `azienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azienda` (
  `id_azienda` int NOT NULL AUTO_INCREMENT,
  `nome_azienda` varchar(50) DEFAULT NULL,
  `sede_azienda` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_azienda`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azienda`
--

LOCK TABLES `azienda` WRITE;
/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
INSERT INTO `azienda` VALUES (1,'AAA','Olanda'),(2,'BBB','Francia'),(3,'CCC','Italia'),(4,'DDD','Giappone'),(5,'EEE','Turchia');
/*!40000 ALTER TABLE `azienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dato_lavorativo`
--

DROP TABLE IF EXISTS `dato_lavorativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dato_lavorativo` (
  `id_dato_lavorativo` int NOT NULL AUTO_INCREMENT,
  `codice_negozio` int DEFAULT NULL,
  `negozio` varchar(255) DEFAULT NULL,
  `ral` int DEFAULT NULL,
  `livello_contratto` int DEFAULT NULL,
  `articolo_104` varchar(255) DEFAULT NULL,
  `categoria_protetta` varchar(255) DEFAULT NULL,
  `dipendente_id` int DEFAULT NULL,
  PRIMARY KEY (`id_dato_lavorativo`),
  KEY `dipendente_id_idx` (`dipendente_id`),
  CONSTRAINT `fk_verso_dipendente` FOREIGN KEY (`dipendente_id`) REFERENCES `dipendente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dato_lavorativo`
--

LOCK TABLES `dato_lavorativo` WRITE;
/*!40000 ALTER TABLE `dato_lavorativo` DISABLE KEYS */;
INSERT INTO `dato_lavorativo` VALUES (1,111,'madrid',29000,2,'no','si',2),(2,112,'nantes',23000,5,'no','no',3),(3,113,'roma',26000,4,'si','no',4),(4,114,'foggia',31000,3,'no','no',5),(5,115,'ancona',29800,4,'no','no',1);
/*!40000 ALTER TABLE `dato_lavorativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dipendente`
--

DROP TABLE IF EXISTS `dipendente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dipendente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `eta` int DEFAULT NULL,
  `anno_assunzione` int DEFAULT NULL,
  `ore_contratto` int DEFAULT NULL,
  `data_di_nascita` date DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `azienda_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_verso_azienda_idx` (`azienda_id`),
  CONSTRAINT `fk_verso_azienda` FOREIGN KEY (`azienda_id`) REFERENCES `azienda` (`id_azienda`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dipendente`
--

LOCK TABLES `dipendente` WRITE;
/*!40000 ALTER TABLE `dipendente` DISABLE KEYS */;
INSERT INTO `dipendente` VALUES (1,'giorgio','neri',35,2015,40,'1968-10-24','male',2),(2,'massimo','mela',50,2020,40,'1968-10-24','male',1),(3,'Prova','Prova',59,2004,20,'1960-07-28','female',4),(4,'Sonia','Cervia',47,1987,38,'1956-01-28','female',5),(5,'Fabio','Lo Guasto',29,2014,40,'1992-12-24','male',3);
/*!40000 ALTER TABLE `dipendente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (124);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-03 10:47:35
