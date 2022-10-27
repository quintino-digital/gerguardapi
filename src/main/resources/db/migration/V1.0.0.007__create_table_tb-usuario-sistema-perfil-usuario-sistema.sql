drop table if exists tb_usuario_sistema_perfil_usuario_sistema;
create table if not exists tb_usuario_sistema_perfil_usuario_sistema (
    codigo serial not null,
    id_usuario_sistema uuid not null,
    id_perfil_usuario_sistema integer not null,
    constraint pk_usuario_sistema_perfil_usuario_sistema primary key (codigo)
);