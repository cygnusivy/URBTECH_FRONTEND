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