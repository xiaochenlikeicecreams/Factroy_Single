show tables;

create table person
(
	personId int primary key auto_increment,
	personName varchar(20),
	personEmail text,
	personSex varchar(20),
	personPassword varchar(20)
);

create table admin
(
adminId int primary key auto_increment,
adminName varchar(50),
adminPassword varchar(50)
);