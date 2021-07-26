package com.ceiba.solicitud.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.solicitud.modelo.entidad.Solicitud;
import com.ceiba.solicitud.puerto.repositorio.RepositorioSolicitud;
import com.ceiba.solicitud.servicio.testdatabuilder.SolicitudTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;

public class ServicioCrearSolicitudTest {

	@Test
	public void validarTipoDeSolicitudInvalidaTest() {

		// arrange
		Solicitud solicitud = new SolicitudTestDataBuilder().solicitudTipoSolitudInvalida().build();
		Usuario usuario = new UsuarioTestDataBuilder().build();
		RepositorioSolicitud repositorioSolicitud = Mockito.mock(RepositorioSolicitud.class);
		RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);

		Mockito.when(repositorioUsuario.buscarUsuarioParaGestionDeLaSolicitud(Mockito.anyObject())).thenReturn(usuario);
		Mockito.when(repositorioSolicitud.crear(Mockito.anyObject())).thenReturn(1L);

		ServicioCrearSolicitud servicioCrearSolicitud = new ServicioCrearSolicitud(repositorioSolicitud,
				repositorioUsuario);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearSolicitud.ejecutar(solicitud), ExcepcionValorInvalido.class,
				"El tipo de solicitud no es valida");

	}

	@Test
	public void crearSolicitudTipoQuejaTest() {

		// arrange
		Solicitud solicitud = new SolicitudTestDataBuilder().solicitudTipoQueja().build();
		Usuario usuario = new UsuarioTestDataBuilder().build();

		RepositorioSolicitud repositorioSolicitud = Mockito.mock(RepositorioSolicitud.class);
		RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
		Long codigoDeRespuestaEsperada = 1L;

		Mockito.when(repositorioSolicitud.crear(Mockito.anyObject())).thenReturn(1L);
		Mockito.when(repositorioUsuario.buscarUsuarioParaGestionDeLaSolicitud(Mockito.anyObject())).thenReturn(usuario);

		ServicioCrearSolicitud servicioCrearSolicitud = new ServicioCrearSolicitud(repositorioSolicitud,
				repositorioUsuario);

		// Action

		Long respuestaSolicitud = servicioCrearSolicitud.ejecutar(solicitud);

		// assert
		assertEquals(codigoDeRespuestaEsperada, respuestaSolicitud);

	}

	@Test
	public void crearSolicitudTipoSolicitudTest() {

		// arrange
		Usuario usuario = new UsuarioTestDataBuilder().build();

		Solicitud solicitud = new SolicitudTestDataBuilder().solicitudTipoSolicitud().build();
		RepositorioSolicitud repositorioSolicitud = Mockito.mock(RepositorioSolicitud.class);
		RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
		Long codigoDeRespuestaEsperada = 1L;

		Mockito.when(repositorioUsuario.buscarUsuarioParaGestionDeLaSolicitud(Mockito.anyObject())).thenReturn(usuario);
		Mockito.when(repositorioSolicitud.crear(Mockito.anyObject())).thenReturn(1L);
		ServicioCrearSolicitud servicioCrearSolicitud = new ServicioCrearSolicitud(repositorioSolicitud,
				repositorioUsuario);

		// Action
		Long respuestaSolicitud = servicioCrearSolicitud.ejecutar(solicitud);

		// assert
		assertEquals(codigoDeRespuestaEsperada, respuestaSolicitud);

	}
}
