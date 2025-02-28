
package Interfaz;
import java.util.*;
import dominio.*;
import java.io.Serializable;
import javax.swing.*;



public class Mensajes implements Serializable{
    static Scanner in = new Scanner(System.in);

   

    public static void yaEstaRegistrado(Jugador j , VentanaRegistroJugador v) {
        JOptionPane.showMessageDialog(v,"El jugador de alias "+j.getAlias()+" ya esta registrado en el sistema , porfavor registrese con un alias diferente.", "No se pudo registrar el jugador", JOptionPane.ERROR_MESSAGE);
    }
    public static void registradoConExito(Jugador j ,VentanaRegistroJugador v ){
        
        JOptionPane.showMessageDialog(v,"El jugador "+j.getAlias()+" fue registrado con exito!","Registro exitoso",1 );
    }



    public String validarJugada() {
        String jugada = in.nextLine();
        boolean valida = false;
        while (!valida) {
            if (jugada.equalsIgnoreCase("x")) {
                jugada = jugada.toUpperCase();
                valida = true;
            } else if (((jugada.matches("[A-Fa-f1-6]*") && jugada.length() == 2) && (!jugada.equalsIgnoreCase("x")))) {
                jugada = jugada.toUpperCase();
                if (jugada.charAt(0) == '1' || jugada.charAt(0) == '2' || jugada.charAt(0) == '3' || jugada.charAt(0) == '4' || jugada.charAt(0) == '5' || jugada.charAt(1) == 'A' || jugada.charAt(1) == 'B' || jugada.charAt(1) == 'C' || jugada.charAt(1) == 'D' || jugada.charAt(1) == 'E' || jugada.charAt(1) == 'F') {
                    System.out.println("Ingrese una jugada valida : ");
                    jugada = in.nextLine();
                    valida = false;
                } else {
                    jugada = jugada.toUpperCase();
                    valida = true;
                }
            } else {
                System.out.println("Ingrese una jugada valida : ");
                jugada = in.nextLine();
            }
        }
        return jugada;
    }

    private static void mostrarTablero(Juego juego, String red, String blue) {
        String[] AF = {"A", "B", "C", "D", "E", "F"};

        System.out.println("  1  2  3  4  5  6");

        for (int i = 0; i < juego.getTablero().getTablero().length; i++) {
            System.out.print(AF[i]);
            for (int j = 0; j < juego.getTablero().getTablero()[0].length; j++) {
                if (juego.getTablero().getTablero()[i][j].endsWith("\u001B[0m")) {
                    System.out.print("|" + juego.getTablero().getTablero()[i][j] + "|");
                } else {
                    System.out.print("|_|");

                }

            }
            System.out.println();

        }

    }

    public static void posicionInvalida(VentanaTablero vt) {
        JOptionPane.showMessageDialog(vt,"Posicion invalida , se forma cuadrado de 2x2","Jugada invalida", JOptionPane.ERROR_MESSAGE);

    }
     public static void posicionInvalidaDos(VentanaTablero vt) {
        JOptionPane.showMessageDialog(vt,"Posicion invalida, no es adyacente.","Jugada invalida", JOptionPane.ERROR_MESSAGE);

    }
    

    public static void mostrarJugadores(ArrayList<Jugador> jugadores) {
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println((i + 1) + ")" + jugadores.get(i).getNombre());

        }
    }

    public static void mostrarRankings(ArrayList<Jugador> jugadores) {
        System.out.println("____________rankings____________");
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println((i + 1) + "- " + jugadores.get(i).getNombre() + " con " + jugadores.get(i).getWin() + " partidas ganadas.");

        }
        System.out.println("_________________________________");

    }

    public static void yaHayFicha(VentanaTablero vt) {
        JOptionPane.showMessageDialog(vt,"Ya hay una ficha en esa posicion","Ya hay ficha", JOptionPane.ERROR_MESSAGE);
    }
    public void cubosRestantes(VentanaTablero vt , Juego juego){
        JOptionPane.showMessageDialog(vt,"Cubos restantes : "+juego.getJugadorActual().getCubos()," Cubos ", 3);
        
    }

    public void alargoEsquinaEn(String aliasJugador,ArrayList<String> dondeAlargo,String letra, int j) {
        
        dondeAlargo.add(aliasJugador+" alargo la esquina formada en "+ letra+(j+1));
    }

    public void formoEsquina(String nombreJugador,String letra, int j , ArrayList<String> dondeFormo) {
        dondeFormo.add(nombreJugador+" formo esquina en "+letra+(j+1));

        

    }



    public void abandonoPartida(Juego juego) {
        if (juego.getJugadorActual().equals(juego.getJugador1())) {
            System.out.println(juego.getJugador1().getNombre() + " abandono la partida. Gana " + juego.getJugador2().getNombre());

        } else {
            System.out.println(juego.getJugador2().getNombre() + " abandono la partida. Gana " + juego.getJugador1().getNombre());

        }

    }

    public void jugoEn(String jugada, Jugador j) {

        

    }

    public int elegirJugador(ArrayList<Jugador> players, int elija) {
        boolean ok = false;

        while (!ok) {
            if (elija > players.size() || elija < 1) {
                System.out.println("Ingrese una opcion valida : ");
                elija = pedirNumero();
            } else {
                ok = true;
            }
        }
        return elija;

    }

    public int pedirNumero() {
        String numero = in.nextLine();
        int numeroRetorno = 0;
        try {
            numeroRetorno = Integer.parseInt(numero);
        } catch (NumberFormatException ex) {
            System.out.println("Debe ingresar un número");
        }
        return numeroRetorno;
    }

    public static String validarAlias() {
        String letter = "";
        letter = in.nextLine();
        letter = letter.trim();
        while (letter.isEmpty()) {
            System.out.println("Campo vacío ingreselo nuevamente:");
            letter = in.nextLine();
            letter = letter.trim();
        }
        return letter;
    }

    public static String letters() {
        String letter = "";
        letter = in.nextLine();
        letter = letter.trim();
        while ((!letter.matches("[A-Za-z ]*")) || (letter.isEmpty())) {
            System.out.println("Ingrese el dato ingresando unicamente letras , sin nigun caracter especial :");
            letter = in.nextLine();
            letter = letter.trim();
        }
        return letter;
    }

    public void esquinaSinGracia(VentanaTablero vt) {
        JOptionPane.showMessageDialog(vt,"Se formo esquina pero tiene altura maxima , no se agregan cubos.","Mala jugada",JOptionPane.ERROR_MESSAGE);
    }

    public static void backToMenu() {
        String enter = "";
        boolean ok = false;
        System.out.println("Volver al menu : Enter");
        enter = in.nextLine();
        while (!ok) {
            if (enter.isEmpty()) {
                ok = true;
            } else {
                System.out.println("Volver al menu : enter");
                enter = in.nextLine();
            }
        }

    }

    private int validarOpcionMenu(int opcion) {
        boolean ok = false;
        while (!ok) {
            if (opcion > 5 || opcion < 1) {
                System.out.println("Ingrese una opcion valida : ");
                opcion = pedirNumero();
            } else {
                ok = true;
            }
        }
        return opcion;

    }

    private void menu(Sistema sistema) {
        int opcion = 0;
        do {
            System.out.println("|_ Esquinas _|\n\n1- Registrar Jugador\n2- Jugar\n3- Ver rankings\n4- Jugar contra la pc\n5- Salir");
            System.out.print("Ingrese opcion : ");
            opcion = pedirNumero();
            opcion = validarOpcionMenu(opcion);
            if (opcion == 4 && sistema.getJugadores().isEmpty()) {
                System.out.println("No hay ningun jugador registrado en el sistema.");
                opcion = 6;
            } else if (opcion == 2 && (sistema.getJugadores().size() == 1)) {
                System.out.println("Hay solo un jugador registrado no se puede jugar modo versus.");
                opcion = 6;

            } else if (opcion == 2 && sistema.getJugadores().isEmpty()) {
                System.out.println("No se puede jugar modo versus porque no hay ningun jugador registrado en el sistema.");
                opcion = 6;
            } else if (opcion == 3 && sistema.getJugadores().isEmpty()) {
                System.out.println("No existe ningun jugador registrado");
                opcion = 6;
            }
            
            switch (opcion) {
                case 1:
                    do {
                       

                        System.out.println("Registrar otro Jugador ?\n1)Si\n2)No");
                        opcion = pedirNumero();

                        while (opcion > 2 || opcion < 1) {
                            System.out.println("Ingrese opcion valida : ");
                            opcion = pedirNumero();
                        }
                    } while (opcion != 2);
                    backToMenu();

                    break;
                case 2:
                   // Juego jugar = crearJuego(sistema.getJugadores());
                    

                    break;
                case 3:
                    sistema.ranking(sistema.getJugadores());
                    mostrarRankings(sistema.getJugadores());

                    break;
                case 4:
                  
                    
                    break;
                case 6:
                    backToMenu();
                    break;
            }
        } while (opcion != 5);
    }

    public Jugador crearJugador() {
        String nombre = "";
        String Alias = "";
        System.out.println("Ingrese el nombre : ");
        nombre = letters();
        if(nombre.equalsIgnoreCase("Mauro")){
            nombre = "el gordo Mauro ";
        }
        System.out.println("Crea un Alias : ");
        Alias = validarAlias();
        System.out.println("Ingresa tu edad : ");
        int edad = pedirNumero();
        while (edad == 0) {
            edad = pedirNumero();
        }
        edad = validarEdad(edad);
        Jugador j = new Jugador(nombre, edad, Alias);
        return j;
    }

    private int validarEdad(int edad) {
        boolean valida = false;
        while (!valida) {
            if (edad > 99 || edad <= 0) {
                System.out.println("Ingrese una edad valida ( 1-99 ): ");

                edad = pedirNumero();
            } else {
                valida = true;
            }
        }
        return edad;
    }

    
    
}
