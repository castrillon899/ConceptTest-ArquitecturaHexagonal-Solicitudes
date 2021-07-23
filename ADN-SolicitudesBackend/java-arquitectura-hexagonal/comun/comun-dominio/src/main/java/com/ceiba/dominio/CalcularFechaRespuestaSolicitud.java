package com.ceiba.dominio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CalcularFechaRespuestaSolicitud {

	public static LocalDateTime carcularFechaDeRespuestaALaSolicitud(LocalDate fechaCreacionDeLaSolicitud,
			int diasEsperadosParaLaRespuesta) {
		LocalDate result = fechaCreacionDeLaSolicitud;
		int cantidadDeDiasAgregados = 0;
		while (cantidadDeDiasAgregados < diasEsperadosParaLaRespuesta) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++cantidadDeDiasAgregados;
			}
		}
		return result.atStartOfDay(ZoneId.systemDefault()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

}
