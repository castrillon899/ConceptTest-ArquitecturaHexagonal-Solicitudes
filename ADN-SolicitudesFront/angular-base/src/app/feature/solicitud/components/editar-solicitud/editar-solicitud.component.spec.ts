import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpService } from '@core/services/http.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';
import { SolicitudService } from '@solicitud/shared/service/solicitud.service';
import { EditarSolicitudComponent } from './editar-solicitud.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { Solicitud } from '@solicitud/shared/model/solicitud';
import { of } from 'rxjs';

describe('EditarSolicitudComponent', () => {
  let component: EditarSolicitudComponent;
  let fixture: ComponentFixture<EditarSolicitudComponent>;
  let solicitudService: SolicitudService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditarSolicitudComponent],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule,
        ReactiveFormsModule,
        FormsModule,
      ],
      providers: [SolicitudService, HttpService, ModalNotificaciones],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarSolicitudComponent);
    component = fixture.componentInstance;
    solicitudService = TestBed.inject(SolicitudService);
    const solicitud: Solicitud = {
      id: 1,
      descripcion:
        'la usuaria manifiesta inconformidad con la factura recibida por favor $200.000',
      tipoDeSolicitud: 'QUEJA',
      estado: 'EN_PROGRESO',
      fechaCreacion: '2021-07-30 06:55:14',
      fechaActualizacion: '2021-07-30 06:55:14',
      fechaTentativaDeRespuesta: '2021-07-31 06:55:14',
      fechaMaximaDeRespuesta: '2021-08-01 06:55:14',
      idUsuarioAsignado: 1,
      respuestaDeLaSolicitud: 'Se esta revisando factura',
      idCliente: 1233,
      clienteCelularContacto: 3004177487,
      respuestaSolicitud: 'atendiendo',
    };
    solicitudService.seleccionarSolicitud(solicitud);
    spyOn(solicitudService, 'editar').and.returnValue(of({ valor: 1 }));
    fixture.detectChanges();
  });

  it('should update', () => {
    component.envioForm.controls.estado.setValue('CANCELADA');
    component.editar();
    expect(component).toBeTruthy();
  });
});
