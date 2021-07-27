package com.ceiba.solicitud.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarValido;

import java.time.LocalDateTime;

import com.ceiba.solicitud.modelo.dto.TipoSolicitudEnum;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Solicitud {

	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_SOLICITUD = "Se debe ingresar el nombre de la solicitud";
	private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_SOLICITUD = "Se debe ingresar un tipo de solicitud";
	private static final String SE_DEBE_INGRESAR_EL_ESTADO_SOLICITUD = "Se debe ingresar el estado de la solicitud";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_CREACION = "Se debe ingresar la fecha de creacion";
	private static final String SE_DEBE_INGRESAR_EL_USUARIO_ASIGNADO = "El usuario asignado a la solicitud es nulo, el usuario no encontro usuario para asignar";
	private static final String EL_TIPO_DE_SOLITUD_NO_VALIDA = "El tipo de solicitud no es valida";
	private static final String ESTADO_SOLICITUD_NO_VALIDO = "El estado de la solicitud no es valida";
	
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

	

	public void validarSolicitud() {
		validarValido(tipoDeSolicitud, TipoSolicitudEnum.class, EL_TIPO_DE_SOLITUD_NO_VALIDA);
		validarObligatorio(descripcion, SE_DEBE_INGRESAR_EL_NOMBRE_DE_SOLICITUD);
		validarObligatorio(tipoDeSolicitud, SE_DEBE_INGRESAR_EL_TIPO_DE_SOLICITUD);
		validarObligatorio(estado, SE_DEBE_INGRESAR_EL_ESTADO_SOLICITUD);
		validarValido(estado, EstadoEnum.class, ESTADO_SOLICITUD_NO_VALIDO);
		validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_DE_CREACION);
	}
	

	public void validarActualizacion() {
		validarObligatorio(estado, SE_DEBE_INGRESAR_EL_ESTADO_SOLICITUD);
		validarValido(estado, EstadoEnum.class, ESTADO_SOLICITUD_NO_VALIDO);
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
