package com.ceiba.configuracion;

import com.ceiba.solicitud.puerto.repositorio.RepositorioSolicitud;
import com.ceiba.solicitud.servicio.ServicioCrearSolicitud;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
	
    
    @Bean
    public ServicioCrearSolicitud servicioCrearSolicitud(RepositorioSolicitud repositorioSolicitud,RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearSolicitud(repositorioSolicitud,repositorioUsuario);
    }

}
