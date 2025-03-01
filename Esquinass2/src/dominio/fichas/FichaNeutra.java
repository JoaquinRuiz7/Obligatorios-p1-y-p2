package dominio.fichas;

import java.awt.*;

public class FichaNeutra implements IFicha {
  @Override
  public Color getColor(Tonalidad tonalidad) {
    return null;
  }

  @Override
  public boolean esFichaNeutra() {
    return true;
  }
}
