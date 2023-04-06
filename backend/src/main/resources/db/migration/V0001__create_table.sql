create table user_registration (
  id bigint not null auto_increment,
  name varchar(60) not null,
  email varchar(255) not null,
  password varchar(2000) not null,
  account_creation_date DATE,
  account_deactivation_date DATE,

  primary key (id)
);