create table if not exists notes
(
    id INT AUTO_INCREMENT primary key,
    header varchar(200) not null,
    text varchar(3000) not null,
    created_date timestamp not null
);