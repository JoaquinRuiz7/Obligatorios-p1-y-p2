
package dominio;

import java.io.Serializable;



public class PartidaGuardada implements Serializable {
    private Tablero t;
    private Jugador jugador1;
    private Jugador Jugador2;
    private Jugador jugadorActual;
    private String fechaYHora;
    private String cancion;
    private boolean tiempo;

    public boolean isTiempo() {
        return tiempo;
    }

    public void setTiempo(boolean tiempo) {
        this.tiempo = tiempo;
    }
   
    

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    
    

    public PartidaGuardada(){
        this.setT(t);
        this.setJugador1(jugador1);
        this.setJugador2(Jugador2);
        this.setJugadorActual(jugadorActual);
        this.setFechaYHora(fechaYHora);
        this.setCancion(cancion);
        this.setTiempo(tiempo);
        
    }

    public String getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(String fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
   
    

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador juggadorActual) {
        this.jugadorActual = juggadorActual;
    }
    
    public Tablero getT() {
        return t;
    }

    public void setT(Tablero t) {
        this.t = t;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return Jugador2;
    }

    public void setJugador2(Jugador Jugador2) {
        this.Jugador2 = Jugador2;
    }
    @Override
    public boolean equals(Object o){
        PartidaGuardada sg = (PartidaGuardada) o;
        return  this.getFechaYHora().equals(sg.getFechaYHora());
        
    }
    @Override
    public String toString(){
        return this.getFechaYHora()+"-"+this.getJugador1()+" Vs "+this.getJugador2();
    }
    
    
}
