drop table if exists tb_usuario_perfil;
create table if not exists tb_usuario_perfil (
    codigo serial not null,
    id_usuario uuid not null,
    id_perfil integer not null, 
    constraint pk_usuario_perfil primary key (codigo)
);

insert into tb_usuario_perfil (id_usuario, id_perfil) values (
	    '15b0fff1-8808-4e48-a1e9-ebb1b4a33462',
	    1
);

insert into tb_usuario_perfil (id_usuario, id_perfil) values (
	    '29d7082b-d420-457c-8c10-c9a00d8492f0',
	    2
);    