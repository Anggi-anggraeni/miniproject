CREATE TABLE list_customer
(
    id serial NOT NULL,
    name varchar(25) NOT NULL,
    address varchar(25),
    phone varchar(11),
    gender varchar(1),
    email varchar(25),
    date_of_register date,
    active_account boolean,
)
insert into list_customer(
	name,
	address,
	phone,
	gender,
	email,
	date_of_register,
	active_account
	)
values ('Andrian Maulana','Palembang','08783797165','M','Andrianmaulana@gmail.com','2019-06-22','true'),
		('Sherly Mustika Sari','Bogor','08983705265','F','sherly.Ms@ymail.com','2019-01-02','true'),
		('Gundala Purnomo','Pontianak','08775797142','M','gundalaP@pro.net','2019-04-12','true')
		('Amrita Puri','Manado','0878307690','F','Amrita@pro.net','2019-03-24','true')
		('Arga Bima Nusantara','Aceh','08783797165','M','ArgaBima@gmail.com','2019-02-22','true');