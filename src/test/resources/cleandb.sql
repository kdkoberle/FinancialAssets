SET foreign_key_checks = 0;
DELETE FROM Role;
DELETE FROM User;
DELETE FROM UserAsset;
SET foreign_key_checks = 1;

create table user
(
  user_id    int auto_increment,
  email      varchar(100) not null,
  first_name varchar(50)  not null,
  last_name  varchar(50)  null,
  password   varchar(150) not null,
  constraint user_email_uindex
    unique (email),
  constraint user_user_id_uindex
    unique (user_id)
);

alter table user
  add primary key (user_id);

create table role
(
  id      int auto_increment,
  email   varchar(100) not null,
  user_id int          not null,
  role    varchar(25)  not null,
  constraint role_email_uindex
    unique (email),
  constraint role_id_uindex
    unique (id),
  constraint role_user_id_uindex
    unique (user_id),
  constraint role_user_id_fk
    foreign key (user_id) references user (user_id)
      on delete cascade
);

alter table role
  add primary key (id);

create table user_asset
(
  user_asset_id int auto_increment,
  buy_price     double(13, 2) not null,
  sell_price    double(13, 2) null,
  buy_date      date          not null,
  sell_date     date          null,
  asset_name    varchar(20)   not null,
  user_id       int           not null,
  qty           int           not null,
  fees          double(13, 2) not null,
  constraint user_asset_user_asset_id_uindex
    unique (user_asset_id),
  constraint user_asset_user_id_fk
    foreign key (user_id) references user (user_id)
      on delete cascade
);

alter table user_asset
  add primary key (user_asset_id);


INSERT INTO `user` VALUES (1,'kdkoberle@madisoncollege.edu','Keith','Koberle','123456');
INSERT INTO `user_asset` VALUES (4,13.51,54.21,'2015-11-12','2018-11-11','INTC',1,15,9.90),(5,14.58,NULL,'2018-11-08',NULL,'TSLA',1,100,4.95),(6,15.21,NULL,'2018-11-01',NULL,'STM',1,115,4.95),(7,5.15,11.73,'2018-10-10','2018-12-19','AU',1,75,9.90),(28,14.50,NULL,'2018-12-19',NULL,'AG',1,50,4.95);
INSERT INTO `role` VALUES (1,'kdkoberle@madisoncollege.edu',1,'admin');


