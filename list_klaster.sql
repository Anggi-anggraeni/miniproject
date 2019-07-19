create table list_klaster(
id serial PRIMARY KEY not null,
	titleKlaster varchar(100) not null,
	data_source varchar(100) not null,
	contact varchar(50) not null,
	date_of_filling date,
	update_of_klaster date
);

insert into list_klaster(
	titleKlaster,
	data_source,
	contact,
	date_of_filling,
	update_of_klaster
	)
values ('Klaster Paprika di Kabupaten Bandung Provinsi Jawa Barat',
		'KBI Bandung','KBI Bandung','2019-04-02','2019-07-07'),
		 ('Kelompok PSRU - Kantor Bank Indonesia Medan',
		'Direktorat Kredit, BPR dan UMKM','DKBU','2019-04-19','2019-07-01'),
		 ('Klaster Tas Motif Bordir Lhokseumawe',
		'Direktorat Kredit, BPR dan UMKM','DKBU','2019-01-21','2019-04-07');
		
select * from list_klaster
select * from list_customer
		
	
	