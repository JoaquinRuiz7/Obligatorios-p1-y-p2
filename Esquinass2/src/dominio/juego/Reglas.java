package dominio.juego;

import dominio.fichas.Ficha;
import dominio.tablero.Coordenada;
import dominio.tablero.Tablero;
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
    {{-1, 0}, {-1, 1}},
    // Ficha colocada arriba
    {{1, 0}, {1, -1}},
    {{1, 0}, {1, 1}},
    // Ficha colocada lateral derecho
    {{0, -1}, {-1, -1}},
    {{0, -1}, {1, -1}},
    // Ficha colocada lateral izquierdo
    {{0, 1}, {-1, 1}},
    {{0, 1}, {1, 1}}
  };

  public int getCantidadDeEsquinasFormadas(Ficha[][] tablero, int fila, int columna) {

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

  public List<Coordenada> getCoordenadasDondeAlargoEsquina(
      Ficha[][] tablero, int fila, int columna) {
    List<Coordenada> coordenadaDondeAlargoEsquina = new ArrayList<>();

    // fila subiendo
    for (int i = 0; i < Tablero.TAMANO_TABLERO; i++) {
      if (i >= 2
          && esPosicionDentroDelTablero((fila - i), columna)
          && getCantidadDeEsquinasFormadas(tablero, (fila - i), columna) != 0) {
        coordenadaDondeAlargoEsquina.add(new Coordenada(fila - i, columna));
      }
    }

    return coordenadaDondeAlargoEsquina;
  }

  private boolean esPosicionDentroDelTablero(int fila, int columna) {
    return fila >= 0 && fila < 5 && columna >= 0 && columna < 5;
  }
}
