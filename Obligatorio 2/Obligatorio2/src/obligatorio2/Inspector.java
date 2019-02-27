
package obligatorio2;


public class Inspector extends Persona{   
    private int edad;

    public Inspector( String nombre , String cedula ,int edad) {
        super (nombre , cedula);
        this.setEdad(edad);

    }
    public Inspector(){
        this.setEdad(0);
    }

 
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString(){
        return "-------Inspector-------\nNombre : "+this.getNombre()+"\nCedula : "+this.getCedula()+"\nEdad : "+this.getEdad()+"\n-----------------------";
    }
    
    
}
