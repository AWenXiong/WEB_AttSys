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
	taff(sid, saccount, spassword, sname, sgender, sdid, sposition, ssalary_holiday, sentry_time) values
('JeidjJEdj2LEIe','黄老板','123','黄老板','男','92k38Hehkae','总经理',10,'2018-11-11 11:11:11'),
('Je2d5esj2LEIe','MrQiu','123','邱老板','男','Jeks2kI23ekEJ','副总经理',10,'2018-11-11 11:11:11'),
('JeieUEIdEejWIe','谢老板1','123','谢老板','男','92k38Hehkae','总经理',10,'2018-11-11 11:11:11'),
('Je92EJquIWLEIe','黄小姐','123','MeiMei','女','jiekIE923j21','总经理',10,'2018-11-11 11:11:11');