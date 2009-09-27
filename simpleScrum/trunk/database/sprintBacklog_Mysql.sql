
CREATE DATABASE  `simpleScrum` ;

-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Mar 14 Juillet 2009 à 21:11
-- Version du serveur: 5.0.51
-- Version de PHP: 5.2.6


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `scrum`
--

-- --------------------------------------------------------

--
-- Structure de la table `sprintbacklog`
--

DROP TABLE IF EXISTS `sprintbacklog`;
CREATE TABLE IF NOT EXISTS `sprintbacklog` (
  `TaskUniqueID` bigint(20) NOT NULL auto_increment,
  `BacklogItemID` varchar(255) default NULL,
  `typeTask2` varchar(255) default NULL,
  `UserStory` varchar(255) default NULL,
  `Team` varchar(255) default NULL,
  `SprintNo` varchar(255) default NULL,
  `CRDSWebModuleSubModule` varchar(255) default NULL,
  `Budget` varchar(255) default NULL,
  `Task` varchar(255) default NULL,
  `Estimate` varchar(255) default NULL,
  `Discrepency` varchar(255) default NULL,
  `Remarks` varchar(255) default NULL,
  `Actual` varchar(255) default NULL,
  `JiraTaskNumber` varchar(255) default NULL,
  `Status` varchar(255) default NULL,
  `Metric` varchar(255) default NULL,
  `Day1` varchar(255) default NULL,
  `Day2` varchar(255) default NULL,
  `Day3` varchar(255) default NULL,
  `Day4` varchar(255) default NULL,
  `Day5` varchar(255) default NULL,
  `Day6` varchar(255) default NULL,
  `Day7` varchar(255) default NULL,
  `Day8` varchar(255) default NULL,
  `Day9` varchar(255) default NULL,
  `Day10` varchar(255) default NULL,
  `Dhanya` varchar(255) default NULL,
  `Kunal` varchar(255) default NULL,
  `Sourabh` varchar(255) default NULL,
  `Nazir` varchar(255) default NULL,
  `Imad` varchar(255) default NULL,
  `Luciano` varchar(255) default NULL,
  `Pranav` varchar(255) default NULL,
  `Tushar` varchar(255) default NULL,
  `Ashish` varchar(255) default NULL,
  `Jphi` varchar(255) default NULL,
  `Yann` varchar(255) default NULL,
  `Florent` varchar(255) default NULL,
  `Day1b` varchar(255) default NULL,
  `Day2b` varchar(255) default NULL,
  `Day3b` varchar(255) default NULL,
  `Day4b` varchar(255) default NULL,
  `Day5b` varchar(255) default NULL,
  `Day6b` varchar(255) default NULL,
  `Day7b` varchar(255) default NULL,
  `Day8b` varchar(255) default NULL,
  `Day9b` varchar(255) default NULL,
  `Day10b` varchar(255) default NULL,
  `Estimatesb` varchar(255) default NULL,
  `EstimatesCompleted` varchar(255) default NULL,
  PRIMARY KEY  (`TaskUniqueID`)
) TYPE=InnoDB  AUTO_INCREMENT=1977 ;

--
-- Contenu de la table `sprintbacklog`
--


INSERT INTO sprintbacklog VALUES('15', 'Planned', 'Setup new integration server', '1', 'Sprint 3', '', 'W', 'First test', '1', '1', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '1', '0');
INSERT INTO sprintbacklog VALUES('15', 'Planned', 'Setup new integration server', '1', 'Sprint 3', '', 'W', 'Define our standards', '1', '1', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '1', '0');
INSERT INTO sprintbacklog VALUES('15', 'Planned', 'Setup new integration server', '1', 'Sprint 3', '', 'W', 'Train everybody using this new integration server', '1', '1', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '1', '0');
INSERT INTO sprintbacklog VALUES('15', 'Planned', 'Setup new integration server', '1', 'Sprint 3', '', 'W', 'Train everybody managing this new integration server', '1', '1', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '1', '0');


commit;
