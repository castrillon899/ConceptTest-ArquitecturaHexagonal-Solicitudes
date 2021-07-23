package com.ceiba.solicitud.puerto.dao;

import com.ceiba.solicitud.modelo.dto.DtoSolicitud;

import java.util.List;

public interface DaoSolicitud {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoSolicitud> listar();
}
