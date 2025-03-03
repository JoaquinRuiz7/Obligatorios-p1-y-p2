package tests;

import dominio.fichas.Ficha;
import dominio.fichas.FichaNeutra;
import dominio.fichas.FichaRoja;
import dominio.juego.CantidadDeEsquinasAlargadas;
import dominio.tablero.Coordenada;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlargoEsquinasTest {

  private Ficha[][] tablero;
  private CantidadDeEsquinasAlargadas cantidadDeEsquinasAlargadas;

  @Before
  public void setUp() {
    tablero = new Ficha[6][6];
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        tablero[i][j] = new FichaNeutra();
      }
    }
    this.cantidadDeEsquinasAlargadas = new CantidadDeEsquinasAlargadas();
  }

  @Test
  public void testAlargoDosEsquinas() {
    tablero[0][0] = new FichaRoja();
    tablero[0][1] = new FichaRoja();
    tablero[1][0] = new FichaRoja();
    tablero[2][0] = new FichaRoja();
    tablero[2][1] = new FichaRoja();
    tablero[3][0] = new FichaRoja();
    tablero[4][0] = new FichaRoja();
    List<Coordenada> coordenadasDondeAlargoEsquina =
        cantidadDeEsquinasAlargadas.verificar(tablero, 5, 0);

    Assert.assertEquals(2, coordenadasDondeAlargoEsquina.size());
  }
}
