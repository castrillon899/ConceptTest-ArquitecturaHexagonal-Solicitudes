package com.ceiba.solicitud.comando.manejador;

import org.springframework.stereotype.Component;
import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.solicitud.comando.ComandoSolicitud;
import com.ceiba.solicitud.comando.fabrica.FabricaSolicitud;
import com.ceiba.solicitud.modelo.entidad.Solicitud;
import com.ceiba.solicitud.servicio.ServicioCrearSolicitud;

@Component
public class ManejadorCrearSolicitud implements ManejadorComandoRespuesta<ComandoSolicitud, ComandoRespuesta<Long>> {

	private final FabricaSolicitud fabricaSolicitud;
	private final ServicioCrearSolicitud servicioCrearSolicitud;

	public ManejadorCrearSolicitud(FabricaSolicitud fabricaSolicitud, ServicioCrearSolicitud servicioCrearSolicitud) {
		this.fabricaSolicitud = fabricaSolicitud;
		this.servicioCrearSolicitud = servicioCrearSolicitud;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoSolicitud comandoSolicitud) {
		Solicitud solicitud = this.fabricaSolicitud.crear(comandoSolicitud);
		return new ComandoRespuesta<>(this.servicioCrearSolicitud.ejecutar(solicitud));
	}

}
