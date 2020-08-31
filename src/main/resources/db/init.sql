drop table if exists votes;
drop table if exists users;
drop table if exists dishes;
drop table if exists restaurants;

drop sequence if exists global_seq;

create sequence global_seq START WITH 100000;

create table users
(
    id          bigint primary key default nextval('global_seq'),
    email       varchar not null,
    password    varchar not null,
    name        varchar not null,
    role        varchar not null default 'USER'
);

CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

create table restaurants
(
    id          bigint primary key default nextval('global_seq'),
    name        varchar not null
);

create unique index restaurants_unique_name_idx on restaurants(name);


create table votes
(
    id                    bigint primary key default nextval('global_seq'),
    date                  date  not null,
    restaurant_id         bigint not null,
    user_id               bigint not null,
    foreign key (restaurant_id ) references restaurants(id) on delete cascade,
    foreign key (user_id) references users(id) on delete cascade
);
create unique index votes_unique_date on votes(user_id,date);
create table dishes
(
    id                  bigint primary key default nextval('global_seq'),
    name                varchar not null,
    price               integer not null,
    date                date not null,
    restaurant_id       bigint not null,
    foreign key (restaurant_id) references restaurants(id) on delete cascade
);
create unique index dishes_unique_name_date_restaurant_id_idx on dishes(restaurant_id,name,date);
