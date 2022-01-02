
CREATE TABLE KING_DOM (
	ID int not null primary key,-- auto_increment,
	NAME varchar(100),
	CAPITAL varchar(100)
);

CREATE TABLE USR (
 ID int not null primary key,-- auto_increment,
 NAME varchar(100),
 KINGDOM_ID int
);