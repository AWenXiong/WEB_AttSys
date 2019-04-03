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