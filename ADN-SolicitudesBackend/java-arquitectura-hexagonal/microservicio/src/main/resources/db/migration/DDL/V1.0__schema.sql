create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);




create table solicitud (
 id int(11) not null auto_increment,
 descripcion varchar(100) not null,
 tipo_de_solicitud varchar(100) not null,
 estado varchar(100) not null,
 fecha_creacion datetime null,
 fecha_actualizacion datetime null,
 fecha_tentativa_respuesta datetime null,
 fecha_maxima_respuesta datetime null,
 id_usuario_asignado int(11),
 respuesta_solicitud varchar(4000),
 id_cliente int(11),
 cliente_celular_contacto varchar(50),
 primary key (id)
);

