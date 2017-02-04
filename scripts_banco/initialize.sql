CREATE TABLE `sql10156007`.`tipo_moeda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `simbolo` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`),
  UNIQUE KEY `simbolo_UNIQUE` (`simbolo`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1 COMMENT='Armazena os tipos de moedas do mundo';


CREATE TABLE `sql10156007`.`cotacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `tipo_moeda` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tipo_moeda` (`tipo_moeda`),
  CONSTRAINT `fk_tipo_moeda` FOREIGN KEY (`tipo_moeda`) REFERENCES `tipo_moeda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1 COMMENT='Armazena as cotações diárias';