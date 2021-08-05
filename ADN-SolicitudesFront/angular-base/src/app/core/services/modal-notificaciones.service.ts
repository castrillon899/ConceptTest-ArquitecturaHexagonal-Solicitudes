import Swal from 'sweetalert2';

export class ModalNotificaciones {
  titulo: string;
  icono: string;
  mostrarBotonCancelacion: boolean;
  colorDeBotonConfirmacion: string;
  colorDeBotonDeCancelacion: string;
  botonConfirmacionTexto: string;
  botonCancelacionTexto: string;

  constructor() {}

  public modalConConfirmacion(
    titulo: string,
    icono: string,
    mostrarBotonCancelacion: boolean,
    colorDeBotonConfirmacion: string,
    colorDeBotonDeCancelacion: string,
    botonConfirmacionTexto: string,
    botonCancelacionTexto: string
  ) {
    this.titulo = titulo;
    this.icono = icono;
    this.mostrarBotonCancelacion = mostrarBotonCancelacion;
    this.colorDeBotonConfirmacion = colorDeBotonConfirmacion;
    this.colorDeBotonDeCancelacion = colorDeBotonDeCancelacion;
    this.botonConfirmacionTexto = botonConfirmacionTexto;
    this.botonCancelacionTexto = botonCancelacionTexto;

    return Swal.fire({
      title: this.titulo,
      icon: this.icono === 'warning' ? 'warning' : 'info',
      showCancelButton: this.mostrarBotonCancelacion,
      confirmButtonColor: this.colorDeBotonConfirmacion,
      cancelButtonColor: this.colorDeBotonDeCancelacion,
      confirmButtonText: this.botonConfirmacionTexto,
      cancelButtonText: this.botonCancelacionTexto,
    }).then((result) => {
      if (!result.isConfirmed) {
        return false;
      }
      return true;
    });
  }

  public modalBasico(titulo: string, icono: string) {
    this.titulo = titulo;
    this.icono = icono;
    return Swal.fire({
      title: this.titulo,
      icon: this.icono === 'warning' ? 'warning' : 'success',
    }).then((result) => {
      return result;
    });
  }
}
