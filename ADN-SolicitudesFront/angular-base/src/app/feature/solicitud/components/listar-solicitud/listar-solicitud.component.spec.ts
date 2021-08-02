import { waitForAsync, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarSolicitudComponent } from './listar-solicitud.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { SolicitudService } from '@solicitud/shared/service/solicitud.service';
import { HttpService } from 'src/app/core/services/http.service';
import { Solicitud } from '@solicitud/shared/model/solicitud';


describe('ListarSolicitudComponent', () => {
  let component: ListarSolicitudComponent;
  let fixture: ComponentFixture<ListarSolicitudComponent>;
  let solicitudService: SolicitudService;
  const listaSolicitudes: Solicitud[] = [
    {
      "id": 1,
      "descripcion": "la usuaria manifiesta inconformidad con la factura recibida por favor $200.000",
      "tipoDeSolicitud": "QUEJA",
      "estado": "EN_PROGRESO",
      "fechaCreacion": "2021-07-30 06:55:14",
      "fechaActualizacion": "2021-07-30 06:55:14",
      "fechaTentativaDeRespuesta": "2021-07-31 06:55:14",
      "fechaMaximaDeRespuesta": "2021-08-01 06:55:14",
      "idUsuarioAsignado": 1,
      "respuestaDeLaSolicitud": "Se esta revisando factura",
      "idCliente": 1233,
      "clienteCelularContacto": 3004177487,
      "respuestaSolicitud": "atendiendo"
    },
    {
      "id": 2,
      "descripcion": "la usuaria manifiesta inconformidad con la factura recibida por favor $500.000",
      "tipoDeSolicitud": "QUEJA",
      "estado": "FINALIZADA",
      "fechaCreacion": "2021-07-30 06:55:14",
      "fechaActualizacion": "2021-07-30 06:55:14",
      "fechaTentativaDeRespuesta": "2021-07-31 06:55:14",
      "fechaMaximaDeRespuesta": "2021-08-01 06:55:14",
      "idUsuarioAsignado": 1,
      "respuestaDeLaSolicitud": "Se valido factura sin novedades, la factura fue a corde a comprado por el cliente",
      "idCliente": 1233,
      "clienteCelularContacto": 3004177487,
      "respuestaSolicitud": "atendiendo"
    },
    {
      "id": 3,
      "descripcion": "La usuaria desea conocer el estado del envio del pedido 254554",
      "tipoDeSolicitud": "SOLICITUD",
      "estado": "FINALIZADA",
      "fechaCreacion": "2021-07-30 06:55:14",
      "fechaActualizacion": "2021-07-30 06:55:14",
      "fechaTentativaDeRespuesta": "2021-08-01 06:55:14",
      "fechaMaximaDeRespuesta": "2021-08-04 06:55:14",
      "idUsuarioAsignado": 1,
      "respuestaDeLaSolicitud": "el envio se encuentra en camino, llegara el dia 30/08/2021",
      "idCliente": 1244,
      "clienteCelularContacto": 3004177488,
      "respuestaSolicitud": "atendiendo"
    },
    {
      "id": 4,
      "descripcion": "La usuaria desea conocer el estado del envio del pedido 544112",
      "tipoDeSolicitud": "SOLICITUD",
      "estado": "FINALIZADA",
      "fechaCreacion": "2021-07-30 06:55:14",
      "fechaActualizacion": "2021-07-30 06:55:14",
      "fechaTentativaDeRespuesta": "2021-08-01 06:55:14",
      "fechaMaximaDeRespuesta": "2021-08-04 06:55:14",
      "idUsuarioAsignado": 1,
      "respuestaDeLaSolicitud": "el envio se encuentra en camino, llegara el dia 27/08/2021",
      "idCliente": 1244,
      "clienteCelularContacto": 3004177488,
      "respuestaSolicitud": "atendiendo"
    },
    {
      "id": 5,
      "descripcion": "La usuaria desea conocer el estado del envio del pedido 5421",
      "tipoDeSolicitud": "SOLICITUD",
      "estado": "CANCELADA",
      "fechaCreacion": "2021-07-30 06:55:14",
      "fechaActualizacion": "2021-07-30 06:55:14",
      "fechaTentativaDeRespuesta": "2021-08-01 06:55:14",
      "fechaMaximaDeRespuesta": "2021-08-04 06:55:14",
      "idUsuarioAsignado": 1,
      "respuestaDeLaSolicitud": "Se cancela solicitud, el pedido no pertenece al cliente, no se le puede brindar esa informacion",
      "idCliente": 1244,
      "clienteCelularContacto": 3004177488,
      "respuestaSolicitud": "atendiendo"
    }
  ];

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ListarSolicitudComponent],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule
      ],
      providers: [SolicitudService, HttpService]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarSolicitudComponent);
    component = fixture.componentInstance;
    solicitudService = TestBed.inject(SolicitudService);
    spyOn(solicitudService, 'consultar').and.returnValue(
      of(listaSolicitudes)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
