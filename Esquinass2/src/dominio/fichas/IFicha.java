package dominio.fichas;

import java.awt.Color;

public interface IFicha {
  Color getColor(final Tonalidad tonalidad);

  boolean esFichaNeutra();
}
