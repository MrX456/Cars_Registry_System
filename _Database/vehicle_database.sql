CREATE DATABASE  IF NOT EXISTS `vehicle_database` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vehicle_database`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: vehicle_database
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `tbl_cars`
--

DROP TABLE IF EXISTS `tbl_cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cars` (
  `id_car` int(11) NOT NULL AUTO_INCREMENT,
  `maker` varchar(20) NOT NULL,
  `model` varchar(50) NOT NULL,
  `country` varchar(25) NOT NULL,
  `year_built` int(11) NOT NULL,
  `body_type` varchar(20) NOT NULL,
  `color` varchar(15) NOT NULL,
  `top_speed` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `photo` longblob,
  `register_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `by_user` varchar(80) NOT NULL,
  `id_engineModel` int(11) NOT NULL,
  PRIMARY KEY (`id_car`),
  KEY `id_engineModel` (`id_engineModel`),
  CONSTRAINT `tbl_cars_ibfk_1` FOREIGN KEY (`id_engineModel`) REFERENCES `tbl_enginemodel` (`id_engineModel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cars`
--

LOCK TABLES `tbl_cars` WRITE;
/*!40000 ALTER TABLE `tbl_cars` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_enginemodel`
--

DROP TABLE IF EXISTS `tbl_enginemodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_enginemodel` (
  `id_engineModel` int(11) NOT NULL AUTO_INCREMENT,
  `engine_model` varchar(20) NOT NULL,
  `size` int(11) NOT NULL,
  `power` int(11) NOT NULL,
  `torque` int(11) NOT NULL,
  PRIMARY KEY (`id_engineModel`),
  UNIQUE KEY `engine_model` (`engine_model`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_enginemodel`
--

LOCK TABLES `tbl_enginemodel` WRITE;
/*!40000 ALTER TABLE `tbl_enginemodel` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_enginemodel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_users`
--

DROP TABLE IF EXISTS `tbl_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(80) NOT NULL,
  `sex` enum('male','female') NOT NULL,
  `login` varchar(40) NOT NULL,
  `user_password` varchar(15) NOT NULL,
  `user_profile` enum('administrator','user') NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_users`
--

LOCK TABLES `tbl_users` WRITE;
/*!40000 ALTER TABLE `tbl_users` DISABLE KEYS */;
INSERT INTO `tbl_users` VALUES (1,'Administrator','','admin','admin','administrator');
/*!40000 ALTER TABLE `tbl_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-03 11:51:14
