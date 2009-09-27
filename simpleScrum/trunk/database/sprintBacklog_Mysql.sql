
CREATE DATABASE  `simpleScrum` ;


DROP TABLE sprintbacklog;


CREATE TABLE sprintbacklog (
  `Backlog Item ID` varchar(255) NULL default NULL,
  `typeTask2` varchar(255) NULL default NULL,
  `User Story` varchar(255) NULL default NULL,
  `Team` varchar(255) NULL default NULL,
  `Sprint #` varchar(255) NULL default NULL,
  `CRDS Web Module Sub Module` varchar(255) NULL default NULL,
  `Budget` varchar(255) NULL default NULL,
  `Task` varchar(255) NULL default NULL,
  `Estimate` varchar(255) NULL default NULL,
  `Discrepency` varchar(255) NULL default NULL,
  `Remarks` varchar(4000) NULL default NULL,
  `Actual` varchar(255) NULL default NULL,
  `Jira Task Number` varchar(255) NULL default NULL,
  `Status` varchar(255) NULL default NULL,
  `Metric` varchar(255) NULL default NULL,
  `Day 1` varchar(255) NULL default NULL,
  `Day 2` varchar(255) NULL default NULL,
  `Day 3` varchar(255) NULL default NULL,
  `Day 4` varchar(255) NULL default NULL,
  `Day 5` varchar(255) NULL default NULL,
  `Day 6` varchar(255) NULL default NULL,
  `Day 7` varchar(255) NULL default NULL,
  `Day 8` varchar(255) NULL default NULL,
  `Day 9` varchar(255) NULL default NULL,
  `Day 10` varchar(255) NULL default NULL,
  `Dhanya` varchar(255) NULL default NULL,
  `Kunal` varchar(255) NULL default NULL,
  `Sourabh` varchar(255) NULL default NULL,
  `Nazir` varchar(255) NULL default NULL,
  `Imad` varchar(255) NULL default NULL,
  `Luciano` varchar(255) NULL default NULL,
  `Pranav` varchar(255) NULL default NULL,
  `Tushar` varchar(255) NULL default NULL,
  `Ashish` varchar(255) NULL default NULL,
  `Jphi` varchar(255) NULL default NULL,
  `Yann` varchar(255) NULL default NULL,
  `Florent` varchar(255) NULL default NULL,
  `Day 1b` varchar(255) NULL default NULL,
  `Day 2b` varchar(255) NULL default NULL,
  `Day 3b` varchar(255) NULL default NULL,
  `Day 4b` varchar(255) NULL default NULL,
  `Day 5b` varchar(255) NULL default NULL,
  `Day 6b` varchar(255) NULL default NULL,
  `Day 7b` varchar(255) NULL default NULL,
  `Day 8b` varchar(255) NULL default NULL,
  `Day 9b` varchar(255) NULL default NULL,
  `Day 10b` varchar(255) NULL default NULL,
  `Estimatesb` varchar(255) NULL default NULL,
  `Estimates Completed` varchar(255) NULL default NULL
) ENGINE = INNODB;


INSERT INTO sprintbacklog VALUES('15', 'Planned', 'Setup new integration server', '1', 'Sprint 3', '', 'W', 'First test', '1', '1', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '1', '0');
INSERT INTO sprintbacklog VALUES('15', 'Planned', 'Setup new integration server', '1', 'Sprint 3', '', 'W', 'Define our standards', '1', '1', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '1', '0');
INSERT INTO sprintbacklog VALUES('15', 'Planned', 'Setup new integration server', '1', 'Sprint 3', '', 'W', 'Train everybody using this new integration server', '1', '1', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '1', '0');
INSERT INTO sprintbacklog VALUES('15', 'Planned', 'Setup new integration server', '1', 'Sprint 3', '', 'W', 'Train everybody managing this new integration server', '1', '1', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '1', '0');


commit;
