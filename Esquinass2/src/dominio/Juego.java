package dominio;

import Interfaz.*;
import dominio.fichas.ColorFicha;
import dominio.fichas.Ficha;
import dominio.fichas.FichaAzul;
import dominio.tablero.Tablero;
import java.awt.*;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;

public class Juego implements Serializable {
  private Jugador jugador1;
  private Jugador jugador2;
  private Mensajes mensajes;
  private Tablero tablero;
  private Jugador jugadorActual;
  private VentanaTablero ventanaTablero;

  public Juego(
      Sistema sistema,
      Jugador jugadorr1,
      Jugador jugadorr2,
      Mensajes i,
      Tablero tab,
      VentanaTablero VT) {
    jugador1 = jugadorr1;
    jugador2 = jugadorr2;
    mensajes = i;
    tablero = tab;
    jugadorActual = this.getJugador1();
  }

  public Juego() {
    this.setJugador1(jugador1);
    this.setJugador2(jugador2);
    this.setMensajes(mensajes);
    this.setTablero(tablero);
    this.setJugadorActual(jugadorActual);
    this.setVentanaTablero(ventanaTablero);
  }

  public Jugador getJugadorActual() {
    return jugadorActual;
  }

  public void setJugadorActual(Jugador jugadorActual) {
    this.jugadorActual = jugadorActual;
  }

  public Jugador getJugador1() {
    return jugador1;
  }

  public void setJugador1(Jugador jugador1) {
    this.jugador1 = jugador1;
  }

  public Jugador getJugador2() {
    return jugador2;
  }

  public void setJugador2(Jugador jugador2) {
    this.jugador2 = jugador2;
  }

  public Mensajes getMensajes() {
    return mensajes;
  }

  public void setMensajes(Mensajes mensajes) {
    this.mensajes = mensajes;
  }

  public Tablero getTablero() {
    return tablero;
  }

  public void setTablero(Tablero tablero) {
    this.tablero = tablero;
  }

  public void ponePc(int i, int j, Tablero t, boolean pj) {
    int pI = 0;
    int pJ = 0;
    String letra = "";
    Ficha[][] ta = t.getFichas();
    if (!pj) {
      pI = i;
      pJ = j;

      if (!pj) {
        if (pI > 0 && pI < 5 && (pJ < 5 && pJ > 0)) {
          ta[pI][pJ + 1] = this.getJugadorActual().getFichas().get(0);
        } else if (pI == 0) {
          ta[pI + 1][pJ] = this.getJugadorActual().getFichas().get(0);
        } else if (pI == 5) {
          ta[pI - 1][pJ] = this.getJugadorActual().getFichas().get(0);
        } else if (pJ == 0) {
          ta[pI][pJ + 1] = this.getJugadorActual().getFichas().get(0);
        } else if (pJ == 5) {
          ta[pI][pJ - 1] = this.getJugadorActual().getFichas().get(0);
        } else if (pI == 0 && pJ == 0) {
          ta[pI][pJ + 1] = this.getJugadorActual().getFichas().get(0);
        } else if (pI == 0 && pJ == 5) {
          ta[pI][pJ - 1] = this.getJugadorActual().getFichas().get(0);
        } else if (pI == 5 && pJ == 0) {
          ta[pI][pJ + 1] = this.getJugadorActual().getFichas().get(0);
        } else if (pI == 5 && pJ == 5) {
          ta[pI][pJ - 1] = this.getJugadorActual().getFichas().get(0);
        }
      }
    } else {
      int maximo = 0;
      int posI = 0;
      int posJ = 0;

      for (int k = 0; k < ta.length; k++) {
        for (int l = 0; l < ta[0].length; l++) {

          if (this.ahiSi(k, l, this.getTablero())
              && this.validarPosicion(k, l, tablero)
              && this.noEsCuadrado(k, l, this.getTablero())) {
            if (this.cuentaEsquina(l, k) + this.cuentaAlargoEsquina(k, l, this.getTablero())
                > maximo) {

              maximo = this.cuentaEsquina(l, k) + this.cuentaAlargoEsquina(k, l, this.getTablero());
              posI = k;
              posJ = l;
            }
          }
        }
      }
      for (int k = 0; k < ta.length; k++) {
        for (int l = 0; l < ta[0].length; l++) {
          if (this.ahiSi(k, l, this.getTablero())
              && this.validarPosicion(k, l, tablero)
              && this.noEsCuadrado(k, l, this.getTablero())) {
            if (this.cuentaEsquina(l, k) + this.cuentaAlargoEsquina(k, l, this.getTablero())
                == maximo) {

              if (posI > k) {
                posI = k;
                posJ = l;
              } else if (posI == k) {
                if (posJ > l) {
                  posJ = l;
                  posI = k;
                }
              }
            }
          }
        }
      }
      if (maximo == 0) {
        for (int k = 0; k < ta.length; k++) {
          for (int l = 0; l < ta[0].length; l++) {
            if (this.ahiSi(k, l, this.getTablero())
                && this.validarPosicion(k, l, tablero)
                && this.noEsCuadrado(k, l, this.getTablero())) {
              posI = k;
              posJ = l;
            }
          }
        }
      }

      ta[posI][posJ] = this.getJugadorActual().getFichas().get(0);
      this.getJugadorActual().descontarFichas(1);
      this.actualizarBoton(
          this.getVentanaTablero().getBotones()[posI][posJ], new FichaAzul().getColor(), "A");

      this.numeroALetra(posI, false, false);
      letra = this.numeroALetra(posI, false, false);
      this.getMensajes().jugoEn(letra + (posJ + 1), this.getJugadorActual());
      this.formaEsquina(posJ, posI);
      this.alargoEsquina(posI, posJ, this.getTablero());
    }
  }

  public void colocarFicha(boolean reanudada, boolean primeraJugada, int fila, int columna) {
    int PosicionI = fila;
    int PosicionJ = columna;
    boolean sePuedeColocarFicha = false;
    String jugada = "";
    if (this.getJugadorActual().isHumano()) {

      sePuedeColocarFicha = ahiSi(PosicionI, PosicionJ, this.getTablero());
      if ((sePuedeColocarFicha && primeraJugada) || (reanudada && sePuedeColocarFicha)) {
        sePuedeColocarFicha = validarPosicion(PosicionI, PosicionJ, this.getTablero());
        if (sePuedeColocarFicha) {
          sePuedeColocarFicha = noEsCuadrado(PosicionI, PosicionJ, this.getTablero());
        }
      }

      this.getJugador1().setUltimaPosicionI(PosicionI);
      this.getJugador1().setUltimaPosicionJ(PosicionJ);

      // Aca es donde se coloca la ficha en la posicion tablero[PosicionI][PosicionJ]
      if (sePuedeColocarFicha) {
        Jugador jugadorActual = this.getJugadorActual();

        if (jugadorActual.equals(this.getJugador1())) {

          Ficha ficha = this.getJugadorActual().getFichas().get(0);
          this.getTablero().getFichas()[fila][columna] = ficha;

          // Rojo
          this.getJugadorActual().descontarFichas(1);
          // rojo
          this.actualizarBoton(
              this.getVentanaTablero().getBotones()[PosicionI][PosicionJ],
              jugadorActual.getFichas().get(0).getColor(),
              "R");

          formaEsquina(PosicionJ, PosicionI);
          alargoEsquina(PosicionI, PosicionJ, this.getTablero());

        } else {
          Ficha ficha = this.getJugadorActual().getFichas().get(0);
          this.getTablero().getFichas()[fila][columna] = ficha;
          // Azul
          this.getJugadorActual().descontarFichas(1);

          this.getVentanaTablero()
              .getBotones()[PosicionI][PosicionJ]
              .setBackground(jugadorActual.getFichas().get(0).getColor());
          this.getVentanaTablero().getBotones()[PosicionI][PosicionJ].setText("A");
          this.getVentanaTablero().getBotones()[PosicionI][PosicionJ].repaint();
          formaEsquina(PosicionJ, PosicionI);
          alargoEsquina(PosicionI, PosicionJ, this.getTablero());
        }
      }

      this.getMensajes().jugoEn(jugada, this.getJugadorActual());

    } else {
      this.ponePc(
          this.getJugador1().getUltimaPosicionI(),
          this.getJugador1().getUltimaPosicionJ(),
          this.getTablero(),
          primeraJugada);
      this.setJugadorActual(this.getJugador1());
    }

    if (this.getJugadorActual().equals(this.getJugador1()) && sePuedeColocarFicha) {
      this.setJugadorActual(this.getJugador2());
    } else if (this.getJugadorActual().equals(this.getJugador2()) && sePuedeColocarFicha) {

      this.setJugadorActual(this.getJugador1());
    }
  }

  private String numeroALetra(int i, boolean paraAbajo, boolean paraArriba) {
    String letra = "";
    if (paraAbajo) {
      i += 1;
    } else if (paraArriba) {
      i -= 1;
    }

    switch (i) {
      case 0:
        letra = "A";
        break;
      case 1:
        letra = "B";
        break;
      case 2:
        letra = "C";
        break;
      case 3:
        letra = "D";
        break;
      case 4:
        letra = "E";
        break;
      case 5:
        letra = "F";
    }
    return letra;
  }

  private int cuentaAlargoEsquina(int i, int j, Tablero tab) {
    int alargadas = 0;
    boolean meVoy = false;
    Ficha[] fila = tab.getFichas()[i];
    int contador = 0;

    for (int k = (j + 1); k < fila.length; k++) {
      if (!fila[k].esFichaNeutra()) {
        contador++;
      } else {
        contador = 0;
        meVoy = true;
      }
      if (i == 0) {
        if ((!meVoy)
            && (contador > 2 && !fila[k].esFichaNeutra())
            && (!(fila[k].getNumero() == 5))
            && (!this.getTablero().getFichas()[i + 1][k].esFichaNeutra())) {
          alargadas++;
        }
      } else if (i < 5 && i > 0) {
        if ((!meVoy)
            && (contador > 2 && !fila[k].esFichaNeutra())
            && (!(fila[k].getNumero() == 5))
            && (!this.getTablero().getFichas()[i + 1][k].esFichaNeutra()
                || !this.getTablero().getFichas()[i - 1][k].esFichaNeutra())) {
          alargadas++;
        }
      } else if (i == 5) {
        if ((!meVoy)
            && (contador > 2 && fila[k].esFichaNeutra())
            && (!(fila[k].getNumero() == 5))
            && (!this.getTablero().getFichas()[i - 1][k].esFichaNeutra())) {
          alargadas++;
        }
      }
    }
    contador = 0;
    meVoy = false;
    for (int k = (j - 1); k >= 0; k--) {
      if (!fila[k].esFichaNeutra()) {
        contador++;
      } else {
        contador = 0;
        meVoy = true;
      }
      if (i == 0) {
        if ((!meVoy)
            && (contador > 2 && !fila[k].esFichaNeutra())
            && (!(fila[k].getNumero() == 5))
            && (!this.getTablero().getFichas()[i + 1][k].esFichaNeutra())) {
          alargadas++;
        }
      } else if (i > 0 && i < 5) {
        if ((!meVoy)
            && (contador > 2 && !fila[k].esFichaNeutra())
            && (!(fila[k].getNumero() == 5))
            && (!this.getTablero().getFichas()[i + 1][k].esFichaNeutra()
                || !this.getTablero().getFichas()[i - 1][k].esFichaNeutra())) {
          alargadas++;
        }
      } else if (i == 5) {
        if ((!meVoy)
            && (contador > 2 && !fila[k].esFichaNeutra())
            && (!(fila[k].getNumero() == 5))
            && (!this.getTablero().getFichas()[i - 1][k].esFichaNeutra())) {
          alargadas++;
        }
      }
    }
    contador = 0;
    meVoy = false;

    for (int k = (i + 1); k < this.getTablero().getFichas().length; k++) {
      if (!this.getTablero().getFichas()[k][j].esFichaNeutra()) {
        contador++;
      } else {
        contador = 0;
        meVoy = true;
      }

      if (j > 0 & j < 5) {
        if ((!meVoy)
            && (contador > 2 && !this.getTablero().getFichas()[k][j].esFichaNeutra())
            && (!(this.getTablero().getFichas()[k][j].getNumero() == 5))
            && (!this.getTablero().getFichas()[k][j + 1].esFichaNeutra()
                || !this.getTablero().getFichas()[k][j - 1].esFichaNeutra())) {
          alargadas++;
        }
      } else if (j == 0) {
        if ((!meVoy)
            && (contador > 2 && !this.getTablero().getFichas()[k][j].esFichaNeutra())
            && (!(this.getTablero().getFichas()[k][j].getNumero() == 5))
            && (!this.getTablero().getFichas()[k][j + 1].esFichaNeutra())) {
          alargadas++;
        }
      } else if (j == 5) {
        if ((!meVoy)
            && (contador > 2 && !this.getTablero().getFichas()[k][j].esFichaNeutra())
            && (!(this.getTablero().getFichas()[k][j].getNumero() == 5))
            && (!this.getTablero().getFichas()[k][j - 1].esFichaNeutra())) {
          alargadas++;
        }
      }
    }
    contador = 0;
    meVoy = false;
    for (int k = (i - 1); k >= 0; k--) {

      if (!this.getTablero().getFichas()[k][j].esFichaNeutra()) {
        contador++;
      } else {
        contador = 0;
        meVoy = true;
      }
      if (j > 0 && j < 5) {
        if ((!meVoy)
            && (contador > 2 && !this.getTablero().getFichas()[k][j].esFichaNeutra())
            && (!(this.getTablero().getFichas()[k][j].getNumero() == 5))
            && (!this.getTablero().getFichas()[k][j + 1].esFichaNeutra()
                || !this.getTablero().getFichas()[k][j - 1].esFichaNeutra())) {
          alargadas++;
        }

      } else if (j == 0) {
        if ((!meVoy)
            && (contador > 2 && !this.getTablero().getFichas()[k][j].esFichaNeutra())
            && (!(this.getTablero().getFichas()[k][j].getNumero() == 5))
            && (!this.getTablero().getFichas()[k][j + 1].esFichaNeutra())) {
          alargadas++;
        }

      } else if (j == 5) {
        if ((!meVoy)
            && (contador > 2 && !this.getTablero().getFichas()[k][j].esFichaNeutra())
            && (!(this.getTablero().getFichas()[k][j].getNumero() == 5))
            && (!this.getTablero().getFichas()[k][j - 1].esFichaNeutra())) {
          alargadas++;
        }
      }
    }
    return alargadas;
  }

  private void alargoEsquina(int i, int j, Tablero tab) {
    ArrayList<String> dondeAlargo = new ArrayList<>();
    String letra = "";
    boolean meVoy = false;

    Ficha[] fila = tab.getFichas()[i];
    int contador = 0;
    if (this.getJugadorActual().tieneFichas()) {
      for (int k = j; k < fila.length; k++) {
        if (!fila[k].esFichaNeutra()) {
          contador++;
        } else {
          contador = 0;
          meVoy = true;
        }
        if (i == 0) {
          if ((!meVoy)
              && (contador > 2 && !fila[k].esFichaNeutra())
              && (!(fila[k].getNumero() == 5))
              && (!this.getTablero().getFichas()[i + 1][k].esFichaNeutra())) {
            setearEsquina(i, k, this.getJugadorActual());
            letra = numeroALetra(i, false, false);
            this.getMensajes()
                .alargoEsquinaEn(this.getJugadorActual().getAlias(), dondeAlargo, letra, k);
          }

        } else if (i < 5 && i > 0) {
          if ((!meVoy)
              && (contador > 2 && !fila[k].esFichaNeutra())
              && (!(fila[k].getNumero() == 5))
              && (!this.getTablero().getFichas()[i + 1][k].esFichaNeutra()
                  || !this.getTablero().getFichas()[i - 1][k].esFichaNeutra())) {
            setearEsquina(i, k, this.getJugadorActual());
            letra = numeroALetra(i, false, false);
            this.getMensajes()
                .alargoEsquinaEn(this.getJugadorActual().getAlias(), dondeAlargo, letra, k);
          }

        } else if (i == 5) {
          if ((!meVoy)
              && (contador > 2 && !fila[k].esFichaNeutra())
              && (!(fila[k].getNumero() == 5))
              && (!this.getTablero().getFichas()[i - 1][k].esFichaNeutra())) {
            setearEsquina(i, k, this.getJugadorActual());
            letra = numeroALetra(i, false, false);
            this.getMensajes()
                .alargoEsquinaEn(this.getJugadorActual().getAlias(), dondeAlargo, letra, k);
          }
        }
      }
      contador = 0;
      meVoy = false;
      for (int k = j; k >= 0; k--) {
        if (!fila[k].esFichaNeutra()) {
          contador++;
        } else {
          contador = 0;
          meVoy = true;
        }
        if (i == 0) {
          if ((!meVoy)
              && (contador > 2 && !fila[k].esFichaNeutra())
              && (!fila[k].esFichaNeutra())
              && (!this.getTablero().getFichas()[i + 1][k].esFichaNeutra())) {
            setearEsquina(i, k, this.getJugadorActual());
            letra = numeroALetra(i, false, false);
            this.getMensajes()
                .alargoEsquinaEn(this.getJugadorActual().getAlias(), dondeAlargo, letra, k);
          }

        } else if (i > 0 && i < 5) {
          if ((!meVoy)
              && (contador > 2 && !fila[k].esFichaNeutra())
              && (!(fila[k].getNumero() == 5))
              && (!this.getTablero().getFichas()[i + 1][k].esFichaNeutra()
                  || !this.getTablero().getFichas()[i - 1][k].esFichaNeutra())) {
            setearEsquina(i, k, this.getJugadorActual());
            letra = numeroALetra(i, false, false);
            this.getMensajes()
                .alargoEsquinaEn(this.getJugadorActual().getAlias(), dondeAlargo, letra, k);
          }

        } else if (i == 5) {
          if ((!meVoy)
              && (contador > 2 && !fila[k].esFichaNeutra())
              && (!(fila[k].getNumero() == 5))
              && (!this.getTablero().getFichas()[i - 1][k].esFichaNeutra())) {
            setearEsquina(i, k, this.getJugadorActual());
            letra = numeroALetra(i, false, false);
            this.getMensajes()
                .alargoEsquinaEn(this.getJugadorActual().getAlias(), dondeAlargo, letra, k);
          }
        }
      }
      contador = 0;
      meVoy = false;

      for (int k = i; k < this.getTablero().getFichas().length; k++) {
        if (!this.getTablero().getFichas()[k][j].esFichaNeutra()) {
          contador++;
        } else {
          contador = 0;
          meVoy = true;
        }

        if (j > 0 & j < 5) {
          if ((!meVoy)
              && (contador > 2 && !this.getTablero().getFichas()[k][j].esFichaNeutra())
              && (!(this.getTablero().getFichas()[k][j].getNumero() == 5))
              && (!this.getTablero().getFichas()[k][j + 1].esFichaNeutra()
                  || !this.getTablero().getFichas()[k][j - 1].esFichaNeutra())) {
            setearEsquina(k, j, this.getJugadorActual());
            letra = numeroALetra(k, false, false);
            this.getMensajes()
                .alargoEsquinaEn(this.getJugadorActual().getAlias(), dondeAlargo, letra, j);
          }

        } else if (j == 0) {
          if ((!meVoy)
              && (contador > 2 && !this.getTablero().getFichas()[k][j].esFichaNeutra())
              && (!(this.getTablero().getFichas()[k][j].getNumero() == 5))
              && (!this.getTablero().getFichas()[k][j + 1].esFichaNeutra())) {
            setearEsquina(k, j, this.getJugadorActual());
            letra = numeroALetra(k, false, false);
            this.getMensajes()
                .alargoEsquinaEn(this.getJugadorActual().getAlias(), dondeAlargo, letra, j);
          }
        } else if (j == 5) {
          if ((!meVoy)
              && (contador > 2 && !this.getTablero().getFichas()[k][j].esFichaNeutra())
              && (!(this.getTablero().getFichas()[k][j].getNumero() == 5))
              && (!this.getTablero().getFichas()[k][j - 1].esFichaNeutra())) {
            setearEsquina(k, j, this.getJugadorActual());
            letra = numeroALetra(k, false, false);
            this.getMensajes()
                .alargoEsquinaEn(this.getJugadorActual().getAlias(), dondeAlargo, letra, j);
          }
        }
      }
      contador = 0;
      meVoy = false;
      for (int k = i; k >= 0; k--) {

        if (!this.getTablero().getFichas()[k][j].esFichaNeutra()) {
          contador++;
        } else {
          contador = 0;
          meVoy = true;
        }
        if (j > 0 && j < 5) {
          if ((!meVoy)
              && (contador > 2 && !this.getTablero().getFichas()[k][j].esFichaNeutra())
              && (!(this.getTablero().getFichas()[k][j].getNumero() == 5))
              && (!this.getTablero().getFichas()[k][j + 1].esFichaNeutra()
                  || !this.getTablero().getFichas()[k][j - 1].esFichaNeutra())) {
            setearEsquina(k, j, this.getJugadorActual());
            letra = numeroALetra(k, false, false);
            this.getMensajes()
                .alargoEsquinaEn(this.getJugadorActual().getAlias(), dondeAlargo, letra, j);
          }

        } else if (j == 0) {
          if ((!meVoy)
              && (contador > 2 && !this.getTablero().getFichas()[k][j].esFichaNeutra())
              && (!(this.getTablero().getFichas()[k][j].getNumero() == 5))
              && (!this.getTablero().getFichas()[k][j + 1].esFichaNeutra())) {
            setearEsquina(k, j, this.getJugadorActual());
            letra = numeroALetra(k, false, false);
            this.getMensajes()
                .alargoEsquinaEn(this.getJugadorActual().getAlias(), dondeAlargo, letra, j);
          }

        } else if (j == 5) {
          if ((!meVoy)
              && (contador > 2 && !this.getTablero().getFichas()[k][j].esFichaNeutra())
              && (!(this.getTablero().getFichas()[k][j].getNumero() == 5))
              && (this.getTablero().getFichas()[k][j - 1].esFichaNeutra())) {
            setearEsquina(k, j, this.getJugadorActual());
            letra = numeroALetra(k, false, false);
            this.getMensajes()
                .alargoEsquinaEn(this.getJugadorActual().getAlias(), dondeAlargo, letra, j);
          }
        }
      }
    }

    if (!this.getJugadorActual().isHumano()) {
      this.getVentanaTablero().getAvisaPc().setListData(dondeAlargo.toArray());
    } else {
      this.getVentanaTablero().getAvisaAlargo().setListData(dondeAlargo.toArray());
    }
  }

  public void calcularPuntaje(Tablero tab) {
    int puntajeJugador1 = 0;
    int puntajeJugador2 = 0;

    for (int i = 0; i < tab.getFichas().length; i++) {
      for (int j = 0; j < tab.getFichas()[0].length; j++) {
        Ficha ficha = tab.getFichas()[i][j];
        if (ficha.getColorFicha().equals(ColorFicha.ROJO)) {
          puntajeJugador1 += ficha.getNumero();
        } else {
          puntajeJugador2 += ficha.getNumero();
        }
      }
    }

    puntajeJugador1 -= this.getJugador1().getFichasRestantes();
    puntajeJugador2 -= this.getJugador2().getFichasRestantes();

    this.getJugador1().setPuntaje(puntajeJugador1);
    this.getJugador2().setPuntaje(puntajeJugador2);
  }

  public VentanaTablero getVentanaTablero() {
    return ventanaTablero;
  }

  public void setVentanaTablero(VentanaTablero ventanaTablero) {
    this.ventanaTablero = ventanaTablero;
  }

  private void setearEsquina(int fila, int columna, Jugador jugador) {
    JButton boton = this.getVentanaTablero().getBotones()[fila][columna];
    if (boton == null) return;

    Tablero tablero = this.getTablero();

    if (tablero.getFichas()[fila][columna].getNumero() < 5
        && this.getJugadorActual().tieneFichas()) {
      Ficha ficha = tablero.getFichas()[fila][columna];
      int altura = ficha.getNumero();
      Ficha fichaAColocar = jugador.getFichas().get(0);
      fichaAColocar.setNumero(altura + 1);
      tablero.getFichas()[fila][columna] = fichaAColocar;
      ficha.aumentarNumero();
      actualizarBoton(boton, fichaAColocar.getColor(), fichaAColocar.getNumero() + "");
      jugador.descontarFichas(1);
    }
  }

  private void actualizarBoton(JButton boton, Color color, String text) {
    SwingUtilities.invokeLater(
        () -> {
          boton.setMargin(new Insets(0, 0, 0, 0));
          boton.setOpaque(true);
          boton.setBorderPainted(false);
          boton.setBackground(color);
          boton.setForeground(Color.WHITE);
          boton.setPreferredSize(new Dimension(100, 50));
          boton.setFont(new Font("Arial", Font.PLAIN, 10));
          boton.setHorizontalAlignment(SwingConstants.CENTER);
          boton.setText(text);
          boton.repaint();
          boton.revalidate();
        });
  }

  private void formaEsquina(int c, int i) {
    if (!this.getJugadorActual().tieneFichas()) {
      return;
    }

    Ficha[][] tablero = this.getTablero().getFichas();
    ArrayList<String> esquinasFormadas = new ArrayList<>();
    String alias = this.getJugadorActual().getAlias();

    // Check all possible corner formations based on position
    if (isInteriorPosition(c, i)) {
      checkInteriorCorners(tablero, c, i, alias, esquinasFormadas);
    } else if (isTopEdge(c, i)) {
      checkTopEdgeCorners(tablero, c, i, alias, esquinasFormadas);
    } else if (isLeftEdge(c, i)) {
      checkLeftEdgeCorners(tablero, c, i, alias, esquinasFormadas);
    } else if (isBottomEdge(c, i)) {
      checkBottomEdgeCorners(tablero, c, i, alias, esquinasFormadas);
    } else if (isRightEdge(c, i)) {
      checkRightEdgeCorners(tablero, c, i, alias, esquinasFormadas);
    } else {
      checkCornerPosition(tablero, c, i, alias, esquinasFormadas);
    }

    // Update UI based on player type
    updateUI(esquinasFormadas);
  }

  // Position classification helpers
  private boolean isInteriorPosition(int c, int i) {
    return c > 0 && c < 5 && i > 0 && i < 5;
  }

  private boolean isTopEdge(int c, int i) {
    return i == 0 && c > 0 && c < 5;
  }

  private boolean isLeftEdge(int c, int i) {
    return c == 0 && i > 0 && i < 5;
  }

  private boolean isBottomEdge(int c, int i) {
    return i == 5 && c > 0 && c < 5;
  }

  private boolean isRightEdge(int c, int i) {
    return c == 5 && i > 0 && i < 5;
  }

  // Corner checking methods
  private void checkInteriorCorners(
      Ficha[][] tablero, int c, int i, String alias, ArrayList<String> esquinasFormadas) {
    checkCorner(tablero, i, c, 0, 1, 1, 1, alias, esquinasFormadas); // Down-right
    checkCorner(tablero, i, c, 1, 0, 1, 1, alias, esquinasFormadas); // Down-right (col)
    checkCorner(tablero, i, c, 0, -1, 1, -1, alias, esquinasFormadas); // Down-left
    checkCorner(tablero, i, c, 1, 0, 1, -1, alias, esquinasFormadas); // Down-left (col)
    checkCorner(tablero, i, c, -1, 0, -1, 1, alias, esquinasFormadas); // Up-right
    checkCorner(tablero, i, c, 0, 1, -1, 1, alias, esquinasFormadas); // Up-right (row)
    checkCorner(tablero, i, c, -1, 0, -1, -1, alias, esquinasFormadas); // Up-left
    checkCorner(tablero, i, c, 0, -1, -1, -1, alias, esquinasFormadas); // Up-left (row)
    checkAdjacentPairs(tablero, i, c, alias, esquinasFormadas);
  }

  // Similar methods for edge cases would follow (simplified for brevity)
  private void checkTopEdgeCorners(
      Ficha[][] tablero, int c, int i, String alias, ArrayList<String> esquinasFormadas) {
    checkCorner(tablero, i, c, 0, -1, 1, -1, alias, esquinasFormadas); // Down-left
    checkCorner(tablero, i, c, 0, 1, 1, 1, alias, esquinasFormadas); // Down-right
    checkCorner(tablero, i, c, 1, 0, 1, 1, alias, esquinasFormadas); // Down-right (col)
    checkCorner(tablero, i, c, 1, 0, 1, -1, alias, esquinasFormadas); // Down-left (col)
    checkAdjacentPairs(
        tablero, i, c, alias, esquinasFormadas, new int[][] {{0, 1, 1, 0}, {0, -1, 1, 0}});
  }

  // Core corner checking logic
  private void checkCorner(
      Ficha[][] tablero,
      int i,
      int c,
      int row1,
      int col1,
      int row2,
      int col2,
      String alias,
      ArrayList<String> esquinasFormadas) {
    if (!tablero[i + row1][c + col1].esFichaNeutra()
        && !tablero[i + row2][c + col2].esFichaNeutra()) {
      int newRow = row1 == 0 ? i : i + row1;
      int newCol = col1 == 0 ? c : c + col1;
      setearEsquina(newRow, newCol, this.getJugadorActual());
      String letra = numeroALetra(i, row1 != 0, row1 < 0);
      this.getMensajes().formoEsquina(alias, letra, newCol, esquinasFormadas);
    }
  }

  private void checkAdjacentPairs(
      Ficha[][] tablero, int i, int c, String alias, ArrayList<String> esquinasFormadas) {
    int[][] pairs = {{-1, 0, 0, 1}, {-1, 0, 0, -1}, {0, 1, 1, 0}, {0, -1, 1, 0}};
    checkAdjacentPairs(tablero, i, c, alias, esquinasFormadas, pairs);
  }

  private void checkAdjacentPairs(
      Ficha[][] tablero,
      int i,
      int c,
      String alias,
      ArrayList<String> esquinasFormadas,
      int[][] pairs) {
    for (int[] pair : pairs) {
      if (!tablero[i + pair[0]][c + pair[1]].esFichaNeutra()
          && !tablero[i + pair[2]][c + pair[3]].esFichaNeutra()) {
        setearEsquina(i, c, this.getJugadorActual());
        String letra = numeroALetra(i, false, false);
        this.getMensajes().formoEsquina(alias, letra, c, esquinasFormadas);
      }
    }
  }

  private void checkLeftEdgeCorners(
      Ficha[][] tablero, int c, int i, String alias, ArrayList<String> esquinasFormadas) {
    // Right-down
    checkCorner(tablero, i, c, 0, 1, 1, 1, alias, esquinasFormadas);
    // Right-up
    checkCorner(tablero, i, c, -1, 0, -1, 1, alias, esquinasFormadas);
    checkCorner(tablero, i, c, 0, 1, -1, 1, alias, esquinasFormadas);
    // Adjacent pairs (right and down)
    checkAdjacentPairs(
        tablero, i, c, alias, esquinasFormadas, new int[][] {{0, 1, 1, 0}, {-1, 0, 1, 0}});
  }

  private void checkBottomEdgeCorners(
      Ficha[][] tablero, int c, int i, String alias, ArrayList<String> esquinasFormadas) {
    // Up-left
    checkCorner(tablero, i, c, -1, 0, -1, -1, alias, esquinasFormadas);
    checkCorner(tablero, i, c, 0, -1, -1, -1, alias, esquinasFormadas);
    // Up-right
    checkCorner(tablero, i, c, -1, 0, -1, 1, alias, esquinasFormadas);
    checkCorner(tablero, i, c, 0, 1, -1, 1, alias, esquinasFormadas);
    // Adjacent pairs (left and right)
    checkAdjacentPairs(
        tablero, i, c, alias, esquinasFormadas, new int[][] {{0, -1, -1, 0}, {0, 1, 1, 0}});
  }

  private void checkRightEdgeCorners(
      Ficha[][] tablero, int c, int i, String alias, ArrayList<String> esquinasFormadas) {
    // Left-up
    checkCorner(tablero, i, c, -1, 0, -1, -1, alias, esquinasFormadas);
    checkCorner(tablero, i, c, 0, -1, -1, -1, alias, esquinasFormadas);
    // Left-down
    checkCorner(tablero, i, c, 0, -1, 1, -1, alias, esquinasFormadas);
    checkCorner(tablero, i, c, 1, 0, 1, -1, alias, esquinasFormadas);
    // Adjacent pairs (left and down)
    checkAdjacentPairs(
        tablero, i, c, alias, esquinasFormadas, new int[][] {{0, -1, 1, 0}, {-1, 0, 1, 0}});
  }

  private void checkCornerPosition(
      Ficha[][] tablero, int c, int i, String alias, ArrayList<String> esquinasFormadas) {
    // This would be for the corner positions (0,0), (0,5), (5,0), (5,5)
    if (c == 0 && i == 0) { // Top-left
      checkCorner(tablero, i, c, 0, 1, 1, 1, alias, esquinasFormadas);
      checkAdjacentPairs(tablero, i, c, alias, esquinasFormadas, new int[][] {{0, 1, 1, 0}});
    } else if (c == 5 && i == 0) { // Top-right
      checkCorner(tablero, i, c, 0, -1, 1, -1, alias, esquinasFormadas);
      checkAdjacentPairs(tablero, i, c, alias, esquinasFormadas, new int[][] {{0, -1, 1, 0}});
    } else if (c == 0 && i == 5) { // Bottom-left
      checkCorner(tablero, i, c, -1, 0, -1, 1, alias, esquinasFormadas);
      checkAdjacentPairs(tablero, i, c, alias, esquinasFormadas, new int[][] {{0, 1, -1, 0}});
    } else if (c == 5 && i == 5) { // Bottom-right
      checkCorner(tablero, i, c, -1, 0, -1, -1, alias, esquinasFormadas);
      checkAdjacentPairs(tablero, i, c, alias, esquinasFormadas, new int[][] {{0, -1, -1, 0}});
    }
  }

  // UI update
  private void updateUI(ArrayList<String> esquinasFormadas) {
    Object[] data = esquinasFormadas.toArray();
    if (!this.getJugadorActual().isHumano()) {
      this.getVentanaTablero().getAvisaPCesquina().setListData(data);
    } else {
      this.getVentanaTablero().getAvisa().setListData(data);
    }
  }

  private int cuentaEsquina(int c, int i) {
    Ficha[][] tab = this.getTablero().getFichas();
    String reset = "\u001B[0m";
    int contador = 0;
    // Para ver si forma esquina hacia la derecha para abajo.
    if ((c > 0 && c < 5) && (i < 5 && i > 0)) {
      if ((!tab[i][c + 1].esFichaNeutra()) && (!tab[i + 1][c + 1].esFichaNeutra())) {
        contador++;
      } // Para ver si forma esquina para abajo a la derecha pero viendo desde la columna.
      if ((!tab[i + 1][c].esFichaNeutra()) && (!tab[i + 1][c + 1].esFichaNeutra())) {
        contador++;
      } // Para ver si se forma esquina para abajo a la izquierda respecto de la fila .
      if ((!tab[i][c - 1].esFichaNeutra()) && (!tab[i + 1][c - 1].esFichaNeutra())) {
        contador++;
      } // Para ver si forma esquina abajo a la izquierda respecto de columna.
      if ((!tab[i + 1][c].esFichaNeutra()) && (!tab[i + 1][c - 1].esFichaNeutra())) {
        contador++;
      } // Para ver si forma esquina arriba a la derecha con respecto a la columna.
      if ((!tab[i - 1][c].esFichaNeutra()) && (!tab[i - 1][c + 1].esFichaNeutra())) {
        contador++;
      } // Para ver si forma essquina arriba a la derecha con respecto a fila.
      if ((!tab[i][c + 1].esFichaNeutra()) && (!tab[i - 1][c + 1].esFichaNeutra())) {
        contador++;
      } // Para ver si forma esquina arriba a la izquierda respecto de columna.
      if ((!tab[i - 1][c].esFichaNeutra()) && (!tab[i - 1][c - 1].esFichaNeutra())) {
        contador++;
      } // Para ver si se forma esquina arriba a la izquierda co respecto a la fila.
      if ((!tab[i][c - 1].esFichaNeutra()) && (!tab[i - 1][c - 1].esFichaNeutra())) {
        contador++;
      } // PAra ver si forma esquina porque mi ficha esta rodeada por dos fichas.
      if ((!tab[i - 1][c].esFichaNeutra() && !tab[i][c + 1].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i - 1][c].esFichaNeutra() && !tab[i][c - 1].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i][c + 1].esFichaNeutra() && !tab[i + 1][c].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i][c - 1].esFichaNeutra() && !tab[i + 1][c].esFichaNeutra())) {
        contador++;
      }
      // Termina para ver fichas rodeadas .
    } else if (i == 0 && (c > 0 && c < 5)) {
      // Abajo a la iquiera respecto columna.
      if ((!tab[i][c - 1].esFichaNeutra() && !tab[i + 1][c - 1].esFichaNeutra())) {
        contador++;
      }
      // Abajo a la derecha ,columna.
      if (!tab[i][c + 1].esFichaNeutra() && !tab[i + 1][c + 1].esFichaNeutra()) {
        contador++;
      } // abajo derecha. columna
      if ((!tab[i + 1][c].esFichaNeutra() && !tab[i + 1][c + 1].esFichaNeutra())) {
        contador++;
      } // abajo izquierda columna
      if ((!tab[i + 1][c].esFichaNeutra() && !tab[i + 1][c - 1].esFichaNeutra())) {
        contador++;
      } // Si la ficha puesta esta rodeada.
      if ((!tab[i][c + 1].esFichaNeutra() && !tab[i + 1][c].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i][c - 1].esFichaNeutra() && !tab[i + 1][c].esFichaNeutra())) {
        contador++;
      }
    } // para la columna de la izquierda.
    else if (c == 0 && (i < 5 && i > 0)) {
      // Para esquina hacia la drecha para abajo fila.
      if ((!tab[i][c + 1].esFichaNeutra() && !tab[i + 1][c + 1].esFichaNeutra())) {
        int columna = (c + 1);
        contador++;
      }
      if ((!tab[i][c + 1].esFichaNeutra() && !tab[i - 1][c + 1].esFichaNeutra())) {
        int columna = (c + 1);
        contador++;
      }
      if ((!tab[i + 1][c].esFichaNeutra() && !tab[i + 1][c + 1].esFichaNeutra())) {
        int fila = (i + 1);
        contador++;
      }
      if ((!tab[i - 1][c].esFichaNeutra() && !tab[i - 1][c + 1].esFichaNeutra())) {
        int fila = (i - 1);
        contador++;
      }
      // para ficha rodeada desde arriba y costado derecho.
      if ((!tab[i - 1][c].esFichaNeutra() && !tab[i][c + 1].esFichaNeutra())) {
        contador++;
      }
      // PAra ficha rodeada desde abajo y el costado derecho
      if ((!tab[i + 1][c].esFichaNeutra() && !tab[i][c + 1].esFichaNeutra())) {
        contador++;
      }
    } // para  la fila de abajo del todo.
    else if (i == 5 && (c < 5 && c > 0)) {
      // ficha rodeada por otras.
      if ((!tab[i - 1][c].esFichaNeutra() && !tab[i][c + 1].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i][c - 1].esFichaNeutra() && !tab[i - 1][c].esFichaNeutra())) {
        setearEsquina(i, c, this.getJugadorActual());
      }
      // fin ficha rodeada.
      if ((!tab[i - 1][c - 1].esFichaNeutra() && !tab[i - 1][c].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i - 1][c].esFichaNeutra() && !tab[i - 1][c + 1].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i][c + 1].esFichaNeutra() && !tab[i - 1][c + 1].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i][c - 1].esFichaNeutra() && !tab[i - 1][c - 1].esFichaNeutra())) {
        contador++;
      }
    } // para la columna a la derecha del todo.
    else if (c == 5 && (i > 0 && i < 5)) {
      if ((!tab[i][c - 1].esFichaNeutra() && (!tab[i - 1][c].esFichaNeutra()))) {
        contador++;
      } // Con respecto a columna.
      if ((!tab[i + 1][c].esFichaNeutra()) && (!tab[i][c - 1].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i][c - 1].esFichaNeutra() && !tab[i - 1][c - 1].esFichaNeutra())) {
        contador++;
      } // Con respecto a columna.
      if ((!tab[i][c - 1].esFichaNeutra() && !tab[i + 1][c - 1].esFichaNeutra())) {
        contador++;
      } // fila.
      if ((!tab[i + 1][c].esFichaNeutra() && !tab[i + 1][c - 1].esFichaNeutra())) {
        contador++;
      } // fila.
      if ((!tab[i - 1][c].esFichaNeutra() && !tab[i - 1][c - 1].esFichaNeutra())) {
        contador++;
      }
    } // Esquina en posicion [0][0].
    else if (i == 0 && c == 0) {
      if ((!tab[i][c + 1].esFichaNeutra() && !tab[i + 1][c + 1].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i + 1][c].esFichaNeutra() && !tab[i + 1][c + 1].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i + 1][c].esFichaNeutra() && !tab[i][c + 1].esFichaNeutra())) {
        contador++;
      }
    } // El caso que forme esquina en la esquina inferior izuierda de la matriz.
    else if (i == 5 && c == 0) {
      if ((!tab[i - 1][c].esFichaNeutra() && !tab[i - 1][c + 1].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i][c + 1].esFichaNeutra() && !tab[i - 1][c + 1].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i - 1][c].esFichaNeutra() && !tab[i][c + 1].esFichaNeutra())) {
        contador++;
      }
    } // para la esquina inferior a la derecha de la matriz.
    else if (i == 5 && c == 5) {
      if ((!tab[i - 1][c].esFichaNeutra() && !tab[i - 1][c - 1].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i][c - 1].esFichaNeutra() && !tab[i - 1][c - 1].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i - 1][c].esFichaNeutra() && !tab[i][c - 1].esFichaNeutra())) {
        contador++;
      }
    } // Para la esquina de arriba del todo a al a derecha del todo de la matriz Posicion[0][5]
    else if (i == 0 && c == 5) {
      if ((!tab[i][c - 1].esFichaNeutra() && !tab[i + 1][c - 1].esFichaNeutra())) {
        contador++;
      }
      if ((!tab[i + 1][c].esFichaNeutra() && !tab[i + 1][c - 1].esFichaNeutra())) {

        contador++;
      }
      if ((!tab[i][c - 1].esFichaNeutra() && !tab[i + 1][c].esFichaNeutra())) {
        contador++;
      }
    }
    return contador;
  }

  private boolean validarPosicion(int i, int j, Tablero tablero) {

    boolean podes = false;
    // Para posiciones dentro del rango que no se cae.
    if ((j > 0 && j < 5) && (i > 0 && i < 5)) {
      if ((tablero.getFichas()[i][j - 1].esFichaNeutra())
          || (tablero.getFichas()[i][j + 1].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j + 1].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j - 1].esFichaNeutra())
          || (tablero.getFichas()[i - 1][j - 1].esFichaNeutra())
          || (tablero.getFichas()[i - 1][j + 1].esFichaNeutra())
          || (tablero.getFichas()[i - 1][j].esFichaNeutra())) {
        podes = true;

      } else if (this.getJugadorActual().isHumano()) {
        mensajes.posicionInvalidaDos(this.getVentanaTablero());
      }
    } // lo de abajo es para la fila de mas arriba del todo para que no se salga de rango
    else if (i == 0 && (j > 0 && j < 5)) {
      if ((tablero.getFichas()[i][j - 1].esFichaNeutra())
          || (tablero.getFichas()[i][j + 1].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j + 1].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j - 1].esFichaNeutra())) {
        podes = true;

      } else if (this.getJugadorActual().isHumano()) {
        mensajes.posicionInvalidaDos(this.getVentanaTablero());
      }

    } // lo de abajo es para el caso de la esquina de arriba a la izquierda , la posicion (0,0).
    else if (i == 0 && j == 0) {
      if ((tablero.getFichas()[i][j + 1].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j + 1].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j].esFichaNeutra())) {
        podes = true;
      } else if (this.getJugadorActual().isHumano()) {
        mensajes.posicionInvalidaDos(this.getVentanaTablero());
      }

    } // Esta es para validar la columna de la izquierda del todo , i menor que 5 y mayor que 0 , j
    // = 0.
    else if (j == 0 && (i < 5 && i > 0)) {
      if ((tablero.getFichas()[i][j + 1].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j].esFichaNeutra())
          || (tablero.getFichas()[i - 1][j].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j + 1].esFichaNeutra())
          || (tablero.getFichas()[i - 1][j + 1].esFichaNeutra())) {

        podes = true;
      } else if (this.getJugadorActual().isHumano()) {
        mensajes.posicionInvalidaDos(this.getVentanaTablero());
      }
    } // para la esquina inferior izquierda
    else if (i == 5 && j == 0) {
      if ((tablero.getFichas()[i][j + 1].esFichaNeutra())
          || (tablero.getFichas()[i - 1][j + 1].esFichaNeutra())
          || (tablero.getFichas()[i - 1][j].esFichaNeutra())) {
        podes = true;
      } else if (this.getJugadorActual().isHumano()) {
        mensajes.posicionInvalidaDos(this.getVentanaTablero());
      }

    } // para la fila de abajo del todo de la matriz a partir de j = 1 hasta j = 4 , i = 5 (
    // constante )
    else if (i == 5 && (j < 5 && j > 0)) {
      if ((tablero.getFichas()[i][j + 1].esFichaNeutra())
          || (tablero.getFichas()[i][j - 1].esFichaNeutra())
          || (tablero.getFichas()[i - 1][j + 1].esFichaNeutra())
          || (tablero.getFichas()[i - 1][j - 1].esFichaNeutra())
          || (tablero.getFichas()[i - 1][j].esFichaNeutra())) {
        podes = true;
      } else if (this.getJugadorActual().isHumano()) {
        mensajes.posicionInvalidaDos(this.getVentanaTablero());
      }

    } // Para la esquina inferior derecha.
    else if (i == 5 && j == 5) {
      if ((tablero.getFichas()[i][j - 1].esFichaNeutra())
          || (tablero.getFichas()[i - 1][j].esFichaNeutra())
          || (tablero.getFichas()[i - 1][j - 1].esFichaNeutra())) {
        podes = true;
      } else if (this.getJugadorActual().isHumano()) {
        mensajes.posicionInvalidaDos(this.getVentanaTablero());
      }

    } // la columna mas contra la derecha.
    else if (j == 5 && (i < 5 && i > 0)) {
      if ((tablero.getFichas()[i - 1][j].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j].esFichaNeutra())
          || (tablero.getFichas()[i][j - 1].esFichaNeutra())
          || (tablero.getFichas()[i - 1][j - 1].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j - 1].esFichaNeutra())) {
        podes = true;

      } else if (this.getJugadorActual().isHumano()) {
        mensajes.posicionInvalidaDos(this.getVentanaTablero());
      }

    } // la esquina superior derecha.
    else if (i == 0 && j == 5) {
      if ((tablero.getFichas()[i][j - 1].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j].esFichaNeutra())
          || (tablero.getFichas()[i + 1][j - 1].esFichaNeutra())) {
        podes = true;
      } else if (this.getJugadorActual().isHumano()) {
        mensajes.posicionInvalidaDos(this.getVentanaTablero());
      }
    }

    return podes;
  }

  private boolean noEsCuadrado(int i, int j, Tablero tablero) {
    boolean NoEsCuadrado = true;

    // Para validar que no se pueda poner una ficha en un lugar que forme un cubo , teniendo en
    // cuanta que i esta entre 1 y 4 y j tambien.
    if ((i < 5 && i > 0) && (j > 0 && j < 5)) {
      // cuadrado a la izquierda es el primero y anda. ( izquierda para arriba)

      if (((!tablero.getFichas()[i - 1][j].esFichaNeutra())
          && (!tablero.getFichas()[i - 1][j - 1].esFichaNeutra())
          && (!tablero.getFichas()[i][j - 1].esFichaNeutra()))) {
        NoEsCuadrado = false;
        if (this.getJugadorActual().isHumano()) {
          mensajes.posicionInvalida(this.getVentanaTablero());
        }

      } // para ver si forma cuadrado a la Derecha y anda.(derecha para arriba)
      else if ((!tablero.getFichas()[i][j + 1].esFichaNeutra())
          && (!tablero.getFichas()[i - 1][j + 1].esFichaNeutra())
          && (!tablero.getFichas()[i - 1][j].esFichaNeutra())) {
        NoEsCuadrado = false;
        if (this.getJugadorActual().isHumano()) {
          mensajes.posicionInvalida(this.getVentanaTablero());
        }
      } // para ver si forma cuadrado a la izquierda  y anda[ izquierda para abajo)
      else if ((!tablero.getFichas()[i][j - 1].esFichaNeutra())
          && (!tablero.getFichas()[i + 1][j - 1].esFichaNeutra())
          && (!tablero.getFichas()[i + 1][j].esFichaNeutra())) {
        NoEsCuadrado = false;
        if (this.getJugadorActual().isHumano()) {
          mensajes.posicionInvalida(this.getVentanaTablero());
        }
      } // para ver si forma cuadrado a la derecha  anda menos con la fila C , rarisimo. ( derecha
      // para abajo). el ejemplo es C5 , D5 , D4 , C4.
      else if ((!tablero.getFichas()[i][j + 1].esFichaNeutra())
          && (!tablero.getFichas()[i + 1][j + 1].esFichaNeutra())
          && (!tablero.getFichas()[i + 1][j].esFichaNeutra())) {
        NoEsCuadrado = false;
        if (this.getJugadorActual().isHumano()) {
          mensajes.posicionInvalida(this.getVentanaTablero());
        }
      }

    } // Para el caso de la esquina superior izquierda.
    else if (i == 0 && j == 0) {
      if ((!tablero.getFichas()[i][j + 1].esFichaNeutra())
          && (!tablero.getFichas()[i + 1][j + 1].esFichaNeutra())
          && (!tablero.getFichas()[i + 1][j].esFichaNeutra())) {
        NoEsCuadrado = false;
        if (this.getJugadorActual().isHumano()) {
          mensajes.posicionInvalida(this.getVentanaTablero());
        }
      }
    } // para validar que no se forme un cuadrado , pero suponiendo que la ficha fue puesta en la
    // primera fila.
    else if (i == 0 && (j < 5 && j > 0)) {
      if (((!tablero.getFichas()[i][j - 1].esFichaNeutra())
              && (!tablero.getFichas()[i + 1][j - 1].esFichaNeutra())
              && (!tablero.getFichas()[i + 1][j].esFichaNeutra()))
          || ((!tablero.getFichas()[i][j + 1].esFichaNeutra())
              && (!tablero.getFichas()[i + 1][j + 1].esFichaNeutra())
              && (!tablero.getFichas()[i + 1][j].esFichaNeutra()))) {
        NoEsCuadrado = false;
        if (this.getJugadorActual().isHumano()) {
          mensajes.posicionInvalida(this.getVentanaTablero());
        }
      }
    } // para validar que no se forme un cuadrado en la columna 0. Sin que se salga de rango la
    // matriz y se caiga.
    else if (j == 0 && (i > 0 && i < 5)) {
      if (((!tablero.getFichas()[i][j + 1].esFichaNeutra())
              && (!tablero.getFichas()[i - 1][j + 1].esFichaNeutra())
              && (!tablero.getFichas()[i - 1][j].esFichaNeutra()))
          || ((!tablero.getFichas()[i][j + 1].esFichaNeutra())
              && (!tablero.getFichas()[i + 1][j + 1].esFichaNeutra())
              && (!tablero.getFichas()[i + 1][j].esFichaNeutra()))) {
        NoEsCuadrado = false;

        if (this.getJugadorActual().isHumano()) {
          mensajes.posicionInvalida(this.getVentanaTablero());
        }
      }
    } // para validar que no se forme cuadrado en la esquina inferior izquierda.
    else if (i == 5 && j == 0) {
      if ((!tablero.getFichas()[i - 1][j].esFichaNeutra())
          && (!tablero.getFichas()[i - 1][j + 1].esFichaNeutra())
          && (!tablero.getFichas()[i][j + 1].esFichaNeutra())) {
        NoEsCuadrado = false;
        if (this.getJugadorActual().isHumano()) {
          mensajes.posicionInvalida(this.getVentanaTablero());
        }
      }
    } // fila de abajo del todo.
    else if (i == 5 && (j < 5 && j > 0)) {
      if (((!tablero.getFichas()[i][j - 1].esFichaNeutra())
              && (!tablero.getFichas()[i - 1][j - 1].esFichaNeutra())
              && (!tablero.getFichas()[i - 1][j].esFichaNeutra()))
          || ((!tablero.getFichas()[i][j + 1].esFichaNeutra())
              && (!tablero.getFichas()[i - 1][j + 1].esFichaNeutra())
              && (!tablero.getFichas()[i - 1][j].esFichaNeutra()))) {
        NoEsCuadrado = false;
        if (this.getJugadorActual().isHumano()) {
          mensajes.posicionInvalida(this.getVentanaTablero());
        }
      }

    } // Para la esquina de abajo a la derecha.
    else if (i == 5 && j == 5) {
      if ((!tablero.getFichas()[i][j - 1].esFichaNeutra())
          && (!tablero.getFichas()[i - 1][j - 1].esFichaNeutra())
          && (!tablero.getFichas()[i - 1][j].esFichaNeutra())) {
        NoEsCuadrado = false;
        if (this.getJugadorActual().isHumano()) {
          mensajes.posicionInvalida(this.getVentanaTablero());
        }
      }
    } // Para la columna borde de la derecha.
    else if (j == 5 && (i > 0 && i < 5)) {
      if (((!tablero.getFichas()[i][j - 1].esFichaNeutra())
              && (!tablero.getFichas()[i - 1][j - 1].esFichaNeutra())
              && (!tablero.getFichas()[i - 1][j].esFichaNeutra()))
          || ((!tablero.getFichas()[i][j - 1].esFichaNeutra())
              && (!tablero.getFichas()[i + 1][j - 1].esFichaNeutra())
              && (!tablero.getFichas()[i + 1][j].esFichaNeutra()))) {
        NoEsCuadrado = false;
        if (this.getJugadorActual().isHumano()) {
          mensajes.posicionInvalida(this.getVentanaTablero());
        }
      }
    } // para la esquina de arriba a la derecha.
    else if (i == 0 && j == 5) {
      if ((!tablero.getFichas()[i][j - 1].esFichaNeutra())
          && (!tablero.getFichas()[i + 1][j - 1].esFichaNeutra())
          && (!tablero.getFichas()[i + 1][j].esFichaNeutra())) {
        NoEsCuadrado = false;
        if (this.getJugadorActual().isHumano()) {
          mensajes.posicionInvalida(this.getVentanaTablero());
        }
      }
    }
    return NoEsCuadrado;
  }

  public boolean ahiSi(int i, int j, Tablero tablero) {
    boolean podes = tablero.getFichas()[i][j].esFichaNeutra();

    if (!podes && this.getJugadorActual().isHumano()) {
      mensajes.yaHayFicha(this.getVentanaTablero());
    }

    return podes;
  }

  @Override
  public String toString() {
    return "Juego{"
        + "jugador1="
        + jugador1
        + ", jugador2="
        + jugador2
        + ", interfaz="
        + mensajes
        + ", tablero="
        + tablero
        + ", jugadorActual="
        + jugadorActual
        + ", vt="
        + ventanaTablero
        + '}';
  }
}
