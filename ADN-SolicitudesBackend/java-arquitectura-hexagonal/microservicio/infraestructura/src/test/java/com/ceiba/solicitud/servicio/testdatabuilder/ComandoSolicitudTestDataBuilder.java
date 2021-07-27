package com.ceiba.solicitud.servicio.testdatabuilder;

import com.ceiba.solicitud.comando.ComandoSolicitud;

import java.util.UUID;

public class ComandoSolicitudTestDataBuilder {

	private Long id;
	private String descripcion;
	private String tipoDeSolicitud;
	private String estado;
	private Long idCliente;
	private Long clienteCelularContacto;
	private String respuestaSolicitud;

	public ComandoSolicitudTestDataBuilder ComandoCreaSolicitudTestDataBuilder() {
		this.id=1L;
		this.descripcion = UUID.randomUUID().toString().concat(" ESTA ES UNA DESCRIPCION DE SOLICITUDs");
		this.tipoDeSolicitud = "QUEJA";
		this.estado = "CREADO";
		this.idCliente = 123444L;
		this.clienteCelularContacto = 3148165758L;
		return this;
	}
	public ComandoSolicitudTestDataBuilder comandoActualizaSolicitudTestDataBuilder() {
		this.id=1L;
		this.descripcion = UUID.randomUUID().toString().concat(" ESTA ES UNA DESCRIPCION DE SOLICITUDs");
		this.respuestaSolicitud="Respuesta prueba unitaria";
		this.estado = "EN_PROGRESO";
		return this;
		
	}
	
	

	public ComandoSolicitud build() {
		return new ComandoSolicitud(this.id, this.descripcion, this.tipoDeSolicitud, this.estado, this.idCliente, this.clienteCelularContacto,
				this.respuestaSolicitud);
	}
}
