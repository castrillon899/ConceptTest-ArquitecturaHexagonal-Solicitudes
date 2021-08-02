export class Solicitud {

    id: number;
    descripcion: string;
    tipoDeSolicitud: string;
    estado: string;
    fechaCreacion: string;
    fechaActualizacion: string;
    fechaTentativaDeRespuesta: string;
    fechaMaximaDeRespuesta: string;
    idUsuarioAsignado: number;
    respuestaDeLaSolicitud: string;
    idCliente: number;
    clienteCelularContacto: number;
    respuestaSolicitud: string;
    



    constructor(
        id: number,
        descripcion: string,
        tipoDeSolicitud: string,
        estado: string,
        fechaCreacion: string,
        fechaActualizacion: string,
        fechaTentativaDeRespuesta: string,
        fechaMaximaDeRespuesta: string,
        idUsuarioAsignado: number,
        respuestaDeLaSolicitud: string,
        idCliente: number,
        clienteCelularContacto: number,
        respuestaSolicitud: string,
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
        this.respuestaSolicitud = respuestaSolicitud;
    }

}


