
package obligatorio2;


public class Inspeccion implements Comparable<Inspeccion>{
   private Inspector inspector;
   private Actividad actividad;
   private int dia;
   private int mes;
   private int horaReal;
   private String comentario;
   private String resultado;
   private String riesgoo;
   private String month;

    public Inspeccion(Inspector inspector, Actividad actividad, int dia, int mes, int horaReal, String comentario, String resultado, String riesgoo, String month) {
        this.inspector = inspector;
        this.actividad = actividad;
        this.dia = dia;
        this.mes = mes;
        this.horaReal = horaReal;
        this.comentario = comentario;
        this.resultado = resultado;
        this.riesgoo = riesgoo;
        this.month = month;
    }
    

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getHoraReal() {
        return horaReal;
    }

    public void setHoraReal(int horaReal) {
        this.horaReal = horaReal;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getRiesgoo() {
        return riesgoo;
    }

    public void setRiesgoo(String riesgoo) {
        this.riesgoo = riesgoo;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    @Override
    public String toString(){
        return "Inspeccion\n-----------------------------------------\nInspector : "+inspector.getNombre()+"\nActividad : "+actividad.getDescripcion()+"\nDia : "+this.getDia()+"\nMes : "+this.getMonth()+"\nComentarios : "+this.getComentario()+"\nHoras reales de la actividad : "+this.getHoraReal()+"\nRiesgo evaluado : "+this.getRiesgoo()+"\nResultado : "+this.getResultado()+"\n-------------------------------------\n";
        
    }
    @Override
    public int compareTo(Inspeccion i){
        int diferencia = 0;
        diferencia = this.getMes()-i.getMes();
        if(diferencia == 0){
            diferencia = this.getDia()-i.getDia();
            
        }
        return diferencia;
    }
    
    
    
    
}
