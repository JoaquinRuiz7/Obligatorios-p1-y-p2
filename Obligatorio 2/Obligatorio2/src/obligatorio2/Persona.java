
package obligatorio2;


public class Persona {

    private String nombre;
    private String cedula;
    public Persona(){
        this.setNombre("Sin nombre");
        this.setCedula("Sin cedula");
    }
    

    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    @Override
    public String toString(){
        return "Nombre : "+this.getNombre()+"\nCedula : "+this.getCedula();
    }
    @Override
    public boolean equals(Object o){
        Persona p = (Persona) o;
        return this.getCedula().equals(p.getCedula());
                
    }
    
    
}
