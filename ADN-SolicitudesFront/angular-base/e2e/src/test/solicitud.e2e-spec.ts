import { browser} from 'protractor';
import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { SolicitudPage } from '../page/solicitud/solicitud.po';

describe('workspace-project Solicitud', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let solicitud: SolicitudPage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        solicitud = new SolicitudPage();
        browser.driver.manage().window().maximize();
    });

    it('Deberia listar solicit', () => {
        page.navigateTo();
        navBar.clickSolicitud();
        solicitud.clickBotonListarSolicitudes();
        expect( solicitud.contarSolicitudes()).toBe(solicitud.contarSolicitudes());
    });

    it('Deberia crear Solicitud', () => {
        const ID_CLIENTE = '001';
        const CELULAR = '001';
        const TIPO_SOLICITUD = 'QUEJA';
        const DESCRIPCION = 'PRUEBAS QUEJA';

        page.navigateTo();
        navBar.clickSolicitud();
        solicitud.clickLinkBotonCrear();
        solicitud.ingresarIdCliente(ID_CLIENTE);
        solicitud.ingresarClienteCelularContacto(CELULAR);
        solicitud.ingresarTipoDeSolicitud(TIPO_SOLICITUD);
        solicitud.ingresarDescripcion(DESCRIPCION);
        solicitud.clickBotonCrear();
        solicitud.clickBotonOK();

        expect(solicitud.obtenerTextoSweetAlert()).toContain('Se creo el radicado');
    });


});
