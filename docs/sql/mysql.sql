create database sb;
use sb;

CREATE TABLE USR
(
 id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
 name varchar(30) NOT NULL COMMENT '姓名',
 PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into USR(NAME) values('MySQL User');