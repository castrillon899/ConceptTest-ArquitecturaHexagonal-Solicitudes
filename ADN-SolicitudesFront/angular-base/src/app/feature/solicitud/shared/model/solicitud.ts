
export class Solicitud {
    id: string;
    descripcion: string;
    tipoDeSolicitud: string;
    estado: string;
    fechaCreacion: string;
    fechaActualizacion: string;
    fechaTentativaDeRespuesta: string;
    fechaMaximaDeRespuesta: string;
    idUsuarioAsignado: string;
    respuestaDeLaSolicitud: string;
    idCliente: string;
    clienteCelularContacto: string;



    constructor(
        id: string,
        descripcion: string,
        tipoDeSolicitud: string,
        estado: string,
        fechaCreacion: string,
        fechaActualizacion: string,
        fechaTentativaDeRespuesta: string,
        fechaMaximaDeRespuesta: string,
        idUsuarioAsignado: string,
        respuestaDeLaSolicitud: string,
        idCliente: string,
        clienteCelularContacto: string
    ) {
        this.id = id
        this.descripcion = descripcion
        this.tipoDeSolicitud = tipoDeSolicitud
        this.estado = estado
        this.fechaCreacion = fechaCreacion
        this.fechaActualizacion = fechaActualizacion
        this.fechaTentativaDeRespuesta = fechaTentativaDeRespuesta
        this.fechaMaximaDeRespuesta = fechaMaximaDeRespuesta
        this.idUsuarioAsignado = idUsuarioAsignado
        this.respuestaDeLaSolicitud = respuestaDeLaSolicitud
        this.idCliente = idCliente
        this.clienteCelularContacto = clienteCelularContacto
    }

}


