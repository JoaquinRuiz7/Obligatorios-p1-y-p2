package obligatorio2;

public class Actividad {

    private int seccion;
    private String descripcion;
    private int duracionHoras;
    private int RiesgoPrincipal;
    private int RiesgoSecundario;
    private String riesgo1;
    private String riesgo2;
    private Encargado encargado;

    public Actividad(int seccion, String descripcion, int duracionHoras, int RiesgoPrincipal, int RiesgoSecundario, String riesgo1, String riesgo2, Encargado encargado) {
        this.seccion = seccion;
        this.descripcion = descripcion;
        this.duracionHoras = duracionHoras;
        this.RiesgoPrincipal = RiesgoPrincipal;
        this.RiesgoSecundario = RiesgoSecundario;
        this.riesgo1 = riesgo1;
        this.riesgo2 = riesgo2;
        this.encargado = encargado;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public Actividad() {
        this.setDescripcion("Sin descripcion");
        this.setDuracionHoras(0);
        this.setRiesgo1("Sin riesgo principal");
        this.setRiesgo2("Sin riesgo secundario");
        this.setRiesgoPrincipal(0);
        this.setRiesgoSecundario(0);
        this.setSeccion(0);
        this.setEncargado(encargado);

    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public int getRiesgoPrincipal() {
        return RiesgoPrincipal;
    }

    public void setRiesgoPrincipal(int RiesgoPrincipal) {
        this.RiesgoPrincipal = RiesgoPrincipal;
    }

    public int getRiesgoSecundario() {
        return RiesgoSecundario;
    }

    public void setRiesgoSecundario(int RiesgoSecundario) {
        this.RiesgoSecundario = RiesgoSecundario;
    }

    public String getRiesgo1() {
        return riesgo1;
    }

    public void setRiesgo1(String riesgo1) {
        this.riesgo1 = riesgo1;
    }

    public String getRiesgo2() {
        return riesgo2;
    }

    public void setRiesgo2(String riesgo2) {
        this.riesgo2 = riesgo2;
    }

    @Override
    public String toString() {
        return "-------Actividad-------\nDescripcion : " + this.getDescripcion() + "\nEncargado : " + encargado.getNombre() + "\nSeccion : " + this.getSeccion() + "\nDuracion en horas : " + this.getDuracionHoras() + "\nRiesgo principal : " + this.getRiesgo1() + "\nRiesgo secundario : " + this.getRiesgo2() + "\n-----------------------";
    }

}
