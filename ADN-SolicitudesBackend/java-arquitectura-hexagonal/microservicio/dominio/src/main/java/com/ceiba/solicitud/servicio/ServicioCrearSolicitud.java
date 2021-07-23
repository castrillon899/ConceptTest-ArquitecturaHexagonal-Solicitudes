package com.ceiba.solicitud.servicio;

import static com.ceiba.dominio.CalcularFechaRespuestaSolicitud.carcularFechaDeRespuestaALaSolicitud;
import static com.ceiba.dominio.ValidadorArgumento.validarValido;
import java.time.LocalDateTime;
import com.ceiba.solicitud.modelo.dto.TipoSolicitudEnum;
import com.ceiba.solicitud.modelo.entidad.Solicitud;
import com.ceiba.solicitud.puerto.repositorio.RepositorioSolicitud;

public class ServicioCrearSolicitud {

	private static final String EL_TIPO_DE_SOLITUD_NO_VALIDA = "El tipo de solicitud no es valida";

	private final RepositorioSolicitud repositorioSolicitud;

	public ServicioCrearSolicitud(RepositorioSolicitud repositorioSolicitud) {
		this.repositorioSolicitud = repositorioSolicitud;
	}

	public Long ejecutar(Solicitud solicitud) {
		validarTipoDeSolicitud(solicitud);

		Long idUsuario = buscarUsuarioQueRespondaLaSolicitud(solicitud);
		solicitud.setIdUsuarioAsignado(idUsuario);

		LocalDateTime fechaTentativaDeRespuesta = carcularFechaDeRespuestaALaSolicitud(
				solicitud.getFechaCreacion().toLocalDate(), calcularDiasTentativosDeRespuestaALaSolicitud(solicitud));
		LocalDateTime fechaMaximaDeRespuesta = carcularFechaDeRespuestaALaSolicitud(
				solicitud.getFechaCreacion().toLocalDate(), calcularDiasMaximosDeRespuestaALaSolicitud(solicitud));
		
		solicitud.setFechaMaximaDeRespuesta(fechaMaximaDeRespuesta);
		solicitud.setFechaTentativaDeRespuesta(fechaTentativaDeRespuesta);
		
		
		return this.repositorioSolicitud.crear(solicitud);
	}

	private int calcularDiasTentativosDeRespuestaALaSolicitud(Solicitud solicitud) {

		if (solicitud.getTipoDeSolicitud().equals(TipoSolicitudEnum.QUEJA.toString())) {
			return 1;
		} else if (solicitud.getTipoDeSolicitud().equals(TipoSolicitudEnum.SOLICITUD.toString())) {
			return 3;
		}
		return 0;
	}

	private int calcularDiasMaximosDeRespuestaALaSolicitud(Solicitud solicitud) {
		if (solicitud.getTipoDeSolicitud().equals(TipoSolicitudEnum.QUEJA.toString())) {
			return 2;
		} else if (solicitud.getTipoDeSolicitud().equals(TipoSolicitudEnum.SOLICITUD.toString())) {
			return 5;
		}
		return 0;
	}

	private void validarTipoDeSolicitud(Solicitud solicitud) {
		validarValido(solicitud.getTipoDeSolicitud(), TipoSolicitudEnum.class, EL_TIPO_DE_SOLITUD_NO_VALIDA);
	}

	private Long buscarUsuarioQueRespondaLaSolicitud(Solicitud solicitud) {
		// TODO Buscar usuario definir regla para tomar un usuario random
		return 1L;
	}

}
