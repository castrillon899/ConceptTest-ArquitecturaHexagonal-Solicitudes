package com.ceiba.solicitud.comando;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitud{

    private Long id;
	private String descripcion;
	private String tipoDeSolicitud;
	private String estado;
	private Long idCliente;
	private Long clienteCelularContacto;
	private String respuestaSolicitud;
    
}
