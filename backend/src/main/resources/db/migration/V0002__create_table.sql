create table login_history (
  id bigint not null auto_increment,
  email varchar(255) not null,
  ind_login_sucess varchar(1) not null,
  login_date DATE not null,

  primary key (id)
);