import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from '@home/home.component';
import { ProductoModule } from '@producto/producto.module';
import { SolicitudModule } from '@solicitud/solicitud.module';
import { CoreModule } from '@core/core.module';
import { CookieService } from 'ngx-cookie-service';

import { registerLocaleData } from '@angular/common';
import localeEs from '@angular/common/locales/es';
import { LOCALE_ID } from '@angular/core';


registerLocaleData(localeEs);


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SolicitudModule,
    ProductoModule,
    CoreModule
  ],
  providers: [CookieService, { provide: LOCALE_ID, useValue: 'es' },],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],

})
export class AppModule { }
