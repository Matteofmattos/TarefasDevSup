INSERT INTO tb_participante (id,nome,email) VALUES (1,'José Silva','Jose@gmail.com');
INSERT INTO tb_participante (id,nome,email) VALUES (2,'Thiago Faria','Tiago@gmail.com');
INSERT INTO tb_participante (id,nome,email) VALUES (3,'Maria do Rosário','maria@gmail.com');
INSERT INTO tb_participante (id,nome,email) VALUES (4,'Tereza Silva','tereza@gmail.com');

INSERT INTO tb_categoria (id,descricao) VALUES (1,'Curso');
INSERT INTO tb_categoria (id,descricao) VALUES (2,'Oficina');

INSERT INTO tb_atividade (id,categoria_id,preco,descricao,nome) VALUES (1,1,80,'Aprenda HTML de forma prática','Curso de HTML');
INSERT INTO tb_atividade (id,categoria_id,preco,descricao,nome) VALUES (2,2,50,'Controle versões de seus projetos','Oficina de Github');

INSERT INTO tb_participante_atividade (atividade_id, participante_id) VALUES (1, 1);
INSERT INTO tb_participante_atividade (atividade_id, participante_id) VALUES (1, 2);
INSERT INTO tb_participante_atividade (atividade_id, participante_id) VALUES (1, 3);
INSERT INTO tb_participante_atividade (atividade_id, participante_id) VALUES (2, 4);
INSERT INTO tb_participante_atividade (atividade_id, participante_id) VALUES (2, 3);


INSERT INTO tb_bloco (id, atividade_id, inicio, fim) VALUES (1,1,TIMESTAMP WITH TIME ZONE '2017-09-25T08:00:00Z',TIMESTAMP WITH TIME ZONE '2017-09-25T11:00:00Z');
INSERT INTO tb_bloco (id, atividade_id, inicio, fim) VALUES (2,2,TIMESTAMP WITH TIME ZONE '2017-09-25T14:00:00Z',TIMESTAMP WITH TIME ZONE '2017-09-25T18:00:00Z');
INSERT INTO tb_bloco (id, atividade_id, inicio, fim) VALUES (3,2,TIMESTAMP WITH TIME ZONE '2017-09-26T08:00:00Z',TIMESTAMP WITH TIME ZONE '2017-09-26T11:00:00Z');