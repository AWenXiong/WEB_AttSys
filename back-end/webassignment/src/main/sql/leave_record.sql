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
foreign key(lstaff_id) references staff(sid) on delete cascade,
)auto_increment=0;