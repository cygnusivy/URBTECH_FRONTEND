create table images (
  id bigint not null auto_increment,
  id_usuario bigint not null,
  imagens varchar(1) not null,
  login_date DATE not null,

  primary key (id)
);