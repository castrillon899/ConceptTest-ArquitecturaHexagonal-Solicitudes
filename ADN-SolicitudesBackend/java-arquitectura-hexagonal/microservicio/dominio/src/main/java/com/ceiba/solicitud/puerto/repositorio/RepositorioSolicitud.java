package com.ceiba.solicitud.puerto.repositorio;

import com.ceiba.solicitud.modelo.entidad.Solicitud;

public interface RepositorioSolicitud {
	/**
	 * Permite crear una solicitud
	 * 
	 * @param usuario
	 * @return el id generado
	 */
	Long crear(Solicitud usuario);

	/**
	 * Permite eliminar una solicitud
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * valida si existe la solcitiud
	 * 
	 * @param id
	 */
	boolean existeSolicitud(Long id);

	/*
	 * Permite actualizar una solicitud
	 * 
	 * @param usuario
	 */
	Long actualizar(Solicitud solicitud);

}
