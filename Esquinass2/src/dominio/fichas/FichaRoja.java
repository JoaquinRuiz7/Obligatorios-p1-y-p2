package dominio.fichas;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FichaRoja extends Ficha {

  private static final ColorFicha COLOR = ColorFicha.ROJO;
  private static final Map<Tonalidad, Color> TONALIDAD_COLORES = new HashMap<>();

  public FichaRoja() {
    this.numero = 1;
  }

  static {
    TONALIDAD_COLORES.put(Tonalidad.MUY_CLARA, new Color(255, 204, 204));
    TONALIDAD_COLORES.put(Tonalidad.CLARA, new Color(255, 102, 102));
    TONALIDAD_COLORES.put(Tonalidad.MEDIA, new Color(204, 0, 0));
    TONALIDAD_COLORES.put(Tonalidad.OSCURA, new Color(153, 0, 0));
    TONALIDAD_COLORES.put(Tonalidad.MUY_OSCURA, new Color(102, 0, 0));
  }

  @Override
  public Color getColor() {
    return switch (this.numero) {
      case 2 -> TONALIDAD_COLORES.get(Tonalidad.CLARA);
      case 3 -> TONALIDAD_COLORES.get(Tonalidad.MEDIA);
      case 4 -> TONALIDAD_COLORES.get(Tonalidad.OSCURA);
      case 5 -> TONALIDAD_COLORES.get(Tonalidad.MUY_OSCURA);
      default -> TONALIDAD_COLORES.get(Tonalidad.MUY_CLARA);
    };
  }

  @Override
  public boolean esFichaNeutra() {
    return false;
  }

  @Override
  public ColorFicha getColorFicha() {
    return COLOR;
  }
}
