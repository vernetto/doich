create user DOICH identified by DOICH;
GRANT CONNECT, RESOURCE, CREATE VIEW, CREATE TABLE TO DOICH;

create table VOCABULARY (
    ID NUMBER(10) PRIMARY KEY,
    NAME VARCHAR2(50) NOT NULL
);
