drop table if exists tb_perfil_usuario_sistema;
create table if not exists tb_perfil_usuario_sistema (
    codigo serial not null,
    descricao_papel_usuario_acesso varchar not null,
    constraint pk_perfil_usuario_sistema primary key (codigo)
);

insert into tb_perfil_usuario_sistema (descricao_papel_usuario_acesso) values ('ROLE_ADMIN'); 
insert into tb_perfil_usuario_sistema (descricao_papel_usuario_acesso) values ('ROLE_USER');