create database miniprojectf;
use miniprojectf;



create table players(pid varchar(25) primary key,pname varchar(20),pphone varchar(40),clname varchar(20),pword varchar(20));
desc players;
select * from  players;

create table coachs(cid varchar(25) primary key,cname varchar(20),cphno varchar(20) ,cemail varchar(20),clname varchar(20),pwd varchar(20));
desc coachs;
select * from  coachs;


create table clubs(clid varchar(25) primary key,clname varchar(20),clsec varchar(20),pid varchar(25),foreign key(pid) references player(pid) on delete cascade);
desc clubs;
select * from clubs;



create table teams(tid varchar(25) primary key,tname varchar(20),tcaptain varchar(20),pname varchar(20),cid varchar(25),foreign key(cid) references coachs(cid) on delete cascade);
desc teams;
select * from  teams;

create table event1(eid varchar(25) primary key,ename varchar(20),edate varchar(30),evenue varchar(20),tid varchar(25),foreign key(tid) references teams(tid) on delete cascade);
desc event1;
select * from  event1;

create table game2(gid varchar(20) primary key,gname varchar(20),tid varchar(20),eid varchar(20),foreign key(tid) references teams(tid) on delete cascade,foreign key(eid) references event1(eid) on delete cascade);
desc game2;
select * from  game2;
create table admin(aid varchar(25) primary key,aname varchar(20),aphno varchar(20) ,aemail varchar(20),pwd varchar(20));
desc admin;
alter table game2 add(game_type varchar(15));
alter table game2 add(no_of_game varchar(20));
delete from game2 where gid='g01';
alter table game2 drop column no_of_game;
create table game_count(gcid int auto_increment,game_type varchar(15),count int,primary key(gcid));
insert into game_count(game_type,count) values('indoor',1);
insert into game_count(game_type,count) values('outdoor',1);
delete from game_count where gcid='';

select * from game_count;
create table total1(gid varchar(20),game_type varchar(10), no_of_game varchar(20),foreign key(gid) references game2(gid) on delete cascade);
select * from total1;

 DELIMITER $$
CREATE PROCEDURE plyr_display() 
BEGIN 
SELECT  pid, pname FROM players;
 END$$
 CALL plyr_display();

 
 
 
 
create TRIGGER db1
AFTER INSERT ON game2
FOR EACH ROW 
UPDATE total
SET no_of_game=no_of_game+1
WHERE game_type=NEW.game_type; 


