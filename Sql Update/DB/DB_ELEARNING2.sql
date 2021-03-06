/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.6.16 : Database - db_elearning
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_elearning` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_elearning`;

/*Table structure for table `tb_answers` */

DROP TABLE IF EXISTS `tb_answers`;

CREATE TABLE `tb_answers` (
  `idanswer` int(10) NOT NULL,
  `answers` text,
  PRIMARY KEY (`idanswer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_answers` */

insert  into `tb_answers`(`idanswer`,`answers`) values (1,'print'),(2,'%'),(3,'!='),(4,'*'),(5,'**');

/*Table structure for table `tb_category` */

DROP TABLE IF EXISTS `tb_category`;

CREATE TABLE `tb_category` (
  `idcategory` int(3) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idcategory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_category` */

insert  into `tb_category`(`idcategory`,`category`) values (1,'QUIZ'),(2,'EXERCISE');

/*Table structure for table `tb_historisquiz` */

DROP TABLE IF EXISTS `tb_historisquiz`;

CREATE TABLE `tb_historisquiz` (
  `idhistory` int(10) NOT NULL,
  `idcolleger` int(10) NOT NULL,
  `idmatery` int(10) NOT NULL,
  `idQA` int(10) NOT NULL,
  `status` int(10) DEFAULT NULL,
  `timeupdate` date DEFAULT NULL,
  PRIMARY KEY (`idhistory`,`idcolleger`,`idmatery`,`idQA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_historisquiz` */

/*Table structure for table `tb_knowledge` */

DROP TABLE IF EXISTS `tb_knowledge`;

CREATE TABLE `tb_knowledge` (
  `idknowledge` int(3) NOT NULL,
  `knowledge` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idknowledge`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_knowledge` */

insert  into `tb_knowledge`(`idknowledge`,`knowledge`) values (1,'good'),(2,'fair'),(3,'poor');

/*Table structure for table `tb_level` */

DROP TABLE IF EXISTS `tb_level`;

CREATE TABLE `tb_level` (
  `idlevel` int(3) NOT NULL,
  `level` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idlevel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_level` */

insert  into `tb_level`(`idlevel`,`level`) values (1,'low'),(2,'middle'),(3,'high');

/*Table structure for table `tb_matery` */

DROP TABLE IF EXISTS `tb_matery`;

CREATE TABLE `tb_matery` (
  `idmatery` int(10) NOT NULL,
  `matery` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idmatery`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_matery` */

insert  into `tb_matery`(`idmatery`,`matery`) values (1,'Sequential'),(2,'Conditional'),(3,'Looping');

/*Table structure for table `tb_mayors` */

DROP TABLE IF EXISTS `tb_mayors`;

CREATE TABLE `tb_mayors` (
  `idmayor` int(3) NOT NULL,
  `mayor` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idmayor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_mayors` */

insert  into `tb_mayors`(`idmayor`,`mayor`) values (1,'MANAJEMEN INFORMATIKA'),(2,'TEKNIK INFORMASI');

/*Table structure for table `tb_model` */

DROP TABLE IF EXISTS `tb_model`;

CREATE TABLE `tb_model` (
  `idModel` int(10) NOT NULL,
  `idgoodlearner` int(10) NOT NULL,
  `iduser` int(10) NOT NULL,
  `idmatery` int(3) NOT NULL,
  `idknowledgegoodlearner` int(3) NOT NULL,
  `idknowledgeuser` int(3) NOT NULL,
  `timeupdate` date DEFAULT NULL,
  PRIMARY KEY (`idModel`,`idgoodlearner`,`iduser`,`idmatery`,`idknowledgegoodlearner`,`idknowledgeuser`),
  KEY `FK_tb_model` (`idgoodlearner`),
  KEY `FK_tb_model_user` (`idknowledgegoodlearner`),
  KEY `FK_tb_model_knowuser` (`idknowledgeuser`),
  KEY `FK_tb_model_matery` (`idmatery`),
  CONSTRAINT `FK_tb_model` FOREIGN KEY (`idgoodlearner`) REFERENCES `tb_user` (`iduser`),
  CONSTRAINT `FK_tb_model_know` FOREIGN KEY (`idknowledgeuser`) REFERENCES `tb_knowledge` (`idknowledge`),
  CONSTRAINT `FK_tb_model_knowuser` FOREIGN KEY (`idknowledgeuser`) REFERENCES `tb_knowledge` (`idknowledge`),
  CONSTRAINT `FK_tb_model_matery` FOREIGN KEY (`idmatery`) REFERENCES `tb_matery` (`idmatery`),
  CONSTRAINT `FK_tb_model_user` FOREIGN KEY (`idknowledgegoodlearner`) REFERENCES `tb_user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_model` */

/*Table structure for table `tb_qa` */

DROP TABLE IF EXISTS `tb_qa`;

CREATE TABLE `tb_qa` (
  `idQA` int(10) NOT NULL,
  `idquiz` int(10) NOT NULL,
  `idanswer` int(10) NOT NULL,
  `status` int(2) DEFAULT NULL,
  `idlevel` int(3) NOT NULL,
  `timeopen` date DEFAULT NULL,
  `timeclose` date DEFAULT NULL,
  `timecreated` date DEFAULT NULL,
  `timemodified` date DEFAULT NULL,
  PRIMARY KEY (`idQA`,`idquiz`,`idanswer`,`idlevel`),
  KEY `FK_tb_qa_quiz` (`idquiz`),
  KEY `FK_tb_qa_answer123` (`idanswer`),
  KEY `FK_tb_qa_level` (`idlevel`),
  CONSTRAINT `FK_tb_qa_level` FOREIGN KEY (`idlevel`) REFERENCES `tb_level` (`idlevel`),
  CONSTRAINT `FK_tb_qa_answer` FOREIGN KEY (`idanswer`) REFERENCES `tb_answers` (`idanswer`),
  CONSTRAINT `FK_tb_qa_quiz` FOREIGN KEY (`idquiz`) REFERENCES `tb_quiz` (`idquiz`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_qa` */

insert  into `tb_qa`(`idQA`,`idquiz`,`idanswer`,`status`,`idlevel`,`timeopen`,`timeclose`,`timecreated`,`timemodified`) values (1,1,1,1,1,'2018-03-21','2018-03-21','2018-03-21','2018-03-21'),(2,2,2,1,1,'2018-03-21','2018-03-21','2018-03-21','2018-03-21'),(3,2,3,0,1,'2018-03-21','2018-03-21','2018-03-21','2018-03-21'),(4,2,4,0,1,'2018-03-21','2018-03-21','2018-03-21','2018-03-21'),(5,2,5,0,1,'2018-03-21','2018-03-21','2018-03-21','2018-03-21');

/*Table structure for table `tb_quiz` */

DROP TABLE IF EXISTS `tb_quiz`;

CREATE TABLE `tb_quiz` (
  `idquiz` int(10) NOT NULL,
  `quiz` text,
  `idmatery` int(3) NOT NULL,
  `idcategory` int(3) NOT NULL,
  PRIMARY KEY (`idquiz`,`idmatery`,`idcategory`),
  KEY `FK_tb_quiz_matery` (`idmatery`),
  KEY `FK_tb_quiz_category` (`idcategory`),
  CONSTRAINT `FK_tb_quiz_category` FOREIGN KEY (`idcategory`) REFERENCES `tb_category` (`idcategory`),
  CONSTRAINT `FK_tb_quiz_matery` FOREIGN KEY (`idmatery`) REFERENCES `tb_matery` (`idmatery`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_quiz` */

insert  into `tb_quiz`(`idquiz`,`quiz`,`idmatery`,`idcategory`) values (1,'__________ adalah statement yang menginstruksikan computer untuk menampilkan informasi di layer computer',1,2),(2,'___________ adalah tipe data di Bahasa pemograman Python yang berisi kumpulan karakter',1,1),(3,'_______ adalah operator modulus',1,1),(4,'_________ digunakan untuk meminta inputan',1,1),(5,'____________ adalah fungsi untuk mengubah nilai dari non-integer menjadi integer',1,1),(6,'Ekspresi aritmatika yang dilingkupi ________  dievaluasi terlebih dahulu.',1,1),(7,'Sebuah objek ____________ menggambarkan informasi yang tersimpan dalam objek',1,1),(8,'Fungsi get_input adalah fungsi untuk meminta inputan dari user',1,1),(9,'Ekspresi aritmatika Python yang valid tanpa tanda kurung dievaluasi dari kiri ke kanan',1,1),(10,'Berikut ini adalah nama variabel tidak valid: 3g, 87 dan 2h.',1,1),(11,'Operator! = Adalah contoh dari operator relasional.',1,1),(12,'Nama variabel mengidentifikasi jenis informasi yang tersimpan dalam objek',1,1),(13,'Pada Python programmer harus mendeklarasikan tipe objek sebelum menggunakan objek di program.',1,1),(14,'Jika tanda kurung bersarang, ekspresi pada pasangan terdalam dievaluasi terlebih dahulu',1,1),(15,'Python memperlakukan nama variabel, a1 dan A1, sebagai variabel yang sama',1,1),(16,'Karakter backslash disebut escape sequence.',1,1),(17,'Operator relasional semuanya memiliki tingkat prioritas yang sama dan mengevaluasi dari kiri ke kanan',1,1),(18,'Kata kunci if dan else adalah contoh kata-kata  yang disediakan disebut Python _________',2,1),(19,'Pengulangan yang dikontrol Sentinel disebut _________ karena jumlah pengulangannya\r\ntidak diketahui sebelum looping mulai dijalankan.\r\n',3,1),(20,'Struktur if / elif / else adalah struktur __________',2,1),(21,'Simbol pengisian *= akan menampilakn',1,1),(22,'Fungsi _______ untuk membuat urutan integer',1,1),(23,'Kata kunci ___________ mewakili pernyataan kosong',1,1),(24,'Semua program dapat ditulis dalam tiga struktur kontrol, yaitu,___________,__________  dan ____________',1,1),(25,'Pseudocode adalah Bahasa pemograman yang sederhana\r\n',1,1),(26,'Struktur penyeleksian if akan mengerjakan statement didalam if jika bernilai benar (true)',2,1),(27,'If/else adalah strukur penyeleksian yang tidak bercabang',2,1),(28,'Error logika yang fatal dikarenakan program yang dieksekusi dan mengeluarkan hasil yang salah',1,2),(29,'Struktur pengulangan menampilkan statement di dalam body ketika beberapa kondisi dalam perulangan bernilai benar',1,1),(30,'Fungsi float mengubah argument menjadi nilai decimal',1,1),(31,'Operator eksponen ** dibaca dari kiri ke kanan',1,1),(32,'Fungsi yang memanggil range(1,10) mengembalikan urutan dari 1 sampai 10 ',3,2),(33,'Sentinel menggunakan variable counter(penghitung) untuk mengontrol angka setiap kali dieksekusi',3,1),(34,'Simbol = adalah untuk menyamakan/kesetaraan',1,1),(35,'Python menyediakan dua jenis struktur pengulangan: while, do while and for',3,1),(36,'Ada berapa macam operator dalam Bahasa pemograman Pyhton _______',1,2),(37,'Operator ‘and’ ditulis dengan _______ ',1,1),(38,'Manakah yang lebih dahulu dieksekusi % atau *',1,1),(39,'Apakah perbedaan dari continue dan break',1,1),(40,'grade = 9\r\nsentinelValue = 0; \r\nif not grade == sentinelValue:\r\nprint \"The next grade is\", grade\r\n\r\nif grade != sentinelValue:\r\nprint \"The next grade is\", grade\r\n\r\nApakah kode pemograman diatas sama?\r\n',2,2),(41,'Principal = 1000.0\r\nSupaya variable Pricipal mencetak 1000.00 , bagaimana kah kode pencetakannya\r\n',1,1);

/*Table structure for table `tb_resultexercise` */

DROP TABLE IF EXISTS `tb_resultexercise`;

CREATE TABLE `tb_resultexercise` (
  `idresultexe` int(10) NOT NULL,
  `idcolleger` int(10) NOT NULL,
  `idmatery` int(10) NOT NULL,
  `idQA` int(10) NOT NULL,
  `status` int(2) DEFAULT NULL,
  `timeopen` date DEFAULT NULL,
  `timeclose` date DEFAULT NULL,
  `timecreated` date DEFAULT NULL,
  `timemodified` date DEFAULT NULL,
  PRIMARY KEY (`idresultexe`,`idcolleger`,`idmatery`,`idQA`),
  KEY `FK_tb_resultexercise_user` (`idcolleger`),
  KEY `FK_tb_resultexercise_matery` (`idmatery`),
  KEY `FK_tb_resultexercise_qa` (`idQA`),
  CONSTRAINT `FK_tb_resultexercise_matery` FOREIGN KEY (`idmatery`) REFERENCES `tb_matery` (`idmatery`),
  CONSTRAINT `FK_tb_resultexercise_qa` FOREIGN KEY (`idQA`) REFERENCES `tb_qa` (`idQA`),
  CONSTRAINT `FK_tb_resultexercise_user` FOREIGN KEY (`idcolleger`) REFERENCES `tb_user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_resultexercise` */

insert  into `tb_resultexercise`(`idresultexe`,`idcolleger`,`idmatery`,`idQA`,`status`,`timeopen`,`timeclose`,`timecreated`,`timemodified`) values (1,1,1,1,0,'2018-03-01','2018-03-01','2018-02-01','2018-03-01');

/*Table structure for table `tb_resultquiz` */

DROP TABLE IF EXISTS `tb_resultquiz`;

CREATE TABLE `tb_resultquiz` (
  `idresultquiz` int(10) NOT NULL,
  `idcolleger` int(10) NOT NULL,
  `idmatery` int(3) NOT NULL,
  `score` double DEFAULT NULL,
  `idknowledge` int(3) NOT NULL,
  PRIMARY KEY (`idresultquiz`,`idcolleger`,`idmatery`,`idknowledge`),
  KEY `FK_tb_resultquiz` (`idknowledge`),
  KEY `FK_matery` (`idmatery`),
  KEY `FK_tb_resultquiz_user` (`idcolleger`),
  CONSTRAINT `FK_matery` FOREIGN KEY (`idmatery`) REFERENCES `tb_matery` (`idmatery`),
  CONSTRAINT `FK_tb_resultquiz` FOREIGN KEY (`idknowledge`) REFERENCES `tb_knowledge` (`idknowledge`),
  CONSTRAINT `FK_tb_resultquiz_user` FOREIGN KEY (`idcolleger`) REFERENCES `tb_user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_resultquiz` */

insert  into `tb_resultquiz`(`idresultquiz`,`idcolleger`,`idmatery`,`score`,`idknowledge`) values (1,1,1,80,1);

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `idrole` int(3) NOT NULL,
  `role` text,
  PRIMARY KEY (`idrole`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_role` */

insert  into `tb_role`(`idrole`,`role`) values (1,'Admin\r\n'),(2,'Lecturer\r\n'),(3,'Colleger\r\n');

/*Table structure for table `tb_skill` */

DROP TABLE IF EXISTS `tb_skill`;

CREATE TABLE `tb_skill` (
  `idcolleger` int(11) NOT NULL,
  `skill` double DEFAULT NULL,
  PRIMARY KEY (`idcolleger`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_skill` */

insert  into `tb_skill`(`idcolleger`,`skill`) values (1,90);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `iduser` int(5) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `born` varchar(70) DEFAULT NULL,
  `phone` int(13) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `idmayor` int(3) NOT NULL,
  `idrole` int(3) NOT NULL,
  `timeopen` date DEFAULT NULL,
  `timeclose` date DEFAULT NULL,
  PRIMARY KEY (`iduser`,`idmayor`,`idrole`),
  KEY `NewIndex1` (`idmayor`,`idrole`),
  KEY `FK_tb_user_role` (`idrole`),
  CONSTRAINT `FK_tb_user_mayor` FOREIGN KEY (`idmayor`) REFERENCES `tb_mayors` (`idmayor`),
  CONSTRAINT `FK_tb_user_role` FOREIGN KEY (`idrole`) REFERENCES `tb_role` (`idrole`),
  CONSTRAINT `FK_tb_user_skill` FOREIGN KEY (`iduser`) REFERENCES `tb_skill` (`idcolleger`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_user` */

insert  into `tb_user`(`iduser`,`name`,`username`,`password`,`born`,`phone`,`email`,`idmayor`,`idrole`,`timeopen`,`timeclose`) values (1,'Dyah Nuraeni','dyah','12345678','Cirebon,09 Oktober 1997',2147483647,'nuraeni_dyah@ymail.com',1,3,'2018-03-20','2018-03-21');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
