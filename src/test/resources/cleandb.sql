
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

create table user_asset
(
  user_asset_id int auto_increment,
  buy_price     double(13, 2) not null,
  sell_price    double(13, 2) null,
  buy_date      date          not null,
  sell_date     date          null,
  asset_name    varchar(20)   not null,
  user_id       int           not null,
  asset_id      int           not null,
  qty           int           null,
  constraint user_asset_user_asset_id_uindex
    unique (user_asset_id),
  constraint user_asset_user_id_fk
    foreign key (user_id) references user (user_id)
      on delete cascade
);

alter table user_asset
  add primary key (user_asset_id);

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
    foreign key (id) references user (user_id)
      on delete cascade
);

alter table role
  add primary key (id);



INSERT INTO user (user_id, email, first_name, last_name, password) VALUES (1, 'kdkoberle@madisoncollege.edu', 'Keith', 'Koberle', '123456');
INSERT INTO user (user_id, email, first_name, last_name, password) VALUES (2, 'jimmy@johns.com', 'Jimmy', 'John', '456789');
INSERT INTO role(email, user_id, role) VALUES ('kdkoberle@madisoncollege.edu', 1, 'admin');
INSERT INTO user_asset (user_asset_id, buy_price, sell_price, buy_date, sell_date, asset_name, user_id, asset_id) VALUES (4, 13.51, 54.21, '2015-11-12', '2018-11-11', 'INTC', 1, 1);
INSERT INTO user_asset (user_asset_id, buy_price, sell_price, buy_date, sell_date, asset_name, user_id, asset_id) VALUES (5, 14.58, null, '2018-11-08', null, 'Silver', 1, 2);
INSERT INTO user_asset (user_asset_id, buy_price, sell_price, buy_date, sell_date, asset_name, user_id, asset_id) VALUES (6, 15.21, null, '2018-11-01', null, 'Silver', 1, 2);
INSERT INTO user_asset (user_asset_id, buy_price, sell_price, buy_date, sell_date, asset_name, user_id, asset_id) VALUES (7, 1225.21, null, '2018-10-10', null, 'Gold', 1, 3);