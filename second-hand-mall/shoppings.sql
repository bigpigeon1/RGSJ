-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: shoppings
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `bask`
--

DROP TABLE IF EXISTS `bask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bask` (
  `tid` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `isselect` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bask`
--

LOCK TABLES `bask` WRITE;
/*!40000 ALTER TABLE `bask` DISABLE KEYS */;
INSERT INTO `bask` VALUES (13,1,0),(3,2,0),(7,1,0);
/*!40000 ALTER TABLE `bask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `itemname` varchar(30) NOT NULL,
  `stime` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `brief` varchar(200) NOT NULL,
  `attributes` varchar(20) NOT NULL,
  `image` varchar(50) NOT NULL,
  `isbuy` int(11) NOT NULL,
  `isgrounding` int(11) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (3,1,'毛巾','2021-10-21',18.5,'高档毛巾','dailysupplies','',0,1),(4,1,'iPhone18','2021-10-22',10999,'高端大气上档次','electronic','',0,1),(5,1,'阿迪达斯球鞋','2021-10-22',1024,'很耐穿','clothing','',0,1),(7,1,'牙刷','2021-10-22',5.2,'软毛，牙刷','dailysupplies','',0,1),(12,2,'漱口瓶','2021-10-22',4.398,'电动小瓶子。','dailysupplies','',0,1),(13,2,'牙套','2021-10-22',439.9,'镶嵌青铜的牙套。','dailysupplies','',0,1),(15,2,'虎牙','2021-10-22',43962002,'虎牙直播平台。','electronic','',0,1),(16,2,'古代人牙龈','2021-10-22',43996,'北京人的牙龈。','antique','',0,1),(17,2,'兽牙上衣','2021-10-22',998,'不要1000，只要998.','clothing','',0,1),(19,2,'兽牙下衣','2021-10-22',988,'兽牙套装之一。','clothing','',0,1),(22,2,'三星手机','2021-11-07',1299,'应该不会爆','electronic','',0,1),(23,2,'牙刷','2021-11-07',12,'没用过','dailysupplies','R-C.png',0,1);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `records`
--

DROP TABLE IF EXISTS `records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `records` (
  `id` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `stime` varchar(20) NOT NULL,
  `price` double NOT NULL,
  `attributes` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `records`
--

LOCK TABLES `records` WRITE;
/*!40000 ALTER TABLE `records` DISABLE KEYS */;
/*!40000 ALTER TABLE `records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(20) NOT NULL,
  `sex` varchar(5) NOT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `idcard` varchar(20) NOT NULL,
  `address` varchar(30) NOT NULL,
  `image` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'15449785465','123456','FNC','男',500,'111111111@qq.com','11111111','广东外语外贸大学','p4.jpg'),(2,'15449785466','018144','lzk','男',19,'2222221@qq.com','2222222222','广东外语外贸大学','1OIP-C.png'),(3,'15449785467','018144','lucky','男',500,'2222221@qq.com','33333333','广东外语外贸大学',''),(4,'15449785468','774396','EDG','男',20,'2222221@qq.com','77777777777','广东外语外贸大学','1OIP-C.png'),(5,'17703086004','e10adc3949ba59abbe56e057f20f883e','sdas','男',0,'无','440223200106153215','无','');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_token`
--

DROP TABLE IF EXISTS `user_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_token` (
  `id` int(11) NOT NULL COMMENT '用户主键id',
  `token` varchar(32) NOT NULL COMMENT 'token值(32位字符串)',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `expire_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'token过期时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_token`
--

LOCK TABLES `user_token` WRITE;
/*!40000 ALTER TABLE `user_token` DISABLE KEYS */;
INSERT INTO `user_token` VALUES (5,'f0df8ff1ae078d813020036fe50d7638','2021-12-24 18:07:21','2021-12-26 18:07:21');
/*!40000 ALTER TABLE `user_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'shoppings'
--

--
-- Dumping routines for database 'shoppings'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-24 22:03:13
