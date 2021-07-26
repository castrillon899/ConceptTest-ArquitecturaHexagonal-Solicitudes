package com.ceiba.solicitud.comando.fabrica;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.ceiba.solicitud.comando.ComandoSolicitud;
import com.ceiba.solicitud.modelo.entidad.Solicitud;

@Component
public class FabricaSolicitud {

	private static final String CREADA = "CREADA";

	public Solicitud crear(ComandoSolicitud comandoUsuario) {

		/*
		LocalDateTime now = LocalDateTime.now();
		return Solicitud.builder().id(comandoUsuario.getId()).descripcion(comandoUsuario.getDescripcion())
				.tipoDeSolicitud(comandoUsuario.getTipoDeSolicitud()).estado(CREADA).fechaCreacion(now)
				.fechaActualizacion(now).idCliente(comandoUsuario.getIdCliente())
				.clienteCelularContacto(comandoUsuario.getClienteCelularContacto()).build();
				*/

		
		  return new Solicitud(comandoUsuario.getId(), comandoUsuario.getDescripcion(),
		  comandoUsuario.getTipoDeSolicitud(), "CREADA", LocalDateTime.now(),
		  LocalDateTime.now(), comandoUsuario.getIdCliente(),
		  comandoUsuario.getClienteCelularContacto());
		  
		  
		 
	}

//Long id, String descripcion, String tipoDeSolicitud, String estado, LocalDateTime fechaCreacion
}
