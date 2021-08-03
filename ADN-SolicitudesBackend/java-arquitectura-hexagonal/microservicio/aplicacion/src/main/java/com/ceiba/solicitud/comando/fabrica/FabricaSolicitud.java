package com.ceiba.solicitud.comando.fabrica;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.ceiba.solicitud.comando.ComandoSolicitud;
import com.ceiba.solicitud.modelo.entidad.Solicitud;

@Component
public class FabricaSolicitud {

	private static final String CREADA = "CREADA";

	public Solicitud crear(ComandoSolicitud comandoUsuario) {
		LocalDateTime now = LocalDateTime.now();
		return new Solicitud(comandoUsuario.getId(), comandoUsuario.getDescripcion(),
				comandoUsuario.getTipoDeSolicitud(), CREADA, now, now, comandoUsuario.getIdCliente(),
				comandoUsuario.getClienteCelularContacto());
	}

	public Solicitud actualizar(ComandoSolicitud comandoUsuario) {
		LocalDateTime now = LocalDateTime.now();
		return new Solicitud(comandoUsuario.getId(), comandoUsuario.getEstado(), now,
				comandoUsuario.getRespuestaSolicitud());
	}

}
