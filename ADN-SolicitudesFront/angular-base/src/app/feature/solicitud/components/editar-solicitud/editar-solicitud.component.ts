import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SolicitudService } from '@solicitud/shared/service/solicitud.service';
import { tiposDeSolicitud } from '../../../../../../src/assets/json/tipos_solicitud';
import { estadosDeSolicitud } from '../../../../../../src/assets/json/estados_solicitud';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-editar-solicitud',
  templateUrl: './editar-solicitud.component.html',
})
export class EditarSolicitudComponent implements OnInit {
  envioForm: FormGroup;
  descripcion: string;
  tipoDeSolicitud: string;
  idCliente: number;
  clienteCelularContacto: number;
  id: string;
  error: string;
  tiposSolicitudList: any[];
  estadosSolicitudList: any[];
  estadoActivo: string;

  constructor(
    private solicitudServices: SolicitudService,
    private router: Router
  ) {
    this.tiposSolicitudList = tiposDeSolicitud;
    this.estadosSolicitudList = estadosDeSolicitud;
  }

  ngOnInit(): void {
    this.construirFormularioEnvio();
  }

  editar() {
    Swal.fire({
      title: 'Estas seguro de actualizar la solicitud',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, actualizar',
      cancelButtonText: 'no, Cancelar!!',
    }).then((result) => {
      if (result.isConfirmed) {
        this.solicitudServices.editar(this.envioForm.value).subscribe(
          (response) => {
            this.id = this.envioForm.value.id;
            if (response.valor) {
              Swal.fire({
                icon: 'success',
                title: `Se actualizado el radicado  # ${this.envioForm.value.id}`,
              });
              this.envioForm.reset();
            }
            setTimeout(() => {
              this.irAListarSolicitudes();
            }, 1000);
          },
          (e) => {
            Swal.fire({
              icon: 'error',
              title: e.error ? e.error.mensaje : e.statusText,
            });
            this.error = e.error;
          }
        );
      }
    });
  }

  limpiar() {
    this.envioForm.reset();
  }

  irAListarSolicitudes() {
    this.router.navigate(['solicitud/listar']);
  }

  private construirFormularioEnvio() {
    this.estadoActivo = this.solicitudServices.solicitudActiva.estado;
    this.envioForm = new FormGroup({
      id: new FormControl(this.solicitudServices.solicitudActiva.id, [
        Validators.required,
      ]),
      idCliente: new FormControl(
        this.solicitudServices.solicitudActiva.idCliente,
        [Validators.required]
      ),
      clienteCelularContacto: new FormControl(
        this.solicitudServices.solicitudActiva.clienteCelularContacto,
        [Validators.required]
      ),
      tipoDeSolicitud: new FormControl(
        this.solicitudServices.solicitudActiva.tipoDeSolicitud,
        [Validators.required]
      ),
      descripcion: new FormControl(
        this.solicitudServices.solicitudActiva.descripcion,
        [Validators.required]
      ),
      estado: new FormControl(this.solicitudServices.solicitudActiva.estado),
      respuestaSolicitud: new FormControl(
        this.solicitudServices.solicitudActiva.respuestaDeLaSolicitud
      ),
      idUsuarioAsignado: new FormControl(
        this.solicitudServices.solicitudActiva.idUsuarioAsignado
      ),
    });
  }
}
