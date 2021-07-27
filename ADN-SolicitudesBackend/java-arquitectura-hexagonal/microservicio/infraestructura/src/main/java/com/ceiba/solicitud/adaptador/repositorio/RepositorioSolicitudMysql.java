package com.ceiba.solicitud.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.solicitud.modelo.entidad.Solicitud;
import com.ceiba.solicitud.puerto.repositorio.RepositorioSolicitud;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSolicitudMysql implements RepositorioSolicitud {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "solicitud", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "solicitud", value = "actualizar")
	private static String sqlActualizar;

	@SqlStatement(namespace = "solicitud", value = "eliminar")
	private static String sqlEliminar;

	@SqlStatement(namespace = "solicitud", value = "existeSolicitudPorId")
	private static String sqlExisteSolicitudPorId;

	public RepositorioSolicitudMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Solicitud usuario) {
		return this.customNamedParameterJdbcTemplate.crear(usuario, sqlCrear);
	}

	@Override
	public void eliminar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
	}

	@Override
	public boolean existeSolicitud(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExisteSolicitudPorId, paramSource, Boolean.class);

	}

	@Override
	public Long actualizar(Solicitud solicitud) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", solicitud.getId());
		paramSource.addValue("respuesta", solicitud.getRespuestaDeLaSolicitud());
		paramSource.addValue("estado", solicitud.getEstado());
		paramSource.addValue("fechaActualizacion", solicitud.getFechaActualizacion());
		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizar, paramSource);
		return solicitud.getId();
	}

}
