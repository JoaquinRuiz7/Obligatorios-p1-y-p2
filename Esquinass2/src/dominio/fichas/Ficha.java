package dominio.fichas;

import java.awt.Color;

public abstract class Ficha {

  protected int numero;

  public abstract Color getColor(final Tonalidad tonalidad);

  public abstract boolean esFichaNeutra();

  public abstract ColorFicha getColorFicha();

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void aumentarNumero(int numero) {
    this.numero += numero;
  }
}
