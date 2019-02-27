
package dominio;


public class PerdistePorTiempo {
    private int tiempoElejido;
    private int tiempoRestante;
public PerdistePorTiempo(int tiempo){
    this.tiempoElejido = tiempo;
     this.reiniciarTiempo();
    
}
public void restarUnSegundo() {
        tiempoRestante--;
    }
    public boolean perdiste() {
        return tiempoRestante <= 0;
    }
    public int getTiempoRestante() {
        return tiempoRestante;
    }
public void reiniciarTiempo() {
        tiempoRestante = tiempoElejido;
    }
    public int getTiempoElejido() {
        return tiempoElejido;
    }

    public void setTiempoElejido(int tiempoElejido) {
        this.tiempoElejido = tiempoElejido;
    }

   

    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }
    
    
}
