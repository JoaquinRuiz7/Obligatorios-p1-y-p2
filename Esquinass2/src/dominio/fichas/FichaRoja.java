package dominio.fichas;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FichaRoja implements IFicha {

  private static final Map<Tonalidad, Color> TONALIDAD_COLORES = new HashMap<>();

  static {
    TONALIDAD_COLORES.put(Tonalidad.MUY_CLARA, new Color(255, 204, 204));
    TONALIDAD_COLORES.put(Tonalidad.CLARA, new Color(255, 102, 102));
    TONALIDAD_COLORES.put(Tonalidad.MEDIA, new Color(204, 0, 0));
    TONALIDAD_COLORES.put(Tonalidad.OSCURA, new Color(153, 0, 0));
    TONALIDAD_COLORES.put(Tonalidad.MUY_OSCURA, new Color(102, 0, 0));
  }

  @Override
  public Color getColor(Tonalidad tonalidad) {
    return TONALIDAD_COLORES.get(tonalidad);
  }

  @Override
  public boolean esFichaNeutra() {
    return false;
  }
}
