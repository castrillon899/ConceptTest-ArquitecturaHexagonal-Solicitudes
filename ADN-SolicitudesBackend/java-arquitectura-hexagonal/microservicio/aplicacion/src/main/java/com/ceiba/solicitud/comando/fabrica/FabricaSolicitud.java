package com.ceiba.solicitud.comando.fabrica;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.ceiba.solicitud.comando.ComandoSolicitud;
import com.ceiba.solicitud.modelo.entidad.Solicitud;

@Component
public class FabricaSolicitud {

	public Solicitud crear(ComandoSolicitud comandoUsuario) {

		// create an LocalDateTime object

		return new Solicitud(comandoUsuario.getId(), comandoUsuario.getDescripcion(),
				comandoUsuario.getTipoDeSolicitud(), comandoUsuario.getEstado(), LocalDateTime.now(),
				LocalDateTime.now(), comandoUsuario.getIdCliente(), comandoUsuario.getClienteCelularContacto()

		);
	}

//Long id, String descripcion, String tipoDeSolicitud, String estado, LocalDateTime fechaCreacion
}
