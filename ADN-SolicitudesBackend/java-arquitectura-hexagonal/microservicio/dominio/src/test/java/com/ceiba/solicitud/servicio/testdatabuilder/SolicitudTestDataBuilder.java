package com.ceiba.solicitud.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.solicitud.modelo.entidad.Solicitud;


public class SolicitudTestDataBuilder {

	Long id;
	String descripcion;
	String tipoDeSolicitud;
	String estado;
	LocalDateTime fechaCreacion;
	LocalDateTime fechaActualizacion;
	Long idCliente;
	Long clienteCelularContacto;

	public SolicitudTestDataBuilder solicitudTipoQueja() {

		id = 1L;
		descripcion = "text";
		tipoDeSolicitud = "QUEJA";
		estado = "CREADO";
		fechaCreacion = LocalDateTime.now();
		fechaActualizacion = LocalDateTime.now();

		idCliente = 123L;
		clienteCelularContacto = 123L;
		return this;

	}
	
	public SolicitudTestDataBuilder solicitudTipoSolicitud() {

		id = 1L;
		descripcion = "text";
		tipoDeSolicitud = "SOLICITUD";
		estado = "CREADO";
		fechaCreacion = LocalDateTime.now();
		fechaActualizacion = LocalDateTime.now();

		idCliente = 123L;
		clienteCelularContacto = 123L;
		return this;

	}

	
	public SolicitudTestDataBuilder solicitudTipoSolitudInvalida() {

		id = 1L;
		descripcion = "text";
		tipoDeSolicitud = "ERRORTIPO";
		estado = "CREADO";
		fechaCreacion = LocalDateTime.now();
		fechaActualizacion = LocalDateTime.now();

		idCliente = 123L;
		clienteCelularContacto = 123L;
		return this;

	}


	public Solicitud build() {
		return new Solicitud(id, descripcion, tipoDeSolicitud, estado, fechaCreacion, fechaActualizacion, idCliente,
				clienteCelularContacto);
	}
}
