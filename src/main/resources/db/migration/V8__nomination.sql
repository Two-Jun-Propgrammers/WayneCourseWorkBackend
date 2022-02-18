create schema nomination;

create table nomination.nomination
(
    id uuid not null
        constraint nomination_pk
            primary key,
    tournament_id uuid not null
        constraint nomination_tournament_id_fk
            references tournament.tournament
            on update cascade on delete cascade,
    name varchar not null
);