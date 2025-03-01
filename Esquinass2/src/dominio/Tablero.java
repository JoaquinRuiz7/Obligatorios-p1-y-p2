package dominio;

import dominio.fichas.Ficha;
import dominio.fichas.FichaNeutra;
import java.io.Serializable;

public class Tablero implements Serializable {
  private static final int TAMANO_TABLERO = 6;
  private Ficha[][] fichas;

  public Tablero(Ficha[][] tablero) {
    this.fichas = tablero;
  }

  public Tablero() {
    this.setFichas(fichas);
  }

  public Ficha[][] getFichas() {
    return fichas;
  }

  public void setFichas(Ficha[][] fichas) {
    this.fichas = fichas;
  }

  public void inicializar() {
    Ficha[][] t = new Ficha[TAMANO_TABLERO][TAMANO_TABLERO];
    for (int i = 0; i < t.length; i++) {
      for (int j = 0; j < t[0].length; j++) {
        t[i][j] = new FichaNeutra();
      }
    }
    this.setFichas(t);
  }

  public boolean isPositionTaken(int x, int y) {
    return this.fichas[x][y] != null;
  }
}
