import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SolicitudService } from '@solicitud/shared/service/solicitud.service';
import { tiposDeSolicitud } from '../../../../../../src/assets/json/tipos_solicitud'
import Swal from 'sweetalert2';
//import { FormControl, FormGroup, Validators } from '@angular/forms';
import { //ActivatedRoute,
  Router
} from '@angular/router';


//const LONGITUD_MINIMA_PERMITIDA_TEXTO = 3;
//const LONGITUD_MAXIMA_PERMITIDA_TEXTO = 20;
//import { FormGroup } from '@angular/forms';
@Component({
  selector: 'app-crear-solicitud',
  templateUrl: './crear-solicitud.component.html',
  styleUrls: ['./crear-solicitud.component.scss']
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


  constructor(protected solicitudServices: SolicitudService, protected router: Router) {
    this.tiposSolicitudList = tiposDeSolicitud;
  }

  ngOnInit(): void {
    this.construirFormularioEnvio();
  }

  crear() {
    Swal.fire({
      title: 'Estas seguro de crear la solicitud',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, crealo',
      cancelButtonText: 'no, Cancelar!!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.solicitudServices.crear(this.envioForm.value).subscribe((response) => {
          this.id = response.valor;
          if (response.valor) {
            Swal.fire({
              icon: 'success',
              title: `Se creo el radicado  # ${response.valor}`
            });
            this.envioForm.reset();
          }
          setTimeout(() => {
            this.irAListarSolicitudes();
          }, 1000);
        }, (e) => {
          console.log(e)
          Swal.fire({
            icon: 'error',
            title: e.error ? e.error.mensaje : e.statusText
          });
          this.error = e.error
        });

      }
    })
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
