import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SolicitudService } from '@solicitud/shared/service/solicitud.service';
import { tiposDeSolicitud } from '../../../../../../src/assets/json/tipos_solicitud';
import { estadosDeSolicitud } from '../../../../../../src/assets/json/estados_solicitud';
import { Router } from '@angular/router';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

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
    private router: Router,
    private modalNotificaciones: ModalNotificaciones
  ) {
    this.tiposSolicitudList = tiposDeSolicitud;
    this.estadosSolicitudList = estadosDeSolicitud;
  }

  ngOnInit(): void {
    this.construirFormularioEnvio();
  }

  editar() {
    this.modalNotificaciones
      .modalConConfirmacion(
        'Estas seguro de actualizar la solicitud',
        'warning',
        true,
        '#3085d6',
        '#d33',
        'Si, crealo',
        'no, Cancelar!!'
      )
      .then((respuestaConfirmacion) => {
        if (respuestaConfirmacion) {
          this.solicitudServices.editar(this.envioForm.value).subscribe(
            (response) => {
              this.id = response.valor;
              if (response.valor) {
                this.modalNotificaciones.modalBasico(
                  `Se actualizado el radicado  # ${this.envioForm.value.id}`,
                  'success'
                );
                this.envioForm.reset();

                setTimeout(() => {
                  this.irAListarSolicitudes();
                }, 1000);
              }
            },
            (e) => {
              this.modalNotificaciones.modalBasico(
                e.error ? e.error.mensaje : e.statusText,
                'warning'
              );
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
