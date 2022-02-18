create schema users;

create table users.users
(
    id uuid not null
        constraint users_pk
            primary key,
    username varchar not null,
    password varchar not null,
    firstname varchar not null,
    lastname varchar not null
);

create unique index users_username_uindex
	on users.users (username);

