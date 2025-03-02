package dominio.juego;

import dominio.fichas.Ficha;
import dominio.tablero.Coordenada;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reglas {
  private static final int[][] COORDENADAS_A_VERIFICAR_PARA_LA_GENERACION_DE_ESQUINAS = {
    {0, -1}, {1, 0}, {-1, 0}, {0, 1}, {-1, -1}, {1, 1}
  };

  public List<Coordenada> getCoordenadasDondeFormoEsquina(
      Ficha[][] tablero, int fila, int columna) {
    if (!esPosicionDentroDelTablero(fila, columna)) {
      return Collections.emptyList();
    }

    List<Coordenada> coordenadasDondeFormoEsquina = new ArrayList<>();

    for (int[] coordenada : COORDENADAS_A_VERIFICAR_PARA_LA_GENERACION_DE_ESQUINAS) {
      int deltaFila = coordenada[0];
      int deltaColumna = coordenada[1];

      int nuevaFila = fila + deltaFila;
      int nuevaColumna = columna + deltaColumna;

      if (esPosicionDentroDelTablero(nuevaFila, nuevaColumna)
          && !tablero[nuevaFila][nuevaColumna].esFichaNeutra()) {
        coordenadasDondeFormoEsquina.add(new Coordenada(nuevaFila, nuevaColumna));
      }
    }

    return coordenadasDondeFormoEsquina;
  }

  private boolean esPosicionDentroDelTablero(int fila, int columna) {
    return fila >= 0 && fila < 5 && columna >= 0 && columna < 5;
  }
}
