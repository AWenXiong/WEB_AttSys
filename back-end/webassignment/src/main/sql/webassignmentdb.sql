create database webassignment;

use webassignment

create table department
(
did varchar(100),
dname varchar(100) not null,
primary key(did)
);
insert into department values
('92k38Hehkae','研发部'),
('Jeks2kI23ekEJ','财务部'),
('jiekIE923j21','行政部');

create table staff
(
sid varchar(100),
saccount varchar(100) not null,
spassword varchar(100) not null,
sname varchar(100) not null,
sgender varchar(10) not null,
sdid varchar(100) not null,
sposition varchar(100) not null,
scontact varchar(100),
saddress varchar(100),
ssalary_holiday int not null,
sentry_time datetime not null,
primary key(sid),
foreign key(sdid) references department(did) on delete cascade
);
insert into staff(sid, saccount, spassword, sname, sgender, sdid, sposition, ssalary_holiday, sentry_time) values
('JeidjJEdj2LEIe','黄老板','123','黄老板','男','92k38Hehkae','总经理',10,'2018-11-11 11:11:11'),
('Je2d5esj2LEIe','MrQiu','123','邱老板','男','Jeks2kI23ekEJ','副总经理',10,'2018-11-11 11:11:11'),
('JeieUEIdEejWIe','谢老板1','123','谢老板','男','92k38Hehkae','总经理',10,'2018-11-11 11:11:11'),
('Je92EJquIWLEIe','黄小姐','123','MeiMei','女','jiekIE923j21','总经理',10,'2018-11-11 11:11:11');

create table leave_apply
(
lid int auto_increment,
lstaff_id varchar(100),
lstart_time datetime not null,
lend_time datetime not null,
lreason varchar(100),
lpass_staff_id varchar(500),
lkind int not null,
lstatus int not null,
primary key(lid),
foreign key(lstaff_id) references staff(sid) on delete cascade,
foreign key(lpass_staff_id) references staff(sid) on delete cascade
)auto_increment=0;

create table leave_record
(
lid int auto_increment,
lstaff_id varchar(100),
lstart_time datetime not null,
lend_time datetime not null,
lreason varchar(100),
lpass_staff_id varchar(300),
lkind int not null,
primary key(lid),
foreign key(lstaff_id) references staff(sid) on delete cascade
)auto_increment=0;

create table out_apply
(
oid int auto_increment,
ostaff_id varchar(100),
ostart_time datetime not null,
oend_time datetime not null,
oreason varchar(100),
opass_staff_id varchar(300),
ostatus int not null,
primary key(oid),
foreign key(ostaff_id) references staff(sid) on delete cascade
)auto_increment=0;

create table out_record
(
oid int auto_increment,
ostaff_id varchar(100),
ostart_time datetime not null,
oend_time datetime not null,
oreason varchar(100),
opass_staff_id varchar(300),
primary key(oid),
foreign key(ostaff_id) references staff(sid) on delete cascade
)auto_increment=0;