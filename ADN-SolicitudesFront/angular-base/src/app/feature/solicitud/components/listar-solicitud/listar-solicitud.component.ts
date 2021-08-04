import { Component, OnInit } from '@angular/core';
import { Solicitud } from '@solicitud/shared/model/solicitud';
import { SolicitudService } from '@solicitud/shared/service/solicitud.service';
import { Observable } from 'rxjs';
import Swal from 'sweetalert2';
import {
  Router,
} from '@angular/router';

@Component({
  selector: 'app-listar-solicitud',
  templateUrl: './listar-solicitud.component.html',
  styleUrls: ['./listar-solicitud.component.scss'],
})
export class ListarSolicitudComponent implements OnInit {
  public listaProductos: Observable<Solicitud[]>;

  constructor(
    private solicitudService: SolicitudService,
    private router: Router
  ) {}

  ngOnInit() {
    this.listaProductos = this.solicitudService.consultar();
  }

  cancelarSolicitud(solicitud: Solicitud) {
    Swal.fire({
      title: `Estas seguro de eliminar la solicitud # ${solicitud.id}`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, cancelarlo',
      cancelButtonText: 'no, no lo quiero hacer!!',
    }).then((result) => {
      if (result.isConfirmed) {
        this.solicitudService.eliminar(solicitud).subscribe(
          (response) => {
            Swal.fire({
              icon: 'success',
              title: `Se cancelo correctamente ${response}`,
            });
          },
          (e) => {
            Swal.fire({
              icon: 'error',
              title: e.error ? e.error.mensaje : e.statusText,
            });
          }
        );
      }
      this.irAListarSolicitudes();
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
