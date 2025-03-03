package dominio.juego;

import dominio.fichas.Ficha;
import dominio.tablero.Coordenada;
import dominio.tablero.Tablero;
import java.util.ArrayList;
import java.util.List;

public class CantidadDeEsquinasAlargadas extends Regla {

  private EsEsquina esEsquina;

  public CantidadDeEsquinasAlargadas() {
    this.esEsquina = new EsEsquina();
  }

  @Override
  public List<Coordenada> verificar(Ficha[][] tablero, int fila, int columna) {
    List<Coordenada> coordenadaDondeAlargoEsquina = new ArrayList<>();

    // fila subiendo
    for (int i = 0; i < Tablero.TAMANO_TABLERO; i++) {
      if (i >= 2
          && esPosicionDentroDelTablero((fila - i), columna)
          && esEsquina.verificar(tablero, (fila - i), columna)) {
        coordenadaDondeAlargoEsquina.add(new Coordenada(fila - i, columna));
      }
    }

    return coordenadaDondeAlargoEsquina;
  }
}
