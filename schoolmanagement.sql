
create database schoolmanagement;
use schoolmanagement;

create table loginadmin(
userid Int not null,
primary key(userid),
password varchar(10)
);

create table loginfaculty(
userid Int not null,
primary key(userid),
password varchar(10)
);

create table loginstudent(
userid Int not null,
primary key(userid),
password varchar(10)
);

create table staff(
id Int not null,primary key(id),
name varchar(15), age int, address varchar(50), dob varchar(10),
phone bigint(10), salary int, email varchar(50), gender varchar(8),
qualification varchar(15), department varchar(15) );

insert into staff values(1, 'Ga', 27, 'pno.8, Subhashnagar pal road', '23/01/1993', 76598769897, 50000, 'ga@gmail.com', 'male', 'none', 'admin');
insert into loginadmin values(1, 'abc');

create table student(
id Int not null,primary key(id),
name varchar(15),father_name varchar(15), age int,  dob varchar(10),address varchar(50),
phone bigint(10), email varchar(50), gender varchar(8), class int);

create table marks(
sid int not null, 
maths int, science int, eng int);

alter table marks add primary key(sid);

create table sub(
sid int not null,
primary key(sid),
subj varchar(15)
);

select * from student;
select * from staff;
select * from loginadmin;
select * from loginfaculty;
select * from loginstudent;
select * from marks;
select * from sub;

