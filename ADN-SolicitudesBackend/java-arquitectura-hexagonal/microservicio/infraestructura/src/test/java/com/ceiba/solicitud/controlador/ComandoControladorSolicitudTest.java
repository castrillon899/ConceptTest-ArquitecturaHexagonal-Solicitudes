package com.ceiba.solicitud.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.solicitud.comando.ComandoSolicitud;
import com.ceiba.solicitud.servicio.testdatabuilder.ComandoSolicitudTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runners.MethodSorters;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorSolicitud.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComandoControladorSolicitudTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;
	
	
	@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
	@Test
	public void crear() throws Exception {
	
		// arrange
		ComandoSolicitud solicitud = new ComandoSolicitudTestDataBuilder().ComandoCreaSolicitudTestDataBuilder()
				.build();

		// act - assert
		mocMvc.perform(post("/solicitudes").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(solicitud))).andDo(print()).
		andExpect(status().isOk());
	}

	@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
	@Test
	public void actualizar() throws Exception {
		// arrange
		Long id = 1L;
		ComandoSolicitud solicitud = new ComandoSolicitudTestDataBuilder().comandoActualizaSolicitudTestDataBuilder()
				.build();

		// act - assert
		mocMvc.perform(put("/solicitudes/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(solicitud))).andDo(print()).andExpect(status().isOk());
	}

}
