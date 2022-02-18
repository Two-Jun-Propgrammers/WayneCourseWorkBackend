create schema rounds;

create table rounds.rounds
(
    id uuid not null
        constraint rounds_pk
            primary key,
    nomination_id uuid not null
        constraint rounds_nomination_id_fk
            references nomination.nomination
            on update cascade on delete cascade,
    number int not null,
    name varchar default 'Round' not null,
    weapon_id uuid not null
        constraint rounds_weapon_category_id_fk
            references weapon_category.weapon_category
            on update cascade on delete cascade
);
