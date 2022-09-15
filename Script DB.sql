-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema orders
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema orders
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `orders` DEFAULT CHARACTER SET utf8 ;
USE `orders` ;

-- -----------------------------------------------------
-- Table `orders`.`mouse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `orders`.`mouse` (
  `idmouse` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `serialNumber` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`idmouse`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orders`.`monitor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `orders`.`monitor` (
  `idmonitor` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `serialNumber` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmonitor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orders`.`keyboard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `orders`.`keyboard` (
  `idkeyboard` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `serialNumber` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idkeyboard`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orders`.`computer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `orders`.`computer` (
  `idcomputer` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NOT NULL,
  `serialNumber` VARCHAR(45) NOT NULL,
  `idmonitor` INT NOT NULL,
  `idmouse` INT NOT NULL,
  `idkeyboard` INT NOT NULL,
  PRIMARY KEY (`idcomputer`),
  INDEX `fk_MonitorComputer_idx` (`idmonitor` ASC) VISIBLE,
  INDEX `fk_MouseComputer_idx` (`idmouse` ASC) VISIBLE,
  INDEX `fk_MouseKeyboard_idx` (`idkeyboard` ASC) VISIBLE,
  CONSTRAINT `fk_MonitorComputer`
    FOREIGN KEY (`idmonitor`)
    REFERENCES `orders`.`monitor` (`idmonitor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MouseComputer`
    FOREIGN KEY (`idmouse`)
    REFERENCES `orders`.`mouse` (`idmouse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MouseKeyboard`
    FOREIGN KEY (`idkeyboard`)
    REFERENCES `orders`.`keyboard` (`idkeyboard`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orders`.`servicesOrder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `orders`.`servicesOrder` (
  `idservicesOrder` INT NOT NULL AUTO_INCREMENT,
  `iduser` INT NOT NULL,
  `date` DATE NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `idcomputer` INT NOT NULL,
  PRIMARY KEY (`idservicesOrder`),
  INDEX `fk_ComputerService_idx` (`idcomputer` ASC) VISIBLE,
  CONSTRAINT `fk_ComputerService`
    FOREIGN KEY (`idcomputer`)
    REFERENCES `orders`.`computer` (`idcomputer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
