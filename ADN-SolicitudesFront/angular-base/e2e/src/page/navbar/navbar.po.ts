import { by, element } from 'protractor';

export class NavbarPage {
    linkHome = element(by.xpath('/html/body/app-root/app-navbar/nav/a[1]'));
   
    linkSolicitud = element(by.xpath('/html/body/app-root/app-navbar/nav/a[2]'));
   

    async clickSolicitud() {
        await this.linkSolicitud.click();
    }



}
