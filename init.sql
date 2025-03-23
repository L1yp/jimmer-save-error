create database if not exists `jimmer-err`;

create table if not exists user
(
    id         bigint unsigned auto_increment
        primary key,
    username   varchar(64)     not null,
    nickname   varchar(64)     not null,
    status     int default 0   not null,
    updated_at datetime        not null,
    updated_by bigint unsigned not null,
    created_at datetime        not null,
    created_by bigint          not null,
    constraint uidx_username
        unique (username)
);

create table if not exists role
(
    id         bigint unsigned auto_increment
        primary key,
    code       varchar(64)     not null,
    name       varchar(64)     not null,
    order_no   int default 0   not null,
    status     int default 0   not null,
    updated_at datetime        not null,
    updated_by bigint unsigned not null,
    created_at datetime        not null,
    created_by bigint unsigned not null,
    constraint uidx_code
        unique (code)
);

create table if not exists user_role_mapping
(
    user_id bigint unsigned not null,
    role_id bigint unsigned not null,
    primary key (user_id, role_id)
);