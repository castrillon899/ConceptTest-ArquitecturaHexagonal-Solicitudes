import { element, by } from 'protractor';

export class SolicitudPage {

    private linkListarSolicitudes = element(by.id('linkListarSolicitudes'));
    private linkCrearSolicitud = element(by.id('linkCrearSolicitud'));
    private inputPrimerCliente = element.all(by.tagName('option')).first();
    private inputIdCliente = element(by.id('idCliente'));
    private inputRespuestaSolicitud = element(by.id('respuestaSolicitud'));
    private inputClienteCelularContacto = element(by.id('clienteCelularContacto'));
    private inputTipoDeSolicitud = element(by.id('tipoDeSolicitud'));
    private inputDescripcion = element(by.id('descripcion'));
    private botonCrear = element(by.buttonText('Crear Solicitud'));
    private botonActualizar = element(by.buttonText('Actualizar solicitud'));
    private botonOkVentanaModal = element(by.buttonText('Si, crealo'));
    private botonActualizadoVentanaModal = element(by.buttonText('Si, actualizar'));
    private textoSweetAlert = element(by.id('swal2-title'));
    private botonEditarPrimerSolicitud = element.all(by.css('.btn-editar-solicitud')).first();




    async ingresarRespuestaSolicitud(respuestaSolicitud) {
        await this.inputRespuestaSolicitud.sendKeys(respuestaSolicitud);
    }



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

    async clickEditarPrimeraSolicitud() {

        await this.botonEditarPrimerSolicitud.click();
    }

    async clickSeleccionarPrimerCliente() {
        await this.inputPrimerCliente.click();
    }

    async clickBotonCrear() {
        await this.botonCrear.click();
    }

    async clickBotonActualizar() {
        await this.botonActualizar.click();
    }


    obtenerTextoSweetAlert() {
        return this.textoSweetAlert.getText() as Promise<string>;
    }

    async clickBotonOK() {
        await this.botonOkVentanaModal.click();
    }

    async clickBotonActualizarModal() {
        await this.botonActualizadoVentanaModal.click();
    }

}
