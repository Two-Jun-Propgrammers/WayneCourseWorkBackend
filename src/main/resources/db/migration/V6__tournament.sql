create schema tournament;

create table tournament.tournament
(
    id uuid not null
        constraint tournament_pk
            primary key,
    name varchar not null,
    beginning date not null,
    ending date,
    arena_id uuid not null
        constraint tournament_arena_id_fk
            references arena.arena
            on update cascade on delete cascade
);

create unique index tournament_name_uindex
	on tournament.tournament (name);