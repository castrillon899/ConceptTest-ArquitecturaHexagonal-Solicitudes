package com.ceiba.solicitud.controlador;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.ComandoRespuesta;
import com.ceiba.solicitud.comando.ComandoSolicitud;
import com.ceiba.solicitud.comando.manejador.ManejadorCrearSolicitud;
import com.ceiba.solicitud.comando.manejador.ManejadorActualizarSolicitud;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/solicitudes")
@Api(tags = { "Controlador comando solicitudes" })
public class ComandoControladorSolicitud {

	private final ManejadorCrearSolicitud manejadorCrearSolicitud;
    private final ManejadorActualizarSolicitud manejadorActualizarSolicitud;
	


	public ComandoControladorSolicitud( ManejadorCrearSolicitud manejadorCrearSolicitud,ManejadorActualizarSolicitud manejadorActualizarSolicitud) {
		this.manejadorCrearSolicitud= manejadorCrearSolicitud;
		this.manejadorActualizarSolicitud = manejadorActualizarSolicitud;
	}

	

    @PostMapping
    @ApiOperation("Crear Solicitud")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitud comandoSolicitud) {
		return manejadorCrearSolicitud.ejecutar(comandoSolicitud);
    }
    
    
    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar solicitud")
    public ComandoRespuesta<Long> actualizar(@RequestBody ComandoSolicitud comandoSolicitud, @PathVariable Long id) {
    	comandoSolicitud.setId(id);
		return manejadorActualizarSolicitud.ejecutar(comandoSolicitud);
    }
    
}
