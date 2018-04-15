create user DOICH identified by DOICH;
GRANT CONNECT, RESOURCE, CREATE VIEW, CREATE TABLE TO DOICH;

--------------------------------------------------------
--  DDL for Table VOCABULARY
--------------------------------------------------------


DROP TABLE "VOCABULARY" cascade constraints;

  CREATE TABLE "VOCABULARY" 
   (	"ID" NUMBER(10,0) NOT NULL, 
	"NAME" VARCHAR2(50) NOT NULL, 
	"GENRE" VARCHAR2(1), 
	"TYPE" VARCHAR2(20) NOT NULL, 
	"TRANSLATION" VARCHAR2(100),
	"ADDEDON" TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	"REPETITIONS" NUMBER(3,0) DEFAULT 0,
	"ACQUIRED" NUMBER(1,0) DEFAULT 0
   );
   
  CREATE UNIQUE INDEX "VOCABULARY_UNIQ_ID" ON "VOCABULARY" ("ID") ;
  ALTER TABLE "VOCABULARY" ADD PRIMARY KEY ("ID");
  
INSERT INTO PUBLIC.VOCABULARY(ID, NAME, GENRE, TYPE, TRANSLATION, ADDEDON, REPETITIONS, ACQUIRED) VALUES
(1, 'Haus', 'N', 'NOUN', 'house', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(2, 'Tasse', 'F', 'NOUN', 'cup', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(3, 'gelegentlich', NULL, 'ADVE', 'occasionally', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(4, 'aufgeben', NULL, 'VERB', 'give up', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(5, STRINGDECODE('abl\u00f6sen'), NULL, 'VERB', 'detach', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(6, 'Anzeichen', 'N', 'NOUN', 'sign', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(7, STRINGDECODE('vort\u00e4uschen'), NULL, 'VERB', 'simulate', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(8, 'Aufwand ', 'M', 'NOUN', 'expenditure', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(9, 'ehrgeizig', NULL, 'ADJE', 'ambitious', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(10, 'Verlegenheit', 'F', 'NOUN', 'embarrassment', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(11, 'Ausrufung', 'F', 'NOUN', 'proclamation', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(12, 'Abkommen', 'N', 'NOUN', 'treaty', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(13, 'Lediglich', NULL, 'ADVE', 'only', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(14, 'Hupe', 'F', 'NOUN', 'horn', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(15, 'Verwarnung', 'F', 'NOUN', 'reprimand', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(16, 'Turnhalle', 'F', 'NOUN', 'gym', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(17, 'Einstellung', 'F', 'NOUN', 'attitude', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(18, 'Tafel', 'F', 'NOUN', 'blackboard', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(19, 'Mann', 'M', 'NOUN', 'man', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(20, 'Frau', 'F', 'NOUN', 'woman', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(21, 'Kind', 'N', 'NOUN', 'child', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(22, 'Jung', NULL, 'ADJE', 'young', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(23, 'Klein', NULL, 'ADJE', 'little', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(24, 'Rot', NULL, 'ADJE', 'red', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(25, 'Frisch', NULL, 'ADJE', 'fresh', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(26, 'Kalt', NULL, 'ADJE', 'cold', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(27, 'Wein', 'M', 'NOUN', 'wine', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(28, 'Brot', 'N', 'NOUN', 'bread', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(29, 'Milch', 'F', 'NOUN', 'milk', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(30, 'Alt', NULL, 'ADJE', 'old', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(31, 'Sofa', 'N', 'NOUN', 'sofa', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(32, 'Pendeluhr', 'F', 'NOUN', 'pendulum clock', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(33, 'Sessel', 'M', 'NOUN', 'armchair', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(34, 'Hund', 'M', 'NOUN', 'Dog', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(35, 'Stuhl', 'M', 'NOUN', 'chair', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(36, 'Fernseher', 'M', 'NOUN', 'TV set', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(37, 'Schrank', 'M', 'NOUN', 'Cupboard', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(38, 'Vorhang', 'M', 'NOUN', 'Curtain', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(39, 'Lampe', 'F', 'NOUN', 'Lamp', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(40, 'Antenne', 'F', 'NOUN', 'Antenna', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(41, 'Kamin', 'M', 'NOUN', 'Chimney', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(42, 'Dach', 'N', 'NOUN', 'Roof', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(43, 'Zaun', 'M', 'NOUN', 'fence', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(44, 'Fenster', 'N', 'NOUN', 'window', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(45, STRINGDECODE('T\u00fcr'), 'F', 'NOUN', 'door', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(46, 'Strasse', 'F', 'NOUN', 'road', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0),
(47, 'verzweifelt', NULL, 'ADJE', 'desperate', TIMESTAMP '2018-04-15 04:45:36.811', 0, 0);



CREATE SEQUENCE VOCABULARY_SEQUENCE_ID START WITH (select max(ID) + 1 from VOCABULARY);

--------------------------------------------------------
--  DDL for Table EXPRESSIONS
--------------------------------------------------------

DROP TABLE EXPRESSIONS;

  CREATE TABLE "EXPRESSIONS" 
   (	"ID" NUMBER(10,0) NOT NULL, 
	"NAME" VARCHAR2(100) NOT NULL, 
	"TRANSLATION" VARCHAR2(100)  NOT NULL 
   );

  CREATE UNIQUE INDEX "EXPRESSIONS_UNIQ_ID" ON "EXPRESSIONS" ("ID") ;
  ALTER TABLE "EXPRESSIONS" ADD PRIMARY KEY ("ID");
  
Insert into EXPRESSIONS (ID, NAME, TRANSLATION) values (1, 'Davon gehe ich aus', 'I assume so');

--------------------------------------------------------
--  DDL for Table WORDFILL
--------------------------------------------------------


DROP TABLE WORDFILL;

CREATE TABLE "WORDFILL" (
	"ID" NUMBER(10,0) NOT NULL,
	"SENTENCE" VARCHAR2(100) NOT NULL
);


Insert into WORDFILL (ID,SENTENCE) values (1,'Guten M{orgen}');
Insert into WORDFILL (ID,SENTENCE) values (2,'Guten T{ag}');


  
  
  
