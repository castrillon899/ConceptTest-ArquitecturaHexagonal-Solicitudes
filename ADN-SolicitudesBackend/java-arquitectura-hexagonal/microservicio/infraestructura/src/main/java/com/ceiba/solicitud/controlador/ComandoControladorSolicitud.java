package com.ceiba.solicitud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.ComandoRespuesta;
import com.ceiba.solicitud.comando.ComandoSolicitud;
import com.ceiba.solicitud.comando.manejador.ManejadorCrearSolicitud;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/solicitudes")
@Api(tags = { "Controlador comando solicitudes" })
public class ComandoControladorSolicitud {

	private final ManejadorCrearSolicitud manejadorCrearSolicitud;

	@Autowired
	public ComandoControladorSolicitud(ManejadorCrearSolicitud manejadorCrearSolicitud

	) {
		this.manejadorCrearSolicitud = manejadorCrearSolicitud;
	}

	

    @PostMapping
    @ApiOperation("Crear Solicitud")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitud comandoSolicitud) {
		return manejadorCrearSolicitud.ejecutar(comandoSolicitud);
    }
}
