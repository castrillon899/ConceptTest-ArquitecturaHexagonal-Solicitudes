import { Component, OnInit } from '@angular/core';
import { Solicitud } from '@solicitud/shared/model/solicitud';
import { SolicitudService } from '@solicitud/shared/service/solicitud.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-listar-solicitud',
  templateUrl: './listar-solicitud.component.html',
  styleUrls: ['./listar-solicitud.component.scss']
})
export class ListarSolicitudComponent implements OnInit {


  public listaProductos: Observable<Solicitud[]>;

  constructor(protected solicitudService: SolicitudService) { }

  ngOnInit() {
    this.listaProductos = this.solicitudService.consultar();
  }


}
