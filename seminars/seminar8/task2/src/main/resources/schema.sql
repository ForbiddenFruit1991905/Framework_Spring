create table if not exists account (
    id int not null auto_increment primary key,
    name varchar(50) not null,
    amount double not null
);