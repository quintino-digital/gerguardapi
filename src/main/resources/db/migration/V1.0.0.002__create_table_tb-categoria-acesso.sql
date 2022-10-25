drop table if exists tb_categoria_acesso;
create table if not exists tb_categoria_acesso (
    codigo serial not null,
    descricao varchar null,
    constraint pk_categoria_acesso primary key (codigo)
);