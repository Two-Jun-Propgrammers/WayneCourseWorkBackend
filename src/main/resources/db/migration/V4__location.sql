create schema location;

create table location.location
(
    id uuid not null
        constraint location_pk
            primary key,
    city varchar not null,
    street varchar,
    house int
);