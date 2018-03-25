create user DOICH identified by DOICH;
GRANT CONNECT, RESOURCE, CREATE VIEW, CREATE TABLE TO DOICH;

--------------------------------------------------------
--  File created - Saturday-March-10-2018   
--------------------------------------------------------
DROP TABLE "VOCABULARY" cascade constraints;
--------------------------------------------------------
--  DDL for Table VOCABULARY
--------------------------------------------------------

  CREATE TABLE "VOCABULARY" 
   (	"ID" NUMBER(10,0) NOT NULL, 
	"NAME" VARCHAR2(50) NOT NULL, 
	"GENRE" VARCHAR2(1), 
	"TYPE" VARCHAR2(20) NOT NULL, 
	"TRANSLATION" VARCHAR2(100)
   );
   

Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (1,'Haus','N','NOUN','house');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (2,'Tasse','F','NOUN','cup');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (3,'gelegentlich',null,'ADVE','ooccasionally');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (4,'aufgeben',null,'VERB','give up');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (5,'ablösen',null,'VERB','detach');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (6,'Anzeichen','N','NOUN','sign');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (7,'vortäuschen',null,'VERB','simulate');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (8,'Aufwand ','M','NOUN','expenditure');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (9,'ehrgeizig',null,'ADJE','ambitious');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (10,'Verlegenheit','F','NOUN','embarrassment');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (11,'Ausrufung','F','NOUN','proclamation');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (12,'Abkommen','N','NOUN','treaty');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (13,'Lediglich',null,'ADVE','only');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (14,'Hupe','F','NOUN','horn');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (15,'Verwarnung','F','NOUN','reprimand');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (16,'Turnhalle','F','NOUN','gym');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (17,'Einstellung','F','NOUN','attitude');
Insert into VOCABULARY (ID,NAME,GENRE,TYPE,TRANSLATION) values (18,'Tafel','F','NOUN','blackboard');

 
DROP TABLE EXPRESSIONS;

  CREATE TABLE "EXPRESSIONS" 
   (	"ID" NUMBER(10,0) NOT NULL, 
	"NAME" VARCHAR2(100) NOT NULL, 
	"TRANSLATION" VARCHAR2(100)  NOT NULL, 
   );

Insert into EXPRESSIONS (ID, NAME, TRANSLATION) values (1, 'Davon gehe ich aus', 'I assume so');


  CREATE UNIQUE INDEX "VOCABULARY_UNIQ_ID" ON "VOCABULARY" ("ID") ;
  CREATE UNIQUE INDEX "EXPRESSIONS_UNIQ_ID" ON "EXPRESSIONS" ("ID") ;

  ALTER TABLE "VOCABULARY" ADD PRIMARY KEY ("ID");
  ALTER TABLE "EXPRESSIONS" ADD PRIMARY KEY ("ID");
  
  
  
