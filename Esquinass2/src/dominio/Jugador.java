package dominio;

import dominio.fichas.ColorFicha;
import dominio.fichas.Ficha;
import dominio.fichas.FichaAzul;
import dominio.fichas.FichaRoja;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Jugador implements Comparable<Jugador>, Serializable {
  private String Nombre;
  private int edad;
  private String alias;
  private int win;
  private int puntaje;
  private int cantidadDeFichas;

  private List<Ficha> fichas;
  private boolean abandono;
  private boolean humano;
  private int ultimaPosicionI = 0;
  private int UltimaPosicionJ = 0;
  private int partidasPerdidas;

  public Jugador(String Nombre, int edad, String alias, ColorFicha colorFicha) {
    this.Nombre = Nombre;
    this.edad = edad;
    this.alias = alias;
    this.win = 0;
    this.puntaje = 0;
    this.abandono = false;
    this.humano = true;
    this.fichas =
        colorFicha.equals(ColorFicha.ROJO)
            ? Arrays.asList(new FichaRoja[25])
            : Arrays.asList(new FichaAzul[25]);
    this.partidasPerdidas = 0;
    this.cantidadDeFichas = 25;
  }

  public int getPartidasPerdidas() {
    return partidasPerdidas;
  }

  public void setPartidasPerdidas(int partidasPerdidas) {
    this.partidasPerdidas = partidasPerdidas;
  }

  public int getUltimaPosicionI() {
    return ultimaPosicionI;
  }

  public void setUltimaPosicionI(int ultimaPosicionI) {
    this.ultimaPosicionI = ultimaPosicionI;
  }

  public int getUltimaPosicionJ() {
    return UltimaPosicionJ;
  }

  public void setUltimaPosicionJ(int UltimaPosicionJ) {
    this.UltimaPosicionJ = UltimaPosicionJ;
  }

  public List<Ficha> getFichas() {
    return fichas;
  }

  public void setFichas(List<Ficha> fichas) {
    this.fichas = fichas;
  }

  public int getCantidadDeFichas() {
    return cantidadDeFichas;
  }

  public void setCantidadDeFichas(int cantidadDeFichas) {
    this.cantidadDeFichas = cantidadDeFichas;
  }

  public boolean getAbandono() {
    return abandono;
  }

  public void setAbandono(boolean seRindio) {
    this.abandono = seRindio;
  }

  public boolean isHumano() {
    return humano;
  }

  public void setHumano(boolean humano) {
    this.humano = humano;
  }

  public Jugador() {
    this.setAlias("No alias");
    this.setEdad(0);
    this.setNombre("No name");
    this.setPuntaje(0);
    this.setWin(0);
    this.setHumano(true);
    this.setPartidasPerdidas(0);
    this.cantidadDeFichas = 25;
  }

  public int getWin() {
    return win;
  }

  public void setWin(int win) {
    this.win = win;
  }

  public int getPuntaje() {
    return puntaje;
  }

  public void setPuntaje(int puntaje) {
    this.puntaje = puntaje;
  }

  public String getNombre() {
    return Nombre;
  }

  public void setNombre(String Nombre) {
    this.Nombre = Nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  @Override
  public String toString() {
    return this.getAlias();
  }

  @Override
  public boolean equals(Object o) {
    Jugador j = (Jugador) o;
    return this.getAlias().equals(j.getAlias());
  }

  @Override
  public int compareTo(Jugador j) {
    int diferencia = 0;
    diferencia = j.getWin() - this.getWin();
    if (diferencia == 0) {
      diferencia = this.getPartidasPerdidas() - j.getPartidasPerdidas();
    }
    return diferencia;
  }

  public boolean tieneFichas() {
    return this.cantidadDeFichas > 0;
  }

  public void descontarFichas(final int cantidad) {
    if (!this.tieneFichas()) {
      return;
    }

    for (int i = 0; i < cantidad; i++) {
      this.cantidadDeFichas--;
    }
  }

  public int getFichasRestantes() {
    if (this.fichas == null) {
      return 0;
    }
    return this.fichas.size();
  }

  public void incrementarPartidasGanadas() {
    this.partidasPerdidas++;
  }
}
