select u.*
from usuario u
where id in (


               

          select id_usuario 
        from 
			(   
					select id_usuario, cantidadSolicitudes  
					from 
					(
								select u.id id_usuario,nvl(count(s.id),0) cantidadSolicitudes from usuario u
								inner join role_usuario r on r.id_usuario =u.id
								inner join role rol on rol.id=r.id_role
								left join solicitud s
								on u.id =s.id_usuario_asignado
								where rol.nombre=:tipoSolicitud
								group by u.id
					)
					
                                        order by cantidadSolicitudes   
	
			)
        where rownum()=1
);

