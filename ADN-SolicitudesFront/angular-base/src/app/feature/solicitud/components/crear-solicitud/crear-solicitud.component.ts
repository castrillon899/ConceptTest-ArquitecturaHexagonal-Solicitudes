import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SolicitudService } from '@solicitud/shared/service/solicitud.service';
import { tiposDeSolicitud } from '../../../../../../src/assets/json/tipos_solicitud';
import { Router } from '@angular/router';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

@Component({
  selector: 'app-crear-solicitud',
  templateUrl: './crear-solicitud.component.html',
})
export class CrearSolicitudComponent implements OnInit {
  envioForm: FormGroup;
  descripcion: string;
  tipoDeSolicitud: string;
  idCliente: number;
  clienteCelularContacto: number;
  id: string;
  error: string;
  tiposSolicitudList: any[];

  constructor(
    private solicitudServices: SolicitudService,
    private router: Router,
    private modalNotificaciones: ModalNotificaciones
  ) {
    this.tiposSolicitudList = tiposDeSolicitud;
  }

  ngOnInit(): void {
    this.construirFormularioEnvio();
  }

  crear() {
    this.modalNotificaciones
      .modalConConfirmacion(
        'Estas seguro de crear la solicitud',
        'warning',
        true,
        '#3085d6',
        '#d33',
        'Si, crealo',
        'no, Cancelar!!'
      )
      .then((respuestaConfirmacion) => {
        if (respuestaConfirmacion) {
          this.solicitudServices.crear(this.envioForm.value).subscribe(
            (response) => {
              this.id = response.valor;
              if (response.valor) {
                this.modalNotificaciones.modalBasico(
                  `Se creo el radicado  # ${response.valor}`,
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
                `No se puedo crear la notificacion ${e}`,
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
    this.envioForm = new FormGroup({
      idCliente: new FormControl('', [Validators.required]),
      clienteCelularContacto: new FormControl('', [Validators.required]),
      tipoDeSolicitud: new FormControl('', [Validators.required]),
      descripcion: new FormControl('', [Validators.required]),
    });
  }
}
