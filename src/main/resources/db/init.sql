drop table if exists Test;
drop sequence if exists global_seq;

create sequence global_seq START WITH 100000;

create table Test
(
    id  bigint primary key default nextval('global_seq'),
    name    varchar not null
);