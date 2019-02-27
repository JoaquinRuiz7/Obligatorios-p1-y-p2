
package obligatorio2;


public class Encargado extends Persona{
    private String direccion;
    public Encargado(){
        this.setDireccion("Sin nombre");
        
    }

    public Encargado(String nombre, String cedula, String direccion) {
        super (nombre , cedula);
        this.direccion = direccion;
    }
    
    

 

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    @Override
    public String toString(){
        return "-----Encargado-----\nNombre : "+this.getNombre()+"\nCedula : "+this.getCedula()+"\nDireccion : "+this.getDireccion()+"\n------------------";
        
    }
    
}
