select * from usuario
where id in (
select min(u.id) from usuario u 
inner join role_usuario r on r.id_usuario=u.id
inner join role rol on rol.id=r.id_role
where rol.nombre=:tipoSolicitud
);



select min(id_usuario)
from (

select id_usuario,count(id_solicitud )
from 
(
select u.id id_usuario,s.id id_solicitud from usuarios u
inner join role_usuario r on r.id_usuario=u.id
inner join role rol on rol.id=r.id_role
left join solicitudes s
on s.id_usuario=u.id
where rol.nombre=:tipoSolicitud
)
group by id_usuario
)


select count(1) cantidad_solicitudes,id_usuario 
from solicitudes
group by id_usuario;