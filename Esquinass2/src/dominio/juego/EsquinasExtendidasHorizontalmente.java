package dominio.juego;

import dominio.fichas.Ficha;
import dominio.tablero.Coordenada;
import dominio.tablero.Tablero;
import java.util.ArrayList;
import java.util.List;

public class EsquinasExtendidasHorizontalmente extends Regla<List<Coordenada>> {
  private DeteccionEsquina esEsquina;

  public EsquinasExtendidasHorizontalmente() {
    this.esEsquina = new DeteccionEsquina();
  }

  @Override
  public List<Coordenada> verificar(Ficha[][] tablero, int fila, int columna) {
    List<Coordenada> coordenadaDondeAlargoEsquina = new ArrayList<>();

    for (int i = 2; i < Tablero.TAMANO_TABLERO; i++) {
      int posicionHorizontal = columna - i;
      if (esPosicionDentroDelTablero(fila, posicionHorizontal)
          && esEsquina.verificar(tablero, fila, posicionHorizontal)) {
        coordenadaDondeAlargoEsquina.add(new Coordenada(fila, posicionHorizontal));
      }
    }

    for (int i = 2; i < Tablero.TAMANO_TABLERO; i++) {
      int posicionHorizontal = columna + i;
      if (esPosicionDentroDelTablero(fila, posicionHorizontal)
          && esEsquina.verificar(tablero, fila, posicionHorizontal)) {
        coordenadaDondeAlargoEsquina.add(new Coordenada(fila, posicionHorizontal));
      }
    }

    return coordenadaDondeAlargoEsquina;
  }
}
