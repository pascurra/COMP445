CREATE DATABASE  IF NOT EXISTS `ascurra_445` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `ascurra_445`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: ascurra.com    Database: ascurra_445
-- ------------------------------------------------------
-- Server version	5.5.40-36.1

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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `idusers` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `registrationDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`idusers`),
  UNIQUE KEY `alias_UNIQUE` (`alias`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (28,'Robin','Robin@Robin.com','2015-03-30 04:12:34'),(29,'paolo2015','paoloew','2015-03-29 22:41:14'),(30,'paolo2016','paoloew1','2015-03-29 22:41:16'),(34,'Robot','twibbleGmail@gmail.com','2015-06-12 17:06:35'),(42,'Sasha','mehdi.m.jamai@gmail.com','2012-06-18 15:34:09'),(45,'Catwoman','catwoman@catwoman.com','2015-04-09 14:18:13'),(46,'Toby','toby@toby.com','2015-04-11 21:10:19'),(48,'nexus7','asdsa@safs.com','2015-04-12 05:57:36'),(50,'nexus8','dsf@sdfsd.com','2015-04-12 06:06:56'),(51,'Joe','joe@joe.com','2015-04-12 16:00:11'),(52,'tester','test@test.ca','2015-04-12 16:07:46'),(53,'tester2','test2@test.ca','2015-04-12 17:46:54'),(54,'tester3','test3@test.ca','2015-04-12 17:49:30'),(55,'tester4','test4@test.ca','2015-04-12 18:00:25'),(56,'Paolo','paoloascurra@gmail.com','2015-04-13 01:23:57'),(57,'Joker','jokes@joke.ca','2015-04-13 13:32:19'),(58,'Riddler','riddle@riddles.com','2015-04-13 14:44:24'),(59,'Green','Lantern','2015-04-13 14:44:52'),(63,'Sam','Lastname','2015-04-13 14:59:30'),(64,'Bill,','dude','2015-04-13 15:04:53'),(65,'Classic','not@notworking.com','2015-04-13 15:10:56'),(66,'Phil','not@working.com','2015-04-13 15:12:25'),(73,'Tommy','tom@tom.org','2015-04-13 23:01:27'),(74,'Newsystemdj','newsystemdj@hotmail.com','2015-04-14 01:09:35'),(75,'Dracula','draco@drac.org','2015-04-14 14:29:36'),(82,'paolo2020','asdsa@fsdfd.com','2015-04-16 03:54:17'),(84,'paolo90','pasd@asfds.com','2015-04-16 04:39:13'),(85,'paolo55','sdfds@wsdf.com','2015-04-16 04:40:21'),(87,'paolo2000','paolo@sjklfhsd.com','2015-04-16 08:19:53'),(88,'paolo999','sdfd@dsgd.com','2015-04-16 08:25:42'),(89,'jasdoas','paolo3@swdf.com','2015-04-16 08:28:28'),(90,'sdfsdf','sdfsdf@dswfsd.com','2015-04-16 08:28:48'),(91,'klsdfhsdfhdk','ksdgfkjsdf@lksjdfhs.com','2015-04-16 08:31:55'),(94,'Gen','ouellong@yahoo.ca','2015-04-16 13:20:27'),(95,'Ryan','rstorm@gmail.com','2015-04-16 13:20:28'),(96,'Mehdi91','mehdi.m.jamai','2015-04-16 17:07:46'),(97,'Fred325432','ewtrewew@sdgds.com','2015-04-16 17:09:42'),(98,'Fred435654','23543253@dsdsds.com','2015-04-16 17:12:16'),(99,'dsfdsf34543','sdfds@dsfrds.com','2015-04-16 17:13:12'),(103,'Jerry12','paolo@ascurra.com','2015-04-16 17:25:42'),(105,'Mehdi2011','mehdi2011@hotmail.com','2015-04-16 18:25:18');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profiles`
--

DROP TABLE IF EXISTS `profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profiles` (
  `idprofiles` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `location` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `interests` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dateOfJoining` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dateOfPostingProfile` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idForeignKey` int(11) NOT NULL,
  PRIMARY KEY (`idprofiles`,`idForeignKey`),
  UNIQUE KEY `idForeignKey_UNIQUE` (`idForeignKey`),
  UNIQUE KEY `alias_UNIQUE` (`alias`),
  KEY `idusers_idx` (`idForeignKey`),
  CONSTRAINT `fk_profiles_1` FOREIGN KEY (`idForeignKey`) REFERENCES `clients` (`idusers`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profiles`
--

LOCK TABLES `profiles` WRITE;
/*!40000 ALTER TABLE `profiles` DISABLE KEYS */;
INSERT INTO `profiles` VALUES (25,'Paolo','Peru','Volley,Basket',' 2015-04-12 20:23:57','2015-04-13 13:28:01',56),(26,'Newsystemdj','NewZealand',' cs,java,c++',' 2015-04-13 20:09:35','2015-04-13 19:46:39',74),(32,'Robin','GothamCity',' HelpingBatman,FightingCrime',' 2015-03-29 23:12:34','2015-04-15 19:24:45',28),(43,'Ryan','Montreal',' Demo,networks',' 2015-04-16 08:20:28','2015-04-16 10:08:41',95),(45,'Jerry12','Morroco','running,jumping',' 2015-04-16 12:25:42','2015-04-16 11:28:40',103);
/*!40000 ALTER TABLE `profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscribers`
--

DROP TABLE IF EXISTS `subscribers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subscribers` (
  `subscriber_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_alias` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `following_client_id` int(11) NOT NULL,
  PRIMARY KEY (`subscriber_id`,`following_client_id`),
  KEY `fk_subscribers_users1_idx` (`following_client_id`),
  CONSTRAINT `fk_subscribers_users1` FOREIGN KEY (`following_client_id`) REFERENCES `clients` (`idusers`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscribers`
--

LOCK TABLES `subscribers` WRITE;
/*!40000 ALTER TABLE `subscribers` DISABLE KEYS */;
INSERT INTO `subscribers` VALUES (5,'sancho',29),(6,'sancho',30),(7,'sancho',28),(10,'Mehdi',42),(16,'Paolo',42),(17,'Ryan',42),(20,'Newsystemdj',56),(21,'Newsystemdj',42),(23,'Sasha',56),(27,'paolo2000',56),(28,'klsdfhsdfhdk',56),(29,'Paolo',42),(36,'Ryan',105);
/*!40000 ALTER TABLE `subscribers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `twibbles`
--

DROP TABLE IF EXISTS `twibbles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `twibbles` (
  `idtwiblr` int(11) NOT NULL AUTO_INCREMENT,
  `twiblrcontent` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `usersIdForeign` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idtwiblr`,`usersIdForeign`),
  UNIQUE KEY `idtwiblr_UNIQUE` (`idtwiblr`),
  KEY `fk_twiblr_users_idx` (`usersIdForeign`),
  CONSTRAINT `fk_twiblr_users` FOREIGN KEY (`usersIdForeign`) REFERENCES `clients` (`idusers`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `twibbles`
--

LOCK TABLES `twibbles` WRITE;
/*!40000 ALTER TABLE `twibbles` DISABLE KEYS */;
INSERT INTO `twibbles` VALUES (40,'sdfs',50,'2015-04-12 05:07:15'),(41,'sdfsdfw',50,'2015-04-12 05:07:32'),(45,'HelloFromSchoolTestingAtThelab',74,'2015-04-14 00:27:11'),(49,'ItwibbleNowForTest',28,'2015-04-15 00:36:21'),(57,'AgainMulti',42,'2015-04-16 04:43:04'),(60,'MultiWorking!',42,'2015-04-16 05:13:01'),(64,'TestingMultithreading',42,'2015-04-16 05:34:27'),(65,'TestingMultithreading',42,'2015-04-16 05:35:06'),(79,'Twibble with spaces!',56,'2015-04-16 15:36:10'),(81,'Sasha Twibbles!',42,'2015-04-16 15:45:21'),(82,'Sasha Twibbled at 11:46',42,'2015-04-16 15:46:36'),(83,'test',56,'2015-04-16 15:56:55'),(84,'Client1 creates twibble',103,'2015-04-16 16:29:22');
/*!40000 ALTER TABLE `twibbles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-16 15:54:38
