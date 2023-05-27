create table usuario (
  id bigint not null auto_increment,
  img_url varchar(250),
  nome varchar(60) not null,
  email varchar(255) unique not null ,
  descricao varchar(500),
  localizacao varchar(100),
  site varchar(100),
  nascimento date,
  senha varchar(2000) not null,
  data_abertura_conta DATE,

  primary key (id)
);

create table registro_login (
  id bigint not null auto_increment,
  email varchar(255) not null,
  ind_login_sucesso varchar(1) not null,
  descricao_login varchar(100) not null,
  login_date DATE not null,

  primary key (id)
);

create table postagem (
  id bigint not null auto_increment,
  img_url varchar(250) not null,
  id_usuario bigint not null,
  descricao varchar(250),
  qtd_curtidas bigint,

  primary key (id)
);

create table comentario (
  id bigint not null auto_increment,
  id_post bigint not null,
  id_usuario_comentario bigint not null,
  comentario varchar(100),
  horario_publicacao datetime,

  primary key (id)
);

create table curtida (
  id bigint not null auto_increment,
  id_usuario_curtida bigint not null,
  id_post bigint not null,

  primary key (id)
);