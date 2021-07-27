package com.ceiba.solicitud.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.solicitud.modelo.entidad.Solicitud;
import com.ceiba.solicitud.puerto.repositorio.RepositorioSolicitud;
import com.ceiba.solicitud.servicio.testdatabuilder.SolicitudTestDataBuilder;

public class ServicioActualizarSolicitudTest {


	@Test
	public void  actualizarSolicitudTest() {

		// arrange
		Solicitud solicitud = new SolicitudTestDataBuilder().solicitudTipoQueja().build();
		RepositorioSolicitud repositorioSolicitud = Mockito.mock(RepositorioSolicitud.class);
		Long codigoDeRespuestaEsperada = 1L;

		Mockito.when(repositorioSolicitud.existeSolicitud(Mockito.anyObject())).thenReturn(true);
		Mockito.when(repositorioSolicitud.actualizar(Mockito.anyObject())).thenReturn(1L);

		ServicioActualizarSolicitud servicioActualizarSolicitud = new ServicioActualizarSolicitud(repositorioSolicitud);

		// Action
		Long respuestaSolicitud = servicioActualizarSolicitud.ejecutar(solicitud);

		// assert
		assertEquals(codigoDeRespuestaEsperada, respuestaSolicitud);

	}
	
	
	@Test
	public void  validarExistenciaDeLaSolicitudPreviaTest() {

		// arrange
		Solicitud solicitud = new SolicitudTestDataBuilder().solicitudTipoQueja().build();
		RepositorioSolicitud repositorioSolicitud = Mockito.mock(RepositorioSolicitud.class);

		Mockito.when(repositorioSolicitud.existeSolicitud(Mockito.anyObject())).thenReturn(false);
		Mockito.when(repositorioSolicitud.actualizar(Mockito.anyObject())).thenReturn(1L);

		ServicioActualizarSolicitud servicioActualizarSolicitud = new ServicioActualizarSolicitud(repositorioSolicitud);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarSolicitud.ejecutar(solicitud), ExcepcionValorInvalido.class,
				"La solicitud no existe para hacer actualizada en el sistema");


	}
	
	
	
	
	
	


}
