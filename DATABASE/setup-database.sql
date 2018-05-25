create database temperature;

use temperature;

set names utf8;

#=============================================================================
# Temperature data
#=============================================================================

create table tempdata (
	id           integer(8)  not null auto_increment,
	sensor_id    varchar(30)  not null,
	temperature  integer(8)  not null,
	dt           timestamp default current_timestamp not null,
	
	primary key (id)
);
