create database boarddb;
create table boarddb.tblBoard(
num int auto_increment primary key,
name char(20),
subject char(50),
content text,
pos smallint unsigned,
ref smallint,
depth smallint unsigned,
regdate date,
pass varchar(15),
ip varchar(15),
count smallint unsigned,
filename varchar(30),
filesize int
);