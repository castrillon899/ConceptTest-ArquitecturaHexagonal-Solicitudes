import { waitForAsync, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarSolicitudComponent } from './listar-solicitud.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { SolicitudService } from '@solicitud/shared/service/solicitud.service';
import { HttpService } from 'src/app/core/services/http.service';
import { Solicitud } from '@solicitud/shared/model/solicitud';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

describe('SolicitudListarComponent', () => {
  let component: ListarSolicitudComponent;
  let fixture: ComponentFixture<ListarSolicitudComponent>;
  let solicitudService: SolicitudService;
  const listaSolicitudes: Solicitud[] = [
    {
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
    },
    {
      id: 2,
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
    },
    {
      id: 3,
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
    },
    {
      id: 4,
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
    },
    {
      id: 5,
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
    },
  ];

  beforeEach(
    waitForAsync(() => {
      TestBed.configureTestingModule({
        declarations: [ListarSolicitudComponent],
        imports: [CommonModule, HttpClientModule, RouterTestingModule],
        providers: [SolicitudService, HttpService, ModalNotificaciones],
      }).compileComponents();
    })
  );

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarSolicitudComponent);
    component = fixture.componentInstance;
    solicitudService = TestBed.inject(SolicitudService);
    spyOn(solicitudService, 'consultar').and.returnValue(of(listaSolicitudes));
    fixture.detectChanges();
  });

  it('should listar Solicitudes', () => {
    expect(component).toBeTruthy();
  });
});
