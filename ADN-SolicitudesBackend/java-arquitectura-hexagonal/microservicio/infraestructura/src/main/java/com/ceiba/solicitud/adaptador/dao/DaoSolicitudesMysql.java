package com.ceiba.solicitud.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.solicitud.modelo.dto.DtoSolicitud;
import com.ceiba.solicitud.puerto.dao.DaoSolicitud;

import org.springframework.stereotype.Component;


@Component
public class DaoSolicitudesMysql implements DaoSolicitud {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "solicitud", value = "listar")
	private static String sqlListar;

	public DaoSolicitudesMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<DtoSolicitud> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
				new MapeoSolicitud());
	}
}
