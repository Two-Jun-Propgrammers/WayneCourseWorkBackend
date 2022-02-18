create schema roles;

create table roles.roles
(
    id uuid not null
        constraint roles_pk
            primary key,
    name varchar not null
);

create unique index roles_name_uindex
	on roles.roles (name);

