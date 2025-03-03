package Interfaz;

import dominio.*;
import dominio.fichas.FichaAzul;
import dominio.fichas.FichaRoja;
import dominio.tablero.Tablero;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class JugarVsHumano extends javax.swing.JFrame {

  private Sistema sistema;
  private boolean yaEligio = false;
  private Jugador juugador1;
  private Jugador juugador2;
  private Juego juego;
  private final String[] music = {"Con musica", "Sin musica"};
  private boolean cllickeoT;
  private VentanaMenu vm;

  public VentanaMenu getVm() {
    return vm;
  }

  public void setVm(VentanaMenu vm) {
    this.vm = vm;
  }

  public boolean isCllickeoT() {
    return cllickeoT;
  }

  public void setCllickeoT(boolean cllickeoT) {
    this.cllickeoT = cllickeoT;
  }

  public Juego getJuego() {
    return juego;
  }

  public void setJuego(Juego juego) {
    this.juego = juego;
  }

  public boolean isYaEligio() {
    return yaEligio;
  }

  public void setYaEligio(boolean yaEligio) {
    this.yaEligio = yaEligio;
  }

  public Jugador getJugador1() {
    return juugador1;
  }

  public void setJuugador1(Jugador jugador1) {
    this.juugador1 = jugador1;
  }

  public Jugador getJuugador2() {
    return juugador2;
  }

  public void setJuugador2(Jugador juugador2) {
    this.juugador2 = juugador2;
  }

  public JugarVsHumano(Sistema s, VentanaMenu vm) {
    this.sistema = s;
    this.yaEligio = false;
    this.setJuugador1(juugador1);
    this.setJuugador2(juugador2);
    this.setJuego(juego);
    this.setVm(vm);
    this.time = false;
    this.clickeoTiempo = false;
    ArrayList<Jugador> jugadoresPro = this.getSistema().jugadoresPro();

    initComponents();
    this.setResizable(false);
    this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono7.png")).getImage());
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(0);
    this.setTitle("Modo Versus");
    this.setSize(940, 780);
    jug.setListData(this.getSistema().getJugadores().toArray());
    musica.setListData(music);
    lol.setListData(jugadoresPro.toArray());
  }

  public Sistema getSistema() {
    return sistema;
  }

  public void setSistema(Sistema sistema) {
    this.sistema = sistema;
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jugadores = new javax.swing.JScrollPane();
    jug = new javax.swing.JList();
    jScrollPane1 = new javax.swing.JScrollPane();
    musica = new javax.swing.JList<>();
    jLabel4 = new javax.swing.JLabel();
    jugar = new javax.swing.JButton();
    elegir = new javax.swing.JButton();
    volver = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    nombre2 = new javax.swing.JLabel();
    nombre1 = new javax.swing.JLabel();
    tiempo = new javax.swing.JCheckBox();
    jScrollPane2 = new javax.swing.JScrollPane();
    lol = new javax.swing.JList();
    jButton1 = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    gano = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(153, 153, 255));
    getContentPane().setLayout(null);

    jLabel1.setBackground(new java.awt.Color(153, 153, 153));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("Elegir Jugadores");
    getContentPane().add(jLabel1);
    jLabel1.setBounds(40, 180, 170, 39);

    jug.setBackground(new java.awt.Color(142, 0, 26));
    jug.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jug.setForeground(new java.awt.Color(255, 255, 255));
    jug.setModel(
        new javax.swing.AbstractListModel() {
          final String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

          public int getSize() {
            return strings.length;
          }

          public Object getElementAt(int i) {
            return strings[i];
          }
        });
    jug.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
            jugMouseClicked(evt);
          }
        });
    jugadores.setViewportView(jug);

    getContentPane().add(jugadores);
    jugadores.setBounds(60, 230, 100, 170);

    musica.setBackground(new java.awt.Color(142, 0, 26));
    musica.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    musica.setForeground(new java.awt.Color(255, 255, 255));
    musica.setModel(
        new javax.swing.AbstractListModel<String>() {
          final String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

          public int getSize() {
            return strings.length;
          }

          public String getElementAt(int i) {
            return strings[i];
          }
        });
    jScrollPane1.setViewportView(musica);

    getContentPane().add(jScrollPane1);
    jScrollPane1.setBounds(300, 230, 320, 160);

    jLabel4.setBackground(new java.awt.Color(153, 153, 153));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("Elegir musica");
    getContentPane().add(jLabel4);
    jLabel4.setBounds(360, 180, 130, 24);

    jugar.setBackground(new java.awt.Color(142, 0, 26));
    jugar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jugar.setForeground(new java.awt.Color(255, 255, 255));
    jugar.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/Imagenes/jugar.png"))); // NOI18N
    jugar.setText(" Jugar");
    jugar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            jugarActionPerformed(evt);
          }
        });
    getContentPane().add(jugar);
    jugar.setBounds(530, 510, 130, 40);

    elegir.setBackground(new java.awt.Color(142, 0, 26));
    elegir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    elegir.setForeground(new java.awt.Color(255, 255, 255));
    elegir.setText("Elegir");
    elegir.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            elegirActionPerformed(evt);
          }
        });
    getContentPane().add(elegir);
    elegir.setBounds(170, 260, 90, 29);

    volver.setBackground(new java.awt.Color(142, 0, 26));
    volver.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    volver.setForeground(new java.awt.Color(255, 255, 255));
    volver.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/Imagenes/espalda.png"))); // NOI18N
    volver.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            volverActionPerformed(evt);
          }
        });
    getContentPane().add(volver);
    volver.setBounds(60, 670, 100, 40);

    jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(153, 0, 0));
    jLabel2.setText("VS");
    getContentPane().add(jLabel2);
    jLabel2.setBounds(560, 455, 40, 30);

    nombre2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    nombre2.setForeground(new java.awt.Color(51, 0, 153));
    getContentPane().add(nombre2);
    nombre2.setBounds(610, 460, 62, 25);

    nombre1.setBackground(new java.awt.Color(204, 204, 204));
    nombre1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    nombre1.setForeground(new java.awt.Color(153, 0, 0));
    getContentPane().add(nombre1);
    nombre1.setBounds(500, 460, 58, 25);

    tiempo.setBackground(new java.awt.Color(142, 0, 26));
    tiempo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    tiempo.setForeground(new java.awt.Color(255, 255, 255));
    tiempo.setText("Jugar con tiempo");
    tiempo.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            tiempoActionPerformed(evt);
          }
        });
    getContentPane().add(tiempo);
    tiempo.setBounds(530, 610, 150, 27);

    lol.setModel(
        new javax.swing.AbstractListModel() {
          final String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

          public int getSize() {
            return strings.length;
          }

          public Object getElementAt(int i) {
            return strings[i];
          }
        });
    jScrollPane2.setViewportView(lol);

    getContentPane().add(jScrollPane2);
    jScrollPane2.setBounds(690, 220, 170, 180);

    jButton1.setText("Ver");
    jButton1.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
          }
        });
    getContentPane().add(jButton1);
    jButton1.setBounds(730, 420, 110, 25);

    jLabel5.setText("GANO :");
    getContentPane().add(jLabel5);
    jLabel5.setBounds(50, 430, 50, 30);
    getContentPane().add(gano);
    gano.setBounds(120, 440, 70, 20);

    jLabel3.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/Imagenes/versuss.jpg"))); // NOI18N
    jLabel3.setText("jLabel3");
    getContentPane().add(jLabel3);
    jLabel3.setBounds(0, 0, 940, 780);

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void jugarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jugarActionPerformed

    if ((nombre1.getText().equals(nombre2.getText()) && !nombre1.getText().isEmpty())
        || (nombre2.getText().equals(nombre1.getText()) && !nombre2.getText().isEmpty())) {
      JOptionPane.showMessageDialog(this, "No se puede jugar contra uno mismo", "No", 0);
      return;
    }

    if (nombre1.getText().isEmpty() || nombre2.getText().isEmpty()) {
      JOptionPane.showMessageDialog(
          this, "No se puede jugar si no hay 2 jugadores seleccionados", "Error", 0);
      return;
    }

    if (musica.getSelectedValue() == null) {
      JOptionPane.showMessageDialog(this, "Debe elegir una cancion", "No", 0);
      return;
    }

    Juego juego = new Juego();
    Tablero tablero = new Tablero();
    tablero.inicializar();
    Mensajes mensajes = new Mensajes();

    this.getJugador1()
        .setFichas(
            IntStream.range(0, 25).mapToObj(i -> new FichaRoja()).collect(Collectors.toList()));
    this.getJuugador2()
        .setFichas(
            IntStream.range(0, 25).mapToObj(i -> new FichaAzul()).collect(Collectors.toList()));

    juego.setJugador1(this.getJugador1());
    juego.setJugador2(this.getJuugador2());
    juego.setTablero(tablero);
    juego.setMensajes(mensajes);
    juego.setJugadorActual(juugador1);
    setJuego(juego);

    VentanaTablero vt =
        new VentanaTablero(
            this.time, this.getSistema(), this.getJuego(), musica.getSelectedValue(), this.getVm());

    vt.setVisible(true);

    this.dispose();
  }

  private void volverActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_volverActionPerformed
    this.getVm().setVisible(true);
    dispose();
  } // GEN-LAST:event_volverActionPerformed

  private void elegirActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_elegirActionPerformed
    if (!this.isYaEligio()) {
      Jugador j = (Jugador) lol.getSelectedValue();
      this.setJuugador1(j);
      this.setYaEligio(true);
      nombre1.setText(j.getAlias());

    } else {
      Jugador j2 = (Jugador) jug.getSelectedValue();
      this.setJuugador2(j2);
      nombre2.setText(j2.getAlias());
    }
  } // GEN-LAST:event_elegirActionPerformed

  private boolean time;
  private boolean clickeoTiempo;

  public boolean isClickeoTiempo() {
    return clickeoTiempo;
  }

  public void setClickeoTiempo(boolean clickeoTiempo) {
    this.clickeoTiempo = clickeoTiempo;
  }

  public boolean isTime() {
    return time;
  }

  public void setTime(boolean time) {
    this.time = time;
  }

  private void tiempoActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_tiempoActionPerformed

    if (!clickeoTiempo) {
      time = true;
      clickeoTiempo = true;
    } else if (clickeoTiempo) {
      time = false;
      clickeoTiempo = false;
    }
  } // GEN-LAST:event_tiempoActionPerformed

  private void jButton1ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton1ActionPerformed
    ArrayList<Jugador> jugadoresGanad = new ArrayList<>();
    for (int i = 0; i < this.getSistema().getJugadores().size(); i++) {
      Jugador j = this.getSistema().getJugadores().get(i);
      int gano = this.getSistema().getJugadores().get(i).getWin();
      if (gano > 0) {
        jugadoresGanad.add(j);
      }
    }
    this.lol.setListData(jugadoresGanad.toArray());
  } // GEN-LAST:event_jButton1ActionPerformed

  private void jugMouseClicked(java.awt.event.MouseEvent evt) { // GEN-FIRST:event_jugMouseClicked
    Jugador j = (Jugador) jug.getSelectedValue();
    int partidasGanadas = this.getSistema().cantidadPArtisasGanadas(j);
    this.gano.setText(partidasGanadas + "");
  } // GEN-LAST:event_jugMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton elegir;
  private javax.swing.JLabel gano;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JList jug;
  private javax.swing.JScrollPane jugadores;
  private javax.swing.JButton jugar;
  private javax.swing.JList lol;
  private javax.swing.JList<String> musica;
  private javax.swing.JLabel nombre1;
  private javax.swing.JLabel nombre2;
  private javax.swing.JCheckBox tiempo;
  private javax.swing.JButton volver;
  // End of variables declaration//GEN-END:variables
}
