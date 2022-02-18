create schema platform;

create table platform.platform
(
    id uuid not null
        constraint platform_pk
            primary key,
    number int not null,
    name varchar not null
);