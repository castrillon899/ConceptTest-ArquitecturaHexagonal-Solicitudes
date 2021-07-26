package com.ceiba.solicitud.servicio;

import static com.ceiba.dominio.CalcularFechaRespuestaSolicitud.carcularFechaDeRespuestaALaSolicitud;
import java.time.LocalDateTime;
import com.ceiba.solicitud.modelo.dto.TipoSolicitudEnum;
import com.ceiba.solicitud.modelo.entidad.Solicitud;
import com.ceiba.solicitud.puerto.repositorio.RepositorioSolicitud;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioCrearSolicitud {


	private final RepositorioSolicitud repositorioSolicitud;

	private final RepositorioUsuario repositorioUsuario;

	public ServicioCrearSolicitud(RepositorioSolicitud repositorioSolicitud, RepositorioUsuario repositorioUsuario) {
		this.repositorioSolicitud = repositorioSolicitud;
		this.repositorioUsuario = repositorioUsuario;
	}

	public Long ejecutar(Solicitud solicitud) {
		solicitud.validarSolicitud();

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
		} else {
			return 3;
		}

	}

	private int calcularDiasMaximosDeRespuestaALaSolicitud(Solicitud solicitud) {
		if (solicitud.getTipoDeSolicitud().equals(TipoSolicitudEnum.QUEJA.toString())) {
			return 2;
		} else {
			return 5;
		}

	}


	private Long buscarUsuarioQueRespondaLaSolicitud(Solicitud solicitud) {
		return this.repositorioUsuario.buscarUsuarioParaGestionDeLaSolicitud(solicitud.getTipoDeSolicitud()).getId();
	}

}
