CREATE TABLE `sql10156007`.`tipo_moeda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `simbolo` VARCHAR(5) NULL,
  PRIMARY KEY (`id`))
COMMENT = 'Armazena os tipos de moedas do mundo';

CREATE TABLE `sql10156007`.`cotacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `valor` DECIMAL NULL,
  PRIMARY KEY (`id`))
  COMMENT = 'Armazena as cotações diárias';
