DROP SCHEMA IF EXISTS `student-project`;

CREATE SCHEMA `student-project`;

use `student-project`;

SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `second_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `pesel` varchar(11) DEFAULT NULL,
  `date_of_birth` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `zip_code` varchar(45) DEFAULT NULL,
  `address_type` varchar(45) DEFAULT NULL,
  
  
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `student_address`;

CREATE TABLE `student_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  FOREIGN KEY (`student_id`) 
  REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  FOREIGN KEY (`address_id`) 
  REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;
