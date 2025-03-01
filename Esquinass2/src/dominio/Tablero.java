package dominio;

import dominio.fichas.IFicha;
import java.io.Serializable;

public class Tablero implements Serializable {
  private static final int TAMANO_TABLERO = 6;
  private IFicha[][] tablero;

  public Tablero(IFicha[][] tablero) {
    this.tablero = tablero;
  }

  public Tablero() {
    this.setTablero(tablero);
  }

  public IFicha[][] getTablero() {
    return tablero;
  }

  public void setTablero(IFicha[][] tablero) {
    this.tablero = tablero;
  }

  public void inicializar() {
    IFicha[][] t = new IFicha[TAMANO_TABLERO][TAMANO_TABLERO];
    for (int i = 0; i < t.length; i++) {
      for (int j = 0; j < t[0].length; j++) {
        t[i][j] = null;
      }
    }
    this.setTablero(t);
  }

  public boolean isPositionTaken(int x, int y) {
    return this.tablero[x][y] != null;
  }
}
