import { Component, OnInit } from '@angular/core';
import { Solicitud } from '@solicitud/shared/model/solicitud';
import { SolicitudService } from '@solicitud/shared/service/solicitud.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

@Component({
  selector: 'app-listar-solicitud',
  templateUrl: './listar-solicitud.component.html',
  styleUrls: ['./listar-solicitud.component.scss'],
})
export class ListarSolicitudComponent implements OnInit {
  public listaProductos: Observable<Solicitud[]>;

  constructor(
    private solicitudService: SolicitudService,
    private router: Router,
    private modalNotificaciones: ModalNotificaciones
  ) {}

  ngOnInit() {
    this.listaProductos = this.solicitudService.consultar();
  }

  cancelarSolicitud(solicitud: Solicitud) {
    this.modalNotificaciones
      .modalConConfirmacion(
        `Estas seguro de cancelar la solicitud # ${solicitud.id}`,
        'warning',
        true,
        '#3085d6',
        '#d33',
        'Si, crealo',
        'no, Cancelar!!'
      )
      .then((respuestaConfirmacion) => {
        if (respuestaConfirmacion) {
          this.solicitudService.eliminar(solicitud).subscribe(
            (response) => {
              if (response.valor) {
                this.modalNotificaciones.modalBasico(
                  `Se cancelo correctamente ${solicitud.id}`,
                  'success'
                );

                setTimeout(() => {
                  this.irAListarSolicitudes();
                }, 1000);
              }
            },
            (e) => {
              this.modalNotificaciones.modalBasico(
                `No se puedo cancelar la notificacion ${
                  e.error ? e.error.mensaje : e.statusText
                }`,
                'warning'
              );
            }
          );
        }
      });
  }

  irAListarSolicitudes() {
    this.router.navigate(['solicitud']);
  }

  navegarAEditar(solicitud: Solicitud) {
    this.solicitudService.solicitudActiva = solicitud;
    this.router.navigateByUrl('/solicitud/editar');
  }
}
