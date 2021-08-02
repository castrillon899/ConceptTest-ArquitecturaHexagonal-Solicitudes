import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Solicitud } from '../model/solicitud';


@Injectable()
export class SolicitudService {

  constructor(protected http: HttpService) { }

  solicitudActiva: Solicitud;

  public consultar() {
    return this.http.doGet<Solicitud[]>(`${environment.endpoint}/api/v1/solicitudes`, this.http.optsName('consultar solicitudes'));
  }

  public crear(solicitud: Solicitud) {
    return this.http.doPost<Solicitud, any>(`${environment.endpoint}/api/v1/solicitudes`, solicitud,
      this.http.optsName('crear/actualizar solicitudes'));
  }

  public eliminar(solicitud: Solicitud) {
    let objectUpdate = {
      'estado': 'CANCELADA',
      'respuestaSolicitud': solicitud.respuestaDeLaSolicitud
    }
    return this.http.doPut<any, any>(`${environment.endpoint}/api/v1/solicitudes/${solicitud.id}`, objectUpdate,
      this.http.optsName('cancelar solicitud'));
  }

  public editar(solicitud: Solicitud) {
    let objectUpdate = {
      'estado': solicitud.estado,
      'respuestaSolicitud': solicitud.respuestaSolicitud
    }

    console.log('prueba')
    console.log(objectUpdate)
    console.log('prueba')


    return this.http.doPut<any, any>(`${environment.endpoint}/api/v1/solicitudes/${solicitud.id}`, objectUpdate,
      this.http.optsName('cancelar solicitud'));
  }


}
