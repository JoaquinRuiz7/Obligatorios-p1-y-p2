package tests;

import dominio.fichas.Ficha;
import dominio.fichas.FichaNeutra;
import dominio.fichas.FichaRoja;
import dominio.juego.EsquinasExtendidasVerticalmente;
import dominio.tablero.Coordenada;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEsquinasExtendidasVerticalmente {

  private Ficha[][] tablero;
  private EsquinasExtendidasVerticalmente esquinasExtendidasVerticalmente;

  @Before
  public void setUp() {
    tablero = new Ficha[6][6];
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        tablero[i][j] = new FichaNeutra();
      }
    }
    this.esquinasExtendidasVerticalmente = new EsquinasExtendidasVerticalmente();
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
        esquinasExtendidasVerticalmente.verificar(tablero, 5, 0);

    Assert.assertEquals(2, coordenadasDondeAlargoEsquina.size());
    Assert.assertEquals(new Coordenada(2, 0), coordenadasDondeAlargoEsquina.get(0));
    Assert.assertEquals(new Coordenada(0, 0), coordenadasDondeAlargoEsquina.get(1));
  }

  @Test
  public void testAlargoUnaEsquinas() {
    tablero[0][0] = new FichaRoja();
    tablero[0][1] = new FichaRoja();
    tablero[1][0] = new FichaRoja();
    tablero[2][0] = new FichaRoja();
    tablero[3][0] = new FichaRoja();

    List<Coordenada> coordenadasDondeAlargoEsquina =
        esquinasExtendidasVerticalmente.verificar(tablero, 3, 0);

    Assert.assertEquals(1, coordenadasDondeAlargoEsquina.size());
    Assert.assertEquals(new Coordenada(0, 0), coordenadasDondeAlargoEsquina.get(0));
  }

  @Test
  public void testExtieneEsquinaVerticalmenteHaciaAbajo() {
    tablero[5][0] = new FichaRoja();
    tablero[5][1] = new FichaRoja();
    tablero[4][0] = new FichaRoja();
    tablero[3][0] = new FichaRoja();
    tablero[2][0] = new FichaRoja();

    List<Coordenada> coordenadasDondeAlargoEsquina =
        esquinasExtendidasVerticalmente.verificar(tablero, 1, 0);

    Assert.assertEquals(1, coordenadasDondeAlargoEsquina.size());
    Assert.assertEquals(new Coordenada(5, 0), coordenadasDondeAlargoEsquina.get(0));
  }
}
