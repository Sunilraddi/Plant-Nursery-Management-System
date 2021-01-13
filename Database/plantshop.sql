-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: plantshop
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `garden`
--

DROP TABLE IF EXISTS `garden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garden` (
  `GID` varchar(4) NOT NULL,
  `GName` varchar(50) NOT NULL,
  `GAddress` varchar(200) NOT NULL,
  `GExpiry` date NOT NULL,
  `GNote` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`GID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garden`
--

LOCK TABLES `garden` WRITE;
/*!40000 ALTER TABLE `garden` DISABLE KEYS */;
INSERT INTO `garden` VALUES ('G001','Blue','Andheri','2021-12-03',''),('G002','Red','Malad','2020-12-25',''),('G003','Green','Borivali','2021-10-15','Green'),('G004','Yellow','Chembur','2021-12-20',''),('G005','Pink','Vikhroli','2021-09-09','Cherry Blossoms'),('G006','Chhatrapati Shivaji Garden','Malad','2021-12-10','No chances of extending');
/*!40000 ALTER TABLE `garden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hybrid`
--

DROP TABLE IF EXISTS `hybrid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hybrid` (
  `HID` varchar(4) NOT NULL,
  `HName` varchar(50) NOT NULL,
  `HSpecies1` varchar(30) DEFAULT NULL,
  `HSpecies2` varchar(30) DEFAULT NULL,
  `HSpecies3` varchar(30) DEFAULT NULL,
  `HSpecies4` varchar(30) DEFAULT NULL,
  `HSpecies5` varchar(30) DEFAULT NULL,
  `HDate` date NOT NULL,
  `HNote` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`HID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hybrid`
--

LOCK TABLES `hybrid` WRITE;
/*!40000 ALTER TABLE `hybrid` DISABLE KEYS */;
INSERT INTO `hybrid` VALUES ('H001','Bellflower and Common Jasmine','Bellflower','Common Jasmine','','','','2020-12-03','May get successful. Needs a special manure.'),('H002','Rose and Common Jasmine - 1','Rose','','Common Jasmine','','','2020-12-01','Failed'),('H003','Rose and Common Jasmine - 2','Rose','Common Jasmine','','','','2020-10-12','Failed!!!'),('H004','Tulip and Rose','Tulip','Rose','','','','2020-12-31','More efforts required'),('H005','Jasmine and Bellflower','Bellflower','Common Jasmine','','','','2020-11-03','Noticeable results'),('H006','Sandy','Bellflower','','Common Jasmine','','','2020-12-10','No chances');
/*!40000 ALTER TABLE `hybrid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `Username` varchar(30) NOT NULL,
  `password` varchar(48) NOT NULL,
  `email` varchar(30) NOT NULL,
  `Contact` varchar(10) NOT NULL,
  `sec` varchar(20) NOT NULL,
  PRIMARY KEY (`Username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('abcd@1234','[1, 2, 3, 4, 5, 6, 7, 8]','abcd@12.as','8743210965','America'),('abcd1234','[a, b, c, d, 1, 2, 3, 4]','abcd@abcd.com','9876556789','dfg'),('abcdef','[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]','abcd@gmail.com','9876545678','Tokyo');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notify`
--

DROP TABLE IF EXISTS `notify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notify` (
  `NID` varchar(4) NOT NULL,
  `PID` varchar(5) NOT NULL,
  `N_entryDate` date NOT NULL,
  `notifyOn` date NOT NULL,
  `notifyNote` varchar(200) DEFAULT NULL,
  `Status` varchar(10) DEFAULT 'dormant',
  PRIMARY KEY (`NID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notify`
--

LOCK TABLES `notify` WRITE;
/*!40000 ALTER TABLE `notify` DISABLE KEYS */;
INSERT INTO `notify` VALUES ('N001','P0001','2020-12-03','2020-12-03','','Dormant'),('N002','P0004','2020-12-03','2020-12-03','','Dormant'),('N003','P0001','2020-12-03','2020-12-11','Time to provide different manures','Dormant'),('N004','P0001','2020-12-03','2020-12-03','Ready to sell!','Dormant'),('N005','P0003','2020-12-03','2020-12-04','','Dormant'),('N006','P0001','2020-12-03','2020-12-31','At the end of fall.','Active'),('N007','P0005','2020-12-10','2020-12-10','Here Today!!!','Dormant'),('N008','P0001','2020-12-10','2020-12-10','Well Ok!','Dormant'),('N009','P0002','2020-12-10','2020-12-10','Nawal Miss!!!','Dormant'),('N010','P0001','2020-12-10','2020-12-10','Notification for Jasmine!','Dormant');
/*!40000 ALTER TABLE `notify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plants_data`
--

DROP TABLE IF EXISTS `plants_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plants_data` (
  `PID` varchar(5) NOT NULL,
  `P_Name` varchar(50) NOT NULL,
  `P_Sciname` varchar(50) NOT NULL,
  `P_ABPna` varchar(10) DEFAULT NULL,
  `Ptag1` varchar(30) DEFAULT NULL,
  `Ptag2` varchar(30) DEFAULT NULL,
  `Ptag3` varchar(30) DEFAULT NULL,
  `Ptag4` varchar(30) DEFAULT NULL,
  `Ptag5` varchar(30) DEFAULT NULL,
  `P_experimented` varchar(3) DEFAULT NULL,
  `P_Note` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`PID`),
  UNIQUE KEY `P_Sciname` (`P_Sciname`),
  UNIQUE KEY `P_Name` (`P_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plants_data`
--

LOCK TABLES `plants_data` WRITE;
/*!40000 ALTER TABLE `plants_data` DISABLE KEYS */;
INSERT INTO `plants_data` VALUES ('P0001','Common Jasmine','Jasminum Officinale','Perennial','Flower','Climber','','','','No',''),('P0002','Rose','Rosa','Perennial','','','','','','No',''),('P0003','Tulip','Tulipa','Perennial','Flower','Herb','','','','No',''),('P0004','Bellflower','Campanula','Biennial','Flower','Herb','','','','No',''),('P0005','Aster','Asteraceae','Perennial','Flower','Herb','','','','No','');
/*!40000 ALTER TABLE `plants_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sold`
--

DROP TABLE IF EXISTS `sold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sold` (
  `Plant_issue_ID` varchar(5) NOT NULL,
  `PID` varchar(5) NOT NULL,
  `Stock_ID` varchar(6) NOT NULL,
  `quantity` smallint unsigned NOT NULL,
  `Cust_name` varchar(30) NOT NULL,
  `Contact` varchar(30) DEFAULT NULL,
  `Plant_Issue_Date` date NOT NULL,
  PRIMARY KEY (`Plant_issue_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sold`
--

LOCK TABLES `sold` WRITE;
/*!40000 ALTER TABLE `sold` DISABLE KEYS */;
INSERT INTO `sold` VALUES ('S0001','P0001','ST0001',1,'Andy','7654321098','2020-12-03'),('S0002','P0002','ST0002',2,'David','','2020-12-03'),('S0003','P0003','ST0003',2,'Jane','jane1996xcv@gmail.com','2020-12-03'),('S0004','P0004','ST0004',1,'Mahesh','','2020-12-03'),('S0005','P0001','ST0001',2,'Akash','7878787878','2020-12-03'),('S0006','P0004','ST0004',1,'Jasmine','jasjasjas@jas.com','2020-12-03'),('S0007','P0005','ST0005',1,'Ashwin','','2020-12-03'),('S0008','P0002','ST0002',5,'a','','2020-12-10'),('S0009','P0001','ST0001',20,'Akash','','2020-12-10'),('S0010','P0002','ST0002',20,'Akash','','2020-12-10'),('S0011','P0003','ST0003',1,'q','','2020-12-13'),('S0012','P0004','ST0004',1,'a','','2020-12-25');
/*!40000 ALTER TABLE `sold` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `Stock_ID` varchar(20) NOT NULL,
  `PID` varchar(5) NOT NULL,
  `P_Quantity` smallint unsigned NOT NULL,
  `P_Price` smallint unsigned NOT NULL,
  PRIMARY KEY (`Stock_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES ('ST0001','P0001',27,250),('ST0002','P0002',73,80),('ST0003','P0003',27,200),('ST0004','P0004',7,200),('ST0005','P0005',19,300);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-26 18:00:45
