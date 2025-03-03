package dominio.juego;

import dominio.fichas.Ficha;

public class FormoEsquina extends Regla {

  @Override
  public Boolean verificar(Ficha[][] tablero, int fila, int columna) {
    boolean formoEsquina = false;

    for (int[][] combinacion : COORDENADAS_A_VERIFICAR_PARA_LA_GENERACION_DE_ESQUINAS) {

      for (int[] coordenada : combinacion) {
        int deltaFila = coordenada[0];
        int deltaColumna = coordenada[1];

        int nuevaFila = fila + deltaFila;
        int nuevaColumna = columna + deltaColumna;

        if (esPosicionDentroDelTablero(nuevaFila, nuevaColumna)
            && !tablero[nuevaFila][nuevaColumna].esFichaNeutra()) {
          return true;
        }
      }
    }

    return formoEsquina;
  }
}
