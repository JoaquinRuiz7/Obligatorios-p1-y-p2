
package dominio;
import Interfaz.*;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;


public class Juego implements Serializable {
    private Jugador jugador1;
    private Jugador jugador2;
    private Mensajes mensajes;
    private Tablero tablero;
    private Jugador jugadorActual;
    private VentanaTablero vt;
    

    public Juego(Sistema sistema,Jugador jugadorr1, Jugador jugadorr2, Mensajes i, Tablero tab , VentanaTablero VT) {
        jugador1 = jugadorr1;
        jugador2 = jugadorr2;
        mensajes = i;
        tablero = tab;
        jugadorActual = this.getJugador1();
        
        
    }
    public Juego (){
        this.setJugador1(jugador1);
        this.setJugador2(jugador2);
        this.setMensajes(mensajes);
        this.setTablero(tablero);
        this.setJugadorActual(jugadorActual);
        this.setVt(vt);
        
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Mensajes getMensajes() {
        return mensajes;
    }

    public void setMensajes(Mensajes mensajes) {
        this.mensajes = mensajes;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    private void ganoAlAbandonar(Jugador jugador) {
        if (this.getJugadorActual().equals(this.getJugador1())) {
            this.getJugadorActual().setCubos(0);
            this.getJugadorActual().setAbandono(true);
            this.getJugador2().setWin(this.getJugador2().getWin() + 1);
        } else {
            this.getJugadorActual().setCubos(0);
            this.getJugadorActual().setAbandono(true);
            this.getJugador1().setWin(this.getJugador1().getWin() + 1);
        }
    }

    public void ponePc(int i, int j, Tablero t, String red, String blue, boolean pj) {
        String reset = "\u001B[0m";
        int pI = 0;
        int pJ = 0;
        String letra = "";
        String[][] ta = t.getTablero();
         String Dosrojo = "\u001B[31m2\u001B[0m";
        String Dosazul = "\033[34m2\u001B[0m";
        String TresRojo = "\u001B[31m3\u001B[0m";
        String TresAzul = "\033[34m3\u001B[0m";
        String CuatroRojo = "\u001B[31m4\u001B[0m";
        String CuatroAzul = "\033[34m4\u001B[0m";
        String CincoRojo = "\u001B[31m5\u001B[0m";
        String CincoAzul = "\033[34m5\u001B[0m";
        if (!pj) {
            pI = i;
            pJ = j;

            if (!pj) {
                if (pI > 0 && pI < 5 && (pJ < 5 && pJ > 0)) {
                    ta[pI][pJ + 1] = blue;
                } else if (pI == 0) {
                    ta[pI + 1][pJ] = blue;
                } else if (pI == 5) {
                    ta[pI - 1][pJ] = blue;
                } else if (pJ == 0) {
                    ta[pI][pJ + 1] = blue;
                } else if (pJ == 5) {
                    ta[pI][pJ - 1] = blue;
                } else if (pI == 0 && pJ == 0) {
                    ta[pI][pJ + 1] = blue;
                } else if (pI == 0 && pJ == 5) {
                    ta[pI][pJ - 1] = blue;
                } else if (pI == 5 && pJ == 0) {
                    ta[pI][pJ + 1] = blue;
                } else if (pI == 5 && pJ == 5) {
                    ta[pI][pJ - 1] = blue;
                    
                    
                }
            }
        } else {
            int maximo = 0;
            int posI = 0;
            int posJ = 0;
            

            for (int k = 0; k < ta.length; k++) {
                for (int l = 0; l < ta[0].length; l++) {

                    if (this.ahiSi(k, l, this.getTablero(), red, blue) && this.validarPosicion(k, l, tablero, red, blue) && this.noEsCuadrado(k, l, this.getTablero(), red, blue)) {
                        if (this.cuentaEsquina(this.getJugadorActual(), l, k, red, blue) + this.cuentaAlargoEsquina(k, l, this.getJugadorActual(), this.getTablero(), red, blue) > maximo) {
                             
                            maximo = this.cuentaEsquina(this.getJugadorActual(), l, k, red, blue) + this.cuentaAlargoEsquina(k, l, this.getJugadorActual(), this.getTablero(), red, blue);
                            posI = k;
                            posJ = l;
                            
                        }
                        

                    }

                }

            }
            for (int k = 0; k < ta.length; k++) {
                for (int l = 0; l < ta[0].length; l++) {
                    if(this.ahiSi(k, l, this.getTablero(), red, blue) && this.validarPosicion(k, l, tablero, red, blue) && this.noEsCuadrado(k, l, this.getTablero(), red, blue)){
                        if(this.cuentaEsquina(this.getJugadorActual(), l, k, red, blue)+this.cuentaAlargoEsquina(k, l, this.getJugadorActual(), this.getTablero(), red, blue) == maximo){
       
                            if(posI>k){
                                posI = k;
                                posJ = l;
                            }else if (posI == k){
                                if(posJ>l){
                                    posJ = l;
                                    posI = k;
                                }
                            }
                        }
                    }
                    
                }
                
            }
            if (maximo == 0) {
                for (int k = 0; k < ta.length; k++) {
                    for (int l = 0; l < ta[0].length; l++) {
                        if (this.ahiSi(k, l, this.getTablero(), red, blue) && this.validarPosicion(k, l, tablero, red, blue) && this.noEsCuadrado(k, l, this.getTablero(), red, blue)) {
                            posI = k;
                            posJ = l;
                        }
                         
                    }
                }
            }

            ta[posI][posJ] = blue;
            this.getJugadorActual().setCubos(this.getJugadorActual().getCubos()-1);
            this.getVt().getBotones()[posI][posJ].setBackground(new Color(204,204,255));
            this.getVt().getBotones()[posI][posJ].setText("A");
            
            this.numeroALetra(posI, false, false);
            letra = this.numeroALetra(posI, false, false);
            this.getMensajes().jugoEn(letra + (posJ + 1), this.getJugadorActual());
            this.formaEsquina(this.getJugadorActual(), posJ, posI, red, blue);
            this.alargoEsquina(posI, posJ, this.getJugadorActual(), this.getTablero(), red, blue);
        }
    }

    public void colocarFicha(boolean reanudada,boolean primeraJugada, String red, String blue , int fila , int columna) {
        int PosicionI = fila;
        int PosicionJ = columna;
        boolean Podes = false;
        String jugada = "";
        if (this.getJugadorActual().isHumano()) {
            
          

                   
                    Podes = ahiSi(PosicionI, PosicionJ, this.getTablero(), red, blue);
                    if ((Podes && primeraJugada) || (reanudada && Podes) ) {
                        Podes = validarPosicion(PosicionI, PosicionJ, this.getTablero(), red, blue);
                        if (Podes) {
                            Podes = noEsCuadrado(PosicionI, PosicionJ, this.getTablero(), red, blue);
                        }
                    }
                    
                
                   
                

            
            this.getJugador1().setUltimaPosicionI(PosicionI);
            this.getJugador1().setUltimaPosicionJ(PosicionJ);

            //Aca es donde se coloca la ficha en la posicion tablero[PosicionI][PosicionJ]
            if(Podes){
                if (this.getJugadorActual().equals(this.getJugador1())) {
                    //Rojo 
                    this.getTablero().getTablero()[PosicionI][PosicionJ] = red;
                    this.getJugadorActual().setCubos(this.getJugadorActual().getCubos()-1);
                    
                    // rojo
                    
                    this.getVt().getBotones()[PosicionI][PosicionJ].setBackground(new Color(255,204,204));
                    this.getVt().getBotones()[PosicionI][PosicionJ].setText("R");
                     formaEsquina(this.getJugadorActual(), PosicionJ, PosicionI, red, blue);
                alargoEsquina(PosicionI, PosicionJ, this.getJugadorActual(), this.getTablero(), red, blue);
                

                } else {
                    //Azul
                    this.getTablero().getTablero()[PosicionI][PosicionJ] = blue;
                    this.getJugadorActual().setCubos(this.getJugadorActual().getCubos()-1);
                    
                    this.getVt().getBotones()[PosicionI][PosicionJ].setBackground(new Color(204,204,255));
                    this.getVt().getBotones()[PosicionI][PosicionJ].setText("A");
                     formaEsquina(this.getJugadorActual(), PosicionJ, PosicionI, red, blue);
                alargoEsquina(PosicionI, PosicionJ, this.getJugadorActual(), this.getTablero(), red, blue);
                
                }
                
            }
                

            
           
                this.getMensajes().jugoEn(jugada, this.getJugadorActual());

            
           
               

            

        } else {
            this.ponePc(this.getJugador1().getUltimaPosicionI(), this.getJugador1().getUltimaPosicionJ(), this.getTablero(), red, blue, primeraJugada);
             this.setJugadorActual(this.getJugador1());
        }

        if (this.getJugadorActual().equals(this.getJugador1() ) && Podes ) {
            this.setJugadorActual(this.getJugador2());
        } else if (this.getJugadorActual().equals(this.getJugador2()) && Podes) {

            this.setJugadorActual(this.getJugador1());
        }
    }

    private String numeroALetra(int i, boolean paraAbajo, boolean paraArriba) {
        String letra = "";
        if (paraAbajo) {
            i += 1;
        } else if (paraArriba) {
            i -= 1;
        }

        switch (i) {
            case 0:
                letra = "A";
                break;
            case 1:
                letra = "B";
                break;
            case 2:
                letra = "C";
                break;
            case 3:
                letra = "D";
                break;
            case 4:
                letra = "E";
                break;
            case 5:
                letra = "F";
        }
        return letra;
    }

    private int cuentaAlargoEsquina(int i, int j, Jugador jugadorActual, Tablero tab, String red, String blue) {
        String reset = "\u001B[0m";
        String letra = "";
        int alargadas = 0;
        boolean meVoy = false;
        String cincoRojo = "\u001B[31m5\u001B[0m";
        String cincoAzul = "\033[34m5\u001B[0m";
        String[] fila = tab.getTablero()[i];
        int contador = 0;

        for (int k = (j+1); k < fila.length; k++) {
            if (fila[k].endsWith(reset)) {
                contador++;
            } else {
                contador = 0;
                meVoy = true;
            }
            if (i == 0) {
                if ((!meVoy) && (contador > 2 && fila[k].endsWith(reset)) && (!fila[k].equals(cincoRojo) && !fila[k].equals(cincoAzul)) && (this.getTablero().getTablero()[i + 1][k].endsWith(reset))) {
                    alargadas++;
                }
            } else if (i < 5 && i > 0) {
                if ((!meVoy) && (contador > 2 && fila[k].endsWith(reset)) && (!fila[k].equals(cincoRojo) && !fila[k].equals(cincoAzul)) && (this.getTablero().getTablero()[i + 1][k].endsWith(reset) || this.getTablero().getTablero()[i - 1][k].endsWith(reset))) {
                    alargadas++;
                }
            } else if (i == 5) {
                if ((!meVoy) && (contador > 2 && fila[k].endsWith(reset)) && (!fila[k].equals(cincoRojo) && !fila[k].equals(cincoAzul)) && (this.getTablero().getTablero()[i - 1][k].endsWith(reset))) {
                    alargadas++;
                }
            }
        }
        contador = 0;
        meVoy = false;
        for (int k = (j-1); k >= 0; k--) {
            if (fila[k].endsWith(reset)) {
                contador++;
            } else {
                contador = 0;
                meVoy = true;
            }
            if (i == 0) {
                if ((!meVoy) && (contador > 2 && fila[k].endsWith(reset)) && (!fila[k].equals(cincoRojo) && !fila[k].equals(cincoAzul)) && (this.getTablero().getTablero()[i + 1][k].endsWith(reset))) {
                    alargadas++;
                }
            } else if (i > 0 && i < 5) {
                if ((!meVoy) && (contador > 2 && fila[k].endsWith(reset)) && (!fila[k].equals(cincoRojo) && !fila[k].equals(cincoAzul)) && (this.getTablero().getTablero()[i + 1][k].endsWith(reset) || this.getTablero().getTablero()[i - 1][k].endsWith(reset))) {
                    alargadas++;
                }
            } else if (i == 5) {
                if ((!meVoy) && (contador > 2 && fila[k].endsWith(reset)) && (!fila[k].equals(cincoRojo) && !fila[k].equals(cincoAzul)) && (this.getTablero().getTablero()[i - 1][k].endsWith(reset))) {
                    alargadas++;
                }
            }
        }
        contador = 0;
        meVoy = false;

        for (int k = (i+1); k < this.getTablero().getTablero().length; k++) {
            if (this.getTablero().getTablero()[k][j].endsWith(reset)) {
                contador++;
            } else {
                contador = 0;
                meVoy = true;
            }

            if (j > 0 & j < 5) {
                if ((!meVoy) && (contador > 2 && this.getTablero().getTablero()[k][j].endsWith(reset)) && (!this.getTablero().getTablero()[k][j].equals(cincoRojo) && !this.getTablero().getTablero()[k][j].equals(cincoAzul)) && (this.getTablero().getTablero()[k][j + 1].endsWith(reset) || this.getTablero().getTablero()[k][j - 1].endsWith(reset))) {
                    alargadas++;
                }
            } else if (j == 0) {
                if ((!meVoy) && (contador > 2 && this.getTablero().getTablero()[k][j].endsWith(reset)) && (!this.getTablero().getTablero()[k][j].equals(cincoRojo) && !this.getTablero().getTablero()[k][j].equals(cincoAzul)) && (this.getTablero().getTablero()[k][j + 1].endsWith(reset))) {
                    alargadas++;
                }
            } else if (j == 5) {
                if ((!meVoy) && (contador > 2 && this.getTablero().getTablero()[k][j].endsWith(reset)) && (!this.getTablero().getTablero()[k][j].equals(cincoRojo) && !this.getTablero().getTablero()[k][j].equals(cincoAzul)) && (this.getTablero().getTablero()[k][j - 1].endsWith(reset))) {
                    alargadas++;
                }
            }

        }
        contador = 0;
        meVoy = false;
        for (int k = (i-1); k >= 0; k--) {

            if (this.getTablero().getTablero()[k][j].endsWith(reset)) {
                contador++;
            } else {
                contador = 0;
                meVoy = true;
            }
            if (j > 0 && j < 5) {
                if ((!meVoy) && (contador > 2 && this.getTablero().getTablero()[k][j].endsWith(reset)) && (!this.getTablero().getTablero()[k][j].equals(cincoRojo) && !this.getTablero().getTablero()[k][j].equals(cincoAzul)) && (this.getTablero().getTablero()[k][j + 1].endsWith(reset) || this.getTablero().getTablero()[k][j - 1].endsWith(reset))) {
                    alargadas++;

                }

            } else if (j == 0) {
                if ((!meVoy) && (contador > 2 && this.getTablero().getTablero()[k][j].endsWith(reset)) && (!this.getTablero().getTablero()[k][j].equals(cincoRojo) && !this.getTablero().getTablero()[k][j].equals(cincoAzul)) && (this.getTablero().getTablero()[k][j + 1].endsWith(reset))) {
                    alargadas++;

                }

            } else if (j == 5) {
                if ((!meVoy) && (contador > 2 && this.getTablero().getTablero()[k][j].endsWith(reset)) && (!this.getTablero().getTablero()[k][j].equals(cincoRojo) && !this.getTablero().getTablero()[k][j].equals(cincoAzul)) && (this.getTablero().getTablero()[k][j - 1].endsWith(reset))) {
                    alargadas++;

                }

            }

        }
        return alargadas;

    }

    private void alargoEsquina(int i, int j, Jugador jugadorActual, Tablero tab, String red, String blue) {
        ArrayList<String> dondeAlargo = new ArrayList<>();
        String reset = "\u001B[0m";
        String letra = "";
        boolean meVoy = false;
        String cincoRojo = "\u001B[31m5\u001B[0m";
        String cincoAzul = "\033[34m5\u001B[0m";
        String[] fila = tab.getTablero()[i];
        int contador = 0;
if(this.getJugadorActual().getCubos() > 0){
    for (int k = j; k < fila.length; k++) {
            if (fila[k].endsWith(reset)) {
                contador++;
            } else {
                contador = 0;
                meVoy = true;
            }
            if (i == 0) {
                if ((!meVoy) && (contador > 2 && fila[k].endsWith(reset)) && (!fila[k].equals(cincoRojo) && !fila[k].equals(cincoAzul)) && (this.getTablero().getTablero()[i + 1][k].endsWith(reset))) {
                    numeroColor(red, blue, i, k, this.getJugadorActual());
                    letra = numeroALetra(i, false, false);
                    this.getMensajes().alargoEsquinaEn(this.getJugadorActual().getAlias(),dondeAlargo,letra, k);
                }

            } else if (i < 5 && i > 0) {
                if ((!meVoy) && (contador > 2 && fila[k].endsWith(reset)) && (!fila[k].equals(cincoRojo) && !fila[k].equals(cincoAzul)) && (this.getTablero().getTablero()[i + 1][k].endsWith(reset) || this.getTablero().getTablero()[i - 1][k].endsWith(reset))) {
                    numeroColor(red, blue, i, k, this.getJugadorActual());
                    letra = numeroALetra(i, false, false);
                    this.getMensajes().alargoEsquinaEn(this.getJugadorActual().getAlias(),dondeAlargo,letra, k);

                }

            } else if (i == 5) {
                if ((!meVoy) && (contador > 2 && fila[k].endsWith(reset)) && (!fila[k].equals(cincoRojo) && !fila[k].equals(cincoAzul)) && (this.getTablero().getTablero()[i - 1][k].endsWith(reset))) {
                    numeroColor(red, blue, i, k, this.getJugadorActual());
                    letra = numeroALetra(i, false, false);
                    this.getMensajes().alargoEsquinaEn(this.getJugadorActual().getAlias(),dondeAlargo,letra, k);
                }
            }
        }
        contador = 0;
        meVoy = false;
        for (int k = j; k >= 0; k--) {
            if (fila[k].endsWith(reset)) {
                contador++;
            } else {
                contador = 0;
                meVoy = true;
            }
            if (i == 0) {
                if ((!meVoy) && (contador > 2 && fila[k].endsWith(reset)) && (!fila[k].equals(cincoRojo) && !fila[k].equals(cincoAzul)) && (this.getTablero().getTablero()[i + 1][k].endsWith(reset))) {
                    numeroColor(red, blue, i, k, this.getJugadorActual());
                    letra = numeroALetra(i, false, false);
                    this.getMensajes().alargoEsquinaEn(this.getJugadorActual().getAlias(),dondeAlargo,letra, k);

                }

            } else if (i > 0 && i < 5) {
                if ((!meVoy) && (contador > 2 && fila[k].endsWith(reset)) && (!fila[k].equals(cincoRojo) && !fila[k].equals(cincoAzul)) && (this.getTablero().getTablero()[i + 1][k].endsWith(reset) || this.getTablero().getTablero()[i - 1][k].endsWith(reset))) {
                    numeroColor(red, blue, i, k, this.getJugadorActual());
                    letra = numeroALetra(i, false, false);
                    this.getMensajes().alargoEsquinaEn(this.getJugadorActual().getAlias(),dondeAlargo,letra, k);
                }

            } else if (i == 5) {
                if ((!meVoy) && (contador > 2 && fila[k].endsWith(reset)) && (!fila[k].equals(cincoRojo) && !fila[k].equals(cincoAzul)) && (this.getTablero().getTablero()[i - 1][k].endsWith(reset))) {
                    numeroColor(red, blue, i, k, this.getJugadorActual());
                    letra = numeroALetra(i, false, false);
                    this.getMensajes().alargoEsquinaEn(this.getJugadorActual().getAlias(),dondeAlargo,letra, k);
                }

            }

        }
        contador = 0;
        meVoy = false;

        for (int k = i; k < this.getTablero().getTablero().length; k++) {
            if (this.getTablero().getTablero()[k][j].endsWith(reset)) {
                contador++;
            } else {
                contador = 0;
                meVoy = true;
            }

            if (j > 0 & j < 5) {
                if ((!meVoy) && (contador > 2 && this.getTablero().getTablero()[k][j].endsWith(reset)) && (!this.getTablero().getTablero()[k][j].equals(cincoRojo) && !this.getTablero().getTablero()[k][j].equals(cincoAzul)) && (this.getTablero().getTablero()[k][j + 1].endsWith(reset) || this.getTablero().getTablero()[k][j - 1].endsWith(reset))) {
                    numeroColor(red, blue, k, j, this.getJugadorActual());
                    letra = numeroALetra(k, false, false);
                    this.getMensajes().alargoEsquinaEn(this.getJugadorActual().getAlias(),dondeAlargo,letra, j);

                }

            } else if (j == 0) {
                if ((!meVoy) && (contador > 2 && this.getTablero().getTablero()[k][j].endsWith(reset)) && (!this.getTablero().getTablero()[k][j].equals(cincoRojo) && !this.getTablero().getTablero()[k][j].equals(cincoAzul)) && (this.getTablero().getTablero()[k][j + 1].endsWith(reset))) {
                    numeroColor(red, blue, k, j, this.getJugadorActual());
                    letra = numeroALetra(k, false, false);
                    this.getMensajes().alargoEsquinaEn(this.getJugadorActual().getAlias(),dondeAlargo,letra, j);

                }
            } else if (j == 5) {
                if ((!meVoy) && (contador > 2 && this.getTablero().getTablero()[k][j].endsWith(reset)) && (!this.getTablero().getTablero()[k][j].equals(cincoRojo) && !this.getTablero().getTablero()[k][j].equals(cincoAzul)) && (this.getTablero().getTablero()[k][j - 1].endsWith(reset))) {
                    numeroColor(red, blue, k, j, this.getJugadorActual());
                    letra = numeroALetra(k, false, false);
                    this.getMensajes().alargoEsquinaEn(this.getJugadorActual().getAlias(),dondeAlargo,letra, j);

                }
            }

        }
        contador = 0;
        meVoy = false;
        for (int k = i; k >= 0; k--) {

            if (this.getTablero().getTablero()[k][j].endsWith(reset)) {
                contador++;
            } else {
                contador = 0;
                meVoy = true;
            }
            if (j > 0 && j < 5) {
                if ((!meVoy) && (contador > 2 && this.getTablero().getTablero()[k][j].endsWith(reset)) && (!this.getTablero().getTablero()[k][j].equals(cincoRojo) && !this.getTablero().getTablero()[k][j].equals(cincoAzul)) && (this.getTablero().getTablero()[k][j + 1].endsWith(reset) || this.getTablero().getTablero()[k][j - 1].endsWith(reset))) {
                    numeroColor(red, blue, k, j, this.getJugadorActual());
                    letra = numeroALetra(k, false, false);
                    this.getMensajes().alargoEsquinaEn(this.getJugadorActual().getAlias(),dondeAlargo,letra, j);

                }

            } else if (j == 0) {
                if ((!meVoy) && (contador > 2 && this.getTablero().getTablero()[k][j].endsWith(reset)) && (!this.getTablero().getTablero()[k][j].equals(cincoRojo) && !this.getTablero().getTablero()[k][j].equals(cincoAzul)) && (this.getTablero().getTablero()[k][j + 1].endsWith(reset))) {
                    numeroColor(red, blue, k, j, this.getJugadorActual());
                    letra = numeroALetra(k, false, false);
                    this.getMensajes().alargoEsquinaEn(this.getJugadorActual().getAlias(),dondeAlargo,letra, j);

                }

            } else if (j == 5) {
                if ((!meVoy) && (contador > 2 && this.getTablero().getTablero()[k][j].endsWith(reset)) && (!this.getTablero().getTablero()[k][j].equals(cincoRojo) && !this.getTablero().getTablero()[k][j].equals(cincoAzul)) && (this.getTablero().getTablero()[k][j - 1].endsWith(reset))) {
                    numeroColor(red, blue, k, j, this.getJugadorActual());
                    letra = numeroALetra(k, false, false);
                    this.getMensajes().alargoEsquinaEn(this.getJugadorActual().getAlias(),dondeAlargo,letra, j);
                }
            }
        }
    
}

if(!this.getJugadorActual().isHumano()){
    this.getVt().getAvisaPc().setListData(dondeAlargo.toArray());
}else{
    this.getVt().getAvisaAlargo().setListData(dondeAlargo.toArray());
}
        
    }

    public void calcularPuntaje(Tablero tab) {
        int puntajeJugador1 = 0;
        int puntajeJugador2 = 0;
        String Dosrojo = "\u001B[31m2\u001B[0m";
        String Dosazul = "\033[34m2\u001B[0m";
        String TresRojo = "\u001B[31m3\u001B[0m";
        String TresAzul = "\033[34m3\u001B[0m";
        String CuatroRojo = "\u001B[31m4\u001B[0m";
        String CuatroAzul = "\033[34m4\u001B[0m";
        String CincoRojo = "\u001B[31m5\u001B[0m";
        String CincoAzul = "\033[34m5\u001B[0m";
        for (int i = 0; i < tab.getTablero().length; i++) {
            for (int j = 0; j < tab.getTablero()[0].length; j++) {
                switch (tab.getTablero()[i][j]) {
                    // Puntaje del Rojo
                    case "\u001B[31m2\u001B[0m":
                        puntajeJugador1 += 2;
                        break;
                    case "\u001B[31m3\u001B[0m":
                        puntajeJugador1 += 3;
                        break;
                    case "\u001B[31m4\u001B[0m":
                        puntajeJugador1 += 4;
                        break;
                    case "\u001B[31m5\u001B[0m":
                        puntajeJugador1 += 5;
                        break;
                    // Fin puntaje del rojo.
                    // Puntaje del azul.
                    case "\033[34m2\u001B[0m":
                        puntajeJugador2 += 2;
                        break;
                    case "\033[34m3\u001B[0m":
                        puntajeJugador2 += 3;
                        break;
                    case "\033[34m4\u001B[0m":
                        puntajeJugador2 += 4;
                        break;
                    case "\033[34m5\u001B[0m":
                        puntajeJugador2 += 5;
                        break;
                    // Fin puntaje azul.
                }
            }
        }
        puntajeJugador1 -= this.getJugador1().getCubos();
        puntajeJugador2 -= this.getJugador2().getCubos();
        this.getJugador1().setPuntaje(puntajeJugador1);
        this.getJugador2().setPuntaje(puntajeJugador2);

    }
     public int calculaFichas(Tablero tab, int fila) {
        int puntajeJugador1 = 0;
        int puntajeJugador2 = 0;
        
        String Dosrojo = "\u001B[31m2\u001B[0m";
        String Dosazul = "\033[34m2\u001B[0m";
        String TresRojo = "\u001B[31m3\u001B[0m";
        String TresAzul = "\033[34m3\u001B[0m";
        String CuatroRojo = "\u001B[31m4\u001B[0m";
        String CuatroAzul = "\033[34m4\u001B[0m";
        String CincoRojo = "\u001B[31m5\u001B[0m";
        String CincoAzul = "\033[34m5\u001B[0m";
        for (int i = 0; i < tab.getTablero().length; i++) {
            
                switch (tab.getTablero()[fila][i]) {
                    // Puntaje del Rojo
                    case "\u001B[31mR\u001B[0m" :
                        puntajeJugador1 ++;
                        break;
                    case "\u001B[31m2\u001B[0m":
                        puntajeJugador1 += 2;
                        break;
                    case "\u001B[31m3\u001B[0m":
                        puntajeJugador1 += 3;
                        break;
                    case "\u001B[31m4\u001B[0m":
                        puntajeJugador1 += 4;
                        break;
                    case "\u001B[31m5\u001B[0m":
                        puntajeJugador1 += 5;
                        break;
                    // Fin puntaje del rojo.
                    // Puntaje del azul.
                    case "\033[34mA\u001B[0m":
                        puntajeJugador2++;
                        break;
                    case "\033[34m2\u001B[0m":
                        puntajeJugador2 += 2;
                        break;
                    case "\033[34m3\u001B[0m":
                        puntajeJugador2 += 3;
                        break;
                    case "\033[34m4\u001B[0m":
                        puntajeJugador2 += 4;
                        break;
                    case "\033[34m5\u001B[0m":
                        puntajeJugador2 += 5;
                        break;
                    // Fin puntaje azul.
                
            }
        }
  
        int total = puntajeJugador1+puntajeJugador2;
        return total;
    }

    public VentanaTablero getVt() {
        return vt;
    }

    public void setVt(VentanaTablero vt) {
        this.vt = vt;
    }

    private void numeroColor(String red, String blue, int i, int c, Jugador j) {
        String Dosrojo = "\u001B[31m2\u001B[0m";
        String Dosazul = "\033[34m2\u001B[0m";
        String TresRojo = "\u001B[31m3\u001B[0m";
        String TresAzul = "\033[34m3\u001B[0m";
        String CuatroRojo = "\u001B[31m4\u001B[0m";
        String CuatroAzul = "\033[34m4\u001B[0m";
        String CincoRojo = "\u001B[31m5\u001B[0m";
        String CincoAzul = "\033[34m5\u001B[0m";
            if(this.getJugadorActual().getCubos() > 0){
                if ((this.getTablero().getTablero()[i][c].equals(red) || this.getTablero().getTablero()[i][c].equals(blue)) && (this.getJugadorActual().getCubos() > 0)) {
            if (this.getJugadorActual().equals(this.getJugador1())) {
                this.getTablero().getTablero()[i][c] = Dosrojo;

                this.getVt().getBotones()[i][c].setForeground(new Color(255,102,102));
                this.getVt().getBotones()[i][c].setText("2");
                this.getVt().getBotones()[i][c].repaint();


                j.setCubos(j.getCubos() - 1);
                 

            } else {
                this.getTablero().getTablero()[i][c] = Dosazul;
                this.getVt().getBotones()[i][c].setForeground(new Color (153,153,255));
                this.getVt().getBotones()[i][c].setText("2");
                this.getVt().getBotones()[i][c].revalidate();
                this.getVt().getBotones()[i][c].repaint();
                j.setCubos(j.getCubos() - 1);
                 

            }
        } else if ((this.getTablero().getTablero()[i][c].equals(Dosrojo) || this.getTablero().getTablero()[i][c].equals(Dosazul)) && (this.getJugadorActual().getCubos() > 0)) {
            if (this.getJugadorActual().equals(this.getJugador1())) {
                this.getTablero().getTablero()[i][c] = TresRojo;
                this.getVt().getBotones()[i][c].setForeground(new Color(255,102,102));
                this.getVt().getBotones()[i][c].setText("3");
                this.getVt().getBotones()[i][c].revalidate();
                this.getVt().getBotones()[i][c].repaint();
                j.setCubos(j.getCubos() - 1);
                 
            } else {
                this.getTablero().getTablero()[i][c] = TresAzul;
                this.getVt().getBotones()[i][c].setForeground(new Color (102,102,255));
                this.getVt().getBotones()[i][c].setText("3");
                this.getVt().getBotones()[i][c].revalidate();
                this.getVt().getBotones()[i][c].repaint();
                j.setCubos(j.getCubos() - 1);
                 
            }

        } else if ((this.getTablero().getTablero()[i][c].equals(TresRojo) || this.getTablero().getTablero()[i][c].equals(TresAzul)) && (this.getJugadorActual().getCubos() > 0)) {
            if (this.getJugadorActual().equals(this.getJugador1())) {
                this.getTablero().getTablero()[i][c] = CuatroRojo;
                this.getVt().getBotones()[i][c].setForeground(new Color(204,0,0));
                this.getVt().getBotones()[i][c].setText("4");
                this.getVt().getBotones()[i][c].revalidate();
                this.getVt().getBotones()[i][c].repaint();
                j.setCubos(j.getCubos() - 1);
                 
            } else {
                this.getTablero().getTablero()[i][c] = CuatroAzul;
                this.getVt().getBotones()[i][c].setForeground(new Color (0,0,255));
                this.getVt().getBotones()[i][c].setText("4");
                this.getVt().getBotones()[i][c].revalidate();
                this.getVt().getBotones()[i][c].repaint();
                 j.setCubos(j.getCubos() - 1);
                
            }
        } else if ((this.getTablero().getTablero()[i][c].equals(CuatroRojo) || this.getTablero().getTablero()[i][c].equals(CuatroAzul)) && (this.getJugadorActual().getCubos() > 0)) {
            if (this.getJugadorActual().equals(this.getJugador1())) {
                this.getTablero().getTablero()[i][c] = CincoRojo;
                this.getVt().getBotones()[i][c].setForeground(new Color(153,0,0));
                this.getVt().getBotones()[i][c].setText("5");
                this.getVt().getBotones()[i][c].revalidate();
                this.getVt().getBotones()[i][c].repaint();
                j.setCubos(j.getCubos() - 1);
                
            } else {
                this.getTablero().getTablero()[i][c] = CincoAzul;
                this.getVt().getBotones()[i][c].setForeground(new Color(0,0,102));
                this.getVt().getBotones()[i][c].setText("5");
                this.getVt().getBotones()[i][c].revalidate();
                this.getVt().getBotones()[i][c].repaint();
                j.setCubos(j.getCubos() - 1);
                            }
        } else if (this.getTablero().getTablero()[i][c].equals(CincoRojo) || this.getTablero().getTablero()[i][c].equals(CincoAzul)) {
            this.getMensajes().esquinaSinGracia(this.getVt());
        }

                
            }
        
    }

    private void formaEsquina(Jugador j, int c, int i, String red, String blue) {
        String[][] tab = this.getTablero().getTablero();
        String reset = "\u001B[0m";
        String letra = "";
        ArrayList<String> esquinasFormadas = new ArrayList<>(); 
        // Para ver si forma esquina hacia la derecha para abajo.
        if(this.getJugadorActual().getCubos() > 0){
            if ((c > 0 && c < 5) && (i < 5 && i > 0)) {
            if ((tab[i][c + 1].endsWith(reset)) && (tab[i + 1][c + 1].endsWith(reset))) {
                int columna = (c + 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            }//Para ver si forma esquina para abajo a la derecha pero viendo desde la columna.
            if ((tab[i + 1][c].endsWith(reset)) && (tab[i + 1][c + 1].endsWith(reset))) {
                int fila = (i + 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, true, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            } // Para ver si se forma esquina para abajo a la izquierda respecto de la fila .
            if ((tab[i][c - 1].endsWith(reset)) && (tab[i + 1][c - 1].endsWith(reset))) {
                int columna = (c - 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);

            } // Para ver si forma esquina abajo a la izquierda respecto de columna.
            if ((tab[i + 1][c].endsWith(reset)) && (tab[i + 1][c - 1].endsWith(reset))) {
                int fila = (i + 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, true, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            } // Para ver si forma esquina arriba a la derecha con respecto a la columna.
            if ((tab[i - 1][c].endsWith(reset)) && (tab[i - 1][c + 1].endsWith(reset))) {
                int fila = (i - 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, false, true);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            } // Para ver si forma essquina arriba a la derecha con respecto a fila.
            if ((tab[i][c + 1].endsWith(reset)) && (tab[i - 1][c + 1].endsWith(reset))) {
                int columna = (c + 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            } // Para ver si forma esquina arriba a la izquierda respecto de columna.
            if ((tab[i - 1][c].endsWith(reset)) && (tab[i - 1][c - 1].endsWith(reset))) {
                int fila = (i - 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, false, true);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            } // Para ver si se forma esquina arriba a la izquierda co respecto a la fila.
            if ((tab[i][c - 1].endsWith(reset)) && (tab[i - 1][c - 1].endsWith(reset))) {
                int columna = (c - 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            }  // PAra ver si forma esquina porque mi ficha esta rodeada por dos fichas.
            if ((tab[i - 1][c].endsWith(reset) && tab[i][c + 1].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            if ((tab[i - 1][c].endsWith(reset) && tab[i][c - 1].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);

            }
            if ((tab[i][c + 1].endsWith(reset) && tab[i + 1][c].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i + 1][c].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            // Termina para ver fichas rodeadas .
        } else if (i == 0 && (c > 0 && c < 5)) {
            // Abajo a la iquiera respecto columna.
            if ((tab[i][c - 1].endsWith(reset) && tab[i + 1][c - 1].endsWith(reset))) {
                int columna = (c - 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            }
            // Abajo a la derecha ,columna.
            if (tab[i][c + 1].endsWith(reset) && tab[i + 1][c + 1].endsWith(reset)) {
                int columna = (c + 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            } // abajo derecha. columna
            if ((tab[i + 1][c].endsWith(reset) && tab[i + 1][c + 1].endsWith(reset))) {
                int fila = (i + 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, true, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            } // abajo izquierda columna
            if ((tab[i + 1][c].endsWith(reset) && tab[i + 1][c - 1].endsWith(reset))) {
                int fila = (i + 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, true, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            } // Si la ficha puesta esta rodeada.
            if ((tab[i][c + 1].endsWith(reset) && tab[i + 1][c].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i + 1][c].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
        } // para la columna de la izquierda.
        else if (c == 0 && (i < 5 && i > 0)) {
            // Para esquina hacia la drecha para abajo fila.
            if ((tab[i][c + 1].endsWith(reset) && tab[i + 1][c + 1].endsWith(reset))) {
                int columna = (c + 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            }
            if ((tab[i][c + 1].endsWith(reset) && tab[i - 1][c + 1].endsWith(reset))) {
                int columna = (c + 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            }
            if ((tab[i + 1][c].endsWith(reset) && tab[i + 1][c + 1].endsWith(reset))) {
                int fila = (i + 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, true, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            if ((tab[i - 1][c].endsWith(reset) && tab[i - 1][c + 1].endsWith(reset))) {
                int fila = (i - 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, false, true);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            // para ficha rodeada desde arriba y costado derecho.
            if ((tab[i - 1][c].endsWith(reset) && tab[i][c + 1].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);

            }
            // PAra ficha rodeada desde abajo y el costado derecho
            if ((tab[i + 1][c].endsWith(reset) && tab[i][c + 1].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
        }// para  la fila de abajo del todo.
        else if (i == 5 && (c < 5 && c > 0)) {
            // ficha rodeada por otras.
            if ((tab[i - 1][c].endsWith(reset) && tab[i][c + 1].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i - 1][c].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
            }
            // fin ficha rodeada.
            if ((tab[i - 1][c - 1].endsWith(reset) && tab[i - 1][c].endsWith(reset))) {
                int fila = (i - 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, false, true);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            if ((tab[i - 1][c].endsWith(reset) && tab[i - 1][c + 1].endsWith(reset))) {
                int fila = (i - 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, false, true);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            if ((tab[i][c + 1].endsWith(reset) && tab[i - 1][c + 1].endsWith(reset))) {
                int columna = (c + 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i - 1][c - 1].endsWith(reset))) {
                int columna = (c - 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            }
        } // para la columna a la derecha del todo.
        else if (c == 5 && (i > 0 && i < 5)) {
            if ((tab[i][c - 1].endsWith(reset) && (tab[i - 1][c].endsWith(reset)))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }// Con respecto a columna.
            if ((tab[i + 1][c].endsWith(reset)) && (tab[i][c - 1].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);

            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i - 1][c - 1].endsWith(reset))) {
                int columna = (c - 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            }// Con respecto a columna.
            if ((tab[i][c - 1].endsWith(reset) && tab[i + 1][c - 1].endsWith(reset))) {
                int columna = (c - 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            } // fila.
            if ((tab[i + 1][c].endsWith(reset) && tab[i + 1][c - 1].endsWith(reset))) {
                int fila = (i + 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, true, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            } // fila.
            if ((tab[i - 1][c].endsWith(reset) && tab[i - 1][c - 1].endsWith(reset))) {
                int fila = (i - 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, false, true);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
        } // Esquina en posicion [0][0].
        else if (i == 0 && c == 0) {
            if ((tab[i][c + 1].endsWith(reset) && tab[i + 1][c + 1].endsWith(reset))) {
                int columna = (c + 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            }
            if ((tab[i + 1][c].endsWith(reset) && tab[i + 1][c + 1].endsWith(reset))) {
                int fila = (i + 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, true, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            if ((tab[i + 1][c].endsWith(reset) && tab[i][c + 1].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
        } // El caso que forme esquina en la esquina inferior izuierda de la matriz.
        else if (i == 5 && c == 0) {
            if ((tab[i - 1][c].endsWith(reset) && tab[i - 1][c + 1].endsWith(reset))) {
                int fila = (i - 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, false, true);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            if ((tab[i][c + 1].endsWith(reset) && tab[i - 1][c + 1].endsWith(reset))) {
                int columna = (c + 1);
                letra = numeroALetra(i, false, false);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            if ((tab[i - 1][c].endsWith(reset) && tab[i][c + 1].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
        } // para la esquina inferior a la derecha de la matriz.
        else if (i == 5 && c == 5) {
            if ((tab[i - 1][c].endsWith(reset) && tab[i - 1][c - 1].endsWith(reset))) {
                int fila = (i - 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, false, true);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i - 1][c - 1].endsWith(reset))) {
                int columna = (c - 1);
                letra = numeroALetra(i, false, false);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            }
            if ((tab[i - 1][c].endsWith(reset) && tab[i][c - 1].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
        } // Para la esquina de arriba del todo a al a derecha del todo de la matriz Posicion[0][5]
        else if (i == 0 && c == 5) {
            if ((tab[i][c - 1].endsWith(reset) && tab[i + 1][c - 1].endsWith(reset))) {
                int columna = (c - 1);
                numeroColor(red, blue, i, columna, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, columna,esquinasFormadas);
            }
            if ((tab[i + 1][c].endsWith(reset) && tab[i + 1][c - 1].endsWith(reset))) {
                int fila = (i + 1);
                numeroColor(red, blue, fila, c, this.getJugadorActual());
                letra = numeroALetra(i, true, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c,esquinasFormadas);
            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i + 1][c].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
                letra = numeroALetra(i, false, false);
                this.getMensajes().formoEsquina(this.getJugadorActual().getAlias(),letra, c , esquinasFormadas);
            }

        }
            
        }
        if(!this.getJugadorActual().isHumano()){
            this.getVt().getAvisaPCesquina().setListData(esquinasFormadas.toArray());
        }else{
             this.getVt().getAvisa().setListData(esquinasFormadas.toArray());
        }
       

    }

    private int cuentaEsquina(Jugador j, int c, int i, String red, String blue) {
        String[][] tab = this.getTablero().getTablero();
        String reset = "\u001B[0m";
        int contador = 0;
        // Para ver si forma esquina hacia la derecha para abajo.
        if ((c > 0 && c < 5) && (i < 5 && i > 0)) {
            if ((tab[i][c + 1].endsWith(reset)) && (tab[i + 1][c + 1].endsWith(reset))) {
                contador++;
            }//Para ver si forma esquina para abajo a la derecha pero viendo desde la columna.
            if ((tab[i + 1][c].endsWith(reset)) && (tab[i + 1][c + 1].endsWith(reset))) {
                contador++;
            } // Para ver si se forma esquina para abajo a la izquierda respecto de la fila .
            if ((tab[i][c - 1].endsWith(reset)) && (tab[i + 1][c - 1].endsWith(reset))) {
                contador++;

            } // Para ver si forma esquina abajo a la izquierda respecto de columna.
            if ((tab[i + 1][c].endsWith(reset)) && (tab[i + 1][c - 1].endsWith(reset))) {
                contador++;
            } // Para ver si forma esquina arriba a la derecha con respecto a la columna.
            if ((tab[i - 1][c].endsWith(reset)) && (tab[i - 1][c + 1].endsWith(reset))) {
                contador++;
            } // Para ver si forma essquina arriba a la derecha con respecto a fila.
            if ((tab[i][c + 1].endsWith(reset)) && (tab[i - 1][c + 1].endsWith(reset))) {
                contador++;
            } // Para ver si forma esquina arriba a la izquierda respecto de columna.
            if ((tab[i - 1][c].endsWith(reset)) && (tab[i - 1][c - 1].endsWith(reset))) {
                contador++;
            } // Para ver si se forma esquina arriba a la izquierda co respecto a la fila.
            if ((tab[i][c - 1].endsWith(reset)) && (tab[i - 1][c - 1].endsWith(reset))) {
                contador++;
            }  // PAra ver si forma esquina porque mi ficha esta rodeada por dos fichas.
            if ((tab[i - 1][c].endsWith(reset) && tab[i][c + 1].endsWith(reset))) {
                contador++;
            }
            if ((tab[i - 1][c].endsWith(reset) && tab[i][c - 1].endsWith(reset))) {
                contador++;

            }
            if ((tab[i][c + 1].endsWith(reset) && tab[i + 1][c].endsWith(reset))) {
                contador++;
            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i + 1][c].endsWith(reset))) {
                contador++;
            }
            // Termina para ver fichas rodeadas .
        } else if (i == 0 && (c > 0 && c < 5)) {
            // Abajo a la iquiera respecto columna.
            if ((tab[i][c - 1].endsWith(reset) && tab[i + 1][c - 1].endsWith(reset))) {
                contador++;
            }
            // Abajo a la derecha ,columna.
            if (tab[i][c + 1].endsWith(reset) && tab[i + 1][c + 1].endsWith(reset)) {
                contador++;
            } // abajo derecha. columna
            if ((tab[i + 1][c].endsWith(reset) && tab[i + 1][c + 1].endsWith(reset))) {
                contador++;
            } // abajo izquierda columna
            if ((tab[i + 1][c].endsWith(reset) && tab[i + 1][c - 1].endsWith(reset))) {
                contador++;
            } // Si la ficha puesta esta rodeada.
            if ((tab[i][c + 1].endsWith(reset) && tab[i + 1][c].endsWith(reset))) {
                contador++;
            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i + 1][c].endsWith(reset))) {
                contador++;
            }
        } // para la columna de la izquierda.
        else if (c == 0 && (i < 5 && i > 0)) {
            // Para esquina hacia la drecha para abajo fila.
            if ((tab[i][c + 1].endsWith(reset) && tab[i + 1][c + 1].endsWith(reset))) {
                int columna = (c + 1);
                contador++;
            }
            if ((tab[i][c + 1].endsWith(reset) && tab[i - 1][c + 1].endsWith(reset))) {
                int columna = (c + 1);
                contador++;
            }
            if ((tab[i + 1][c].endsWith(reset) && tab[i + 1][c + 1].endsWith(reset))) {
                int fila = (i + 1);
                contador++;
            }
            if ((tab[i - 1][c].endsWith(reset) && tab[i - 1][c + 1].endsWith(reset))) {
                int fila = (i - 1);
                contador++;
            }
            // para ficha rodeada desde arriba y costado derecho.
            if ((tab[i - 1][c].endsWith(reset) && tab[i][c + 1].endsWith(reset))) {
                contador++;

            }
            // PAra ficha rodeada desde abajo y el costado derecho
            if ((tab[i + 1][c].endsWith(reset) && tab[i][c + 1].endsWith(reset))) {
                contador++;
            }
        }// para  la fila de abajo del todo.
        else if (i == 5 && (c < 5 && c > 0)) {
            // ficha rodeada por otras.
            if ((tab[i - 1][c].endsWith(reset) && tab[i][c + 1].endsWith(reset))) {
                contador++;
            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i - 1][c].endsWith(reset))) {
                numeroColor(red, blue, i, c, this.getJugadorActual());
            }
            // fin ficha rodeada.
            if ((tab[i - 1][c - 1].endsWith(reset) && tab[i - 1][c].endsWith(reset))) {
                contador++;
            }
            if ((tab[i - 1][c].endsWith(reset) && tab[i - 1][c + 1].endsWith(reset))) {
                contador++;
            }
            if ((tab[i][c + 1].endsWith(reset) && tab[i - 1][c + 1].endsWith(reset))) {
                contador++;
            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i - 1][c - 1].endsWith(reset))) {
                contador++;
            }
        } // para la columna a la derecha del todo.
        else if (c == 5 && (i > 0 && i < 5)) {
            if ((tab[i][c - 1].endsWith(reset) && (tab[i - 1][c].endsWith(reset)))) {
                contador++;
            }// Con respecto a columna.
            if ((tab[i + 1][c].endsWith(reset)) && (tab[i][c - 1].endsWith(reset))) {
                contador++;

            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i - 1][c - 1].endsWith(reset))) {
                contador++;
            }// Con respecto a columna.
            if ((tab[i][c - 1].endsWith(reset) && tab[i + 1][c - 1].endsWith(reset))) {
                contador++;
            } // fila.
            if ((tab[i + 1][c].endsWith(reset) && tab[i + 1][c - 1].endsWith(reset))) {
                contador++;
            } // fila.
            if ((tab[i - 1][c].endsWith(reset) && tab[i - 1][c - 1].endsWith(reset))) {
                contador++;
            }
        } // Esquina en posicion [0][0].
        else if (i == 0 && c == 0) {
            if ((tab[i][c + 1].endsWith(reset) && tab[i + 1][c + 1].endsWith(reset))) {
                contador++;
            }
            if ((tab[i + 1][c].endsWith(reset) && tab[i + 1][c + 1].endsWith(reset))) {
                contador++;
            }
            if ((tab[i + 1][c].endsWith(reset) && tab[i][c + 1].endsWith(reset))) {
                contador++;
            }
        } // El caso que forme esquina en la esquina inferior izuierda de la matriz.
        else if (i == 5 && c == 0) {
            if ((tab[i - 1][c].endsWith(reset) && tab[i - 1][c + 1].endsWith(reset))) {
                contador++;
            }
            if ((tab[i][c + 1].endsWith(reset) && tab[i - 1][c + 1].endsWith(reset))) {
                contador++;
            }
            if ((tab[i - 1][c].endsWith(reset) && tab[i][c + 1].endsWith(reset))) {
                contador++;
            }
        } // para la esquina inferior a la derecha de la matriz.
        else if (i == 5 && c == 5) {
            if ((tab[i - 1][c].endsWith(reset) && tab[i - 1][c - 1].endsWith(reset))) {
                contador++;
            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i - 1][c - 1].endsWith(reset))) {
                contador++;
            }
            if ((tab[i - 1][c].endsWith(reset) && tab[i][c - 1].endsWith(reset))) {
                contador++;
            }
        } // Para la esquina de arriba del todo a al a derecha del todo de la matriz Posicion[0][5]
        else if (i == 0 && c == 5) {
            if ((tab[i][c - 1].endsWith(reset) && tab[i + 1][c - 1].endsWith(reset))) {
                contador++;
            }
            if ((tab[i + 1][c].endsWith(reset) && tab[i + 1][c - 1].endsWith(reset))) {
               
                contador++;
            }
            if ((tab[i][c - 1].endsWith(reset) && tab[i + 1][c].endsWith(reset))) {
                contador++;
            }

        }
        return contador;

    }

    private boolean validarPosicion(int i, int j, Tablero tablero, String red, String blue) {
        String reset = "\u001B[0m";

        boolean podes = false;
        // Para posiciones dentro del rango que no se cae.
        if ((j > 0 && j < 5) && (i > 0 && i < 5)) {
            if ((tablero.getTablero()[i][j - 1].endsWith(reset)) || (tablero.getTablero()[i][j + 1].endsWith(reset)) || (tablero.getTablero()[i + 1][j].endsWith(reset)) || (tablero.getTablero()[i + 1][j + 1].endsWith(reset)) || (tablero.getTablero()[i + 1][j - 1].endsWith(reset)) || (tablero.getTablero()[i - 1][j - 1].endsWith(reset)) || (tablero.getTablero()[i - 1][j + 1].endsWith(reset)) || (tablero.getTablero()[i - 1][j].endsWith(reset))) {
                podes = true;

            } else if (this.getJugadorActual().isHumano()) {
                mensajes.posicionInvalidaDos(this.getVt());
            }
        } // lo de abajo es para la fila de mas arriba del todo para que no se salga de rango
        else if (i == 0 && (j > 0 && j < 5)) {
            if ((tablero.getTablero()[i][j - 1].endsWith(reset)) || (tablero.getTablero()[i][j + 1].endsWith(reset)) || (tablero.getTablero()[i + 1][j].endsWith(reset)) || (tablero.getTablero()[i + 1][j + 1].endsWith(reset)) || (tablero.getTablero()[i + 1][j - 1].endsWith(reset))) {
                podes = true;

            } else if (this.getJugadorActual().isHumano()) {
                mensajes.posicionInvalidaDos(this.getVt());
            }

        } // lo de abajo es para el caso de la esquina de arriba a la izquierda , la posicion (0,0).
        else if (i == 0 && j == 0) {
            if ((tablero.getTablero()[i][j + 1].endsWith(reset)) || (tablero.getTablero()[i + 1][j + 1].endsWith(reset)) || (tablero.getTablero()[i + 1][j].endsWith(reset))) {
                podes = true;
            } else if (this.getJugadorActual().isHumano()) {
                mensajes.posicionInvalidaDos(this.getVt());
            }

        }// Esta es para validar la columna de la izquierda del todo , i menor que 5 y mayor que 0 , j = 0.
        else if (j == 0 && (i < 5 && i > 0)) {
            if ((tablero.getTablero()[i][j + 1].endsWith(reset)) || (tablero.getTablero()[i + 1][j].endsWith(reset)) || (tablero.getTablero()[i - 1][j].endsWith(reset)) || (tablero.getTablero()[i + 1][j + 1].endsWith(reset)) || (tablero.getTablero()[i - 1][j + 1].endsWith(reset))) {

                podes = true;
            } else if (this.getJugadorActual().isHumano()) {
                mensajes.posicionInvalidaDos(this.getVt());
            }
        } // para la esquina inferior izquierda
        else if (i == 5 && j == 0) {
            if ((tablero.getTablero()[i][j + 1].endsWith(reset)) || (tablero.getTablero()[i - 1][j + 1].endsWith(reset)) || (tablero.getTablero()[i - 1][j].endsWith(reset))) {
                podes = true;
            } else if (this.getJugadorActual().isHumano()) {
                mensajes.posicionInvalidaDos(this.getVt());
            }

        } // para la fila de abajo del todo de la matriz a partir de j = 1 hasta j = 4 , i = 5 ( constante )
        else if (i == 5 && (j < 5 && j > 0)) {
            if ((tablero.getTablero()[i][j + 1].endsWith(reset)) || (tablero.getTablero()[i][j - 1].endsWith(reset)) || (tablero.getTablero()[i - 1][j + 1].endsWith(reset)) || (tablero.getTablero()[i - 1][j - 1].endsWith(reset)) || (tablero.getTablero()[i - 1][j].endsWith(reset))) {
                podes = true;
            } else if (this.getJugadorActual().isHumano()) {
                mensajes.posicionInvalidaDos(this.getVt());
            }

        }// Para la esquina inferior derecha.
        else if (i == 5 && j == 5) {
            if ((tablero.getTablero()[i][j - 1].endsWith(reset)) || (tablero.getTablero()[i - 1][j].endsWith(reset)) || (tablero.getTablero()[i - 1][j - 1].endsWith(reset))) {
                podes = true;
            } else if (this.getJugadorActual().isHumano()) {
                mensajes.posicionInvalidaDos(this.getVt());
            }

        }// la columna mas contra la derecha.
        else if (j == 5 && (i < 5 && i > 0)) {
            if ((tablero.getTablero()[i - 1][j].endsWith(reset)) || (tablero.getTablero()[i + 1][j].endsWith(reset)) || (tablero.getTablero()[i][j - 1].endsWith(reset)) || (tablero.getTablero()[i - 1][j - 1].endsWith(reset)) || (tablero.getTablero()[i + 1][j - 1].endsWith(reset))) {
                podes = true;

            } else if (this.getJugadorActual().isHumano()) {
                mensajes.posicionInvalidaDos(this.getVt());
            }

        }// la esquina superior derecha.
        else if (i == 0 && j == 5) {
            if ((tablero.getTablero()[i][j - 1].endsWith(reset)) || (tablero.getTablero()[i + 1][j].endsWith(reset)) || (tablero.getTablero()[i + 1][j - 1].endsWith(reset))) {
                podes = true;
            } else if (this.getJugadorActual().isHumano()) {
                mensajes.posicionInvalidaDos(this.getVt());
            }

        }

        return podes;
    }

    private boolean noEsCuadrado(int i, int j, Tablero tablero, String red, String blue) {
        boolean NoEsCuadrado = true;
        String reset = "\u001B[0m";

        // Para validar que no se pueda poner una ficha en un lugar que forme un cubo , teniendo en cuanta que i esta entre 1 y 4 y j tambien.
        if ((i < 5 && i > 0) && (j > 0 && j < 5)) {
            // cuadrado a la izquierda es el primero y anda. ( izquierda para arriba)

            if (((tablero.getTablero()[i - 1][j].endsWith(reset)) && (tablero.getTablero()[i - 1][j - 1].endsWith(reset)) && (tablero.getTablero()[i][j - 1].endsWith(reset)))) {
                NoEsCuadrado = false;
                if (this.getJugadorActual().isHumano()) {
                    mensajes.posicionInvalida(this.getVt());

                }

            }// para ver si forma cuadrado a la Derecha y anda.(derecha para arriba)
            else if ((tablero.getTablero()[i][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i - 1][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i - 1][j].endsWith("\u001B[0m"))) {
                NoEsCuadrado = false;
                if (this.getJugadorActual().isHumano()) {
                    mensajes.posicionInvalida(this.getVt());

                }
            } // para ver si forma cuadrado a la izquierda  y anda[ izquierda para abajo)
            else if ((tablero.getTablero()[i][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j].endsWith("\u001B[0m"))) {
                NoEsCuadrado = false;
                if (this.getJugadorActual().isHumano()) {
                    mensajes.posicionInvalida(this.getVt());

                }
            } // para ver si forma cuadrado a la derecha  anda menos con la fila C , rarisimo. ( derecha para abajo). el ejemplo es C5 , D5 , D4 , C4.
            else if ((tablero.getTablero()[i][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j].endsWith("\u001B[0m"))) {
                NoEsCuadrado = false;
                if (this.getJugadorActual().isHumano()) {
                    mensajes.posicionInvalida(this.getVt());

                }

            }

        }// Para el caso de la esquina superior izquierda.
        else if (i == 0 && j == 0) {
            if ((tablero.getTablero()[i][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j].endsWith("\u001B[0m"))) {
                NoEsCuadrado = false;
                if (this.getJugadorActual().isHumano()) {
                    mensajes.posicionInvalida(this.getVt());

                }
            }
        } // para validar que no se forme un cuadrado , pero suponiendo que la ficha fue puesta en la primera fila.
        else if (i == 0 && (j < 5 && j > 0)) {
            if (((tablero.getTablero()[i][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j].endsWith("\u001B[0m"))) || ((tablero.getTablero()[i][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j].endsWith("\u001B[0m")))) {
                NoEsCuadrado = false;
                if (this.getJugadorActual().isHumano()) {
                    mensajes.posicionInvalida(this.getVt());

                }
            }
        } // para validar que no se forme un cuadrado en la columna 0. Sin que se salga de rango la matriz y se caiga.
        else if (j == 0 && (i > 0 && i < 5)) {
            if (((tablero.getTablero()[i][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i - 1][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i - 1][j].endsWith("\u001B[0m"))) || ((tablero.getTablero()[i][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j].endsWith("\u001B[0m")))) {
                NoEsCuadrado = false;

                if (this.getJugadorActual().isHumano()) {
                    mensajes.posicionInvalida(this.getVt());

                }
            }
        } // para validar que no se forme cuadrado en la esquina inferior izquierda.
        else if (i == 5 && j == 0) {
            if ((tablero.getTablero()[i - 1][j].endsWith("\u001B[0m")) && (tablero.getTablero()[i - 1][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i][j + 1].endsWith("\u001B[0m"))) {
                NoEsCuadrado = false;
                if (this.getJugadorActual().isHumano()) {
                    mensajes.posicionInvalida(this.getVt());

                }
            }
        } // fila de abajo del todo.
        else if (i == 5 && (j < 5 && j > 0)) {
            if (((tablero.getTablero()[i][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i - 1][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i - 1][j].endsWith("\u001B[0m"))) || ((tablero.getTablero()[i][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i - 1][j + 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i - 1][j].endsWith("\u001B[0m")))) {
                NoEsCuadrado = false;
                if (this.getJugadorActual().isHumano()) {
                    mensajes.posicionInvalida(this.getVt());

                }
            }

        } // Para la esquina de abajo a la derecha.
        else if (i == 5 && j == 5) {
            if ((tablero.getTablero()[i][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i - 1][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i - 1][j].endsWith("\u001B[0m"))) {
                NoEsCuadrado = false;
                if (this.getJugadorActual().isHumano()) {
                    mensajes.posicionInvalida(this.getVt());

                }
            }
        } // Para la columna borde de la derecha.
        else if (j == 5 && (i > 0 && i < 5)) {
            if (((tablero.getTablero()[i][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i - 1][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i - 1][j].endsWith("\u001B[0m"))) || ((tablero.getTablero()[i][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j].endsWith("\u001B[0m")))) {
                NoEsCuadrado = false;
                if (this.getJugadorActual().isHumano()) {
                    mensajes.posicionInvalida(this.getVt());
                }
            }
        } // para la esquina de arriba a la derecha.
        else if (i == 0 && j == 5) {
            if ((tablero.getTablero()[i][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j - 1].endsWith("\u001B[0m")) && (tablero.getTablero()[i + 1][j].endsWith("\u001B[0m"))) {
                NoEsCuadrado = false;
                if (this.getJugadorActual().isHumano()) {
                    mensajes.posicionInvalida(this.getVt());
                }
            }
        }
        return NoEsCuadrado;
    }

    public boolean ahiSi(int i, int j, Tablero tablero, String red, String blue) {
        boolean Podes = false;
        String reset = "\u001B[0m";
        if ((!tablero.getTablero()[i][j].endsWith(reset))) {
            Podes = true;

        } else if (this.getJugadorActual().isHumano()) {
            mensajes.yaHayFicha(this.getVt());
        }
        return Podes;
    }

    @Override
    public String toString() {
        return "Juego{" + "jugador1=" + jugador1 + ", jugador2=" + jugador2 + ", interfaz=" + mensajes + ", tablero=" + tablero + ", jugadorActual=" + jugadorActual + ", vt=" + vt + '}';
    }
    
    
}
