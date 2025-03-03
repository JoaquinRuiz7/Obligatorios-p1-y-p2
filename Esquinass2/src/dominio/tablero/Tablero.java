package dominio.tablero;

import dominio.fichas.Ficha;
import dominio.fichas.FichaNeutra;
import java.io.Serializable;

public class Tablero implements Serializable {
  public static final int TAMANO_TABLERO = 6;
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
    Ficha[][] tablero = new Ficha[TAMANO_TABLERO][TAMANO_TABLERO];
    for (int i = 0; i < tablero.length; i++) {
      for (int j = 0; j < tablero[0].length; j++) {
        tablero[i][j] = new FichaNeutra();
      }
    }
    this.setFichas(tablero);
  }
}
