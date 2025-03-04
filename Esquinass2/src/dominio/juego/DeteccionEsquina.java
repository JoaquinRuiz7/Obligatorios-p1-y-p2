package dominio.juego;

import dominio.fichas.Ficha;

public class DeteccionEsquina extends Regla<Boolean> {

  private static final int[][][] COORDENADAS_A_VERIFICAR = {
    {{0, 1}, {1, 0}},
    {{-1, 0}, {0, 1}},
    {{-1, 0}, {0, -1}},
    {{1, 0}, {0, 1}},
    {{0, -1}, {-1, 0}},
    {{0, -1}, {1, 0}}
  };

  @Override
  public Boolean verificar(Ficha[][] tablero, int fila, int columna) {

    boolean esEsquina = true;
    for (int[][] combincaion : COORDENADAS_A_VERIFICAR) {
      esEsquina = true;
      for (int[] coordenada : combincaion) {
        int deltaFila = coordenada[0];
        int deltaColumna = coordenada[1];

        int nuevaFila = fila + deltaFila;
        int nuevaColumna = columna + deltaColumna;
        esEsquina = esEsquina && esFichaValida(tablero, nuevaFila, nuevaColumna);
      }
      if (esEsquina) {
        return true;
      }
    }

    return esEsquina;
  }

  private boolean esFichaValida(Ficha[][] tablero, int fila, int columna) {
    return esPosicionDentroDelTablero(fila, columna) && !tablero[fila][columna].esFichaNeutra();
  }
}
