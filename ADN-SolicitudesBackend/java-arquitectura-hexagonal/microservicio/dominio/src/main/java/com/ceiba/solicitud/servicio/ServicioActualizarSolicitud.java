package com.ceiba.solicitud.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.solicitud.modelo.entidad.Solicitud;
import com.ceiba.solicitud.puerto.repositorio.RepositorioSolicitud;

public class ServicioActualizarSolicitud {

	private static final String LA_SOLICITUD_NO_EXISTE_EN_EL_SISTEMA = "La solicitud no existe para hacer actualizada en el sistema";

	private final RepositorioSolicitud repositorioSolicitud;

	public ServicioActualizarSolicitud(RepositorioSolicitud repositorioSolicitud) {
		this.repositorioSolicitud = repositorioSolicitud;
	}

	public Long ejecutar(Solicitud solicitud) {
		solicitud.validarActualizacion();
		boolean existeSolicitud = repositorioSolicitud.existeSolicitud(solicitud.getId());
		if (existeSolicitud) {
			repositorioSolicitud.actualizar(solicitud);
			return solicitud.getId();
		} else {
			throw new ExcepcionValorInvalido(LA_SOLICITUD_NO_EXISTE_EN_EL_SISTEMA);
		}

	}

}
