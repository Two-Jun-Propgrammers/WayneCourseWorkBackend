create schema clubs;

create table clubs.clubs
(
    id uuid not null
        constraint clubs_pk
            primary key,
    name varchar not null,
    activity bool default true not null,
    location_id uuid not null
        constraint clubs_location_id_fk
            references location.location
            on update cascade on delete cascade
);

create unique index clubs_name_uindex
	on clubs.clubs (name);
