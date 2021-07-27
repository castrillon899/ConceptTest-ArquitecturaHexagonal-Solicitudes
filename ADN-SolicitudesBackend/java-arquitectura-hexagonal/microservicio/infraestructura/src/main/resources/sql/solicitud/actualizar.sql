update solicitud
set     respuesta_solicitud=:respuesta,
	estado= :estado,
        fecha_actualizacion=:fechaActualizacion       
where id = :id;