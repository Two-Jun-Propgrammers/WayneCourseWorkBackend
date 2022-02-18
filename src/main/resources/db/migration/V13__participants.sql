create schema participants;

create table participants.participants
(
    id uuid not null
        constraint participants_pk
            primary key,
    number serial not null,
    firstname varchar not null,
    lastname varchar not null,
    club_id uuid
        constraint participants_clubs_id_fk
            references clubs.clubs
            on update cascade on delete set null
);

create unique index participants_number_uindex
	on participants.participants (number);