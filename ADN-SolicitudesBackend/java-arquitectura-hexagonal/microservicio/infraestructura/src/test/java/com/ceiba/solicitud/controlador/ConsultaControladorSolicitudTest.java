package com.ceiba.solicitud.controlador;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.ceiba.ApplicationMock;
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
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorSolitud.class)
public class ConsultaControladorSolicitudTest {

	@Autowired
	private MockMvc mocMvc;

	
	@Test
	@DirtiesContext(methodMode = MethodMode.BEFORE_METHOD)
	public void listar() throws Exception {
		// arrange

		// act - assert
		mocMvc.perform(get("/solicitudes").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
		      //  .andExpect(jsonPath("$", hasSize(5)))
			 	.andExpect(jsonPath("$[0].descripcion", is("la usuaria manifiesta inconformidad con la factura recibida por favor $200.000")));
	}

}
