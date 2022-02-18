create schema judges;

create table judges.judges
(
    id uuid not null
        constraint judges_pk
            primary key,
    firstname varchar not null,
    lastname varchar not null
);
