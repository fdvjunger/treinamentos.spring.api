CREATE TABLE `ponto_inteligente`.`tbl_empresa` (
  `id` BIGINT(20) NOT NULL,
  `razao_social` VARCHAR(60) NOT NULL,
  `cnpj` VARCHAR(18) NOT NULL,
  `data_atualizacao` DATETIME NOT NULL,
  `data_criacao` DATETIME NOT NULL,
  PRIMARY KEY (`id`))



