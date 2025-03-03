package dominio.juego;

import dominio.fichas.Ficha;

public class EsEsquina extends Regla<Boolean> {

  private static final int[][][] COORDENADAS_A_VERIFICAR = {
    {{0, -1}, {1, 0}}, {{0, 1}, {-1, 0}},
  };

  @Override
  public Boolean verificar(Ficha[][] tablero, int fila, int columna) {
    boolean esEsquina = true;
    for (int[][] combincaion : COORDENADAS_A_VERIFICAR) {
      for (int[] coordenada : combincaion) {
        int deltaFila = coordenada[0];
        int deltaColumna = coordenada[1];

        int nuevaFila = fila + deltaFila;
        int nuevaColumna = columna + deltaColumna;
        if (esPosicionDentroDelTablero(nuevaFila, nuevaColumna)
            && tablero[nuevaFila][nuevaColumna].esFichaNeutra()) {
          esEsquina = false;
        }
      }
    }

    return esEsquina;
  }
}
