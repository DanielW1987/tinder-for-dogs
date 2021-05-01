create table if not exists rated_dog
(
    id bigserial not null
        constraint rated_dog_pkey
            primary key,
    image_url varchar(255) not null,
    name varchar(255) not null,
    rating varchar(255) not null
);

alter table rated_dog owner to qlbcaawnfiiuno;
