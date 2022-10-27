drop table if exists tb_usuario;
create table if not exists tb_usuario (
    codigo uuid not null,
    identificador varchar not null,
    chave varchar not null,
    responsavel_atualizacao varchar null,
    data_atualizacao timestamp not null default now(),
    is_ativo boolean not null default true,
    constraint pk_usuario primary key (codigo)
);

insert into tb_usuario (codigo, identificador, chave, responsavel_atualizacao, data_atualizacao) values (
    '15b0fff1-8808-4e48-a1e9-ebb1b4a33462',
    'desenvolvimento',
    '$2a$10$jmstj1w81FOPSXSsI0QGOeExkewffDjEPqRjDlOtxAqoMTOWDU4Qm',
    'GERGUARDAPI',
    now()
);