# unjfsc20160528JWExamenParcial1
1° Examen Parcial de Java Web del 28 de mayo de 2016

#Script Database - Oracle

drop view v_transporte;
commit;

drop table Transporte;
commit;

drop table TipoTransporte;
commit;

drop table Marca;
commit;

drop table Modelo;
commit;

drop table TipoModelo;
commit;



create table TipoModelo(
idTipoModelo int primary key not null,
descTipoModelo varchar2(50),
fechaRegistro date
);
commit;

insert into TipoModelo values(1,'Tipo de Modelo 1',sysdate);
commit;

insert into TipoModelo values(2,'Tipo de Modelo 2',sysdate);
commit;

create table Modelo(
idModelo int primary key,
idTipoModelo int,
descModelo varchar2(50),
fechaRegistro date,
foreign key (idTipoModelo) references TipoModelo(idTipoModelo)
);
commit;

insert into Modelo values(1,2,'Modelo 1',sysdate);
commit;
insert into Modelo values(2,1,'Modelo 2',sysdate);
commit;

create table Marca(
idMarca int primary key not null,
descMarca varchar2(50),
fechaRegistro date
);
commit;

insert into Marca values(1,'Marca 1',sysdate);
commit;

insert into Marca values(2,'Marca 2',sysdate);
commit;

create table TipoTransporte(
idTipoTransporte int primary key not null,
descTipoTransporte varchar2(50),
fechaRegistro date
);
commit;

insert into TipoTransporte values(1,'Tipo Transporte 1',sysdate);
commit;

insert into TipoTransporte values(2,'Tipo Transporte 2',sysdate);
commit;

create table Transporte(
idTransporte int primary key,
idTipoTransporte int,
descTransporte varchar2(50),
costo decimal(5,2),
stock int,
idModelo int,
idMarca int,
fechaRegistro date,
foreign key (idTipoTransporte) references TipoTransporte(idTipoTransporte),
foreign key (idModelo) references Modelo(idModelo),
foreign key (idMarca) references Marca(idMarca)
);
commit;

insert into Transporte values
(1,2,'Transporte 1',100.00,10,2,2,sysdate);
commit;



create view v_transporte
as
select 
  tr.*,
  tt.descTipoTransporte,
  mo.descModelo,
  tm.descTipoModelo,
  ma.descMarca
from Transporte tr
inner join TipoTransporte tt
on tr.idTipoTransporte=tt.idTipoTransporte
inner join Modelo mo
on tr.idModelo=mo.idModelo
inner join TipoModelo tm
on mo.idTipoModelo=tm.idTipoModelo
inner join Marca ma 
on tr.idMarca=ma.idMarca
order by 1;

select * from  v_transporte;
select * from transporte;
