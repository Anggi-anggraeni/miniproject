CREATE TABLE list_UMKM
(
    id serial NOT NULL,
    name varchar(25) NOT NULL,
    address varchar(25),
    phone varchar(11),
    gender varchar(1),
    email varchar(25),
    date_of_register date,
    active_account boolean,
	
	titleKlaster varchar(100) not null,
	data_source varchar(100) not null,
	contact varchar(50) not null,
	date_of_filling date,
	update_of_klaster date
)
insert into list_UMKM(
	name,
	address,
	phone,
	gender,
	email,
	date_of_register,
	active_account,

	titleKlaster,
	data_source,
	contact,
	date_of_filling,
	update_of_klaster
	)
values 
('Andrian Maulana','Palembang','08783797165','M','Andrianmaulana@gmail.com','2019-06-22','true',
'Klaster Paprika di Kabupaten Bandung Provinsi Jawa Barat','KBI Bandung','KBI Bandung','2019-04-02','2019-07-07'),
('Sherly Mustika Sari','Bogor','08983705265','F','sherly.Ms@ymail.com','2019-01-02','true',
'Kelompok PSRU - Kantor Bank Indonesia Medan','Direktorat Kredit, BPR dan UMKM','DKBU','2019-04-19','2019-07-01'),	
('Arga Bima Nusantara','Aceh','08783797165','M','ArgaBima@gmail.com','2019-02-22','true',
'Klaster Tas Motif Bordir Lhokseumawe','Direktorat Kredit, BPR dan UMKM','DKBU','2019-01-21','2019-04-07');
		
select * from list_klaster
select * from list_customer
select * from list_UMKM		
	
	