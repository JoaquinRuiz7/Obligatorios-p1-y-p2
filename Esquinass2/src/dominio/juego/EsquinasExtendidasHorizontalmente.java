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
      int nuevaColumna = columna - i;
      if (esPosicionDentroDelTablero(fila, nuevaColumna)
          && esEsquina.verificar(tablero, fila, nuevaColumna)) {
        coordenadaDondeAlargoEsquina.add(new Coordenada(fila, nuevaColumna));
      }
    }

    for (int i = 2; i < Tablero.TAMANO_TABLERO; i++) {
      int nuevaColumna = columna + i;
      if (esPosicionDentroDelTablero(fila, nuevaColumna)
          && esEsquina.verificar(tablero, fila, nuevaColumna)) {
        coordenadaDondeAlargoEsquina.add(new Coordenada(fila, nuevaColumna));
      }
    }

    return coordenadaDondeAlargoEsquina;
  }
}
