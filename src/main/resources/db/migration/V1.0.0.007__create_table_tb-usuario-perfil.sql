drop table if exists tb_usuario_perfil;
create table if not exists tb_usuario_perfil (
    codigo serial not null,
    id_usuario_sistema uuid not null,
    id_perfil_usuario integer not null,
    constraint pk_usuario_perfil primary key (codigo)
);