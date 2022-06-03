CREATE DATABASE `monthly_expense`;

use `monthly_expense`;

CREATE TABLE tb_user (
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`email`));


CREATE TABLE `expense` (
  `expense_id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NOT NULL,
  `expense_name` VARCHAR(50) NOT NULL,
  `expense_amount` INT NOT NULL,
  `creation_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `category_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`expense_id`),
  CONSTRAINT `fk_expense_email` FOREIGN KEY (`email`) REFERENCES `tb_user` (`email`));


CREATE TABLE `saving` (
  `saving_id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NOT NULL,
  `saving_name` VARCHAR(50) NOT NULL,
  `saving_amount` INT NOT NULL,
  `creation_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`saving_id`),
  CONSTRAINT `fk_saving_email` FOREIGN KEY (`email`) REFERENCES `tb_user` (`email`));


CREATE TABLE `category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`category_id`));


INSERT INTO `tb_user` VALUES ('John', 'pass1234', 'john@xyz.com');
INSERT INTO `tb_user` VALUES ('Harry', 'harry1234', 'harry@xyz.com');
INSERT INTO `tb_user` VALUES ('Thomas', 'thomas1234', 'thomas@xyz.com');


INSERT INTO `category` (`category_name`) VALUES ('travel');
INSERT INTO `category` (`category_name`) VALUES ('food');
INSERT INTO `category` (`category_name`) VALUES ('education');
INSERT INTO `category` (`category_name`) VALUES ('grocery');
INSERT INTO `category` (`category_name`) VALUES ('rent');


INSERT INTO `expense` (`email`, `expense_name`, `expense_amount`, `category_name`, `creation_date`) VALUES ('john@xyz.com', 'Fare of home to university', '40', 'travel', '2021-01-15');
INSERT INTO `expense` (`email`, `expense_name`, `expense_amount`, `category_name`, `creation_date`) VALUES ('harry@xyz.com', 'Dinner at hotel', '50', 'food', '2021-02-15');
INSERT INTO `expense` (`email`, `expense_name`, `expense_amount`, `category_name`, `creation_date`) VALUES ('thomas@xyz.com', 'Purchase books', '100', 'education', '2021-07-25');
INSERT INTO `expense` (`email`, `expense_name`, `expense_amount`, `category_name`, `creation_date`) VALUES ('thomas@xyz.com', 'Apartment Rent', '1000', 'rent', '2021-10-22');
INSERT INTO `expense` (`email`, `expense_name`, `expense_amount`, `category_name`, `creation_date`) VALUES ('john@xyz.com', 'Dinner', '100', 'food', '2020-07-05');


INSERT INTO `saving` (`email`, `saving_name`, `saving_amount`, `creation_date`) VALUES ('john@xyz.com', 'Extra work', '100', '2021-01-25');
INSERT INTO `saving` (`email`, `saving_name`, `saving_amount`, `creation_date`) VALUES ('thomas@xyz.com', 'Internship payment', '500', '2021-01-05');
INSERT INTO `saving` (`email`, `saving_name`, `saving_amount`, `creation_date`) VALUES ('harry@xyz.com', 'Work bonus', '400', '2021-06-12');
INSERT INTO `saving` (`email`, `saving_name`, `saving_amount`, `creation_date`) VALUES ('harry@xyz.com', 'Internship', '1000', '2021-03-30');
INSERT INTO `saving` (`email`, `saving_name`, `saving_amount`, `creation_date`) VALUES ('thomas@xyz.com', 'Online work', '250', '2020-12-25');

