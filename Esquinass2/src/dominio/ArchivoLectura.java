
package dominio;

import java.io.*;
public class ArchivoLectura {
    String linea = "";
    BufferedReader in;
    public ArchivoLectura(String nombre){
        try{
            in = new BufferedReader (new FileReader(nombre));
        }catch(FileNotFoundException e){
        
        }
        
    }
    public boolean hayMasLineas(){
        try{
           linea = in.readLine();
           
        }catch(IOException e){
            linea = null;
            
        }
        return (linea != null);
    }
    public String linea(){
return linea;
}
    public boolean cerrar(){
        boolean ok = true;
        try{
            in.close();
        }catch(Exception e){
            ok = false;
        }
      return ok;  
    }
}
