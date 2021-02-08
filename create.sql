create table country (id int4 not null, iso_code varchar(255), last_observation_date date, name varchar(255), source_name varchar(255), source_website varchar(255), primary key (id))
create table country_vaccine (country_id int4 not null, vaccine_id int4 not null)
create table vaccination_series (id int8 not null, daily_vaccinations_raw int8, daily_vaccinations int8, daily_vaccinations_per_million int8, date date, people_fully_vaccinated_per_hundred float8, people_fully_vaccinated int8, people_vaccinated int8, people_vaccinated_per_hundred float8, total_vaccinations_per_hundred float8, total_vaccinations int8, country_id int4, primary key (id))
create table vaccine (id int4 not null, name varchar(255), primary key (id))
create table world_series (id int4 not null, daily_vaccinations_raw int8, daily_vaccinations int8, daily_vaccinations_per_million int8, date date, people_fully_vaccinated_per_hundred float8, iso_code varchar(255), name varchar(255), people_fully_vaccinated int8, people_vaccinated int8, people_vaccinated_per_hundred float8, total_vaccinations_per_hundred float8, total_vaccinations int8, primary key (id))
alter table if exists country_vaccine add constraint FKg2yjbuqvw8dx497l0a5bj3s0s foreign key (vaccine_id) references vaccine
alter table if exists country_vaccine add constraint FKbc620u45htqes0k3y4g53phtf foreign key (country_id) references country
alter table if exists vaccination_series add constraint FKt13u9yhu93p1qpkdctsy4vui1 foreign key (country_id) references country
create table country (id int4 not null, iso_code varchar(255), last_observation_date date, name varchar(255), source_name varchar(255), source_website varchar(255), primary key (id))
create table country_vaccine (country_id int4 not null, vaccine_id int4 not null)
create table vaccination_series (id int8 not null, daily_vaccinations_raw int8, daily_vaccinations int8, daily_vaccinations_per_million int8, date date, people_fully_vaccinated_per_hundred float8, people_fully_vaccinated int8, people_vaccinated int8, people_vaccinated_per_hundred float8, total_vaccinations_per_hundred float8, total_vaccinations int8, country_id int4, primary key (id))
create table vaccine (id int4 not null, name varchar(255), primary key (id))
create table world_series (id int4 not null, daily_vaccinations_raw int8, daily_vaccinations int8, daily_vaccinations_per_million int8, date date, people_fully_vaccinated_per_hundred float8, iso_code varchar(255), name varchar(255), people_fully_vaccinated int8, people_vaccinated int8, people_vaccinated_per_hundred float8, total_vaccinations_per_hundred float8, total_vaccinations int8, primary key (id))
alter table if exists country_vaccine add constraint FKg2yjbuqvw8dx497l0a5bj3s0s foreign key (vaccine_id) references vaccine
alter table if exists country_vaccine add constraint FKbc620u45htqes0k3y4g53phtf foreign key (country_id) references country
alter table if exists vaccination_series add constraint FKt13u9yhu93p1qpkdctsy4vui1 foreign key (country_id) references country
create table country (id int4 not null, iso_code varchar(255), last_observation_date date, name varchar(255), source_name varchar(255), source_website varchar(255), primary key (id))
create table country_vaccine (country_id int4 not null, vaccine_id int4 not null)
create table vaccination_series (id int8 not null, daily_vaccinations_raw int8, daily_vaccinations int8, daily_vaccinations_per_million int8, date date, people_fully_vaccinated_per_hundred float8, people_fully_vaccinated int8, people_vaccinated int8, people_vaccinated_per_hundred float8, total_vaccinations_per_hundred float8, total_vaccinations int8, country_id int4, primary key (id))
create table vaccine (id int4 not null, name varchar(255), primary key (id))
create table world_series (id int4 not null, daily_vaccinations_raw int8, daily_vaccinations int8, daily_vaccinations_per_million int8, date date, people_fully_vaccinated_per_hundred float8, iso_code varchar(255), name varchar(255), people_fully_vaccinated int8, people_vaccinated int8, people_vaccinated_per_hundred float8, total_vaccinations_per_hundred float8, total_vaccinations int8, primary key (id))
alter table if exists country_vaccine add constraint FKg2yjbuqvw8dx497l0a5bj3s0s foreign key (vaccine_id) references vaccine
alter table if exists country_vaccine add constraint FKbc620u45htqes0k3y4g53phtf foreign key (country_id) references country
alter table if exists vaccination_series add constraint FKt13u9yhu93p1qpkdctsy4vui1 foreign key (country_id) references country
create table country (id int4 not null, iso_code varchar(255), last_observation_date date, name varchar(255), source_name varchar(255), source_website varchar(255), primary key (id))
create table country_vaccine (country_id int4 not null, vaccine_id int4 not null)
create table vaccination_series (id int8 not null, daily_vaccinations_raw int8, daily_vaccinations int8, daily_vaccinations_per_million int8, date date, people_fully_vaccinated_per_hundred float8, people_fully_vaccinated int8, people_vaccinated int8, people_vaccinated_per_hundred float8, total_vaccinations_per_hundred float8, total_vaccinations int8, country_id int4, primary key (id))
create table vaccine (id int4 not null, name varchar(255), primary key (id))
create table world_series (id int4 not null, daily_vaccinations_raw int8, daily_vaccinations int8, daily_vaccinations_per_million int8, date date, people_fully_vaccinated_per_hundred float8, iso_code varchar(255), name varchar(255), people_fully_vaccinated int8, people_vaccinated int8, people_vaccinated_per_hundred float8, total_vaccinations_per_hundred float8, total_vaccinations int8, primary key (id))
alter table if exists country_vaccine add constraint FKg2yjbuqvw8dx497l0a5bj3s0s foreign key (vaccine_id) references vaccine
alter table if exists country_vaccine add constraint FKbc620u45htqes0k3y4g53phtf foreign key (country_id) references country
alter table if exists vaccination_series add constraint FKt13u9yhu93p1qpkdctsy4vui1 foreign key (country_id) references country
