
package dominio;

import java.io.Serializable;


public class Tablero implements Serializable {
     private String [][] tablero;
    
    public Tablero(String[][] tablero ) {
        this.tablero = tablero;        
    }
    
    public Tablero(){
        this.setTablero(tablero);
    }   

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }
    
}
