-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: my-database.c7u2kc6sgxm7.ca-central-1.rds.amazonaws.com    Database: keyboard_planet
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` varchar(40) NOT NULL,
  `name` varchar(64) NOT NULL,
  `sort` int NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `is_deleted` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('1','Digital Piano',1,'2024-08-31 10:00:00','2024-08-31 10:00:00',0),('2','Arranger',2,'2024-08-31 10:05:00','2024-08-31 10:05:00',0),('3','Synthesizer',3,'2024-08-31 10:10:00','2024-09-05 04:06:45',0),('4','MIDI Keyboard',4,'2024-08-31 10:15:00','2024-08-31 10:15:00',0);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` varchar(40) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('1','user1','password1'),('10','user10','password10'),('1831269263625658370','Fannie','Fannie'),('2','user2','password2'),('3','user3','password3'),('4','user4','password4'),('5','user5','password5'),('6','user6','password6'),('7','user7','password7'),('8','user8','password8'),('9','user9','password9');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_1`
--

DROP TABLE IF EXISTS `order_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_1` (
  `id` varchar(40) NOT NULL,
  `status` varchar(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(40) NOT NULL,
  `product_id` int NOT NULL,
  `amount` int NOT NULL,
  `total_price` int NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_1`
--

LOCK TABLES `order_1` WRITE;
/*!40000 ALTER TABLE `order_1` DISABLE KEYS */;
INSERT INTO `order_1` VALUES ('1','已完成','user1','123-456-7890','123 Elm St, Springfield',1,2,120000,'2024-08-31 10:00:00','2024-08-31 10:00:00'),('2','Shipped','user1','234-567-8901','456 Oak St, Springfield',2,1,50000,'2024-08-31 11:00:00','2024-08-31 11:00:00'),('3','Delivered','user1','345-678-9012','789 Pine St, Springfield',3,3,135000,'2024-08-31 12:00:00','2024-08-31 12:00:00'),('4','已完成','Fannie','456-789-0123','321 Maple St, Springfield',4,1,35000,'2024-08-31 13:00:00','2024-08-31 13:00:00');
/*!40000 ALTER TABLE `order_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` varchar(40) NOT NULL,
  `name` varchar(64) NOT NULL,
  `category_id` int NOT NULL,
  `price` int NOT NULL,
  `image` varchar(200) NOT NULL,
  `description` varchar(400) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `weight` varchar(40) NOT NULL,
  `key_nums` tinyint NOT NULL,
  `keyboard_type` varchar(50) NOT NULL,
  `keyboard_force` varchar(40) NOT NULL,
  `sound_source` varchar(50) NOT NULL,
  `complex_tone_nums` varchar(50) NOT NULL,
  `tone_nums` smallint NOT NULL,
  `effects` varchar(60) NOT NULL,
  `functions` varchar(60) NOT NULL,
  `song_nums` varchar(50) NOT NULL,
  `recording` varchar(50) NOT NULL,
  `accompaniment` varchar(50) NOT NULL,
  `power_amplifier` varchar(40) NOT NULL,
  `accessory` varchar(60) NOT NULL,
  `is_deleted` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('1','Yamaha P-125',2,60000,'image1.jpg','Digital piano','2023-08-31 10:00:00','2023-08-31 10:00:00','12kg',88,'Graded Hammer Standard (GHS)','5 levels','AWM Stereo Sampling','100',10,'Reverb','Chorus','50','Yes','Yes','10W x 2','Stand, Adapter',0),('2','Casio PX-160',3,50000,'image2.jpg','Portable keyboard','2023-08-31 10:00:00','2023-08-31 10:00:00','11.5kg',88,'Tri-Sensor Scaled Hammer Action II','3 levels','Multi-dimensional Morphing AiR','80',18,'Reverb','Chorus','60','Yes','Yes','8W x 2','Stand, Adapter',0),('3','Roland FP-30',1,45000,'image3.jpg','Compact digital piano','2023-08-31 10:00:00','2023-08-31 10:00:00','12kg',88,'PHA-4 Standard','5 levels','SuperNATURAL Piano Sound','90',15,'Reverb','Chorus','40','Yes','Yes','6W x 2','Stand, Adapter',0),('4','Korg B1',4,35000,'image4.jpg','Digital piano with 88 keys','2023-08-31 10:00:00','2023-08-31 10:00:00','10.5kg',88,'NH (Natural Weighted Hammer) Action','3 levels','Stereo PCM','60',12,'Reverb','Chorus','30','Yes','No','8W x 2','Stand, Adapter',0),('5','Nord Stage 3',2,120000,'image5.jpg','Stage piano with advanced features','2023-08-31 10:00:00','2023-08-31 10:00:00','15kg',88,'Virtual Hammer Action','6 levels','Nord Piano Library','120',20,'Reverb','Chorus','70','Yes','Yes','30W x 2','Stand, Adapter',0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `id` varchar(40) NOT NULL,
  `username` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `status` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES ('172947','Soson','Suo','123456','13372727272',1),('1825808516594462721','Ukmate','U.kmate','123456','13374747474',1),('1831278943647170562','test','test1','123456','13344444444',1),('1831595695446827009','t2t2','t2t2','123456','13342424242',1),('1831607958849441793','test1','tset11','123456','13342424242',1);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-30 14:11:55
