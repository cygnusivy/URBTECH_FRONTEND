create table user_registration (
  id bigint not null auto_increment,
  name varchar(60) not null,
  email varchar(255) unique not null ,
  descricao varchar(500),
  localizacao varchar(100),
  site varchar(100),
  nascimento date,
  password varchar(2000) not null,
  account_creation_date DATE,
  account_deactivation_date DATE,

  primary key (id)
);