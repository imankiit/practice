-- INSERT SCRIPTS
truncate table city;
commit;

insert into city (city_id, city_name) values (CITY_SEQ.nextval,'DELHI');
insert into city (city_id, city_name) values (CITY_SEQ.nextval, 'MUMBAI');
insert into city (city_id, city_name) values (CITY_SEQ.nextval,'HYDERABAD');

commit;

truncate table city;
commit;

insert into THEATER (THEATER_NAME) values ('PVR');
insert into THEATER (THEATER_NAME) values ('AMB');
insert into THEATER (THEATER_NAME) values ('INOX');

commit;