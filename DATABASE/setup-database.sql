create database temperature;

use temperature;

set names utf8;

#=============================================================================
# Sensor
#=============================================================================

create table sensor (
	id       integer(8)    not null,
	name     varchar(20)   not null,
	details  varchar(40),

	primary key (id)
);

insert into sensor values(0, "sensor0", "sala");
insert into sensor values(1, "sensor1", "cozinha");
insert into sensor values(2, "sensor2", "quarto");

#=============================================================================
# Temperature data
#=============================================================================

create table tempdata (
	id           integer(8)  not null auto_increment,
	sensor_id    integer(8)  not null,
	temperature  integer(8)  not null,
	
	primary key (id),
	foreign key (sensor_id)
		references sensor(id)
);
