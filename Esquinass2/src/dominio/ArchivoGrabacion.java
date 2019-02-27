
package dominio;
import java.io.*;


public class ArchivoGrabacion {
    BufferedWriter out;
    public ArchivoGrabacion(String nombre){
        try{
            out = new BufferedWriter(new FileWriter(nombre));
        }
    catch(IOException e){
            
    
}
    }
     public boolean grabarLinea(String linea){
            boolean ok = true;
            try{
                out.write(linea);
                out.newLine();
            }catch (IOException e){
                
                ok = false;
            }
            
           return ok; 
        }
     public boolean cerrar(){
         boolean ok = true;
         try{
             out.flush();
             out.close();
         }catch(Exception e){
            ok = false;
         }
         return ok;
     }
    }
       
    
    

