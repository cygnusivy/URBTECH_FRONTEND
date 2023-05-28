ALTER TABLE postagem
ADD CONSTRAINT fk_postagem_usuario
FOREIGN KEY (id_usuario)
REFERENCES usuario(id);

ALTER TABLE comentario
ADD CONSTRAINT fk_postagem_usuario_cmt
FOREIGN KEY (id_usuario_comentario)
REFERENCES usuario(id);

ALTER TABLE comentario
ADD CONSTRAINT fk_post
FOREIGN KEY (id_post)
REFERENCES postagem(id);

ALTER TABLE curtida
ADD CONSTRAINT fk_curtida_usuario_ctd
FOREIGN KEY (id_usuario_curtida)
REFERENCES usuario(id);

ALTER TABLE curtida
ADD CONSTRAINT fk_curtida_post
FOREIGN KEY (id_post)
REFERENCES postagem(id);

ALTER TABLE usuario_comunidade
ADD CONSTRAINT fk_usuario_comunidade_usuario
FOREIGN KEY (id_usuario)
REFERENCES usuario(id);

ALTER TABLE usuario_comunidade
ADD CONSTRAINT fk_usuario_comunidade_comunidade
FOREIGN KEY (id_comunidade)
REFERENCES comunidade(id);

ALTER TABLE registro_login
ADD CONSTRAINT fk_login_usuario
FOREIGN KEY (email)
REFERENCES usuario(email);

ALTER TABLE tags
ADD CONSTRAINT fk_tag_usuario
FOREIGN KEY (id_postagem)
REFERENCES postagem(id);

ALTER TABLE endereco
ADD CONSTRAINT fk_endereco_usuario
FOREIGN KEY (id_usuario)
REFERENCES usuario(id);

ALTER TABLE telefone
ADD CONSTRAINT fk_telefone_usuario
FOREIGN KEY (id_usuario)
REFERENCES usuario(id);