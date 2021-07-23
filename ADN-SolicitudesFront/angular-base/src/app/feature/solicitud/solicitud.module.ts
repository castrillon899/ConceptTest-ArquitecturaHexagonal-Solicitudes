import { NgModule } from '@angular/core';
import { CrearSolicitudComponent } from './components/crear-solicitud/crear-solicitud.component';
import { ListarSolicitudComponent } from './components/listar-solicitud/listar-solicitud.component';
import { BorrarSolicitudComponent } from './components/borrar-solicitud/borrar-solicitud.component';
import { SolicitudComponent } from './components/solicitud/solicitud.component';
import { SolicitudRoutingModule } from './solicitud-routing.module';
import { SharedModule } from '@shared/shared.module';
import { SolicitudService } from './shared/service/solicitud.service';




@NgModule({
  declarations: [
    CrearSolicitudComponent,
    ListarSolicitudComponent,
    BorrarSolicitudComponent,
    SolicitudComponent
  ],
  imports: [
    SolicitudRoutingModule,
    SharedModule
  ],
  
  providers: [SolicitudService]
 
})
export class SolicitudModule { }


