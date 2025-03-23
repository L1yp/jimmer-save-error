create table user
(
    id         integer not null constraint user_pk primary key,
    created_at integer not null
);

create table role
(
    id         integer not null constraint role_pk primary key,
    created_at integer not null
);


create table user_role_mapping
(
    user_id integer not null,
    role_id integer not null,
    constraint user_role_pk primary key(user_id, role_id)
);

