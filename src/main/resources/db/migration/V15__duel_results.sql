create schema duel_results;

create table duel_results.duel_results
(
    id uuid not null
        constraint duel_results_pk
            primary key,
    participant_id uuid not null
        constraint duel_results_participants_id_fk
            references participants.participants
            on update cascade on delete cascade,
    duel_id uuid not null
        constraint duel_results_duel_id_fk
            references duel.duel
            on update cascade on delete cascade,
    points int default 0 not null
);