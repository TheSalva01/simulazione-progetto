create table corso(
	cod_corso int, 
	nome_corso varchar2(30) not null,
	data_inizio date not null,
	data_fine date not null,
	costo_corso number(8,2) not null,
	commenti number(1,0) not null,
	aula_corso varchar2(3) not null,
	constraint p_cod_corso primary key(cod_corso)
)
