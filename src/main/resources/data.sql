insert into concessionnaire (id, name) values (1, 'Concessionnaire Seclin');
insert into concessionnaire (id, name) values (2, 'Concessionnaire Lesquin');
insert into concessionnaire (id, name) values (3, 'Concessionnaire Lille');

insert into brand (id, name) values (1, 'Kawasaki');
insert into brand (id, name) values (2, 'Yamaha');
insert into brand (id, name) values (3, 'BMW');

insert into car (id, name, brand_id) values (1, 'er-6n', 1);
insert into car (id, name, brand_id) values (2, 'ninja', 1);
insert into car (id, name, brand_id) values (3, 'mt-07', 2);
insert into car (id, name, brand_id) values (4, 'yzf', 2);
insert into car (id, name, brand_id) values (5, 'z4', 3);

insert into brand_concessionnaire (brand_id, concessionnaire_id) values (1, 1);
insert into brand_concessionnaire (brand_id, concessionnaire_id) values (1, 2);
insert into brand_concessionnaire (brand_id, concessionnaire_id) values (2, 3);