package com.ceiba.solicitud.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.solicitud.modelo.dto.DtoSolicitud;
import com.ceiba.solicitud.puerto.dao.DaoSolicitud;

@Component
public class ManejadorListarSolicitudes {

    private final DaoSolicitud daoSolicitud;

    public ManejadorListarSolicitudes(DaoSolicitud daoSolicitud){
        this.daoSolicitud = daoSolicitud;
    }

    public List<DtoSolicitud> ejecutar(){ return this.daoSolicitud.listar(); }
}
