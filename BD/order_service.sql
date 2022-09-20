drop database if exists order_services;
create database order_services;

use order_services;

create table monitor(
monitor_id int primary key auto_increment,
brand varchar(40) binary character set utf8 collate utf8_bin not null ,
model varchar(40) binary character set utf8 collate utf8_bin not null ,
serialNumber varchar(40) binary character set utf8 collate utf8_bin not null
) engine = InnoDB character set utf8;

create table mouse(
mouse_id int primary key auto_increment,
brand varchar(40) binary character set utf8 collate utf8_bin not null ,
model varchar(40) binary character set utf8 collate utf8_bin not null ,
serialNumber varchar(40) binary character set utf8 collate utf8_bin not null
) engine = InnoDB character set utf8;

create table keyboard(
keyboard_id int primary key auto_increment,
brand varchar(40) binary character set utf8 collate utf8_bin not null ,
model varchar(40) binary character set utf8 collate utf8_bin not null ,
serialNumber varchar(40) binary character set utf8 collate utf8_bin not null
) engine = InnoDB character set utf8;

create table orders(
order_id int primary key auto_increment,
date_order date not null
) engine = InnoDB character set utf8;

create table computer(
computer_id int primary key auto_increment,
brand varchar(40) binary character set utf8 collate utf8_bin not null ,
serial_number varchar(40) binary character set utf8 collate utf8_bin not null ,
monitor_id int not null,
mouse_id int not null,
keyboard_id int not null,
order_id int not null,
foreign key (monitor_id) references monitor(monitor_id),
foreign key (mouse_id) references mouse(mouse_id),
foreign key (keyboard_id) references keyboard(keyboard_id),
foreign key (order_id) references orders(order_id)
) engine = InnoDB character set utf8;

create table users (
id int primary key not null auto_increment,
age integer,
ds_lastname varchar(40),
ds_name varchar(240)
) engine = InnoDB character set utf8;

insert into monitor (brand, model, serialNumber) values ("acer", "201", "jH2FE");
insert into monitor (brand, model, serialNumber) values ("compaq", "202", "JicF2");
insert into monitor (brand, model, serialNumber) values ("hp", "203", "8ZyWt");

insert into mouse (brand, model, serialNumber) values ("acer", "201", "jH2FE");
insert into mouse (brand, model, serialNumber) values ("compaq", "202", "JicF2");
insert into mouse (brand, model, serialNumber) values ("hp", "203", "8ZyWt");

insert into keyboard (brand, model, serialNumber) values ("acer", "201", "jH2FE");
insert into keyboard (brand, model, serialNumber) values ("compaq", "202", "JicF2");
insert into keyboard (brand, model, serialNumber) values ("hp", "203", "8ZyWt");

insert into orders(date_order) values ("2022-05-12");
insert into orders(date_order) values ("2022-07-21");
insert into orders(date_order) values ("2021-10-25");

insert into computer(brand, serial_number, monitor_id, mouse_id, keyboard_id, order_id) values ("acer", "jH2FE", 1 , 1, 1, 1);
insert into computer(brand, serial_number, monitor_id, mouse_id, keyboard_id, order_id) values ("compaq", "JicF2", 2 , 2, 2, 2);
insert into computer(brand, serial_number, monitor_id, mouse_id, keyboard_id, order_id) values ("hp", "8ZyWt", 3 , 3, 3, 3);

INSERT INTO `order_services`.`users` (`id`, `age`, `ds_lastname`, `ds_name`) VALUES ('1', '24', 'Garcia', 'Jose');
INSERT INTO `order_services`.`users` (`id`, `age`, `ds_lastname`, `ds_name`) VALUES ('2', '22', 'Garcia', 'Adriana');
INSERT INTO `order_services`.`users` (`id`, `age`, `ds_lastname`, `ds_name`) VALUES ('3', '40', 'Garcia', 'Daniel');

select * from computer;
select * from orders; 