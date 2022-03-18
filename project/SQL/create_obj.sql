create table corsista(
	cod_corsista int,
	nome_corsista varchar2(30) not null,
	cognome_corsista varchar2(30) not null,
	prec_form number(1,0) not null,
	constraint p_cod_corsista primary key(cod_corsista));

create sequence corsista_seq;

create table amministratore(
	cod_admin int,
	nome_admin varchar2(30) not null,
	cognome_admin varchar2(30) not null,
	constraint p_cod_admin primary key(cod_admin));
	
create table docente(
	cod_docente int,
	nome_docente varchar2(30) not null,
	cognome_docente varchar2(30) not null,
	cv_docente varchar2(200) not null,
	constraint p_cod_docente primary key(cod_docente));

create table corso(
	cod_corso int, 
	nome_corso varchar2(30) not null,
	data_inizio date not null,
	data_fine date not null,
	costo_corso number(8,2) not null,
	commenti varchar2(200) not null,
	aula_corso varchar2(30) not null,
	docente int,
	constraint p_cod_corso primary key(cod_corso),
	constraint f_docente foreign key(docente) references docente(cod_docente) on delete cascade);
	
create table corso_corsista(
	cod_corso int,
	cod_corsista int,
	constraint p_cc primary key(cod_corso, cod_corsista),
	constraint f_cod_corso foreign key(cod_corso) references corso(cod_corso) on delete cascade,
	constraint f_cod_corsista foreign key(cod_corsista) references corsista(cod_corsista) on delete cascade);

