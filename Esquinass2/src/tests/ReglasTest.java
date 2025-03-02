package tests;

import dominio.fichas.Ficha;
import dominio.fichas.FichaNeutra;
import dominio.fichas.FichaRoja;
import dominio.juego.Reglas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReglasTest {

  private Ficha[][] tablero;
  private Reglas reglas;

  @Before
  public void setUp() {
    tablero = new Ficha[6][6];
    reglas = new Reglas();
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        tablero[i][j] = new FichaNeutra();
      }
    }
  }

  @Test
  public void testFichaForma4Esquinas() {
    tablero[0][1] = new FichaRoja();
    tablero[1][0] = new FichaRoja();
    tablero[1][2] = new FichaRoja();
    tablero[2][1] = new FichaRoja();

    int result = reglas.getCantidadDeEsquinasFormadas(tablero, 1, 1);
    Assert.assertEquals(4, result);
  }

  @Test
  public void forma2EsquinasArriba() {
    tablero[1][0] = new FichaRoja();
    tablero[1][1] = new FichaRoja();
    tablero[1][2] = new FichaRoja();
    int result = reglas.getCantidadDeEsquinasFormadas(tablero, 0, 1);
    Assert.assertEquals(2, result);
  }

  @Test
  public void forma2EsquinasAbajo() {
    tablero[1][0] = new FichaRoja();
    tablero[1][1] = new FichaRoja();
    tablero[1][2] = new FichaRoja();
    int result = reglas.getCantidadDeEsquinasFormadas(tablero, 2, 1);
    Assert.assertEquals(2, result);
  }

  @Test
  public void forma2EsquinasALaDerecha() {
    tablero[0][1] = new FichaRoja();
    tablero[1][1] = new FichaRoja();
    tablero[2][1] = new FichaRoja();
    int result = reglas.getCantidadDeEsquinasFormadas(tablero, 1, 2);
    Assert.assertEquals(2, result);
  }

  @Test
  public void forma2EsquinasALaIzquierda() {
    tablero[0][1] = new FichaRoja();
    tablero[1][1] = new FichaRoja();
    tablero[2][1] = new FichaRoja();
    int result = reglas.getCantidadDeEsquinasFormadas(tablero, 1, 0);
    Assert.assertEquals(2, result);
  }

  @Test
  public void forma1EsquinasALaIzquierda() {
    tablero[0][1] = new FichaRoja();
    tablero[1][1] = new FichaRoja();
    int result = reglas.getCantidadDeEsquinasFormadas(tablero, 1, 0);
    Assert.assertEquals(1, result);
  }
}
