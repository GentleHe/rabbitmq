drop database if exists rabbitmq;
create database if not exists rabbitmq;

use rabbitmq;

create table t_order
(
  order_id varchar(128) primary key ,
  order_name varchar(128),
  message_id varchar(128) not null
);

