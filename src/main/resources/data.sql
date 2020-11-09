-- Brand

insert into brand (id, name) values (1, 'Citroën');
insert into brand (id, name) values (2, 'Ford');
insert into brand (id, name) values (3, 'Mercedes');
insert into brand (id, name) values (4, 'BMW');
insert into brand (id, name) values (5, 'Volkswagen');

-- Concessionnaire

insert into concessionnaire (id, name) values (1, 'Concessionnaire Seclin');
insert into concessionnaire (id, name) values (2, 'Concessionnaire Lesquin');
insert into concessionnaire (id, name) values (3, 'Concessionnaire Lille');
insert into concessionnaire (id, name) values (4, 'Concessionnaire Ronchin');
insert into concessionnaire (id, name) values (5, 'Concessionnaire Paris');

-- Address

insert into address (id, num, street, cp, city, concessionnaire_id) values (1, 1, 'rue Ravel', 59113, 'Seclin', 1);
insert into address (id, num, street, cp, city, concessionnaire_id) values (2, 27, 'rue René Cassin', 59810, 'Lesquin', 2);
insert into address (id, num, street, cp, city, concessionnaire_id) values (3, 12, 'place Victor Hugo', 59000, 'Lille', 3);
insert into address (id, num, street, cp, city, concessionnaire_id) values (4, 119, 'rue de la Vigne', 59790, 'Ronchin', 4);
insert into address (id, num, street, cp, city, concessionnaire_id) values (5, 20, 'avenue des Champs-Elysées', 75108, 'Paris', 5);

-- Client

insert into client (id, firstname, lastname) values (1, 'Antoine', 'Mortelier');
insert into client (id, firstname, lastname) values (2, 'Logan', 'Chenavier');
insert into client (id, firstname, lastname) values (3, 'Cathy', 'Houdart');
insert into client (id, firstname, lastname) values (4, 'Alexandre', 'Janaszek');
insert into client (id, firstname, lastname) values (5, 'Pierre', 'Mullier');
insert into client (id, firstname, lastname) values (6, 'Dimitri', 'Bazille');
insert into client (id, firstname, lastname) values (7, 'Emilie', 'Bourget');
insert into client (id, firstname, lastname) values (8, 'Gaylord', 'Thuaudait');
insert into client (id, firstname, lastname) values (9, 'Jacques', 'Bertoneche');
insert into client (id, firstname, lastname) values (10, 'Heloïse', 'Fouillard');

-- Car

insert into car (id, name, brand_id, client_id) values (1, 'C3', 1, 1);
insert into car (id, name, brand_id, client_id) values (2, 'DS 7', 1, 2);
insert into car (id, name, brand_id, client_id) values (3, 'Mustang', 2, 3);
insert into car (id, name, brand_id, client_id) values (4, 'Fiesta', 2, 4);
insert into car (id, name, brand_id, client_id) values (5, 'Classe A Berline', 3, 5);
insert into car (id, name, brand_id, client_id) values (6, 'Classe B', 3, 6);
insert into car (id, name, brand_id, client_id) values (7, 'X5', 4, 7);
insert into car (id, name, brand_id, client_id) values (8, 'Z4', 4, 8);
insert into car (id, name, brand_id, client_id) values (9, 'Golf', 5, 9);
insert into car (id, name, brand_id, client_id) values (10, 'Polo', 5, 10);

-- Jointure (Brand - Concessionnaire)

insert into brand_concessionnaire (brand_id, concessionnaire_id) values (1, 1);
insert into brand_concessionnaire (brand_id, concessionnaire_id) values (2, 2);
insert into brand_concessionnaire (brand_id, concessionnaire_id) values (3, 3);
insert into brand_concessionnaire (brand_id, concessionnaire_id) values (4, 4);
insert into brand_concessionnaire (brand_id, concessionnaire_id) values (5, 5);
