package dominio.juego;

import dominio.fichas.Ficha;
import dominio.tablero.Coordenada;
import java.util.ArrayList;
import java.util.List;

public class Reglas {
  private static final int[][][] COORDENADAS_A_VERIFICAR_PARA_LA_GENERACION_DE_ESQUINAS = {
    // Ficha colocada en el centro
    {{0, -1}, {1, 0}}, // esquina inferior izquierda
    {{-1, 0}, {0, -1}}, // Esquina superior izquierda
    {{-1, 0}, {0, 1}}, // Esquina superior derecha
    {{0, 1}, {1, 0}}, // Esquina inferior derecha
    // Ficha colocada abajo
    {{-1, 0}, {-1, -1}},
    {{-1, 0}, {-1, 1}}
  };

  public int getCantidadDeEsquinasFormadas(Ficha[][] tablero, int fila, int columna) {
    if (!esPosicionDentroDelTablero(fila, columna)) {
      return -1;
    }

    List<Coordenada> coordenadasDondeFormoEsquina = new ArrayList<>();
    int cantidadDeEsquinasFromadas = 0;

    for (int[][] combinacion : COORDENADAS_A_VERIFICAR_PARA_LA_GENERACION_DE_ESQUINAS) {
      boolean formoEsquina = true;

      // Recorre cada par de coordenadas dentro de la combinación
      for (int[] coordenada : combinacion) {
        int deltaFila = coordenada[0];
        int deltaColumna = coordenada[1];

        int nuevaFila = fila + deltaFila;
        int nuevaColumna = columna + deltaColumna;

        if (esPosicionDentroDelTablero(nuevaFila, nuevaColumna)
            && !tablero[nuevaFila][nuevaColumna].esFichaNeutra()) {
          continue;
        }
        // Si alguna coordenada no cumple la condición, no formó una esquina
        formoEsquina = false;
        break;
      }

      if (formoEsquina) {
        cantidadDeEsquinasFromadas++;
      }
    }

    return cantidadDeEsquinasFromadas;
  }

  private boolean esPosicionDentroDelTablero(int fila, int columna) {
    return fila >= 0 && fila < 5 && columna >= 0 && columna < 5;
  }
}
