package Interfaz;

import dominio.*;
import java.io.Serializable;
import java.util.*;
import javax.swing.*;

public class Mensajes implements Serializable {
  static Scanner in = new Scanner(System.in);

  public static void yaEstaRegistrado(Jugador j, VentanaRegistroJugador v) {
    JOptionPane.showMessageDialog(
        v,
        "El jugador de alias "
            + j.getAlias()
            + " ya esta registrado en el sistema , porfavor registrese con un alias diferente.",
        "No se pudo registrar el jugador",
        JOptionPane.ERROR_MESSAGE);
  }

  public static void registradoConExito(Jugador j, VentanaRegistroJugador v) {

    JOptionPane.showMessageDialog(
        v, "El jugador " + j.getAlias() + " fue registrado con exito!", "Registro exitoso", 1);
  }

  public static void posicionInvalida(VentanaTablero vt) {
    JOptionPane.showMessageDialog(
        vt,
        "Posicion invalida , se forma cuadrado de 2x2",
        "Jugada invalida",
        JOptionPane.ERROR_MESSAGE);
  }

  public static void posicionInvalidaDos(VentanaTablero vt) {
    JOptionPane.showMessageDialog(
        vt, "Posicion invalida, no es adyacente.", "Jugada invalida", JOptionPane.ERROR_MESSAGE);
  }

  public static void yaHayFicha(VentanaTablero vt) {
    JOptionPane.showMessageDialog(
        vt, "Ya hay una ficha en esa posicion", "Ya hay ficha", JOptionPane.ERROR_MESSAGE);
  }

  public void alargoEsquinaEn(
      String aliasJugador, ArrayList<String> dondeAlargo, String letra, int j) {

    dondeAlargo.add(aliasJugador + " alargo la esquina formada en " + letra + (j + 1));
  }

  public void formoEsquina(
      String nombreJugador, String letra, int j, ArrayList<String> dondeFormo) {
    dondeFormo.add(nombreJugador + " formo esquina en " + letra + (j + 1));
  }

  public void jugoEn(String jugada, Jugador j) {}

  public void esquinaSinGracia(VentanaTablero vt) {
    JOptionPane.showMessageDialog(
        vt,
        "Se formo esquina pero tiene altura maxima , no se agregan cubos.",
        "Mala jugada",
        JOptionPane.ERROR_MESSAGE);
  }
}
