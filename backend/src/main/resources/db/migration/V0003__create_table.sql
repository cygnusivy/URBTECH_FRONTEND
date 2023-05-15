create table images (
  id bigint not null auto_increment,
  id_usuario bigint not null,
  img BLOB,
  primary key (id)
);