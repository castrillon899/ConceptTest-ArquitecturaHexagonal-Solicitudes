import { element, by } from 'protractor';

export class SolicitudPage {

    private linkListarSolicitudes = element(by.id('linkListarSolicitudes'));
    private linkCrearSolicitud = element(by.id('linkCrearSolicitud'));
    private inputPrimerCliente = element.all(by.tagName('option')).first();
    private inputIdCliente= element(by.id('idCliente'));
    private inputClienteCelularContacto= element(by.id('clienteCelularContacto'));
    private inputTipoDeSolicitud= element(by.id('tipoDeSolicitud'));
    private inputDescripcion= element(by.id('descripcion'));   
    private botonCrear = element(by.buttonText('Crear Solicitud'));
    private botonOkVentanaModal = element(by.buttonText('Si, crealo'));
    private textoSweetAlert = element(by.id('swal2-title'));
    private listaSolicitudes= element.all(by.css('app-root table tbody tr'));


    async ingresarIdCliente(idProducto) {
        await this.inputIdCliente.sendKeys(idProducto);
    }


    async ingresarTipoDeSolicitud(tipoDeSolicitud) {
        await this.inputTipoDeSolicitud.sendKeys(tipoDeSolicitud);
    }

    async ingresarClienteCelularContacto(inputClienteCelularContacto) {
        await this.inputClienteCelularContacto.sendKeys(inputClienteCelularContacto);
    }

    async ingresarDescripcion(descripcion) {
        await this.inputDescripcion.sendKeys(descripcion);
    }


    async clickBotonListarSolicitudes() {
        await this.linkListarSolicitudes.click();
    }

    async clickLinkBotonCrear() {
        await this.linkCrearSolicitud.click();
    }

    async clickSeleccionarPrimerCliente() {
        await this.inputPrimerCliente.click();
    }
  
    async contarSolicitudes() {
        return this.listaSolicitudes.count();
    }
   
    async clickBotonCrear() {
        await this.botonCrear.click();
    }

    obtenerTextoSweetAlert() {
        return this.textoSweetAlert.getText() as Promise<string>;
    }

    async clickBotonOK() {
        await this.botonOkVentanaModal.click();
    }
}
