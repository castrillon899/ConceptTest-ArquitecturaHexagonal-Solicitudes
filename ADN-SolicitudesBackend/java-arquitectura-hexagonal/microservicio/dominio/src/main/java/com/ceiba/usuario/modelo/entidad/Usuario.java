package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@ToString
public class Usuario {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el primer nombre de usuario";
    private static final String SE_DEBE_INGRESAR_EL_APELLIDO_DE_USUARIO = "Se debe ingresar el primer apellido de usuario";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_DOCUMENTO = "Se debe ingresar el tipo de documento";
    private static final String SE_DEBE_INGRESAR_EL_DOCUMENTO = "Se debe ingresar el doucumento";
    private static final String SE_DEBE_INGRESAR_ADMINISTRADORA_PENSION = "Se debe ingresar la administradora de pension";
    private static final String SE_DEBE_INGRESAR_ADMINISTRADORA_SALUD = "Se debe ingresar la EPS";
    private static final String SE_DEBE_INGRESAR_FECHA_AFILIACION = "Se debe ingresar la fecha de afiliacion a salud";
    private static final String SE_DEBE_INGRESAR_FECHA_AFILIACION_PENSION = "Se debe ingresar la fecha de afiliacion a pension";


 
    
    
    private Long id;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String tipoDeDocumento;
	private String documento;
	private String administradoraSalud;
	private LocalDateTime fechaAfiliacionASalud;
	private String administradoraDePension;
	private LocalDateTime fechaAfiliacionAPension;
	
	
	
	public Usuario(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			String tipoDeDocumento, String documento, String administradoraSalud, LocalDateTime fechaAfiliacionASalud,
			String administradoraDePension, LocalDateTime fechaAfiliacionAPension) {
	
		validarObligatorio(primerNombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
	    validarObligatorio(primerApellido, SE_DEBE_INGRESAR_EL_APELLIDO_DE_USUARIO);
        validarObligatorio(tipoDeDocumento, SE_DEBE_INGRESAR_EL_TIPO_DE_DOCUMENTO);
	    validarObligatorio(documento, SE_DEBE_INGRESAR_EL_DOCUMENTO);
	    validarObligatorio(administradoraSalud, SE_DEBE_INGRESAR_ADMINISTRADORA_SALUD);
	    validarObligatorio(fechaAfiliacionASalud, SE_DEBE_INGRESAR_FECHA_AFILIACION);
	    validarObligatorio(administradoraDePension, SE_DEBE_INGRESAR_ADMINISTRADORA_PENSION);
	    validarObligatorio(fechaAfiliacionASalud, SE_DEBE_INGRESAR_FECHA_AFILIACION_PENSION);
	        

		
		this.id = id;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.tipoDeDocumento = tipoDeDocumento;
		this.documento = documento;
		this.administradoraSalud = administradoraSalud;
		this.fechaAfiliacionASalud = fechaAfiliacionASalud;
		this.administradoraDePension = administradoraDePension;
		this.fechaAfiliacionAPension = fechaAfiliacionAPension;
	}
    
	
	
    

}
