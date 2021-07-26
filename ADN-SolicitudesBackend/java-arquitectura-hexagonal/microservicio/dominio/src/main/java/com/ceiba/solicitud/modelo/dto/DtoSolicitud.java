package com.ceiba.solicitud.modelo.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DtoSolicitud {

	private Long id;
	private String descripcion;
	private String tipoDeSolicitud;
	private String estado;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaActualizacion;
	private LocalDateTime fechaTentativaDeRespuesta;
	private LocalDateTime fechaMaximaDeRespuesta;
	private Long idUsuarioAsignado;
	private String respuestaDeLaSolicitud;
	private Long idCliente;
	private Long clienteCelularContacto;
	
}
