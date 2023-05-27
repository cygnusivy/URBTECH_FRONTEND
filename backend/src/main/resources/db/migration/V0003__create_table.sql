create table comunidade (
  id bigint not null auto_increment,
  nome_comunidade varchar(50) unique not null,
  data_criacao_comunidade datetime not null,
  qtd_usuarios bigint not null,
  qtd_limite_usuarios bigint not null,

  primary key (id)
);

create table usuario_comunidade (
    id bigint not null auto_increment,
    id_usuario bigint not null,
    id_comunidade bigint not null,

    primary key (id)
);

ALTER TABLE usuario_comunidade
ADD CONSTRAINT fk_usuario_comunidade_usuario
FOREIGN KEY (id_usuario)
REFERENCES usuario(id);

ALTER TABLE usuario_comunidade
ADD CONSTRAINT fk_usuario_comunidade_comunidade
FOREIGN KEY (id_comunidade)
REFERENCES comunidade(id);

