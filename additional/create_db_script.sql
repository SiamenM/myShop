-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema shop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shop` DEFAULT CHARACTER SET utf8 ;
USE `shop` ;

-- -----------------------------------------------------
-- Table `shop`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`category` (
  `id_category` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NOT NULL,
  `url` VARCHAR(60) NOT NULL,
  `product_count` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_category`),
  UNIQUE INDEX `id_UNIQUE` (`id_category` ASC) VISIBLE,
  UNIQUE INDEX `category_name_UNIQUE` (`category_name` ASC) VISIBLE,
  UNIQUE INDEX `url_UNIQUE` (`url` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`producer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`producer` (
  `id_producer` INT NOT NULL AUTO_INCREMENT,
  `producer_name` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id_producer`),
  UNIQUE INDEX `producer_name_UNIQUE` (`producer_name` ASC) VISIBLE,
  UNIQUE INDEX `id_producer_UNIQUE` (`id_producer` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`product_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`product_image` (
  `id_product_image` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `product_image_type` VARCHAR(20) NOT NULL,
  `product_image_data` MEDIUMBLOB NOT NULL,
  PRIMARY KEY (`id_product_image`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`product` (
  `id_product` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(255) NOT NULL,
  `product_description` TEXT(0) NOT NULL,
  `product_price` DECIMAL NOT NULL,
  `id_producer` INT NOT NULL,
  `id_product_image` INT UNSIGNED NOT NULL,
  `id_category` INT NOT NULL,
  PRIMARY KEY (`id_product`, `id_producer`, `id_product_image`, `id_category`),
  INDEX `fk_product_producer_idx` (`id_producer` ASC) VISIBLE,
  INDEX `fk_product_product_image1_idx` (`id_product_image` ASC) VISIBLE,
  INDEX `fk_product_category1_idx` (`id_category` ASC) VISIBLE,
  CONSTRAINT `fk_product_producer`
    FOREIGN KEY (`id_producer`)
    REFERENCES `shop`.`producer` (`id_producer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_product_image1`
    FOREIGN KEY (`id_product_image`)
    REFERENCES `shop`.`product_image` (`id_product_image`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_category1`
    FOREIGN KEY (`id_category`)
    REFERENCES `shop`.`category` (`id_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`account` (
  `id_account` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_account`),
  UNIQUE INDEX `id_account_UNIQUE` (`id_account` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`order` (
  `id_order` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP,
  `id_account` INT NOT NULL,
  `ordercol` VARCHAR(45) NULL,
  PRIMARY KEY (`id_order`, `id_account`),
  CONSTRAINT `fk_order_account1`
    FOREIGN KEY (`id_account`)
    REFERENCES `shop`.`account` (`id_account`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`order_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`order_item` (
  `id_order_item` INT NOT NULL AUTO_INCREMENT,
  `order_item_count` INT NOT NULL,
  `id_order` INT NOT NULL,
  `product_id_product` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_order_item`, `id_order`, `product_id_product`),
  INDEX `fk_order_item_order1_idx` (`id_order` ASC) VISIBLE,
  INDEX `fk_order_item_product1_idx` (`product_id_product` ASC) VISIBLE,
  CONSTRAINT `fk_order_item_order1`
    FOREIGN KEY (`id_order`)
    REFERENCES `shop`.`order` (`id_account`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_item_product1`
    FOREIGN KEY (`product_id_product`)
    REFERENCES `shop`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
