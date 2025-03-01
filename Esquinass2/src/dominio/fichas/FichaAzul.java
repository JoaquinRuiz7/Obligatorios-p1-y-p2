package dominio.fichas;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class FichaAzul implements IFicha {
  private static final Map<Tonalidad, Color> TONALIDAD_COLORES = new HashMap<>();

  static {
    TONALIDAD_COLORES.put(Tonalidad.MUY_CLARA, new Color(204, 229, 255));
    TONALIDAD_COLORES.put(Tonalidad.CLARA, new Color(153, 204, 255));
    TONALIDAD_COLORES.put(Tonalidad.MEDIA, new Color(51, 153, 255));
    TONALIDAD_COLORES.put(Tonalidad.OSCURA, new Color(0, 102, 204));
    TONALIDAD_COLORES.put(Tonalidad.MUY_OSCURA, new Color(0, 51, 102));
  }

  @Override
  public Color getColor(Tonalidad tonalidad) {
    return TONALIDAD_COLORES.get(tonalidad);
  }
}
