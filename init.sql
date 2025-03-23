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

INSERT INTO role (id, code, name, order_no, status, updated_at, updated_by, created_at, created_by) VALUES (1, 'admin', '系统管理员', 1, 1, '2025-03-24 00:45:49', 1, '2025-03-24 00:45:45', 1);
INSERT INTO role (id, code, name, order_no, status, updated_at, updated_by, created_at, created_by) VALUES (2, 'default', '成员', 2, 1, '2025-03-24 00:46:10', 1, '2025-03-24 00:46:13', 1);
