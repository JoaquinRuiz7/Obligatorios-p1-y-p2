package dominio.tablero;

import java.util.Objects;

public class Coordenada {
  private int fila;
  private int columna;

  public Coordenada(int fila, int columna) {
    this.fila = fila;
    this.columna = columna;
  }

  public Coordenada() {}

  public int getFila() {
    return fila;
  }

  public int getColumna() {
    return columna;
  }

  public void setFila(int fila) {
    this.fila = fila;
  }

  public void setColumna(int columna) {
    this.columna = columna;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Coordenada that = (Coordenada) o;
    return fila == that.fila && columna == that.columna;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fila, columna);
  }
}
