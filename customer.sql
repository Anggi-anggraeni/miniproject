create table customer (
id serial not null,
	username varchar (25) not null,
	role varchar (25),
	password varchar (225) not null
);

drop table customer
insert into customer(username, role, password) 
	values ('Admin', 'admin', '$2a$10$5e3dB36HeRcozRgp8xQfw.tfD3Qsut8xu/NT9g/DSpVKg9Kzuitrq'),
			('User', 'user', '$2a$10$5e3dB36HeRcozRgp8xQfw.tfD3Qsut8xu/NT9g/DSpVKg9Kzuitrq');