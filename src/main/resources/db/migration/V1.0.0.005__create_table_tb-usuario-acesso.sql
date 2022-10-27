drop table if exists tb_usuario_acesso;
create table if not exists tb_usuario_acesso (
    codigo uuid not null,
    identificador varchar not null,
    chave varchar not null,
    responsavel_atualizacao varchar null,
    data_atualizacao timestamp not null default now(),
    is_ativo boolean not null default true,
    constraint pk_usuario_acesso primary key (codigo)
);