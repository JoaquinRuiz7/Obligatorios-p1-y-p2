package dominio;

import java.util.*;
import Interfaz.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Sistema implements Serializable {

    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<PartidaGuardada> partidasGuardadas = new ArrayList<>();
   

    
    

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<PartidaGuardada> getPartidasGuardadas() {
        return partidasGuardadas;
    }

    public void setPartidasGuardadas(ArrayList<PartidaGuardada> partidasGuardadas) {
        this.partidasGuardadas = partidasGuardadas;
    }
public ArrayList<Jugador> jugadoresPro(){
    ArrayList<Jugador> jugadoresPro = new ArrayList<>();
    for (int i = 0; i < jugadores.size(); i++) {
        if(jugadores.get(i).getWin() >= 1){
            jugadoresPro.add(jugadores.get(i));
            
        }
        
    }
    return jugadoresPro;
}    

   
    public Sistema() {
        jugadores = new ArrayList();
        partidasGuardadas = new ArrayList<>();
        
    }
    

public int cantidadPArtisasGanadas(Jugador j){
    int ganadas = 0;
    for (int i = 0; i <jugadores.size(); i++) {
        Jugador ju = jugadores.get(i);
        if ( j.equals(ju)){
            ganadas = j.getWin();
        }
        
    }
    return ganadas;
}   
    

    public void registrarJugador(Jugador jugador, VentanaRegistroJugador v) {
       
        if (!jugadores.contains(jugador)) {
            jugadores.add(jugador);
            Mensajes.registradoConExito(jugador, v);
           
           
        } else {
            Mensajes.yaEstaRegistrado(jugador, v);
        }

    }
  
    public Sistema loadSystem() {
        Sistema sistema = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("datos.txt"));
            sistema = (Sistema) in.readObject();
            in.close();

        } catch (Exception e) {
            sistema = new Sistema();

        }
        return sistema;
    }

    public void setJugadores(ArrayList<Jugador> jugadores ) {
        this.jugadores = jugadores;
    }

    public void saveSystem(Sistema sistema ) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("datos.txt"));
            out.writeObject(sistema);
            out.close();
        } catch (Exception ex) {
            
        }

    }

    public void ranking(ArrayList<Jugador> jugadores) {
        Collections.sort(jugadores);
    }

}
