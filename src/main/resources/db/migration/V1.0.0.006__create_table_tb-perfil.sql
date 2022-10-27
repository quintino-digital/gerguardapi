drop table if exists tb_perfil;
create table if not exists tb_perfil (
    codigo serial not null,
    descricao_papel_usuario_acesso varchar not null,
    constraint pk_perfil primary key (codigo)
);

insert into tb_perfil (descricao_papel_usuario_acesso) values ('ROLE_ADMIN'); 
insert into tb_perfil (descricao_papel_usuario_acesso) values ('ROLE_USER');