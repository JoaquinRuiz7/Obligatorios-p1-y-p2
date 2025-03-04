package tests;

import dominio.fichas.Ficha;
import dominio.fichas.FichaNeutra;
import dominio.fichas.FichaRoja;
import dominio.juego.EsquinasExtendidasHorizontalmente;
import dominio.tablero.Coordenada;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEsquinasExtendidasHorizontalmente {
  private Ficha[][] tablero;
  private EsquinasExtendidasHorizontalmente esquinasExtendidasHorizontalmente;

  @Before
  public void setUp() {
    tablero = new Ficha[6][6];
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        tablero[i][j] = new FichaNeutra();
      }
    }
    this.esquinasExtendidasHorizontalmente = new EsquinasExtendidasHorizontalmente();
  }

  @Test
  public void testExtiendeEsquinaHorizontalmentALaDerecha() {
    tablero[2][0] = new FichaRoja();
    tablero[2][1] = new FichaRoja();
    tablero[2][2] = new FichaRoja();
    tablero[3][0] = new FichaRoja();

    List<Coordenada> coordenadasDondeAlargoEsquina =
        esquinasExtendidasHorizontalmente.verificar(tablero, 2, 3);

    Assert.assertEquals(1, coordenadasDondeAlargoEsquina.size());
  }

  @Test
  public void testExtiendeEsquinaHorizontalmentALaIzquierda() {
    tablero[0][0] = new FichaRoja();
    tablero[0][1] = new FichaRoja();
    tablero[1][0] = new FichaRoja();

    List<Coordenada> coordenadasDondeAlargoEsquina =
        esquinasExtendidasHorizontalmente.verificar(tablero, 0, 2);

    Assert.assertEquals(1, coordenadasDondeAlargoEsquina.size());
    Assert.assertEquals(new Coordenada(0, 0), coordenadasDondeAlargoEsquina.get(0));
  }

  @Test
  public void testExtiendeDosEsquinaHorizontalmentALaIzquierda() {
    tablero[0][0] = new FichaRoja();
    tablero[0][1] = new FichaRoja();
    tablero[1][0] = new FichaRoja();
    tablero[0][2] = new FichaRoja();
    tablero[1][2] = new FichaRoja();
    tablero[0][3] = new FichaRoja();

    List<Coordenada> coordenadasDondeAlargoEsquina =
        esquinasExtendidasHorizontalmente.verificar(tablero, 0, 4);

    Assert.assertEquals(2, coordenadasDondeAlargoEsquina.size());
    Assert.assertEquals(new Coordenada(0, 2), coordenadasDondeAlargoEsquina.get(0));
    Assert.assertEquals(new Coordenada(0, 0), coordenadasDondeAlargoEsquina.get(1));
  }

  @Test
  public void testExtiendeEsquinaCasoBorde() {
    tablero[0][5] = new FichaRoja();
    tablero[1][5] = new FichaRoja();
    tablero[0][4] = new FichaRoja();

    List<Coordenada> coordenadasDondeAlargoEsquina =
        esquinasExtendidasHorizontalmente.verificar(tablero, 0, 3);

    Assert.assertEquals(1, coordenadasDondeAlargoEsquina.size());
    Assert.assertEquals(new Coordenada(0, 5), coordenadasDondeAlargoEsquina.get(0));
  }
}
