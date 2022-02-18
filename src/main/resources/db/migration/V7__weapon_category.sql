create schema weapon_category;

create table weapon_category.weapon_category
(
    id uuid not null
        constraint weapon_category_pk
            primary key,
    name varchar not null
);

create unique index weapon_category_name_uindex
	on weapon_category.weapon_category (name);