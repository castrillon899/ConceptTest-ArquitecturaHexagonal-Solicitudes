import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { SolicitudService } from './solicitud.service';
import { environment } from 'src/environments/environment';
import { HttpService } from 'src/app/core/services/http.service';
//import { Solicitud } from '../model/solicitud';
import { HttpResponse } from '@angular/common/http';

describe('SolitudService', () => {
  let httpMock: HttpTestingController;
  let service: SolicitudService;
  //const apiEndpointProductoConsulta = `${environment.endpoint}/tiposFamilia`;
  const apiEndpointSolicitudes = `${environment.endpoint}/api/v1/solicitudes`;

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [SolicitudService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    service = TestBed.inject(SolicitudService);
  });

  it('should be created', () => {
    const solicitudService: SolicitudService = TestBed.inject(SolicitudService);
    expect(solicitudService).toBeTruthy();
  });


  /*
  it('deberia crear un producto', () => {
    const dummyProducto = new Producto('1', 'Producto 1');
    service.guardar(dummyProducto).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(apiEndpointProductos);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({body: true}));
  });*/


  it('deberia crear una solicitud', () => {
    const dummyProducto: any = {
      id: 6,
      descripcion: 'esto es una preuba e2e',
      tipoDeSolicitud: 'QUEJA',
      estado: null,
      fechaCreacion: null,
      fechaActualizacion: null,
      fechaTentativaDeRespuesta: null,
      fechaMaximaDeRespuesta: null,
      idUsuarioAsignado: null,
      respuestaDeLaSolicitud: null,
      idCliente: 123,
      clienteCelularContacto: 1234
    };

    const respuestaServicio: any = { 'valor': 7 };


    service.crear(dummyProducto).subscribe((respuesta) => {
      expect(respuesta).toEqual(respuestaServicio);
      console.log('********SE cumple*******************')
    },
    );


    const req = httpMock.expectOne(apiEndpointSolicitudes);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({ body: respuestaServicio }));
  });


  /*
  it('deberia listar productos', () => {
    const dummyProductos = [
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
        "clienteCelularContacto": 3004177487
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
        "clienteCelularContacto": 3004177487
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
        "clienteCelularContacto": 3004177488
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
        "clienteCelularContacto": 3004177488
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
        "clienteCelularContacto": 3004177488
      },
      {
        "id": 6,
        "descripcion": "la usuaria manifiesta inconformidad con la factura recibida por favor $200.000",
        "tipoDeSolicitud": "QUEJA",
        "estado": "CREADA",
        "fechaCreacion": "2021-07-30 11:49:30",
        "fechaActualizacion": "2021-07-30 11:49:30",
        "fechaTentativaDeRespuesta": "2021-08-02 00:00:00",
        "fechaMaximaDeRespuesta": "2021-08-03 00:00:00",
        "idUsuarioAsignado": 2,
        "idCliente": 1233,
        "clienteCelularContacto": 3004177487
      }
      //  new Solicitud(descripcion='222', 'Producto 1'), new Solicitud('2', 'Producto 2')
    ];
    service.consultar().subscribe(productos => {
      console.log(dummyProductos);

      expect(productos.length).toBe(7);
      //expect(productos[0]).toEqual(dummyProductos[0]);
    });
    // const req = httpMock.expectOne(apiEndpointProductoConsulta);
    // expect(req.request.method).toBe('GET');
    // req.flush(dummyProductos);
  });
s
*/


  /*
  it('deberia eliminar un producto', () => {
    const dummyProducto = new Solicitud('1', 'Producto 1');
    service.eliminar(dummyProducto).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(`${apiEndpointProductos}/1`);
    expect(req.request.method).toBe('DELETE');
    req.event(new HttpResponse<boolean>({ body: true }));
  });
  */
});
