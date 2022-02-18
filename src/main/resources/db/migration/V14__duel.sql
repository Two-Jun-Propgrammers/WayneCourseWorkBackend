create schema duel;

create table duel.duel
(
    id uuid not null
        constraint duel_pk
            primary key,
    round_id uuid not null
        constraint duel_rounds_id_fk
            references rounds.rounds
            on update cascade on delete cascade,
    number int not null,
    judges_id uuid not null
        constraint duel_judges_id_fk
            references judges.judges
            on update cascade on delete cascade,
    platform_id uuid not null
        constraint duel_platform_id_fk
            references platform.platform
            on update cascade on delete cascade
);