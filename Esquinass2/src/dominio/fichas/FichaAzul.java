package dominio.fichas;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class FichaAzul extends Ficha {
  private static final ColorFicha COLOR = ColorFicha.AZUL;
  private static final Map<Tonalidad, Color> TONALIDAD_COLORES = new HashMap<>();

  public FichaAzul() {
    this.numero = 1;
  }

  static {
    TONALIDAD_COLORES.put(Tonalidad.MUY_CLARA, new Color(204, 229, 255));
    TONALIDAD_COLORES.put(Tonalidad.CLARA, new Color(153, 204, 255));
    TONALIDAD_COLORES.put(Tonalidad.MEDIA, new Color(51, 153, 255));
    TONALIDAD_COLORES.put(Tonalidad.OSCURA, new Color(0, 102, 204));
    TONALIDAD_COLORES.put(Tonalidad.MUY_OSCURA, new Color(0, 51, 102));
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
