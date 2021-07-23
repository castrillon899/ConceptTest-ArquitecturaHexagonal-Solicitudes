import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BorrarSolicitudComponent } from './borrar-solicitud.component';

describe('BorrarSolicitudComponent', () => {
  let component: BorrarSolicitudComponent;
  let fixture: ComponentFixture<BorrarSolicitudComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BorrarSolicitudComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BorrarSolicitudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
