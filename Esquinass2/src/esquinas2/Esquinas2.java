package esquinas2;

import Interfaz.*;
import dominio.Sistema;

// 4876 lineas de codigo.

public class Esquinas2 {

  public static void main(String[] args) {
    Sistema sistema = new Sistema();
    sistema = sistema.loadSystem();
    VentanaMenu vm = new VentanaMenu(sistema);
    vm.setVisible(true);
  }
}
