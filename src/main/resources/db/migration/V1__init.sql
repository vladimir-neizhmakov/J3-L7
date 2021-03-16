create table products (
id bigserial primary key,
title varchar(255),
cost double,
created timestamp default current_timestamp,
updated timestamp default current_timestamp,
deleted timestamp default null);

insert into products (title, cost) values
('Milk', 39.90),
('Bread', 28.20),
('Orange', 119.50),
('Apples', 87.60),
('Makaroni', 49.90),
('Sugar', 54.10),
('Chocolate', 43.30),
('Water', 19.60);