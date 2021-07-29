import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Solicitud } from '../model/solicitud';


@Injectable()
export class SolicitudService {

  constructor(protected http: HttpService) { }

  public consultar() {
    return this.http.doGet<Solicitud[]>(`${environment.endpoint}/api/v1/solicitudes`, this.http.optsName('consultar solicitudes'));
  }

  public crear(solicitud: Solicitud) {
    return this.http.doPost<Solicitud, any>(`${environment.endpoint}/api/v1/solicitudes`, solicitud,
      this.http.optsName('crear/actualizar solicitudes'));
  }

  public eliminar(producto: any) {
    return this.http.doDelete<number>(`${environment.endpoint}/api/v1/solicitudes/${producto.id}`,
      this.http.optsName('eliminar solicitudes'));
  }
}
