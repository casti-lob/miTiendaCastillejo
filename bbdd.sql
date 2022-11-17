CREATE DATABASE miTiendaCastillejo;

CREATE TABLE miTiendaCastillejo.USERS
	(nick		varchar(100),
    password 		VARCHAR(32),
	name 		VARCHAR(200),
    
    dateUser	DATE,
    gender		boolean,
    admin		boolean,
	CONSTRAINT pk_users PRIMARY KEY (nick)
	);
    
CREATE TABLE miTiendaCastillejo.CATEGORY
	(code_cat 		int(8) AUTO_INCREMENT, 
     name 		varchar(100),
     description    varchar(300),
     CONSTRAINT pk_category PRIMARY KEY (code_cat)
    );
CREATE TABLE miTiendaCastillejo.ELEMENT
	(code_ele 		int(8) AUTO_INCREMENT,
    name_ele		varchar(100) unique,
    description_ele varchar(300),
    price			double(8,3),
     code_cat 		int(8),
     img 			blob,
     
    CONSTRAINT pk_element PRIMARY KEY (code_ele),
    CONSTRAINT fk_element FOREIGN KEY (code_cat) REFERENCES miTiendaCastillejo.CATEGORY(code_cat) ON DELETE CASCADE
    );
CREATE TABLE miTiendaCastillejo.PRODUCT
	(nick		varchar(100),
     code_ele	int(8),
     number		int(8),
     price		double(8,3),
     dateBuy 	date,
     CONSTRAINT pk_product PRIMARY KEY (nick,code_ele,dateBuy),
     CONSTRAINT fk_product_user FOREIGN KEY (nick) REFERENCES miTiendaCastillejo.USERS (nick) ON DELETE CASCADE,
     CONSTRAINT fk_product_element FOREIGN KEY (code_ele) REFERENCES miTiendaCastillejo.ELEMENT (code_ele) ON DELETE CASCADE
       );
       
insert into miTiendaCastillejo.USERS (nick, password, name, dateUser, gender, admin) values ('jose', md5('user'), 'Jose', '2022-07-8', true, false);



insert into CATEGORY (code_cat, name, description) values (1, 'Comedy', 'Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones');
insert into CATEGORY (code_cat, name, description) values (2, 'Romance', 'Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones');
insert into CATEGORY (code_cat, name, description) values (3, 'Adventure', 'Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones');
insert into CATEGORY (code_cat, name, description) values (4, 'Drama', 'Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones');
insert into CATEGORY (code_cat, name, description) values (5, 'Action', 'Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones');
insert into CATEGORY (code_cat, name, description) values (6, 'Drama', 'Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones');






insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (1, 'Day of the Outlaw', 93, 6);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (2, 'Brand Upon the Brain!', 43, 1);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (3, '...All the Marbles (California Dolls, The)', 84, 2);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (4, 'Thérèse', 69, 4);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (5, 'Big Bird Cage, The', 94, 3);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (6, 'Red Elvis, The (Der rote Elvis)', 87, 6);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (7, 'Ocean''s Twelve', 53, 5);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (8, 'Anzio', 86, 5);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (9, 'Gun Woman', 35, 1);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (10, 'My Little Pony: Equestria Girls', 55, 3);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (11, 'Kiss for Corliss, A (Almost a Bride)', 65, 5);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (12, 'Let It Ride', 32, 4);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (13, 'Who Are you Polly Maggoo (Qui êtes-vous, Polly Maggoo?)', 53, 1);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (14, 'Night of the Comet', 28, 2);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (15, 'Shades of Ray', 79, 3);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (16, 'Blue City', 61, 1);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (17, 'Sharkwater', 55, 2);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (18, 'Something to Sing About', 44, 5);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (19, 'Flying Scotsman, The', 35, 4);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (20, 'Man Called Sledge, A', 59, 1);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (21, 'Fat City', 39, 5);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (22, 'Campfire Tales', 55, 1);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (23, 'Pahat pojat', 15, 1);
insert into miTiendaCastillejo.ELEMENT (code_ele, name_ele, price, code_cat) values (24, 'Autumn Tale, An (Conte d''automne)', 53, 6);


insert into miTiendaCastillejo.PRODUCT (nick, code_ele, number, price, dateBuy) values ('jose', 3, 3, 64.0388, '2022-07-8');

insert into miTiendaCastillejo.PRODUCT (nick, code_ele, number, price, dateBuy) values ('jose', 8, 4, 61.6396,  '2022-07-8');

insert into miTiendaCastillejo.PRODUCT (nick, code_ele, number, price, dateBuy) values ('jose', 7, 3, 23.5821,   '2022-07-8');
insert into miTiendaCastillejo.PRODUCT (nick, code_ele, number, price, dateBuy) values ('jose', 12, 5, 38.9408,  '2022-07-8');


insert into miTiendaCastillejo.PRODUCT (nick, code_ele, number, price, dateBuy) values ('jose', 1, 5, 27.3501,  '2022-07-8');


insert into miTiendaCastillejo.PRODUCT (nick, code_ele, number, price, dateBuy) values ('jose', 14, 3, 49.691,   '2022-07-8');

insert into miTiendaCastillejo.PRODUCT (nick, code_ele, number, price, dateBuy) values ('jose', 13, 4, 22.2505,  '2022-07-8');

CREATE USER 'castillejo'@'% IDENTIFIED BY 'jose';
GRANT ALL PRIVILIEGES ON miTiendaCastillejo.* TO 'castillejo'@'%';






