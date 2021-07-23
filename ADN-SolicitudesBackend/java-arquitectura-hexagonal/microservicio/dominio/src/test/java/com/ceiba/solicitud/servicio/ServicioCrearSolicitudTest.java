package com.ceiba.solicitud.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.solicitud.modelo.entidad.Solicitud;
import com.ceiba.solicitud.puerto.repositorio.RepositorioSolicitud;
import com.ceiba.solicitud.servicio.testdatabuilder.SolicitudTestDataBuilder;

public class ServicioCrearSolicitudTest {

	@Test
	public void validarTipoDeSolicitudInvalidaTest() {

		// arrange
		Solicitud solicitud = new SolicitudTestDataBuilder().solicitudTipoSolitudInvalida().build();
		RepositorioSolicitud repositorioSolicitud = Mockito.mock(RepositorioSolicitud.class);

		Mockito.when(repositorioSolicitud.crear(Mockito.anyObject())).thenReturn(1L);
		ServicioCrearSolicitud servicioCrearSolicitud = new ServicioCrearSolicitud(repositorioSolicitud);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearSolicitud.ejecutar(solicitud), ExcepcionValorInvalido.class,
				"El tipo de solicitud no es valida");

	}

	@Test
	public void crearSolicitudTipoQuejaTest() {

		// arrange
		Solicitud solicitud = new SolicitudTestDataBuilder().solicitudTipoQueja().build();

		RepositorioSolicitud repositorioSolicitud = Mockito.mock(RepositorioSolicitud.class);
		Long codigoDeRespuestaEsperada = 1L;

		Mockito.when(repositorioSolicitud.crear(Mockito.anyObject())).thenReturn(1L);
		ServicioCrearSolicitud servicioCrearSolicitud = new ServicioCrearSolicitud(repositorioSolicitud);

		// Action

		Long respuestaSolicitud = servicioCrearSolicitud.ejecutar(solicitud);

		// assert
		assertEquals(codigoDeRespuestaEsperada, respuestaSolicitud);

	}

	@Test
	public void crearSolicitudTipoSolicitudTest() {

		// arrange
		Solicitud solicitud = new SolicitudTestDataBuilder().solicitudTipoSolicitud().build();

		RepositorioSolicitud repositorioSolicitud = Mockito.mock(RepositorioSolicitud.class);
		Long codigoDeRespuestaEsperada = 1L;

		Mockito.when(repositorioSolicitud.crear(Mockito.anyObject())).thenReturn(1L);
		ServicioCrearSolicitud servicioCrearSolicitud = new ServicioCrearSolicitud(repositorioSolicitud);

		// Action

		Long respuestaSolicitud = servicioCrearSolicitud.ejecutar(solicitud);

		// assert
		assertEquals(codigoDeRespuestaEsperada, respuestaSolicitud);

	}
}
