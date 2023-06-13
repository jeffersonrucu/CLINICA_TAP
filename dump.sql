-- MySQL dump 10.13  Distrib 5.7.42, for Linux (x86_64)
--
-- Host: localhost    Database: clinic
-- ------------------------------------------------------
-- Server version	5.7.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `consultation_patient_employee`
--

DROP TABLE IF EXISTS `consultation_patient_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consultation_patient_employee` (
  `date_consult` date NOT NULL,
  `description` varchar(255) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `id_employee` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_date` varchar(30) NOT NULL,
  `update_date` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_consultation_employee` (`id_employee`),
  KEY `id_consultation_patient` (`id_patient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultation_patient_employee`
--

LOCK TABLES `consultation_patient_employee` WRITE;
/*!40000 ALTER TABLE `consultation_patient_employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `consultation_patient_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_job_role` int(11) NOT NULL,
  `hiring_date` varchar(30) NOT NULL,
  `wage` double NOT NULL,
  `creation_date` varchar(30) NOT NULL,
  `update_date` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_user_fk` (`id_user`),
  KEY `employee_job_fk` (`id_job_role`),
  CONSTRAINT `employee_job_fk` FOREIGN KEY (`id_job_role`) REFERENCES `job_role` (`id`),
  CONSTRAINT `employee_user_fk` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,6,1,'01/03/2003',1110,'2023-06-13 02:49:11','2023-06-13 02:49:11');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_role`
--

DROP TABLE IF EXISTS `job_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_job` varchar(60) NOT NULL,
  `permission` int(10) NOT NULL,
  `creation_date` varchar(30) NOT NULL,
  `update_date` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_role`
--

LOCK TABLES `job_role` WRITE;
/*!40000 ALTER TABLE `job_role` DISABLE KEYS */;
INSERT INTO `job_role` VALUES (1,'gerente',5,'2023-06-13 02:47:26','2023-06-13 02:47:26');
/*!40000 ALTER TABLE `job_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logradouro`
--

DROP TABLE IF EXISTS `logradouro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logradouro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street_name` varchar(255) NOT NULL,
  `zip_code` varchar(9) NOT NULL,
  `number` int(11) NOT NULL,
  `neighborhood` varchar(255) NOT NULL,
  `city` varchar(150) NOT NULL,
  `state` varchar(150) NOT NULL,
  `country` varchar(150) DEFAULT NULL,
  `creation_date` varchar(30) NOT NULL,
  `update_date` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logradouro`
--

LOCK TABLES `logradouro` WRITE;
/*!40000 ALTER TABLE `logradouro` DISABLE KEYS */;
INSERT INTO `logradouro` VALUES (1,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 00:51:50','2023-06-13 00:51:50'),(2,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 00:54:09','2023-06-13 00:54:09'),(3,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 00:55:04','2023-06-13 00:55:04'),(4,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 00:56:44','2023-06-13 00:56:44'),(5,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 00:57:15','2023-06-13 00:57:15'),(6,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 00:57:55','2023-06-13 00:57:55'),(7,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 00:59:30','2023-06-13 00:59:30'),(8,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:02:54','2023-06-13 01:02:54'),(9,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:05:39','2023-06-13 01:05:39'),(10,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:06:13','2023-06-13 01:06:13'),(11,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:07:02','2023-06-13 01:07:02'),(12,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:10:56','2023-06-13 01:10:56'),(13,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:12:47','2023-06-13 01:12:47'),(14,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:13:07','2023-06-13 01:13:07'),(15,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:13:42','2023-06-13 01:13:42'),(16,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:15:02','2023-06-13 01:15:02'),(17,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:17:02','2023-06-13 01:17:02'),(18,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:50:23','2023-06-13 01:50:23'),(19,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:50:55','2023-06-13 01:50:55'),(20,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:55:02','2023-06-13 01:55:02'),(21,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 01:55:44','2023-06-13 01:55:44'),(22,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 02:16:18','2023-06-13 02:16:18'),(23,'Rua Nova Bassam','08240-220',94,'Jardim Norma','São Paulo','São Paulo','São Paulo','2023-06-13 02:16:47','2023-06-13 02:16:47'),(24,'Rua Lapa Jama','33213-123',10,'Jardim Juru','São Paulo','São Paulo','São Paulo','2023-06-13 02:48:12','2023-06-13 02:48:12'),(25,'Rua Lapa Jama','33213-123',10,'Jardim Juru','São Paulo','São Paulo','São Paulo','2023-06-13 02:49:10','2023-06-13 02:49:10');
/*!40000 ALTER TABLE `logradouro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `health_insurance` varchar(80) DEFAULT NULL,
  `creation_date` varchar(30) NOT NULL,
  `update_date` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_user_fk` (`id_user`),
  CONSTRAINT `patient_user_fk` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,4,'Amil','2023-06-13 02:16:47','2023-06-13 02:16:47');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_type` int(11) NOT NULL,
  `id_logradouro` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `gender` char(1) NOT NULL,
  `creation_date` varchar(30) NOT NULL,
  `update_date` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `person_type_fk` (`id_type`),
  KEY `person_logradouro_fk` (`id_logradouro`),
  CONSTRAINT `person_logradouro_fk` FOREIGN KEY (`id_logradouro`) REFERENCES `logradouro` (`id`),
  CONSTRAINT `person_type_fk` FOREIGN KEY (`id_type`) REFERENCES `type_person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (12,13,17,'Jefferson Oliveira','M','2023-06-13 01:17:02','2023-06-13 01:17:02'),(13,14,18,'Jefferson Oliveira','M','2023-06-13 01:50:23','2023-06-13 01:50:23'),(14,15,19,'Jefferson Oliveira','M','2023-06-13 01:50:55','2023-06-13 01:50:55'),(15,16,20,'Jefferson Oliveira','M','2023-06-13 01:55:03','2023-06-13 01:55:03'),(16,17,21,'Jefferson Oliveira','M','2023-06-13 01:55:45','2023-06-13 01:55:45'),(17,18,22,'Jefferson Oliveira','M','2023-06-13 02:16:19','2023-06-13 02:16:19'),(18,19,23,'Jefferson Oliveira','M','2023-06-13 02:16:47','2023-06-13 02:16:47'),(19,20,24,'Leo Oliveira','M','2023-06-13 02:48:13','2023-06-13 02:48:13'),(20,21,25,'Leo Oliveira','M','2023-06-13 02:49:11','2023-06-13 02:49:11');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_person`
--

DROP TABLE IF EXISTS `type_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(16) DEFAULT NULL,
  `cnpj` varchar(20) DEFAULT NULL,
  `creation_date` varchar(30) NOT NULL,
  `update_date` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1 COMMENT='type of person, physical or legal';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_person`
--

LOCK TABLES `type_person` WRITE;
/*!40000 ALTER TABLE `type_person` DISABLE KEYS */;
INSERT INTO `type_person` VALUES (1,'527.208.558-20','0000.00000.00.000/00','2023-06-13 00:57:15','2023-06-13 00:57:15'),(2,'527.208.558-20','0000.00000.00.000/00','2023-06-13 00:57:55','2023-06-13 00:57:55'),(3,'527.208.558-20','0000.00000.00.000/00','2023-06-13 00:59:31','2023-06-13 00:59:31'),(4,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:02:54','2023-06-13 01:02:54'),(5,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:05:39','2023-06-13 01:05:39'),(6,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:06:14','2023-06-13 01:06:14'),(7,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:07:02','2023-06-13 01:07:02'),(8,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:10:56','2023-06-13 01:10:56'),(9,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:12:47','2023-06-13 01:12:47'),(10,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:13:07','2023-06-13 01:13:07'),(11,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:13:43','2023-06-13 01:13:43'),(12,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:15:03','2023-06-13 01:15:03'),(13,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:17:02','2023-06-13 01:17:02'),(14,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:50:23','2023-06-13 01:50:23'),(15,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:50:55','2023-06-13 01:50:55'),(16,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:55:03','2023-06-13 01:55:03'),(17,'527.208.558-20','0000.00000.00.000/00','2023-06-13 01:55:44','2023-06-13 01:55:44'),(18,'527.208.558-20','0000.00000.00.000/00','2023-06-13 02:16:19','2023-06-13 02:16:19'),(19,'527.208.558-20','0000.00000.00.000/00','2023-06-13 02:16:47','2023-06-13 02:16:47'),(20,'123.333.212-20','123.00000.00.000/00','2023-06-13 02:48:13','2023-06-13 02:48:13'),(21,'123.333.212-20','123.00000.00.000/00','2023-06-13 02:49:11','2023-06-13 02:49:11');
/*!40000 ALTER TABLE `type_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_person` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `email` varchar(255) NOT NULL,
  `email_recovery` varchar(255) NOT NULL,
  `password` varchar(128) NOT NULL COMMENT '128 character hash',
  `creation_date` varchar(30) NOT NULL,
  `update_date` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_person_fk` (`id_person`),
  CONSTRAINT `user_person_fk` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,16,'jeffersonrucu','jefferoidtex7@gmail.com','jeffersontex7@gmail.com','LWpass2010','2023-06-13 01:55:45','2023-06-13 01:55:45'),(3,17,'jeffersonrucu','jefferoidtex7@gmail.com','jeffersontex7@gmail.com','LWpass2010','2023-06-13 02:16:19','2023-06-13 02:16:19'),(4,18,'jeffersonrucu','jefferoidtex7@gmail.com','jeffersontex7@gmail.com','LWpass2010','2023-06-13 02:16:47','2023-06-13 02:16:47'),(5,19,'leooliveira','leo@gmail.com','leo123@gmail.com','LWpass2010','2023-06-13 02:48:13','2023-06-13 02:48:13'),(6,20,'leooliveira','leo@gmail.com','leo123@gmail.com','LWpass2010','2023-06-13 02:49:11','2023-06-13 02:49:11');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-13 16:30:59
