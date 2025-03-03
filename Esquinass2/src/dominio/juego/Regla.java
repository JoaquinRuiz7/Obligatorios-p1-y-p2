package dominio.juego;

import dominio.fichas.Ficha;

public abstract class Regla<R> {
  protected static final int[][][] COORDENADAS_A_VERIFICAR_PARA_LA_GENERACION_DE_ESQUINAS = {
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

  public abstract R verificar(Ficha[][] tablero, int fila, int columna);

  protected boolean esPosicionDentroDelTablero(int fila, int columna) {
    return fila >= 0 && fila < 5 && columna >= 0 && columna < 5;
  }
}
