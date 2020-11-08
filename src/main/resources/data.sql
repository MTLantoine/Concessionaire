insert into concessionnaire (id, name) values (1, 'Concessionnaire Seclin');
insert into concessionnaire (id, name) values (2, 'Concessionnaire Lesquin');
insert into concessionnaire (id, name) values (3, 'Concessionnaire Lille');

insert into brand (id, name) values (1, 'Kawasaki');
insert into brand (id, name) values (2, 'Yamaha');
insert into brand (id, name) values (3, 'BMW');

insert into brand_concessionnaire (brand_id, concessionnaire_id) values (1, 1);
insert into brand_concessionnaire (brand_id, concessionnaire_id) values (2, 1);
insert into brand_concessionnaire (brand_id, concessionnaire_id) values (3, 2);