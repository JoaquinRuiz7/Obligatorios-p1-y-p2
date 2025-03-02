package tests;

import dominio.fichas.Ficha;
import dominio.fichas.FichaNeutra;
import dominio.fichas.FichaRoja;
import dominio.juego.Reglas;
import org.junit.Assert;
import org.junit.Test;

public class ReglasTest {

  @Test
  public void testFormoEsquina() {
    Ficha[][] tablero = new Ficha[6][6];
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        tablero[i][j] = new FichaNeutra();
      }
    }
    tablero[0][1] = new FichaRoja();
    tablero[1][0] = new FichaRoja();
    tablero[1][2] = new FichaRoja();
    tablero[2][1] = new FichaRoja();

    Reglas reglas = new Reglas();
    int result = reglas.getCantidadDeEsquinasFormadas(tablero, 1, 1);
    Assert.assertEquals(4, result);
  }
}
