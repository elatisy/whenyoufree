create table user (
    id bigint(20) identity(1,1) primary key not null,
    nick varchar(30) default null,
    real_name varchar(30) default null,
    email varchar(50) default null,
    phone varchar(20) not null,
    created_at datetime default null,
    updated_at datetime default null
) engine=innodb charset=utf8;
