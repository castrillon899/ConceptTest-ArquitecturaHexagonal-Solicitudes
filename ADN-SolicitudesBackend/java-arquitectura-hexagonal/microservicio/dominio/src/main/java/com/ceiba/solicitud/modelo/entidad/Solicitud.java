package com.ceiba.solicitud.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

import com.ceiba.solicitud.modelo.dto.DtoSolicitud;

import lombok.Builder;
import lombok.Getter;

//@Builder
@Getter
public class Solicitud {

	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_SOLICITUD = "Se debe ingresar el nombre de la solicitud";
	private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_SOLICITUD = "Se debe ingresar un tipo de solicitud";
	private static final String SE_DEBE_INGRESAR_EL_ESTADO_SOLICITUD = "Se debe ingresar el estado de la solicitud";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_CREACION = "Se debe ingresar la fecha de creacion";
	private static final String SE_DEBE_INGRESAR_EL_USUARIO_ASIGNADO = "El usuario asignado a la solicitud es nulo, el usuario no encontro usuario para asignar";

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

	public Solicitud(Long id, String descripcion, String tipoDeSolicitud, String estado, LocalDateTime fechaCreacion,
			LocalDateTime fechaActualizacion, Long idCliente, Long clienteCelularContacto) {
		validarObligatorio(descripcion, SE_DEBE_INGRESAR_EL_NOMBRE_DE_SOLICITUD);
		validarObligatorio(tipoDeSolicitud, SE_DEBE_INGRESAR_EL_TIPO_DE_SOLICITUD);
		validarObligatorio(estado, SE_DEBE_INGRESAR_EL_ESTADO_SOLICITUD);
		validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_DE_CREACION);

		this.id = id;
		this.descripcion = descripcion;
		this.tipoDeSolicitud = tipoDeSolicitud;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.idCliente = idCliente;
		this.clienteCelularContacto = clienteCelularContacto;
	}

	public void validarSolicitud() {
		validarObligatorio(descripcion, SE_DEBE_INGRESAR_EL_NOMBRE_DE_SOLICITUD);
		validarObligatorio(tipoDeSolicitud, SE_DEBE_INGRESAR_EL_TIPO_DE_SOLICITUD);
		validarObligatorio(estado, SE_DEBE_INGRESAR_EL_ESTADO_SOLICITUD);
		validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_DE_CREACION);
	}

	public void setIdUsuarioAsignado(Long idUsuario) {
		validarObligatorio(idUsuario, SE_DEBE_INGRESAR_EL_USUARIO_ASIGNADO);
		this.idUsuarioAsignado = idUsuario;

	}

	public void setFechaTentativaDeRespuesta(LocalDateTime fechaTentativaDeRespuesta) {
		this.fechaTentativaDeRespuesta = fechaTentativaDeRespuesta;
	}

	public void setFechaMaximaDeRespuesta(LocalDateTime fechaMaximaDeRespuesta) {
		this.fechaMaximaDeRespuesta = fechaMaximaDeRespuesta;
	}

}
