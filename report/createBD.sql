SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `habitat` ;
CREATE SCHEMA IF NOT EXISTS `habitat` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `habitat` ;

-- -----------------------------------------------------
-- Table `habitat`.`Funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`Funcionario` ;

CREATE TABLE IF NOT EXISTS `habitat`.`Funcionario` (
  `idFunc` INT NOT NULL AUTO_INCREMENT,
  `tipoFunc` ENUM('ADMIN','FAM','FUNDOS','OBRAS') NOT NULL,
  `nome` VARCHAR(75) NOT NULL,
  `nif` INT NULL,
  `morada` VARCHAR(65) NULL,
  `telefone` VARCHAR(20) NULL,
  `telemovel` VARCHAR(20) NULL,
  `codigoPostal` VARCHAR(10) NULL,
  `dataNascimento` DATE NULL,
  `localidade` VARCHAR(45) NULL,
  `password` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFunc`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`Familia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`Familia` ;

CREATE TABLE IF NOT EXISTS `habitat`.`Familia` (
  `idFam` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `morada` VARCHAR(45) NULL,
  `telefone` INT NULL,
  `idFunc` INT NOT NULL,
  `nif` INT NULL,
  `dataNascimento` DATE NULL,
  `apelido` VARCHAR(45) NULL,
  `dataCriaFam` DATE NULL,
  PRIMARY KEY (`idFam`),
  INDEX `fk_Familia_Funcionario1_idx` (`idFunc` ASC),
  CONSTRAINT `fk_Familia_Funcionario1`
    FOREIGN KEY (`idFunc`)
    REFERENCES `habitat`.`Funcionario` (`idFunc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`Candidatura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`Candidatura` ;

CREATE TABLE IF NOT EXISTS `habitat`.`Candidatura` (
  `idCand` INT NOT NULL AUTO_INCREMENT,
  `idFam` INT NOT NULL,
  `dataCand` DATE NULL,
  `rendimento` DECIMAL(10,2) NULL,
  `estado` ENUM('APROVADO','NAOAPROVADO','NAOACEITE','PENDENTE') NULL DEFAULT 'PENDENTE',
  PRIMARY KEY (`idCand`),
  INDEX `fk_Candidatura_Familia1_idx` (`idFam` ASC),
  CONSTRAINT `fk_Candidatura_Familia1`
    FOREIGN KEY (`idFam`)
    REFERENCES `habitat`.`Familia` (`idFam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`Projeto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`Projeto` ;

CREATE TABLE IF NOT EXISTS `habitat`.`Projeto` (
  `idProj` INT NOT NULL AUTO_INCREMENT,
  `orcamento` INT NULL,
  `prazo` DATE NULL,
  `dataInicio` DATE NULL,
  `dataFim` DATE NULL,
  `idFunc` INT NOT NULL,
  `idCand` INT NOT NULL,
  `designacao` VARCHAR(75) NULL,
  `descricao` VARCHAR(200) NULL,
  `dataCriaProj` DATE NULL,
  PRIMARY KEY (`idProj`),
  INDEX `fk_Projeto_Funcionario1_idx` (`idFunc` ASC),
  INDEX `fk_Projeto_Candidatura1_idx` (`idCand` ASC),
  CONSTRAINT `fk_Projeto_Funcionario1`
    FOREIGN KEY (`idFunc`)
    REFERENCES `habitat`.`Funcionario` (`idFunc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projeto_Candidatura1`
    FOREIGN KEY (`idCand`)
    REFERENCES `habitat`.`Candidatura` (`idCand`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`Tarefa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`Tarefa` ;

CREATE TABLE IF NOT EXISTS `habitat`.`Tarefa` (
  `idTar` INT NOT NULL AUTO_INCREMENT,
  `designacao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTar`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`TarefaProjeto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`TarefaProjeto` ;

CREATE TABLE IF NOT EXISTS `habitat`.`TarefaProjeto` (
  `idProj` INT NOT NULL,
  `idTar` INT NOT NULL,
  `dataPlInicio` DATETIME NULL,
  `dataPlFim` DATETIME NULL,
  `dataExInicio` DATETIME NULL,
  `dataExFim` DATETIME NULL,
  PRIMARY KEY (`idProj`, `idTar`),
  INDEX `fk_Projeto_has_Tarefa_Tarefa1_idx` (`idTar` ASC),
  INDEX `fk_Projeto_has_Tarefa_Projeto_idx` (`idProj` ASC),
  CONSTRAINT `fk_Projeto_has_Tarefa_Projeto`
    FOREIGN KEY (`idProj`)
    REFERENCES `habitat`.`Projeto` (`idProj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projeto_has_Tarefa_Tarefa1`
    FOREIGN KEY (`idTar`)
    REFERENCES `habitat`.`Tarefa` (`idTar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`TipoDonativo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`TipoDonativo` ;

CREATE TABLE IF NOT EXISTS `habitat`.`TipoDonativo` (
  `idTipoDon` INT NOT NULL AUTO_INCREMENT,
  `designacao` VARCHAR(50) NOT NULL,
  `unidade` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idTipoDon`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`Evento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`Evento` ;

CREATE TABLE IF NOT EXISTS `habitat`.`Evento` (
  `idEv` INT NOT NULL AUTO_INCREMENT,
  `designacao` VARCHAR(100) NOT NULL,
  `data` DATE NULL,
  `idFunc` INT NOT NULL,
  `descricao` VARCHAR(200) NULL,
  PRIMARY KEY (`idEv`),
  INDEX `fk_Evento_Funcionario1_idx` (`idFunc` ASC),
  CONSTRAINT `fk_Evento_Funcionario1`
    FOREIGN KEY (`idFunc`)
    REFERENCES `habitat`.`Funcionario` (`idFunc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`Individuo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`Individuo` ;

CREATE TABLE IF NOT EXISTS `habitat`.`Individuo` (
  `idIndiv` INT NOT NULL AUTO_INCREMENT,
  `idFunc` INT NOT NULL,
  `nome` VARCHAR(75) NOT NULL,
  `dataNascimento` DATE NULL,
  `profissao` VARCHAR(45) NULL,
  `morada` VARCHAR(75) NULL,
  `codigoPostal` VARCHAR(10) NULL,
  `localidade` VARCHAR(60) NULL,
  `telefone` VARCHAR(20) NULL,
  `telemovel` VARCHAR(20) NULL,
  `email` VARCHAR(45) NULL,
  `habilitacoes` VARCHAR(45) NULL,
  `conhecimentosLing` VARCHAR(45) NULL,
  `formacaoComp` VARCHAR(45) NULL,
  `experienciaVolunt` VARCHAR(75) NULL,
  `conhecmentosConstr` VARCHAR(75) NULL,
  `trabalharJuntoVolunt` TINYINT(1) NULL,
  `disponibilidade` VARCHAR(150) NULL,
  `comoConheceu` VARCHAR(75) NULL,
  `receberInfo` TINYINT(1) NULL,
  `isParceiro` TINYINT(1) NOT NULL DEFAULT FALSE,
  `nif` INT NULL,
  `isColectivo` TINYINT(1) NOT NULL DEFAULT FALSE,
  `isDoador` TINYINT(1) NOT NULL DEFAULT FALSE,
  `isVoluntario` TINYINT(1) NOT NULL DEFAULT FALSE,
  `nacionalidadeIndev` VARCHAR(45) NULL,
  `dataCriaIndiv` DATE NULL,
  PRIMARY KEY (`idIndiv`),
  INDEX `fk_Voluntario_Funcionario1_idx` (`idFunc` ASC),
  CONSTRAINT `fk_Voluntario_Funcionario1`
    FOREIGN KEY (`idFunc`)
    REFERENCES `habitat`.`Funcionario` (`idFunc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`Donativo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`Donativo` ;

CREATE TABLE IF NOT EXISTS `habitat`.`Donativo` (
  `idDon` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NULL,
  `quantInicial` INT NOT NULL,
  `quantAtual` INT NOT NULL,
  `idTipoDon` INT NOT NULL,
  `dataDon` DATE NULL,
  `idFunc` INT NOT NULL,
  `idEv` INT NOT NULL,
  `idIndiv` INT NOT NULL,
  PRIMARY KEY (`idDon`),
  INDEX `fk_Donativo_TipoDonativo1_idx` (`idTipoDon` ASC),
  INDEX `fk_Donativo_Evento1_idx` (`idEv` ASC),
  INDEX `fk_Donativo_Funcionario1_idx` (`idFunc` ASC),
  INDEX `fk_Donativo_Individuo1_idx` (`idIndiv` ASC),
  CONSTRAINT `fk_Donativo_TipoDonativo1`
    FOREIGN KEY (`idTipoDon`)
    REFERENCES `habitat`.`TipoDonativo` (`idTipoDon`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Donativo_Evento1`
    FOREIGN KEY (`idEv`)
    REFERENCES `habitat`.`Evento` (`idEv`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Donativo_Funcionario1`
    FOREIGN KEY (`idFunc`)
    REFERENCES `habitat`.`Funcionario` (`idFunc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Donativo_Individuo1`
    FOREIGN KEY (`idIndiv`)
    REFERENCES `habitat`.`Individuo` (`idIndiv`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`Equipa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`Equipa` ;

CREATE TABLE IF NOT EXISTS `habitat`.`Equipa` (
  `idEq` INT NOT NULL AUTO_INCREMENT,
  `nacionalidadeEq` VARCHAR(45) NULL,
  `designacao` VARCHAR(100) NOT NULL,
  `dataCriaEq` DATETIME NOT NULL,
  `idFunc` INT NOT NULL,
  PRIMARY KEY (`idEq`),
  INDEX `fk_Equipa_Funcionario1_idx` (`idFunc` ASC),
  CONSTRAINT `fk_Equipa_Funcionario1`
    FOREIGN KEY (`idFunc`)
    REFERENCES `habitat`.`Funcionario` (`idFunc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`EquipaTarefaProjeto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`EquipaTarefaProjeto` ;

CREATE TABLE IF NOT EXISTS `habitat`.`EquipaTarefaProjeto` (
  `idEq` INT NOT NULL,
  `dataTrabalho` DATE NOT NULL,
  `duracao` INT NOT NULL,
  `idProj` INT NOT NULL,
  `idTar` INT NOT NULL,
  PRIMARY KEY (`idEq`, `idProj`, `idTar`),
  INDEX `fk_Equipa_has_Projeto_Equipa1_idx` (`idEq` ASC),
  INDEX `fk_EquipaProjeto_TarefaProjeto1_idx` (`idProj` ASC, `idTar` ASC),
  CONSTRAINT `fk_Equipa_has_Projeto_Equipa1`
    FOREIGN KEY (`idEq`)
    REFERENCES `habitat`.`Equipa` (`idEq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EquipaProjeto_TarefaProjeto1`
    FOREIGN KEY (`idProj` , `idTar`)
    REFERENCES `habitat`.`TarefaProjeto` (`idProj` , `idTar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`IndividuoTarefaProjeto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`IndividuoTarefaProjeto` ;

CREATE TABLE IF NOT EXISTS `habitat`.`IndividuoTarefaProjeto` (
  `idIndiv` INT NOT NULL,
  `dataTrabalho` DATE NOT NULL,
  `duracao` INT NOT NULL,
  `idProj` INT NOT NULL,
  `idTar` INT NOT NULL,
  PRIMARY KEY (`idIndiv`, `idProj`, `idTar`),
  INDEX `fk_Voluntario_has_Projeto_Voluntario1_idx` (`idIndiv` ASC),
  INDEX `fk_VoluntarioProjeto_TarefaProjeto1_idx` (`idProj` ASC, `idTar` ASC),
  CONSTRAINT `fk_Voluntario_has_Projeto_Voluntario1`
    FOREIGN KEY (`idIndiv`)
    REFERENCES `habitat`.`Individuo` (`idIndiv`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_VoluntarioProjeto_TarefaProjeto1`
    FOREIGN KEY (`idProj` , `idTar`)
    REFERENCES `habitat`.`TarefaProjeto` (`idProj` , `idTar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`EquipaIndividuo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`EquipaIndividuo` ;

CREATE TABLE IF NOT EXISTS `habitat`.`EquipaIndividuo` (
  `idIndiv` INT NOT NULL,
  `idEq` INT NOT NULL,
  PRIMARY KEY (`idIndiv`, `idEq`),
  INDEX `fk_Voluntario_has_Equipa_Equipa1_idx` (`idEq` ASC),
  INDEX `fk_Voluntario_has_Equipa_Voluntario1_idx` (`idIndiv` ASC),
  CONSTRAINT `fk_Voluntario_has_Equipa_Voluntario1`
    FOREIGN KEY (`idIndiv`)
    REFERENCES `habitat`.`Individuo` (`idIndiv`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Voluntario_has_Equipa_Equipa1`
    FOREIGN KEY (`idEq`)
    REFERENCES `habitat`.`Equipa` (`idEq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`Actividade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`Actividade` ;

CREATE TABLE IF NOT EXISTS `habitat`.`Actividade` (
  `idAtividade` INT NOT NULL AUTO_INCREMENT,
  `designacao` VARCHAR(55) NULL,
  PRIMARY KEY (`idAtividade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`IndividuoActividade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`IndividuoActividade` ;

CREATE TABLE IF NOT EXISTS `habitat`.`IndividuoActividade` (
  `idIndiv` INT NOT NULL,
  `idAtividade` INT NOT NULL,
  PRIMARY KEY (`idIndiv`, `idAtividade`),
  INDEX `fk_Voluntario_has_Atividade_Atividade1_idx` (`idAtividade` ASC),
  INDEX `fk_Voluntario_has_Atividade_Voluntario1_idx` (`idIndiv` ASC),
  CONSTRAINT `fk_Voluntario_has_Atividade_Voluntario1`
    FOREIGN KEY (`idIndiv`)
    REFERENCES `habitat`.`Individuo` (`idIndiv`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Voluntario_has_Atividade_Atividade1`
    FOREIGN KEY (`idAtividade`)
    REFERENCES `habitat`.`Actividade` (`idAtividade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`Questao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`Questao` ;

CREATE TABLE IF NOT EXISTS `habitat`.`Questao` (
  `idQuestao` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(200) NOT NULL,
  `ativa` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idQuestao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`CandidaturaQuestao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`CandidaturaQuestao` ;

CREATE TABLE IF NOT EXISTS `habitat`.`CandidaturaQuestao` (
  `idCand` INT NOT NULL,
  `idQuestao` INT NOT NULL,
  `resposta` VARCHAR(100) NULL,
  PRIMARY KEY (`idCand`, `idQuestao`),
  INDEX `fk_Candidatura_has_Questao_Questao1_idx` (`idQuestao` ASC),
  INDEX `fk_Candidatura_has_Questao_Candidatura1_idx` (`idCand` ASC),
  CONSTRAINT `fk_Candidatura_has_Questao_Candidatura1`
    FOREIGN KEY (`idCand`)
    REFERENCES `habitat`.`Candidatura` (`idCand`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Candidatura_has_Questao_Questao1`
    FOREIGN KEY (`idQuestao`)
    REFERENCES `habitat`.`Questao` (`idQuestao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`ElementoFamilia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`ElementoFamilia` ;

CREATE TABLE IF NOT EXISTS `habitat`.`ElementoFamilia` (
  `idElemento` INT NOT NULL AUTO_INCREMENT,
  `idFam` INT NOT NULL,
  `nome` VARCHAR(75) NOT NULL,
  `parentesco` VARCHAR(20) NULL,
  `dataNascimento` DATE NULL,
  `estadoCivil` VARCHAR(20) NULL,
  `ocupacao` VARCHAR(55) NULL,
  `escolaridade` VARCHAR(20) NULL,
  PRIMARY KEY (`idElemento`),
  INDEX `fk_ElementoFamilia_Familia1_idx` (`idFam` ASC),
  CONSTRAINT `fk_ElementoFamilia_Familia1`
    FOREIGN KEY (`idFam`)
    REFERENCES `habitat`.`Familia` (`idFam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`Prestacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`Prestacao` ;

CREATE TABLE IF NOT EXISTS `habitat`.`Prestacao` (
  `idPrestacao` INT NOT NULL AUTO_INCREMENT,
  `idFunc` INT NOT NULL,
  `valor` DECIMAL(10,2) NULL,
  `data` DATETIME NULL,
  `idFam` INT NOT NULL,
  PRIMARY KEY (`idPrestacao`),
  INDEX `fk_Prestacao_Funcionario1_idx` (`idFunc` ASC),
  INDEX `fk_Prestacao_Familia1_idx` (`idFam` ASC),
  CONSTRAINT `fk_Prestacao_Funcionario1`
    FOREIGN KEY (`idFunc`)
    REFERENCES `habitat`.`Funcionario` (`idFunc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prestacao_Familia1`
    FOREIGN KEY (`idFam`)
    REFERENCES `habitat`.`Familia` (`idFam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`DonativoProjeto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`DonativoProjeto` ;

CREATE TABLE IF NOT EXISTS `habitat`.`DonativoProjeto` (
  `idDon` INT NOT NULL,
  `idProj` INT NOT NULL,
  `dataDonProj` DATE NULL,
  `quantDonProj` INT NULL,
  `idFunc` INT NOT NULL,
  PRIMARY KEY (`idDon`, `idProj`),
  INDEX `fk_Donativo_has_Projeto_Projeto1_idx` (`idProj` ASC),
  INDEX `fk_Donativo_has_Projeto_Donativo1_idx` (`idDon` ASC),
  INDEX `fk_DonativoProjeto_Funcionario1_idx` (`idFunc` ASC),
  CONSTRAINT `fk_Donativo_has_Projeto_Donativo1`
    FOREIGN KEY (`idDon`)
    REFERENCES `habitat`.`Donativo` (`idDon`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Donativo_has_Projeto_Projeto1`
    FOREIGN KEY (`idProj`)
    REFERENCES `habitat`.`Projeto` (`idProj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonativoProjeto_Funcionario1`
    FOREIGN KEY (`idFunc`)
    REFERENCES `habitat`.`Funcionario` (`idFunc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitat`.`Relatorio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitat`.`Relatorio` ;

CREATE TABLE IF NOT EXISTS `habitat`.`Relatorio` (
  `idRel` INT NOT NULL AUTO_INCREMENT,
  `obsRel` VARCHAR(45) NULL,
  `dataRel` VARCHAR(45) NULL,
  `ficheiroRel` BLOB NULL,
  `idFam` INT NOT NULL,
  `idFunc` INT NOT NULL,
  PRIMARY KEY (`idRel`),
  INDEX `fk_Relatorio_Familia1_idx` (`idFam` ASC),
  INDEX `fk_Relatorio_Funcionario1_idx` (`idFunc` ASC),
  CONSTRAINT `fk_Relatorio_Familia1`
    FOREIGN KEY (`idFam`)
    REFERENCES `habitat`.`Familia` (`idFam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Relatorio_Funcionario1`
    FOREIGN KEY (`idFunc`)
    REFERENCES `habitat`.`Funcionario` (`idFunc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `habitat` ;

-- -----------------------------------------------------
-- Placeholder table for view `habitat`.`ViewTarefaProjeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habitat`.`ViewTarefaProjeto` (`idProj` INT, `idTar` INT, `designacaoTar` INT, `dataPlInicio` INT, `dataPlFim` INT, `DataExInicio` INT, `DataExFim` INT);


-- -----------------------------------------------------
-- View `habitat`.`ViewTarefaProjeto`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `habitat`.`ViewTarefaProjeto` ;
DROP TABLE IF EXISTS `habitat`.`ViewTarefaProjeto`;
USE `habitat`;
CREATE  OR REPLACE VIEW `ViewTarefaProjeto` AS
Select idProj, t.idTar as idTar, t.designacao as designacaoTar, dataPlInicio, dataPlFim, DataExInicio, DataExFim from TarefaProjeto tp inner join Tarefa t on t.idtar = tp.idtar;
SET SQL_MODE = '';
GRANT USAGE ON *.* TO admin;
 DROP USER admin;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE VIEW `ViewCandidaturaQuestao` AS
select `c`.`idCand` AS `idCand`,`c`.`idQuestao` AS `idQuestao`,`c`.`resposta` AS `resposta`,`q`.`descricao` AS `questao`,`q`.`ativa` AS `ativa` from (`CandidaturaQuestao` `c` join `Questao` `q` on((`q`.`idQuestao` = `c`.`idQuestao`)));


CREATE USER 'admin' IDENTIFIED BY 'admin';

GRANT ALL ON TABLE `habitat`.`CandidaturaQuestao` TO 'admin';
GRANT ALL ON TABLE `habitat`.`Prestacao` TO 'admin';
GRANT ALL ON TABLE `habitat`.`Relatorio` TO 'admin';
GRANT ALL ON TABLE `habitat`.`ElementoFamilia` TO 'admin';
GRANT ALL ON TABLE `habitat`.`Familia` TO 'admin';
GRANT ALL ON TABLE `habitat`.`EquipaTarefaProjeto` TO 'admin';
GRANT ALL ON TABLE `habitat`.`IndividuoTarefaProjeto` TO 'admin';
GRANT ALL ON TABLE `habitat`.`TarefaProjeto` TO 'admin';
GRANT ALL ON TABLE `habitat`.`ViewTarefaProjeto` TO 'admin';
GRANT ALL ON TABLE `habitat`.`Projeto` TO 'admin';
GRANT ALL ON TABLE `habitat`.`DonativoProjeto` TO 'admin';
GRANT ALL ON TABLE `habitat`.`Donativo` TO 'admin';
GRANT ALL ON TABLE `habitat`.`Individuo` TO 'admin';
GRANT ALL ON TABLE `habitat`.`EquipaIndividuo` TO 'admin';
GRANT ALL ON TABLE `habitat`.`Evento` TO 'admin';
GRANT ALL ON TABLE `habitat`.`IndividuoActividade` TO 'admin';
GRANT ALL ON TABLE `habitat`.`Equipa` TO 'admin';
GRANT ALL ON TABLE `habitat`.`Candidatura` TO 'admin';
GRANT ALL ON TABLE `habitat`.`TipoDonativo` TO 'admin';
GRANT ALL ON TABLE `habitat`.`Funcionario` TO 'admin';
GRANT ALL ON TABLE `habitat`.`Actividade` TO 'admin';
GRANT ALL ON TABLE `habitat`.`Tarefa` TO 'admin';
GRANT ALL ON TABLE `habitat`.`Questao` TO 'admin';
SET SQL_MODE = '';
GRANT USAGE ON *.* TO fundos;
 DROP USER fundos;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'fundos' IDENTIFIED BY 'fundos';

GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`DonativoProjeto` TO 'fundos';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`Donativo` TO 'fundos';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`Individuo` TO 'fundos';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`EquipaIndividuo` TO 'fundos';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`Evento` TO 'fundos';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`IndividuoActividade` TO 'fundos';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`Equipa` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`EquipaTarefaProjeto` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`IndividuoTarefaProjeto` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`TarefaProjeto` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`ViewTarefaProjeto` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Projeto` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`DonativoProjeto` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Donativo` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Individuo` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`EquipaIndividuo` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Evento` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`IndividuoActividade` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Equipa` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`CandidaturaQuestao` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Relatorio` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Candidatura` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`ElementoFamilia` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Familia` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Prestacao` TO 'fundos';
SET SQL_MODE = '';
GRANT USAGE ON *.* TO obras;
 DROP USER obras;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'obras' IDENTIFIED BY 'obras';

GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`EquipaTarefaProjeto` TO 'obras';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`IndividuoTarefaProjeto` TO 'obras';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`TarefaProjeto` TO 'obras';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`ViewTarefaProjeto` TO 'obras';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`Projeto` TO 'obras';
GRANT INSERT, DELETE, SELECT, UPDATE ON TABLE `habitat`.`DonativoProjeto` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`EquipaTarefaProjeto` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`IndividuoTarefaProjeto` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`TarefaProjeto` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`ViewTarefaProjeto` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`Projeto` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`DonativoProjeto` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`Donativo` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`Individuo` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`EquipaIndividuo` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`Evento` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`IndividuoActividade` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`Equipa` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`CandidaturaQuestao` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`Relatorio` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`Candidatura` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`ElementoFamilia` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`Familia` TO 'obras';
GRANT SELECT ON TABLE `habitat`.`Prestacao` TO 'obras';
SET SQL_MODE = '';
GRANT USAGE ON *.* TO fundos;
 DROP USER fundos;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'fundos' IDENTIFIED BY 'fundos';

GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`DonativoProjeto` TO 'fundos';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`Donativo` TO 'fundos';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`Individuo` TO 'fundos';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`EquipaIndividuo` TO 'fundos';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`Evento` TO 'fundos';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`IndividuoActividade` TO 'fundos';
GRANT DELETE, INSERT, SELECT, UPDATE ON TABLE `habitat`.`Equipa` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`EquipaTarefaProjeto` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`IndividuoTarefaProjeto` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`TarefaProjeto` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`ViewTarefaProjeto` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Projeto` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`DonativoProjeto` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Donativo` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Individuo` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`EquipaIndividuo` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Evento` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`IndividuoActividade` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Equipa` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`CandidaturaQuestao` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Relatorio` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Candidatura` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`ElementoFamilia` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Familia` TO 'fundos';
GRANT SELECT ON TABLE `habitat`.`Prestacao` TO 'fundos';
SET SQL_MODE = '';
GRANT USAGE ON *.* TO guest;
 DROP USER guest;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'guest';

SET SQL_MODE = '';
GRANT USAGE ON *.* TO loginCheck;
 DROP USER loginCheck;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'loginCheck' IDENTIFIED BY 'tpV8jKd9YwSzLvQfzHLUZz9Jua3mt5VnTFWvsVczTNanJxSh';

GRANT SELECT ON TABLE `habitat`.`Funcionario` TO 'loginCheck';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE `habitat`;

DELIMITER $$

USE `habitat`$$
DROP TRIGGER IF EXISTS `habitat`.`VerificarQuant` $$
USE `habitat`$$
CREATE TRIGGER `VerificarQuant` BEFORE INSERT ON `Donativo`
FOR EACH ROW
begin
    IF (NEW.quantAtual < 0) THEN
      SIGNAL SQLSTATE '45000'
         SET MESSAGE_TEXT = 'Quantidade Actual inferior a 0', MYSQL_ERRNO = 1001;
    END IF;
end$$


USE `habitat`$$
DROP TRIGGER IF EXISTS `habitat`.`VerificarQuantUpdate` $$
USE `habitat`$$
CREATE TRIGGER `VerificarQuantUpdate` BEFORE UPDATE ON `Donativo` 
FOR EACH ROW
begin
    IF (NEW.quantAtual < 0) THEN
      SIGNAL SQLSTATE '45000'
         SET MESSAGE_TEXT = 'Quantidade Actual inferior a 0', MYSQL_ERRNO = 1001;
    END IF;
end$$


USE `habitat`$$
DROP TRIGGER IF EXISTS `habitat`.`TirarStock` $$
USE `habitat`$$
CREATE TRIGGER `TirarStock` BEFORE INSERT ON `DonativoProjeto` 
FOR EACH ROW 
BEGIN
    UPDATE Donativo Set quantAtual = quantAtual - NEW.quantDonProj where idDon = NEW.idDon;
END$$


USE `habitat`$$
DROP TRIGGER IF EXISTS `habitat`.`TirarSockUpdate` $$
USE `habitat`$$
CREATE TRIGGER `TirarSockUpdate` BEFORE UPDATE ON `DonativoProjeto`
FOR EACH ROW 
BEGIN
    UPDATE Donativo Set quantAtual = quantAtual + OLD.quantDonProj - NEW.quantDonProj where idDon = NEW.idDon;
  if (@@error_count > 0) then
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Quantidade Actual inferior a 0', MYSQL_ERRNO = 1001;
  end if
END$$


USE `habitat`$$
DROP TRIGGER IF EXISTS `habitat`.`ReporStock` $$
USE `habitat`$$
CREATE TRIGGER `ReporStock` BEFORE DELETE ON `DonativoProjeto` 
FOR EACH ROW
BEGIN
  UPDATE Donativo Set quantAtual = quantAtual + OLD.quantDonProj where idDon = OLD.idDon;
END$$


DELIMITER ;
