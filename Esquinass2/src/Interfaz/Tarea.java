
package Interfaz;

import java.util.TimerTask;


public class Tarea extends TimerTask {
    private VentanaTablero vt;

    public VentanaTablero getVt() {
        return vt;
    }

    public void setVt(VentanaTablero vt) {
        this.vt = vt;
    }
    
    public Tarea(VentanaTablero vt){
        this.vt = vt;
    } 
    @Override
    public void run() {
        this.getVt().cuentaRegresiva();
           
    }
    
}
