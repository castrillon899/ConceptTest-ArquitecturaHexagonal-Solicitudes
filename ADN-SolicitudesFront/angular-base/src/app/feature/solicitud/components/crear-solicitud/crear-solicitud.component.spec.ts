import { CrearSolicitudComponent } from './crear-solicitud.component';
import { waitForAsync, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from 'src/app/core/services/http.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SolicitudService } from '@solicitud/shared/service/solicitud.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

describe('CrearSolicitudComponent', () => {
  let component: CrearSolicitudComponent;
  let fixture: ComponentFixture<CrearSolicitudComponent>;
  let solicitudService: SolicitudService;

  beforeEach(
    waitForAsync(() => {
      TestBed.configureTestingModule({
        declarations: [CrearSolicitudComponent],
        imports: [
          CommonModule,
          HttpClientModule,
          RouterTestingModule,
          ReactiveFormsModule,
          FormsModule,
        ],
        providers: [SolicitudService, HttpService, ModalNotificaciones],
      }).compileComponents();
    })
  );

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearSolicitudComponent);
    component = fixture.componentInstance;
    solicitudService = TestBed.inject(SolicitudService);
    spyOn(solicitudService, 'crear').and.returnValue(of({ valor: 18 }));
    fixture.detectChanges();
  });

  it('formulario es invalido cuando esta vacio', () => {
    expect(component.envioForm.valid).toBeFalsy();
  });

  it('Registrando solicitud', () => {
    expect(component.envioForm.valid).toBeFalsy();
    component.envioForm.controls.tipoDeSolicitud.setValue('QUEJA');
    component.envioForm.controls.idCliente.setValue(123);
    component.envioForm.controls.clienteCelularContacto.setValue(123);
    component.envioForm.controls.descripcion.setValue('Producto test');
    expect(component.envioForm.valid).toBeTruthy();
    component.crear();
  });
});
