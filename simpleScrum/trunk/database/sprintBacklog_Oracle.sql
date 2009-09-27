
set define off

create user sscrum identified by sscrum default tablespace users;
grant resource to sscrum;
grant connect to sscrum;


--
-- Structure de la table `sprintbacklog`
--

DROP TABLE sprintbacklog;
CREATE TABLE sprintbacklog (
  "TaskUniqueID" number(20) NOT NULL,
  "BacklogItemID" varchar(255) default NULL,
  "typeTask2" varchar(255) default NULL,
  "UserStory" varchar(255) default NULL,
  "Team" varchar(255) default NULL,
  "SprintNo" varchar(255) default NULL,
  "CRDSWebModuleSubModule" varchar(255) default NULL,
  "Budget" varchar(255) default NULL,
  "Task" varchar(255) default NULL,
  "Estimate" varchar(255) default NULL,
  "Discrepency" varchar(255) default NULL,
  "Remarks" varchar(255) default NULL,
  "Actual" varchar(255) default NULL,
  "JiraTaskNumber" varchar(255) default NULL,
  "Status" varchar(255) default NULL,
  "Metric" varchar(255) default NULL,
  "Day1" varchar(255) default NULL,
  "Day2" varchar(255) default NULL,
  "Day3" varchar(255) default NULL,
  "Day4" varchar(255) default NULL,
  "Day5" varchar(255) default NULL,
  "Day6" varchar(255) default NULL,
  "Day7" varchar(255) default NULL,
  "Day8" varchar(255) default NULL,
  "Day9" varchar(255) default NULL,
  "Day10" varchar(255) default NULL,
  "Dhanya" varchar(255) default NULL,
  "Kunal" varchar(255) default NULL,
  "Sourabh" varchar(255) default NULL,
  "Nazir" varchar(255) default NULL,
  "Imad" varchar(255) default NULL,
  "Luciano" varchar(255) default NULL,
  "Pranav" varchar(255) default NULL,
  "Tushar" varchar(255) default NULL,
  "Ashish" varchar(255) default NULL,
  "Jphi" varchar(255) default NULL,
  "Yann" varchar(255) default NULL,
  "Florent" varchar(255) default NULL,
  "Day1b" varchar(255) default NULL,
  "Day2b" varchar(255) default NULL,
  "Day3b" varchar(255) default NULL,
  "Day4b" varchar(255) default NULL,
  "Day5b" varchar(255) default NULL,
  "Day6b" varchar(255) default NULL,
  "Day7b" varchar(255) default NULL,
  "Day8b" varchar(255) default NULL,
  "Day9b" varchar(255) default NULL,
  "Day10b" varchar(255) default NULL,
  "Estimatesb" varchar(255) default NULL,
  "EstimatesCompleted" varchar(255) default NULL,
  PRIMARY KEY  ("TaskUniqueID")
) ;

drop sequence sq_sprintbacklog;
create sequence sq_sprintbacklog start with 5;

--
-- Contenu de la table `sprintbacklog`
--

INSERT INTO sprintbacklog VALUES(1, '15', 'Planned', 'Setup new integration server', '1', 'Sprint 3', '', 'W', 'First test', '1', '1', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '1', '0');
INSERT INTO sprintbacklog VALUES(2, '15', 'Planned', 'Setup new integration server', '1', 'Sprint 3', '', 'W', 'Define our standards', '1', '1', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '1', '0');
INSERT INTO sprintbacklog VALUES(3, '15', 'Planned', 'Setup new integration server', '1', 'Sprint 3', '', 'W', 'Train everybody using this new integration server', '1', '1', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '1', '0');
INSERT INTO sprintbacklog VALUES(4, '15', 'Planned', 'Setup new integration server', '1', 'Sprint 3', '', 'W', 'Train everybody managing this new integration server', '1', '1', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '1', '0');

commit;

set define on
