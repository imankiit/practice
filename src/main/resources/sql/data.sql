-- INSERT SCRIPTS
truncate table city;
commit;

insert into city (city_name) values ('DELHI');
insert into city (city_name) values ('MUMBAI');
insert into city (city_name) values ('HYDERABAD');

commit;

truncate table city;
commit;

insert into THEATER (THEATER_NAME) values ('PVR');
insert into THEATER (THEATER_NAME) values ('AMB');
insert into THEATER (THEATER_NAME) values ('INOX');

commit;