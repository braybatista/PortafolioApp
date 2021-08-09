use `portfolio`;

CREATE TABLE if not exists `portfolio`.`portafolio` 
( `id` INT NOT NULL AUTO_INCREMENT , 
`name` VARCHAR(75) NOT NULL , 
`detail` VARCHAR NOT NULL AUTO_INCREMENT , 
PRIMARY KEY (`id`, `detail`)) ENGINE = InnoDB;
