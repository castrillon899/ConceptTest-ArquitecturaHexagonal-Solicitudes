package com.ceiba.solicitud.comando.manejador;

import org.springframework.stereotype.Component;
import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.solicitud.comando.ComandoSolicitud;
import com.ceiba.solicitud.comando.fabrica.FabricaSolicitud;
import com.ceiba.solicitud.modelo.entidad.Solicitud;
import com.ceiba.solicitud.servicio.ServicioActualizarSolicitud;

@Component
public class ManejadorActualizarSolicitud implements ManejadorComandoRespuesta<ComandoSolicitud, ComandoRespuesta<Long>> {

	private final FabricaSolicitud fabricaSolicitud;
	private final ServicioActualizarSolicitud  servicioActualizarSolicitud;

	public ManejadorActualizarSolicitud(FabricaSolicitud fabricaSolicitud, ServicioActualizarSolicitud servicioCrearSolicitud) {
		this.fabricaSolicitud = fabricaSolicitud;
		this.servicioActualizarSolicitud = servicioCrearSolicitud;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoSolicitud comandoSolicitud) {
		Solicitud solicitud = this.fabricaSolicitud.actualizar(comandoSolicitud);
		return new ComandoRespuesta<>(this.servicioActualizarSolicitud.ejecutar(solicitud));
	}

}
