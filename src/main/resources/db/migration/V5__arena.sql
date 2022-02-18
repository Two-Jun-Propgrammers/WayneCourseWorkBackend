create schema arena;

create table arena.arena
(
    id uuid not null
        constraint arena_pk
            primary key,
    name varchar not null,
    location_id uuid not null
        constraint arena_location_id_fk
            references location.location
            on update cascade on delete cascade
);

create unique index arena_location_id_uindex
	on arena.arena (location_id);

create unique index arena_name_uindex
	on arena.arena (name);
