drop table if exists tb_acesso;
create table if not exists tb_acesso (
    codigo serial not null,
    id_pessoa integer not null,
    url varchar not null,
    identificador varchar not null,
    chave varchar not null,
    data_cadastro date not null,
    data_vencimento date null,
    observacao varchar null,
    is_ativo boolean not null,
    constraint pk_acesso primary key (codigo)
);