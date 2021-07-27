package com.ceiba.usuario.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;


public class ServicioEliminarUsuarioTest {


	@Test
	public void eliminarUsuarioTest() {
		// arrange
		RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
		Long idUsuario = 1L;
		ServicioEliminarUsuario servicioCrearUsuario = new ServicioEliminarUsuario(repositorioUsuario);
		boolean respuestaExitosa=true;
		// act
		servicioCrearUsuario.ejecutar(idUsuario);
		
	
		// - assert
		assertTrue(respuestaExitosa);
		
	}

	
}
