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

  public guardar(producto: Solicitud) {
    return this.http.doPost<Solicitud, boolean>(`${environment.endpoint}/productos`, producto,
      this.http.optsName('crear/actualizar productos'));
  }

  public eliminar(producto: Solicitud) {
    return this.http.doDelete<boolean>(`${environment.endpoint}/productos/${producto.id}`,
      this.http.optsName('eliminar productos'));
  }
}
