create table if not exists rated_dogs
(
    id bigserial not null
        constraint rated_dogs_pkey
            primary key,
    image_url varchar(255) not null,
    name varchar(255) not null,
    rating varchar(255) not null
);

alter table rated_dogs owner to puestpknmhsypt;

create table if not exists users
(
    id bigserial not null
        constraint users_pkey
            primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    email varchar(255) not null,
    bio varchar(255) not null,
    encrypted_password varchar(60) not null
);

alter table users owner to puestpknmhsypt;
