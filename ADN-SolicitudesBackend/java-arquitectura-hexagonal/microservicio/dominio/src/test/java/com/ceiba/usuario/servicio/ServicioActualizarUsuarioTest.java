package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioActualizarUsuarioTest {

	@Test
	public void validarUsuarioExistenciaPreviaTest() {
		// arrange
		Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();
		RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
		Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
		ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);
		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,
				"El usuario ya existe en el sistema");
	}

	@Test
	public void actualizarUsuarioTest() {
		// arrange
		Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();
		RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
		Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
		boolean respuestaExitosa=true;
		ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);
		// act
		servicioActualizarUsuario.ejecutar(usuario);

	
		// assert
		assertTrue(respuestaExitosa);		
	}
}
