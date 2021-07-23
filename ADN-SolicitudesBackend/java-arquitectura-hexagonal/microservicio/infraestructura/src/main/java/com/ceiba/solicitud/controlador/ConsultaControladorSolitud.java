package com.ceiba.solicitud.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.solicitud.consulta.ManejadorListarSolicitudes;
import com.ceiba.solicitud.modelo.dto.DtoSolicitud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/solicitudes")
@Api(tags={"Controlador consulta solicitudes"})
public class ConsultaControladorSolitud {

    private final ManejadorListarSolicitudes manejadorListarUsuarios;

    public ConsultaControladorSolitud(ManejadorListarSolicitudes manejadorListarUsuarios) {
        this.manejadorListarUsuarios = manejadorListarUsuarios;
    }

    @GetMapping
    @ApiOperation("Listar Solicitudes")
    public List<DtoSolicitud> listar() {
        return this.manejadorListarUsuarios.ejecutar();
    }

}
