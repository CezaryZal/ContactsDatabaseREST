CREATE DATABASE  IF NOT EXISTS `web_contacts`;
USE `web_contacts`;

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


INSERT INTO `contact` VALUES 
	(1,'David','Adams','david@gmail.com','569842365'),
	(2,'John','Dick','john@gmail.com','846152365'),
	(3,'Tom','Bonsso','tom@gmail.com','141232518'),
	(4,'Mary','Table','mary@gmail.com','523569523'),
	(5,'Max','Nixon','max@gmail.com','425236528');
