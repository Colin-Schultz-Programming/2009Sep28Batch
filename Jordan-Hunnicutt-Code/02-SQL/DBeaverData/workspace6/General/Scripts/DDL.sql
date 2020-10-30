--ddl
--create database jdbc_db;

create schema jdbc_db_schema;

create user jdbc_db_user with password 'wasspord';

--when working with grant or revoke, we're working with DCL (data control language) (controlling access to data)
grant all privileges on schema jdbc_db_schema to jdbc_db_user;
grant all privileges on schema public to jdbc_db_user;

grant all on table jdbc_db_schema.bear to jdbc_db_user;
grant all on table jdbc_db_schema.circus to jdbc_db_user;

insert into circus values ('clowntown', 'john', true);
insert into bear (color, has_fur, belongs_to) values ('purple', false, 'clowntown');
insert into bear (color, has_fur, belongs_to) values ('plum crazy purple', false, null);

select * from bear;
select * from circus;
-----------------------------------------------------------------------
-------Above is notes from lecture.  Below is what I used to create items for Project 0.---------
-----------------------------------------------------------------------
create schema p_0_schema;
create user p_0_user with password 'projectzero';

grant all privileges on schema p_0_schema to p_0_user;
grant all privileges on schema public to p_0_user;

create table user_account(
	userId serial primary key,
	username text unique not null,
	userPass text not null,
	userType int not null
);

create table car(
	carId serial primary key,
	make text,
	model text,
	color text,
	carYear int,
	listPrice int,
	userId int --use is 0 to determine if not owned
);

insert into car (make, model, color, carYear, listPrice, userId) values ('Chevrolet', 'Equinox', 'Blue', 2018, 16000, 0);
insert into car (make, model, color, carYear, listPrice, userId) values ('Old', 'Sedan', 'Grey', 1972, 100, 0);

create table offer(
	amount int,
	carId int,
	userId int,
	status text,
	addDate date,
	appOrRejDate date
);

create table payment(
	amount int,
	num_of int,
	carId int references car (carId),
	userId int references user_account (userId),
	purchaseDate date
);

grant all privileges on table user_account to p_0_user;
grant all privileges on table car to p_0_user;
grant all privileges on table offer to p_0_user;
grant all privileges on table payment to p_0_user;
grant all privileges on sequence user_account_userid_seq to p_0_user;
grant all privileges on sequence car_carid_seq to p_0_user;

insert into user_account (username, userpass, usertype) values ('manager', 'manager', 3);
insert into user_account (username, userpass, usertype) values ('employee1', 'employee1', 2);
insert into user_account (username, userpass, usertype) values ('customer1', 'customer1', 1);

update car set "userid" = 0 where carid = 1;
update offer set "carid" = 3 where carid = 2;

drop table car;
drop table offer;
drop table payment;

truncate table offer;

create or replace procedure auto_reject(a int, b date)
	language sql as $$
	
	update offer set (status, apporrejdate) = ('rejected', b) where (status, carid) = ('submitted', a);
	
	$$;
--call is keyword to run function
call auto_reject();