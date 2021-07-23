package com.ceiba.solicitud.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.solicitud.modelo.dto.DtoSolicitud;
import org.springframework.jdbc.core.RowMapper;

public class MapeoSolicitud implements RowMapper<DtoSolicitud>, MapperResult {

	@Override
	public DtoSolicitud mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("id");
		String descripcion = resultSet.getString("descripcion");
		String tipoDeSolicitud = resultSet.getString("tipo_de_solicitud");
		String estado = resultSet.getString("estado");
		LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");
		LocalDateTime fechaActualizacion = extraerLocalDateTime(resultSet, "fecha_actualizacion");
		LocalDateTime fechaTentativaDeRespuesta = extraerLocalDateTime(resultSet, "fecha_tentativa_respuesta");
		LocalDateTime fechaMaximaRespuesta = extraerLocalDateTime(resultSet, "fecha_maxima_respuesta");
		Long idUsuarioAsignado = resultSet.getLong("id_usuario_asignado");
		String respuestaDeLaSolicitud = resultSet.getString("respuesta_solicitud");
		Long idCliente = resultSet.getLong("id_cliente");
		Long clienteCelular = resultSet.getLong("cliente_celular_contacto");

		return new DtoSolicitud(id, descripcion, tipoDeSolicitud, estado, fechaCreacion, fechaActualizacion,
				fechaTentativaDeRespuesta, fechaMaximaRespuesta, idUsuarioAsignado, respuestaDeLaSolicitud, idCliente,
				clienteCelular);
	}

}
