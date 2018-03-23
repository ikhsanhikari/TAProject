/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.5.5-10.1.13-MariaDB : Database - e_learning
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`e_learning` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `e_learning`;

/*Table structure for table `tb_answers` */

DROP TABLE IF EXISTS `tb_answers`;

CREATE TABLE `tb_answers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answers` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

/*Data for the table `tb_answers` */

insert  into `tb_answers`(`id`,`answers`) values (1,'print'),(2,'%'),(3,'!='),(4,'*'),(5,'**'),(6,'rawinput()'),(7,'input()\r\n'),(8,'raw_input()'),(9,'scan()'),(10,'int()\r\n  \r\n'),(11,'benar'),(12,'salah'),(13,'()'),(14,'variabel'),(15,'Sequential\r\n'),(16,'Looping    	\r\n'),(17,'Conditional'),(18,'Prosedure'),(19,'Sentinel'),(20,'Single Conditional'),(21,'Nested Conditional	'),(22,'Multiple Conditional'),(23,'Perkalian'),(24,'for'),(25,'0'),(26,'none'),(27,'\" \"'),(28,'\" \"	');

/*Table structure for table `tb_assignment` */

DROP TABLE IF EXISTS `tb_assignment`;

CREATE TABLE `tb_assignment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course` int(11) DEFAULT NULL,
  `name` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_assignment` */

/*Table structure for table `tb_choice` */

DROP TABLE IF EXISTS `tb_choice`;

CREATE TABLE `tb_choice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `timecreated` varchar(50) DEFAULT NULL,
  `timemodified` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_choice` */

/*Table structure for table `tb_choice_answers` */

DROP TABLE IF EXISTS `tb_choice_answers`;

CREATE TABLE `tb_choice_answers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `choiceid` int(11) DEFAULT NULL,
  `optionid` int(11) DEFAULT NULL,
  `timecreated` varchar(50) DEFAULT NULL,
  `timemodified` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_choice_answers` */

/*Table structure for table `tb_choice_options` */

DROP TABLE IF EXISTS `tb_choice_options`;

CREATE TABLE `tb_choice_options` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `maxanswer` int(11) DEFAULT NULL,
  `timemodified` varchar(50) DEFAULT NULL,
  `timecreated` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_choice_options` */

/*Table structure for table `tb_course` */

DROP TABLE IF EXISTS `tb_course`;

CREATE TABLE `tb_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` int(11) DEFAULT NULL,
  `fullname` varchar(254) DEFAULT NULL,
  `shortname` varchar(255) DEFAULT NULL,
  `idnumber` varchar(100) DEFAULT NULL,
  `format` varchar(21) DEFAULT NULL,
  `startdate` varchar(100) DEFAULT NULL,
  `timecreated` varchar(100) DEFAULT NULL,
  `timemodified` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_course` */

/*Table structure for table `tb_events` */

DROP TABLE IF EXISTS `tb_events`;

CREATE TABLE `tb_events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `courseid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `timestart` varchar(50) DEFAULT NULL,
  `timeduration` varchar(50) DEFAULT NULL,
  `timemodified` varchar(50) DEFAULT NULL,
  `timecreated` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_events` */

/*Table structure for table `tb_feedback` */

DROP TABLE IF EXISTS `tb_feedback`;

CREATE TABLE `tb_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `timeopen` varchar(50) DEFAULT NULL,
  `timeclose` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_feedback` */

/*Table structure for table `tb_file` */

DROP TABLE IF EXISTS `tb_file`;

CREATE TABLE `tb_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file` varchar(255) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_file` */

/*Table structure for table `tb_file_categories` */

DROP TABLE IF EXISTS `tb_file_categories`;

CREATE TABLE `tb_file_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_categories` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_file_categories` */

/*Table structure for table `tb_free_quiz` */

DROP TABLE IF EXISTS `tb_free_quiz`;

CREATE TABLE `tb_free_quiz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `free_quiz` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `timeopen` varchar(255) DEFAULT NULL,
  `timeclose` varchar(255) DEFAULT NULL,
  `timelimit` varchar(255) DEFAULT NULL,
  `timecreated` varchar(255) DEFAULT NULL,
  `timemodified` varchar(255) DEFAULT NULL,
  `id_course` int(11) DEFAULT NULL,
  `id_materi` int(11) DEFAULT NULL,
  `id_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_free_quiz` */

/*Table structure for table `tb_jenissoal` */

DROP TABLE IF EXISTS `tb_jenissoal`;

CREATE TABLE `tb_jenissoal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jenisSoal` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tb_jenissoal` */

insert  into `tb_jenissoal`(`id`,`jenisSoal`) values (1,'Choice'),(2,'Short Answer');

/*Table structure for table `tb_lesson` */

DROP TABLE IF EXISTS `tb_lesson`;

CREATE TABLE `tb_lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course` int(11) DEFAULT NULL,
  `name` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_lesson` */

/*Table structure for table `tb_level` */

DROP TABLE IF EXISTS `tb_level`;

CREATE TABLE `tb_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_level` */

/*Table structure for table `tb_majors` */

DROP TABLE IF EXISTS `tb_majors`;

CREATE TABLE `tb_majors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `majors` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_majors` */

/*Table structure for table `tb_materi_syarat` */

DROP TABLE IF EXISTS `tb_materi_syarat`;

CREATE TABLE `tb_materi_syarat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lessonid` int(11) DEFAULT NULL,
  `quizid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_materi_syarat` */

/*Table structure for table `tb_nilai` */

DROP TABLE IF EXISTS `tb_nilai`;

CREATE TABLE `tb_nilai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `nilai_uts` double DEFAULT NULL,
  `nilai_uas` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_nilai` */

/*Table structure for table `tb_qa` */

DROP TABLE IF EXISTS `tb_qa`;

CREATE TABLE `tb_qa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_quiz` varchar(255) DEFAULT NULL,
  `id_answers` varchar(255) DEFAULT NULL,
  `id_status` varchar(255) DEFAULT NULL,
  `id_level` varchar(255) DEFAULT NULL,
  `id_jenis_soal` varchar(255) DEFAULT NULL,
  `timeopen` varchar(255) DEFAULT NULL,
  `timeclose` varchar(255) DEFAULT NULL,
  `timecreated` varchar(255) DEFAULT NULL,
  `timemodified` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=latin1;

/*Data for the table `tb_qa` */

insert  into `tb_qa`(`id`,`id_quiz`,`id_answers`,`id_status`,`id_level`,`id_jenis_soal`,`timeopen`,`timeclose`,`timecreated`,`timemodified`) values (1,'1','1','1','1','1','2018-03-21 00:00:00','2018-03-21 00:00:00','2018-03-21 00:00:00','2018-03-21 00:00:00'),(2,'2','2','1','1','2','2018-03-21 00:00:00','2018-03-21 00:00:00','2018-03-21 00:00:00','2018-03-21 00:00:00'),(3,'2','3','0','1','2','2018-03-21 00:00:00','2018-03-21 00:00:00','2018-03-21 00:00:00','2018-03-21 00:00:00'),(4,'2','4','0','1','2','2018-03-21 00:00:00','2018-03-21 00:00:00','2018-03-21 00:00:00','2018-03-21 00:00:00'),(5,'2','5','0','1','2','2018-03-21 00:00:00','2018-03-21 00:00:00','2018-03-21 00:00:00','2018-03-21 00:00:00'),(6,'4','6','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(7,'4','7','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(8,'4','8','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(9,'4','9','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:02'),(10,'5','10','1','1','1','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(11,'6','13','1','1','1','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(12,'7','14','1','1','1','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(13,'8','11','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(14,'8','12','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(15,'9','11','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(16,'9','12','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(17,'10','11','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(18,'10','12','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(19,'11','11','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(20,'11','12','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(21,'12','11','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(22,'12','12','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(23,'13','11','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(24,'13','12','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(25,'14','11','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(26,'14','12','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(27,'15','11','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(28,'15','12','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(29,'16','11','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(30,'16','12','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(31,'17','11','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(32,'17','12','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(33,'18','15','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(34,'18','16','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(35,'18','17','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(36,'18','18','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(37,'19','19','1','1','1','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(38,'20','17','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(39,'20','20','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(40,'20','21','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(41,'20','22','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(42,'21','23','1','1','1','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(43,'22','24','1','1','1','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(44,'23','25','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(45,'23','26','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(46,'23','27','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(47,'23','28','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(48,'24','1','1','1','1','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(49,'25','11','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(50,'25','12','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(51,'26','11','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(52,'26','12','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(53,'27','11','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(54,'27','12','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(55,'28','11','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(56,'28','12','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(57,'29','11','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(58,'29','12','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(59,'30','11','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(60,'30','12','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(61,'31','11','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(62,'31','12','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(63,'32','11','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(64,'32','12','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(65,'33','11','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(66,'33','12','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(67,'34','11','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(68,'34','12','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(69,'35','11','0','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(70,'35','12','1','1','2','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(71,'3','2','1','1','1','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(100,'3','2','1','1','1','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00','2018-03-22 00:00:00'),(122,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `tb_question_answers` */

DROP TABLE IF EXISTS `tb_question_answers`;

CREATE TABLE `tb_question_answers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionid` int(11) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_question_answers` */

/*Table structure for table `tb_questions` */

DROP TABLE IF EXISTS `tb_questions`;

CREATE TABLE `tb_questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(10) DEFAULT NULL,
  `modifiedby` varchar(10) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `timecreated` varchar(50) DEFAULT NULL,
  `timemodified` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_questions` */

/*Table structure for table `tb_quiz` */

DROP TABLE IF EXISTS `tb_quiz`;

CREATE TABLE `tb_quiz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `timeopen` int(11) DEFAULT NULL,
  `timeclose` int(11) DEFAULT NULL,
  `timelimit` int(11) DEFAULT NULL,
  `timecreated` int(11) DEFAULT NULL,
  `timemodified` int(11) DEFAULT NULL,
  `id_category` int(11) DEFAULT NULL,
  `id_matery` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=latin1;

/*Data for the table `tb_quiz` */

insert  into `tb_quiz`(`id`,`name`,`timeopen`,`timeclose`,`timelimit`,`timecreated`,`timemodified`,`id_category`,`id_matery`) values (1,'__________ adalah statement yang menginstruksikan computer untuk menampilkan informasi di layer computer',NULL,NULL,NULL,NULL,NULL,2,1),(2,'___________ adalah tipe data di Bahasa pemograman Python yang berisi kumpulan karakter',NULL,NULL,NULL,NULL,NULL,1,1),(3,'_______ adalah operator modulus',NULL,NULL,NULL,NULL,NULL,2,1),(4,'_________ digunakan untuk meminta inputan',NULL,NULL,NULL,NULL,NULL,1,1),(5,'____________ adalah fungsi untuk mengubah nilai dari non-integer menjadi integer',NULL,NULL,NULL,NULL,NULL,1,1),(6,'Ekspresi aritmatika yang dilingkupi ________  dievaluasi terlebih dahulu.',NULL,NULL,NULL,NULL,NULL,1,1),(7,'Sebuah objek ____________ menggambarkan informasi yang tersimpan dalam objek',NULL,NULL,NULL,NULL,NULL,1,1),(8,'Fungsi get_input adalah fungsi untuk meminta inputan dari user',NULL,NULL,NULL,NULL,NULL,1,1),(9,'Ekspresi aritmatika Python yang valid tanpa tanda kurung dievaluasi dari kiri ke kanan',NULL,NULL,NULL,NULL,NULL,1,1),(10,'Berikut ini adalah nama variabel tidak valid: 3g, 87 dan 2h.',NULL,NULL,NULL,NULL,NULL,1,1),(11,'Operator! = Adalah contoh dari operator relasional.',NULL,NULL,NULL,NULL,NULL,1,1),(12,'Nama variabel mengidentifikasi jenis informasi yang tersimpan dalam objek',NULL,NULL,NULL,NULL,NULL,1,1),(13,'Pada Python programmer harus mendeklarasikan tipe objek sebelum menggunakan objek di program.',NULL,NULL,NULL,NULL,NULL,1,1),(14,'Jika tanda kurung bersarang, ekspresi pada pasangan terdalam dievaluasi terlebih dahulu',NULL,NULL,NULL,NULL,NULL,1,1),(15,'Python memperlakukan nama variabel, a1 dan A1, sebagai variabel yang sama',NULL,NULL,NULL,NULL,NULL,1,1),(16,'Karakter backslash disebut escape sequence.',NULL,NULL,NULL,NULL,NULL,1,1),(17,'Operator relasional semuanya memiliki tingkat prioritas yang sama dan mengevaluasi dari kiri ke kanan',NULL,NULL,NULL,NULL,NULL,1,1),(18,'Kata kunci if dan else adalah contoh kata-kata  yang disediakan disebut Python _________',NULL,NULL,NULL,NULL,NULL,1,2),(19,'Pengulangan yang dikontrol  disebut _________ karena jumlah pengulangannya\r\ntidak diketahui sebelum looping mulai dijalankan.\r\n',NULL,NULL,NULL,NULL,NULL,1,3),(20,'Struktur if / elif / else adalah struktur __________',NULL,NULL,NULL,NULL,NULL,1,2),(21,'Simbol pengisian *= akan menampilakn',NULL,NULL,NULL,NULL,NULL,1,1),(22,'Fungsi _______ untuk membuat urutan integer',NULL,NULL,NULL,NULL,NULL,1,1),(23,'Kata kunci ___________ mewakili pernyataan kosong',NULL,NULL,NULL,NULL,NULL,1,1),(24,'Semua program dapat ditulis dalam tiga struktur kontrol, yaitu,___________,__________  dan ____________',NULL,NULL,NULL,NULL,NULL,1,1),(25,'Pseudocode adalah Bahasa pemograman yang sederhana\r\n',NULL,NULL,NULL,NULL,NULL,1,1),(26,'Struktur penyeleksian if akan mengerjakan statement didalam if jika bernilai benar (true)',NULL,NULL,NULL,NULL,NULL,1,2),(27,'If/else adalah strukur penyeleksian yang tidak bercabang',NULL,NULL,NULL,NULL,NULL,1,2),(28,'Error logika yang fatal dikarenakan program yang dieksekusi dan mengeluarkan hasil yang salah',NULL,NULL,NULL,NULL,NULL,2,1),(29,'Struktur pengulangan menampilkan statement di dalam body ketika beberapa kondisi dalam perulangan bernilai benar',NULL,NULL,NULL,NULL,NULL,1,1),(30,'Fungsi float mengubah argument menjadi nilai decimal',NULL,NULL,NULL,NULL,NULL,1,1),(31,'Operator eksponen ** dibaca dari kiri ke kanan',NULL,NULL,NULL,NULL,NULL,1,1),(32,'Fungsi yang memanggil range(1,10) mengembalikan urutan dari 1 sampai 10 ',NULL,NULL,NULL,NULL,NULL,2,3),(33,'Sentinel menggunakan variable counter(penghitung) untuk mengontrol angka setiap kali dieksekusi',NULL,NULL,NULL,NULL,NULL,1,3),(34,'Simbol = adalah untuk menyamakan/kesetaraan',NULL,NULL,NULL,NULL,NULL,1,1),(35,'Python menyediakan dua jenis struktur pengulangan: while, do while and for',NULL,NULL,NULL,NULL,NULL,1,3),(36,'Ada berapa macam operator dalam Bahasa pemograman Pyhton _______',NULL,NULL,NULL,NULL,NULL,2,1),(37,'Operator ‘and’ ditulis dengan _______ ',NULL,NULL,NULL,NULL,NULL,1,1),(38,'Manakah yang lebih dahulu dieksekusi % atau *',NULL,NULL,NULL,NULL,NULL,1,1),(39,'Apakah perbedaan dari continue dan break',NULL,NULL,NULL,NULL,NULL,1,1),(40,'grade = 9\r\nsentinelValue = 0; \r\nif not grade == sentinelValue:\r\nprint \"The next grade is\", grade\r\n\r\nif grade != sentinelValue:\r\nprint \"The next grade is\", grade\r\n\r\nApakah kode pemograman diatas sama?\r\n',NULL,NULL,NULL,NULL,NULL,2,2),(41,'Principal = 1000.0\r\nSupaya variable Pricipal mencetak 1000.00 , bagaimana kah kode pencetakannya\r\n',NULL,NULL,NULL,NULL,NULL,1,1),(42,'Simbol ** digunakan untuk _________',NULL,NULL,NULL,NULL,NULL,1,1),(43,'Penambahan dalam perulangan disebut ________',NULL,NULL,NULL,NULL,NULL,1,3),(44,'Pengurangan dalam perulangan disebut ________',NULL,NULL,NULL,NULL,NULL,1,3),(45,'**= dan %= dapat dideklarasikan menjadi ________ dan __________',NULL,NULL,NULL,NULL,NULL,1,1),(46,'Apa keluaran dari program berikut\r\n\r\nValue1 = 5\r\nValue2 =2.5\r\nprint int ( Value1 )/ int (Value2)\r\n',NULL,NULL,NULL,NULL,NULL,1,1),(47,'Apa keluaran dari program berikut\r\n\r\nGrade = 75\r\nif Grade >75 :\r\n   print “Passed”\r\nelse :\r\n   print “FAILED”\r\nprint “Try Again”\r\n',NULL,NULL,NULL,NULL,NULL,1,2),(48,'Eror kah penulisan variable di bawah ini:\r\n\r\nAnd = 6\r\n',NULL,NULL,NULL,NULL,NULL,1,1),(49,'Eror kah penulisan variable di bawah ini:\r\n\r\n_nn = “hello”\r\n',NULL,NULL,NULL,NULL,NULL,1,1),(50,'Eror kah penulisan variable di bawah ini:\r\n\r\nPrint = 2.30\r\n',NULL,NULL,NULL,NULL,NULL,1,1),(51,'Ada berapa jenis if  ?',NULL,NULL,NULL,NULL,NULL,1,2),(52,'Simbol apakah yang digunakan agar kode pemograman yang memiliki beberapa garis  tidak dieksekusi ',NULL,NULL,NULL,NULL,NULL,1,1),(53,'Apakah yang tercetak ?\r\n\r\nprint “//”\r\n',NULL,NULL,NULL,NULL,NULL,1,1),(54,'< >  termasuk symbol operator __________',NULL,NULL,NULL,NULL,NULL,1,1),(55,'Format specifier untuk tipe data float adalah ____________',NULL,NULL,NULL,NULL,NULL,1,1),(56,'Format specifier untuk tipe data integer adalah ____________',NULL,NULL,NULL,NULL,NULL,1,1),(57,'Format specifier untuk tipe data string adalah ____________',NULL,NULL,NULL,NULL,NULL,1,1),(58,'Format specifier untuk tipe data double adalah ____________',NULL,NULL,NULL,NULL,NULL,1,1),(59,'Format specifier untuk tipe data C adalah ____________',NULL,NULL,NULL,NULL,NULL,1,1),(60,'Format specifier untuk tipe data C adalah ____________',NULL,NULL,NULL,NULL,NULL,1,1),(61,'Apakah keluaran program berikut\r\n\r\nprint “\\””\r\n',NULL,NULL,NULL,NULL,NULL,1,1),(62,'Urutkan operator aritmatika yang paling tinggi tingkatannya ',NULL,NULL,NULL,NULL,NULL,1,1),(63,'raw_input di gunakan untuk ___________',NULL,NULL,NULL,NULL,NULL,1,1),(64,'kutipantiga = \"\"\"this is a long string that is made up of\r\nseveral lines and non-printable characters such as\r\nTAB ( \\t ) and they will show up that way when displayed.\r\nNEWLINEs within the string, whether explicitly given like\r\nthis within the brackets [',NULL,NULL,NULL,NULL,NULL,1,1),(65,'Bagaimana cara mengubah variable yang bertipe data float menjadi integer?',NULL,NULL,NULL,NULL,NULL,1,1),(66,'Bagaimana cara mengubah variable yang bertipe data integer menjadi float?',NULL,NULL,NULL,NULL,NULL,1,1),(67,'Nama = “small”\r\n\r\nBagaimana mengubah variable Nama menjadi huruf capital ? \r\n',NULL,NULL,NULL,NULL,NULL,1,1),(68,'Number = “3.57”\r\n\r\nBagaimana cara membulatkan variable diatas\r\n',NULL,NULL,NULL,NULL,NULL,1,1),(69,'Bagaimana mengambil Panjang dari suatu string',NULL,NULL,NULL,NULL,NULL,1,1),(70,'Bagaimana menggabungkan 2 string',NULL,NULL,NULL,NULL,NULL,1,1),(71,'Pernyataan a = 7 % 4 akan menghasilkan a = ...',NULL,NULL,NULL,NULL,NULL,1,1),(72,'++ dan -- merupakan operator...',NULL,NULL,NULL,NULL,NULL,1,1),(73,'Kode untuk membuat baris baru adalah',NULL,NULL,NULL,NULL,NULL,1,1),(74,'Kode untuk melakukan tab adalah ….',NULL,NULL,NULL,NULL,NULL,1,1),(75,'Tipe data bahasa Python  untuk true false adalah…',NULL,NULL,NULL,NULL,NULL,1,1),(76,'Identifier yang digunakan untuk mengidentifikasi data yang nilainya sudah ditentukan, dan tidak dapat diubah saat program berjalan, disebut identifier…',NULL,NULL,NULL,NULL,NULL,1,1),(77,'Pengertian dari konstanta adalah…',NULL,NULL,NULL,NULL,NULL,1,1),(78,'operator logika yang menyatakan “atau” dalam lambang berikut ini adalah…',NULL,NULL,NULL,NULL,NULL,1,1),(79,'name = \'John Doe\' message = \"John Doe belajar bahasa python di Belajar python\"\r\nprint (\"name[0]: \", name[0])\r\nprint (\"message[1:4]: \", message[1:4])\r\nOutput dari source code diatas…\r\n',NULL,NULL,NULL,NULL,NULL,1,1),(80,'word= ‘Hello Python’\r\nprint (word[5])\r\n',NULL,NULL,NULL,NULL,NULL,1,1),(81,'magic= ‘Try to coding’\r\nprint (magic[12:7],magic[0:2])\r\n',NULL,NULL,NULL,NULL,NULL,1,1),(82,'ceil digunakan untuk ..',NULL,NULL,NULL,NULL,NULL,1,1),(83,'tolower() digunakan untuk…',NULL,NULL,NULL,NULL,NULL,1,1),(84,'isAlpha() digunakan untuk',NULL,NULL,NULL,NULL,NULL,1,1);

/*Table structure for table `tb_resultexercise` */

DROP TABLE IF EXISTS `tb_resultexercise`;

CREATE TABLE `tb_resultexercise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_collerger` int(11) DEFAULT NULL,
  `id_matery` int(11) DEFAULT NULL,
  `id_qa` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `timeopen` varchar(255) DEFAULT NULL,
  `timeclose` varchar(255) DEFAULT NULL,
  `timecreated` varchar(255) DEFAULT NULL,
  `timemodified` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `tb_resultexercise` */

insert  into `tb_resultexercise`(`id`,`id_collerger`,`id_matery`,`id_qa`,`status`,`timeopen`,`timeclose`,`timecreated`,`timemodified`) values (1,1,1,1,1,'1','1','1','1');

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `shortname` varchar(254) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_role` */

/*Table structure for table `tb_session` */

DROP TABLE IF EXISTS `tb_session`;

CREATE TABLE `tb_session` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `timecreated` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `timeout` varchar(255) DEFAULT NULL,
  `firstip` varchar(255) DEFAULT NULL,
  `lastip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tb_session` */

insert  into `tb_session`(`id`,`userid`,`timecreated`,`username`,`timeout`,`firstip`,`lastip`) values (1,1,'2018-03-23 15:19:52','ikhsan',NULL,'10.10.10.142','10.10.10.142'),(2,1,'2018-03-23 15:21:53','ikhsan',NULL,'10.10.10.142','10.10.10.142'),(3,1,'2018-03-23 20:11:19','ikhsan',NULL,'10.10.10.142','10.10.10.142');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone1` varchar(20) DEFAULT NULL,
  `institution` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(120) DEFAULT NULL,
  `firstaccess` varchar(100) DEFAULT NULL,
  `lastaccess` varchar(100) DEFAULT NULL,
  `lastlogin` varchar(100) DEFAULT NULL,
  `currentlogin` varchar(100) DEFAULT NULL,
  `picture` varchar(100) DEFAULT NULL,
  `description` longtext,
  `timecreated` varchar(100) DEFAULT NULL,
  `timemodified` varchar(100) DEFAULT NULL,
  `id_role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`username`,`password`,`firstname`,`lastname`,`email`,`phone1`,`institution`,`department`,`address`,`city`,`firstaccess`,`lastaccess`,`lastlogin`,`currentlogin`,`picture`,`description`,`timecreated`,`timemodified`,`id_role`) values (1,'ikhsan','ikhsan','ikhsan','ikhsan','ikhsan@gmail.com','0993579','98798',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);

/*Table structure for table `tb_weekly_quiz` */

DROP TABLE IF EXISTS `tb_weekly_quiz`;

CREATE TABLE `tb_weekly_quiz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `weekly_quiz` varchar(200) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `timeopen` varchar(255) DEFAULT NULL,
  `timeclose` varchar(255) DEFAULT NULL,
  `timelimit` varchar(255) DEFAULT NULL,
  `timecreated` varchar(255) DEFAULT NULL,
  `timemodified` varchar(255) DEFAULT NULL,
  `id_course` int(11) DEFAULT NULL,
  `id_materi` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_weekly_quiz` */

/*Table structure for table `user_tbl` */

DROP TABLE IF EXISTS `user_tbl`;

CREATE TABLE `user_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `jenis` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_tbl` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
