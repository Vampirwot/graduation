delete from users;
delete from restaurants;
delete from dishes;
delete from votes;
alter sequence global_seq restart with 100000;

insert into users(email,password,name,role)
values  ('user@yandex.ru','user','user','USER'),
        ('admin@yandex.ru','admin','admin','ADMIN');

insert into restaurants(name)
values ('Shore House'),
       ('Высота 5642'),
       ('Чайка. Ресторан-яхта');

insert into dishes(name, price, date, restaurant_id)
values ('Первое блюдо',1000,now() + interval '1 day',100002),
       ('Второе блюдо',1500,now() + interval '1 day',100002),
       ('Первое блюдо',1000,now() + interval '1 day',100003),
       ('Второе блюдо',6000,now() + interval '2 day',100003),
       ('Первое блюдо',500,now() + interval '1 day',100004),
       ('Второе блюдо',450,now() + interval '1 day',100004),
       ('Третье блюдо',600,now() + interval '1 day',100004);
