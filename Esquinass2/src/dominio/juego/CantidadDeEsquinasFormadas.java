package dominio.juego;

import dominio.fichas.Ficha;

public class CantidadDeEsquinasFormadas extends Regla<Integer> {
  public Integer verificar(Ficha[][] tablero, int fila, int columna) {
    int cantidadDeEsquinasFromadas = 0;

    for (int[][] combinacion : COORDENADAS_A_VERIFICAR_PARA_LA_GENERACION_DE_ESQUINAS) {
      boolean formoEsquina = true;

      for (int[] coordenada : combinacion) {
        int deltaFila = coordenada[0];
        int deltaColumna = coordenada[1];

        int nuevaFila = fila + deltaFila;
        int nuevaColumna = columna + deltaColumna;

        if (esPosicionDentroDelTablero(nuevaFila, nuevaColumna)
            && !tablero[nuevaFila][nuevaColumna].esFichaNeutra()) {
          continue;
        }

        formoEsquina = false;
        break;
      }

      if (formoEsquina) {
        cantidadDeEsquinasFromadas++;
      }
    }

    return cantidadDeEsquinasFromadas;
  }
}
