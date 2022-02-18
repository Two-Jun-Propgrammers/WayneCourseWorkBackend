create schema users_roles;

create table users_roles.users_roles
(
    id uuid not null
        constraint users_roles_pk
            primary key,
    user_id uuid not null
        constraint users_roles_users_id_fk
            references users.users (id)
            on update cascade on delete cascade,
    role_id uuid not null
        constraint users_roles_roles_id_fk
            references roles.roles
            on update cascade on delete cascade
);