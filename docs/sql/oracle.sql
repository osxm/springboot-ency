create tablespace SB datafile 'D:\APP\XUEMI\VIRTUAL\ORADATA\ORCL\SB01.DBF' size 200M autoextend on next 10M;


select sys_context ('USERENV', 'CON_NAME') from dual; 

alter pluggable database ORCLPDB open;
alter session set container=ORCLPDB
show pdbs;

create user SB identified by oscar default tablespace SB;

grant create session to SB;  
grant resource to SB;  
grant create database link to SB ;  
grant create view to SB;

CREATE TABLE SB_IMAGE(
  NAME VARCHAR(30),
  CONTENT BLOB,
  REMARK CLOB
);


--

CREATE TABLE　USR(
  ID NUMBER,
  NAME VARCHAR(100),
  ADDRESS VARCHAR(200)
);
CREATE SEQUENCE SEQ_USR_ID INCREMENT BY 1 START WITH 1;


-- Begin For JPA Demo
CREATE TABLE　USR(
  ID NUMBER,
  NAME VARCHAR(100),
  TITLE VARCHAR(30)
);
INSERT INTO USR VALUES(1,'刘备','君主') ;
INSERT INTO USR VALUES(2,'关羽','上将军') ;
-- End   For JPA Demo　



