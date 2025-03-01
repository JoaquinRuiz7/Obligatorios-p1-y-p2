package dominio;

import dominio.fichas.FichaNeutra;
import dominio.fichas.IFicha;
import java.io.Serializable;

public class Tablero implements Serializable {
  private static final int TAMANO_TABLERO = 6;
  private IFicha[][] fichas;

  public Tablero(IFicha[][] tablero) {
    this.fichas = tablero;
  }

  public Tablero() {
    this.setFichas(fichas);
  }

  public IFicha[][] getFichas() {
    return fichas;
  }

  public void setFichas(IFicha[][] fichas) {
    this.fichas = fichas;
  }

  public void inicializar() {
    IFicha[][] t = new IFicha[TAMANO_TABLERO][TAMANO_TABLERO];
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
