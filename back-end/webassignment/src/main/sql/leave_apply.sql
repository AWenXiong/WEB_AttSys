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