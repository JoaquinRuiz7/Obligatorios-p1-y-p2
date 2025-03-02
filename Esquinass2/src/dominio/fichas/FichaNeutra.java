package dominio.fichas;

import java.awt.*;

public class FichaNeutra extends Ficha {

  @Override
  public Color getColor() {
    return null;
  }

  @Override
  public boolean esFichaNeutra() {
    return true;
  }

  @Override
  public ColorFicha getColorFicha() {
    return null;
  }
}
