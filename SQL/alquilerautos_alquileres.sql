-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: alquilerautos
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `alquileres`
--

DROP TABLE IF EXISTS `alquileres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alquileres` (
  `id_alquiler` int NOT NULL AUTO_INCREMENT,
  `nombre_cliente` varchar(255) DEFAULT NULL,
  `apellidos_cliente` varchar(255) DEFAULT NULL,
  `edad_cliente` int DEFAULT NULL,
  `telefono_cliente` varchar(15) DEFAULT NULL,
  `correo_cliente` varchar(255) DEFAULT NULL,
  `lugar_recoleccion` varchar(255) DEFAULT NULL,
  `lugar_devolucion` varchar(255) DEFAULT NULL,
  `cantidad_pasajeros` int DEFAULT NULL,
  `cantidad_ninos` int DEFAULT NULL,
  `cantidad_adultos` int DEFAULT NULL,
  `vehiculo_seleccionado` varchar(255) DEFAULT NULL,
  `complementos` varchar(255) DEFAULT NULL,
  `fecha_inicio_recoleccion` date DEFAULT NULL,
  `hora_inicio_recoleccion` time DEFAULT NULL,
  `fecha_fin_devolucion` date DEFAULT NULL,
  `hora_fin_devolucion` time DEFAULT NULL,
  `ruta_ine` varchar(255) DEFAULT NULL,
  `ruta_licencia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_alquiler`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquileres`
--

LOCK TABLES `alquileres` WRITE;
/*!40000 ALTER TABLE `alquileres` DISABLE KEYS */;
INSERT INTO `alquileres` VALUES (11,NULL,NULL,NULL,NULL,NULL,'Istmo','Oaxaca',NULL,NULL,NULL,NULL,NULL,'2024-07-03','12:00:00','2025-05-03','02:21:11',NULL,NULL),(12,NULL,NULL,NULL,NULL,NULL,'Puerto Escondido','Istmo',NULL,NULL,NULL,NULL,NULL,'2024-12-16','12:00:00','2024-12-17','01:00:00',NULL,NULL),(13,NULL,NULL,NULL,NULL,NULL,'Puerto Escondido','Puerto escondido, oax',NULL,NULL,NULL,NULL,NULL,'2024-12-16','12:00:00','2024-12-17','01:00:00',NULL,NULL),(14,'alejandro','cansecos',26,'9513459414','yaii2canseco@gmail.com','Puerto Escondido','Oaxaca',NULL,1,1,'Ford','GPS','2024-12-16','12:00:00','2024-12-17','01:00:00','C:\\Users\\yc\\Desktop\\imagenss\\asientoninos.jpg','C:\\Users\\yc\\Desktop\\imagenss\\silla bebes.jpg'),(15,'yahir alejandro','canseco',23,'9513459414','yaii2canseco@gmail.com','Oaxaca centro','Puerto escondido, oax',NULL,1,1,'Toyota','GPS','2024-12-16','12:00:00','2024-12-17','01:00:00','C:\\Users\\yc\\Desktop\\imagenss\\asientoninos.jpg','C:\\Users\\yc\\Desktop\\imagenss\\toyot.jpg');
/*!40000 ALTER TABLE `alquileres` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-16  6:20:30
