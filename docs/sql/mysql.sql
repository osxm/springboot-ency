create database sb;
use sb;

create table usr
(
 id int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
 name varchar(30) NOT NULL COMMENT '姓名'
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8