package dominio.juego;

import dominio.fichas.Ficha;
import dominio.tablero.Coordenada;
import dominio.tablero.Tablero;
import java.util.ArrayList;
import java.util.List;

public class EsquinasExtendidasVerticalmente extends Regla {

  private DeteccionEsquina esEsquina;

  public EsquinasExtendidasVerticalmente() {
    this.esEsquina = new DeteccionEsquina();
  }

  @Override
  public List<Coordenada> verificar(Ficha[][] tablero, int fila, int columna) {
    List<Coordenada> coordenadaDondeAlargoEsquina = new ArrayList<>();

    for (int i = 2; i < Tablero.TAMANO_TABLERO; i++) {
      int posicionVertical = fila - i;
      if (esPosicionDentroDelTablero(posicionVertical, columna)
          && esEsquina.verificar(tablero, posicionVertical, columna)) {
        coordenadaDondeAlargoEsquina.add(new Coordenada(posicionVertical, columna));
      }
    }

    for (int i = 2; i < Tablero.TAMANO_TABLERO; i++) {
      int posicionVertical = fila + i;
      if (esPosicionDentroDelTablero(posicionVertical, columna)
          && esEsquina.verificar(tablero, posicionVertical, columna)) {
        coordenadaDondeAlargoEsquina.add(new Coordenada(posicionVertical, columna));
      }
    }

    return coordenadaDondeAlargoEsquina;
  }
}
