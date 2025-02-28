package Interfaz;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import dominio.*;
import java.applet.AudioClip;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;




public class VentanaTablero extends javax.swing.JFrame implements Serializable {

    private boolean reanudada;
    private JButton[][] botones;
    private Sistema system;
    private boolean pj;
    // Musica sacada de https://www.youtube.com/watch?v=JipQOxRoogY de uso libre.
    private AudioClip musica;
    private Juego juego;
    private String nombreCancion;
    private Timer timer;
    private PerdistePorTiempo ppt;
    private boolean tiem ;
    private VentanaMenu vm;
    private final String[] vacio = {""};
    
    

    public VentanaMenu getVm() {
        return vm;
    }

    public void setVm(VentanaMenu vm) {
        this.vm = vm;
    }

    public boolean getTiempo() {
        return tiem;
    }

    public void setTiempo(boolean time) {
        this.tiem = time;
    }

    public PerdistePorTiempo getPpt() {
        return ppt;
    }

    public void setPpt(PerdistePorTiempo ppt) {
        this.ppt = ppt;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public boolean isReanudada() {
        return reanudada;
    }

    public void setReanudada(boolean reanudada) {
        this.reanudada = reanudada;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public AudioClip getMusica() {
        return musica;
    }

    public void setMusica(AudioClip musica) {
        this.musica = musica;
    }

    public Sistema getSystem() {
        return system;
    }

    public JList getAvisa() {
        return avisa;
    }

    public void setAvisa(JList avisa) {
        this.avisa = avisa;
    }

    public void setSystem(Sistema sistem) {
        this.system = sistem;
    }

    public JButton[][] getBotones() {
        return botones;
    }

    public void setBotones(JButton[][] botones) {
        this.botones = botones;
    }

    public void cuentaRegresiva() {
        this.ppt.restarUnSegundo();
        this.tiempo.setText(Integer.toString(ppt.getTiempoRestante()));
        if (this.ppt.perdiste()) {
            this.musica.stop();
            this.getTimer().cancel();
            this.getJuego().getJugadorActual().setCubos(0);
            this.setMusica(java.applet.Applet.newAudioClip(getClass().getResource("/musica/wasted.wav")));
                this.musica.play();
            JOptionPane.showMessageDialog(this, this.getJuego().getJugadorActual() + " perdiste por tiempo.", "Se acabo el tiempo", 1);
            if (this.getJuego().getJugadorActual().equals(this.getJuego().getJugador1())) {
                this.getJuego().getJugador2().setWin(this.getJuego().getJugador2().getWin() + 1);
                this.getJuego().getJugador1().setPartidasPerdidas(this.getJuego().getJugador1().getPartidasPerdidas() + 1);
                this.musica.stop();
                
                this.getVm().setVisible(true);
                this.dispose();
            } else {
                this.getJuego().getJugador1().setWin(this.getJuego().getJugador1().getWin() + 1);
                this.getJuego().getJugador2().setPartidasPerdidas(this.getJuego().getJugador2().getPartidasPerdidas() + 1);
                this.musica.stop();
                this.getVm().setVisible(true);
                this.dispose();
            }
        }

    }

    public JList getAvisaAlargo() {
        return avisaAlargo;
    }

    public void setAvisaAlargo(JList avisaAlargo) {
        this.avisaAlargo = avisaAlargo;
    }

    public JList getAvisaPc() {
        return avisaPc;
    }

    public void setAvisaPc(JList avisaPc) {
        this.avisaPc = avisaPc;
    }

    public JList getAvisaPCesquina() {
        return avisaPCesquina;
    }

    public void setAvisaPCesquina(JList avisaPCesquina) {
        this.avisaPCesquina = avisaPCesquina;
    }

    public VentanaTablero(boolean time,Sistema sistema, Juego juego, String music, VentanaMenu vm) {
        this.tiem = time;
        this.vm = vm;
        this.system = sistema;
        this.nombreCancion = music;
        this.juego = juego;
        this.getJuego().setVt(this);
        this.cambio = false;
        this.setTitle(getJuego().getJugador1().getNombre() + " VS " + getJuego().getJugador2().getNombre());
        this.setReanudada(this.getJuego().getJugador1().getCubos() < 25 || this.getJuego().getJugador2().getCubos() < 25);
        this.pj = false;

        initComponents();
        this.setLocationRelativeTo(this);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono7.png")).getImage());
        this.gano.setVisible(false);
        this.nombreWinner.setVisible(false);
        this.avisa.setListData(vacio);
        this.avisaAlargo.setListData(vacio);
        if (this.getJuego().getJugador1().isHumano() && this.getJuego().getJugador2().isHumano()) {
            this.getAvisaPc().setVisible(false);
            this.getAvisaPCesquina().setVisible(false);

        } else {
            this.avisaPc.setListData(vacio);
            this.getAvisaPCesquina().setListData(vacio);
            this.getAvisaPCesquina().setVisible(true);
            this.avisaPc.setVisible(true);
        }

        this.setSize(1250, 810);
        this.setDefaultCloseOperation(0);
       if(tiem){
            ppt = new PerdistePorTiempo(12);
        Tarea t = new Tarea(this);
        this.timer = new Timer();
        this.timer.schedule(t, 0, 1000);
           
       }else{
           
       }
       

        quienJuega.setText(getJuego().getJugadorActual().getAlias());
        cubos.setText(getJuego().getJugadorActual().getCubos() + " ");

        if (music.equals("Con musica")) {
            musica = java.applet.Applet.newAudioClip(getClass().getResource("/musica/base2.wav"));
            this.setNombreCancion("Con musica");

        } else if (music.equals("Sin musica")) {
            musica = java.applet.Applet.newAudioClip(getClass().getResource(""));

        }

        musica.play();
        panelJuego.setLayout(new GridLayout(6, 6));
        botones = new JButton[6][6];

        for (int i = 0; i < botones.length; i++) {

            for (int j = 0; j < botones[0].length; j++) {

                JButton jButton = new JButton();
                jButton.addActionListener(new ListenerBoton(i, j));
                panelJuego.add(jButton);
                botones[i][j] = jButton;

                jButton.setMargin(new Insets(40, 40, 40, 40));
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tiempo = new javax.swing.JLabel();
        panelJuego = new javax.swing.JPanel();
        salir = new javax.swing.JButton();
        guargarPartida = new javax.swing.JButton();
        silencio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cubos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        quienJuega = new javax.swing.JLabel();
        B = new javax.swing.JButton();
        C = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        nombreWinner = new javax.swing.JLabel();
        gano = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        avisa = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        avisaAlargo = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        avisaPc = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        avisaPCesquina = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(650, 320));
        jPanel1.setLayout(null);

        tiempo.setBackground(new java.awt.Color(255, 255, 255));
        tiempo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tiempo.setForeground(new java.awt.Color(255, 255, 255));
        tiempo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reloj-de-arena.png"))); // NOI18N
        jPanel1.add(tiempo);
        tiempo.setBounds(860, 180, 120, 70);

        panelJuego.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );

        jPanel1.add(panelJuego);
        panelJuego.setBounds(150, 90, 590, 530);

        salir.setBackground(new java.awt.Color(61, 144, 85));
        salir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir);
        salir.setBounds(110, 680, 140, 60);

        guargarPartida.setBackground(new java.awt.Color(61, 142, 84));
        guargarPartida.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        guargarPartida.setForeground(new java.awt.Color(255, 255, 255));
        guargarPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible.png"))); // NOI18N
        guargarPartida.setText("Guardar Partida");
        guargarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guargarPartidaActionPerformed(evt);
            }
        });
        jPanel1.add(guargarPartida);
        guargarPartida.setBounds(1030, 80, 200, 60);

        silencio.setBackground(new java.awt.Color(61, 142, 84));
        silencio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        silencio.setForeground(new java.awt.Color(255, 255, 255));
        silencio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reproductor-de-musica.png"))); // NOI18N
        silencio.setText("Silenciar / Reproducir Musica");
        silencio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silencioActionPerformed(evt);
            }
        });
        jPanel1.add(silencio);
        silencio.setBounds(750, 270, 300, 40);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Juega : ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(770, 50, 90, 50);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cubos :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(770, 120, 80, 40);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tiempo");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(770, 190, 130, 40);

        cubos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cubos.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(cubos);
        cubos.setBounds(860, 130, 120, 30);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("A");
        jButton1.setMargin(new java.awt.Insets(40, 40, 40, 40));
        jPanel1.add(jButton1);
        jButton1.setBounds(40, 90, 110, 90);

        quienJuega.setBackground(new java.awt.Color(255, 255, 255));
        quienJuega.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        quienJuega.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(quienJuega);
        quienJuega.setBounds(870, 50, 150, 50);

        B.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        B.setText("B");
        B.setMargin(new java.awt.Insets(40, 40, 40, 40));
        jPanel1.add(B);
        B.setBounds(40, 180, 110, 90);

        C.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        C.setText("C");
        C.setMargin(new java.awt.Insets(40, 40, 40, 40));
        jPanel1.add(C);
        C.setBounds(40, 270, 110, 88);

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("D");
        jPanel1.add(jButton2);
        jButton2.setBounds(40, 350, 110, 90);

        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setText("E");
        jPanel1.add(jButton3);
        jButton3.setBounds(40, 440, 110, 90);

        jButton4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4.setText("F");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(40, 530, 110, 89);

        jButton5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton5.setText("1");
        jPanel1.add(jButton5);
        jButton5.setBounds(150, 5, 100, 80);

        jButton6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton6.setText("2");
        jPanel1.add(jButton6);
        jButton6.setBounds(250, 5, 100, 80);

        jButton7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton7.setText("3");
        jPanel1.add(jButton7);
        jButton7.setBounds(350, 5, 100, 80);

        jButton8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton8.setText("4");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(450, 5, 95, 80);

        jButton9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton9.setText("5");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(540, 5, 100, 80);

        jButton10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton10.setText("6");
        jPanel1.add(jButton10);
        jButton10.setBounds(640, 5, 100, 80);

        nombreWinner.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jPanel1.add(nombreWinner);
        nombreWinner.setBounds(890, 430, 120, 50);

        gano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/winner.gif"))); // NOI18N
        jPanel1.add(gano);
        gano.setBounds(750, 380, 400, 323);

        avisa.setBackground(new java.awt.Color(61, 142, 84));
        avisa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        avisa.setForeground(new java.awt.Color(255, 255, 255));
        avisa.setModel(new javax.swing.AbstractListModel() {
            final String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(avisa);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(750, 330, 210, 110);

        avisaAlargo.setBackground(new java.awt.Color(63, 145, 87));
        avisaAlargo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        avisaAlargo.setForeground(new java.awt.Color(255, 255, 255));
        avisaAlargo.setModel(new javax.swing.AbstractListModel() {
            final String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(avisaAlargo);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(750, 440, 310, 110);

        avisaPc.setBackground(new java.awt.Color(63, 145, 87));
        avisaPc.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        avisaPc.setForeground(new java.awt.Color(255, 255, 255));
        avisaPc.setModel(new javax.swing.AbstractListModel() {
            final String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(avisaPc);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(750, 550, 310, 130);

        avisaPCesquina.setBackground(new java.awt.Color(61, 142, 84));
        avisaPCesquina.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        avisaPCesquina.setForeground(new java.awt.Color(255, 255, 255));
        avisaPCesquina.setModel(new javax.swing.AbstractListModel() {
            final String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(avisaPCesquina);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(750, 679, 220, 120);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondot.gif"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 1250, 800);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1260, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guargarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guargarPartidaActionPerformed
        if(tiem){
            this.timer.cancel();
        }
        
        Date date = new Date();
        String fechaYHora = "";
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        PartidaGuardada pg = new PartidaGuardada();
        pg.setJugador1(this.getJuego().getJugador1());
        pg.setJugador2(this.getJuego().getJugador2());
        pg.setJugadorActual(this.getJuego().getJugadorActual());
        pg.setT(this.getJuego().getTablero());
        fechaYHora = hourdateFormat.format(date);
        pg.setFechaYHora(fechaYHora);
        pg.setCancion(nombreCancion);
        pg.setTiempo(tiem);
        this.getSystem().getPartidasGuardadas().add(pg);
        this.getSystem().saveSystem(system);
        this.musica.stop();
        JOptionPane.showMessageDialog(this,"Partida guardada con exito, para reanudarla ingrese a la opcion reanudar partida.","Se guardo la partida", 1);
        this.getVm().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_guargarPartidaActionPerformed

    private void silencioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silencioActionPerformed

        if (!pausa) {
            this.getMusica().stop();
            pausa = true;
        } else {
            this.getMusica().play();
            pausa = false;
        }

    }//GEN-LAST:event_silencioActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
      if(tiem){
           this.timer.cancel();
      }
       
        this.getSystem().saveSystem(system);
        this.getMusica().stop();
        this.vm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed
    private boolean pausa = false;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B;
    private javax.swing.JButton C;
    private javax.swing.JList avisa;
    private javax.swing.JList avisaAlargo;
    private javax.swing.JList avisaPCesquina;
    private javax.swing.JList avisaPc;
    private javax.swing.JLabel cubos;
    private javax.swing.JLabel gano;
    private javax.swing.JButton guargarPartida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel nombreWinner;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JLabel quienJuega;
    private javax.swing.JButton salir;
    private javax.swing.JButton silencio;
    private javax.swing.JLabel tiempo;
    // End of variables declaration//GEN-END:variables
private class ListenerBoton implements ActionListener {

        private final int x;
        private final int y;

        public ListenerBoton(int i, int j) {
            // en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
            // cuando se presiona un botón, se ejecutará este método
            clickBoton(x, y);
        }
    }

    public boolean isPj() {
        return pj;
    }

    public void setPj(boolean pj) {
        this.pj = pj;
    }
private boolean cambio;

    public boolean isCambio() {
        return cambio;
    }

    public void setCambio(boolean cambio) {
        this.cambio = cambio;
    }

    private void JugarVsHumano(int fila, int columna) {
        String red = "\u001B[31mR\u001B[0m";
        String blue = "\033[34mA\u001B[0m";
        
        
         
              
          
        if (getJuego().getJugador1().getCubos() > 0 && getJuego().getJugador2().getCubos() > 0) {
            quienJuega.setText(getJuego().getJugadorActual().getAlias());
            cubos.setText(getJuego().getJugadorActual().getCubos() + "");
             if(this.getJuego().getJugadorActual().equals(this.getJuego().getJugador1())){
                 getJuego().colocarFicha(reanudada, pj, red, blue, fila, columna);
                 if(this.getJuego().getJugadorActual().equals(this.getJuego().getJugador2()) && tiem){
                      this.ppt.reiniciarTiempo();
                 }
             }else{
                 
                 getJuego().colocarFicha(reanudada, pj, red, blue, fila, columna);
                 
                 if(this.getJuego().getJugadorActual().equals(this.getJuego().getJugador1() ) && tiem){
                     this.ppt.reiniciarTiempo();
                 }
             }
            
               
            if (getJuego().getJugador1().getCubos() == 0 || getJuego().getJugador2().getCubos() == 0) {
                this.getBotones()[0][0].doClick();
                if(tiem){
                    this.timer.cancel();
                }
                

            }
            pj = true;
            
            
           quienJuega.setText(getJuego().getJugadorActual().getAlias());
            cubos.setText(getJuego().getJugadorActual().getCubos() + "");
             
                
            

           
        } else {
            if(tiem){
                this.getTimer().cancel();
            }
            
            getJuego().calcularPuntaje(getJuego().getTablero());
            if (getJuego().getJugador1().getPuntaje() > getJuego().getJugador2().getPuntaje()) {
                getJuego().getJugador1().setWin(getJuego().getJugador1().getWin() + 1);
                getJuego().getJugador2().setPartidasPerdidas(getJuego().getJugador2().getPartidasPerdidas() + 1);
                this.gano.setVisible(true);
                this.nombreWinner.setText(this.getJuego().getJugador1().getAlias());
                this.nombreWinner.setVisible(true);
                JOptionPane.showMessageDialog(this, " Gana " + getJuego().getJugador1().getAlias() + " con " + getJuego().getJugador1().getPuntaje() + " puntos!\nPierde " + getJuego().getJugador2().getAlias() + " con " + getJuego().getJugador2().getPuntaje() + " puntos.", " Fin de partida ", 1);
                this.vm.setVisible(true);
                if(reanudada){
                this.getVm().borrarPartidasTerminadas();
                }

                this.getMusica().stop();
                this.dispose();
            } else if (getJuego().getJugador1().getPuntaje() < getJuego().getJugador2().getPuntaje()) {
                getJuego().getJugador2().setWin(getJuego().getJugador2().getWin() + 1);
                getJuego().getJugador1().setPartidasPerdidas(getJuego().getJugador1().getPartidasPerdidas() + 1);
                this.gano.setVisible(true);
                this.nombreWinner.setText(this.getJuego().getJugador2().getAlias());
                this.nombreWinner.setVisible(true);
                JOptionPane.showMessageDialog(this, " Gana " + getJuego().getJugador2().getAlias() + " con " + getJuego().getJugador2().getPuntaje() + " puntos!\nPierde " + getJuego().getJugador1().getAlias() + " con " + getJuego().getJugador1().getPuntaje() + " puntos.", " Fin de partida ", 1);
                this.vm.setVisible(true);
                if(reanudada){
                    this.getVm().borrarPartidasTerminadas();
                }
                this.getMusica().stop();
                this.dispose();
            } else if (getJuego().getJugador1().getPuntaje() == getJuego().getJugador2().getPuntaje()) {
                JOptionPane.showMessageDialog(this, "Empate", "Empataron", 1);
                this.vm.setVisible(true);
                this.getMusica().stop();
                if(reanudada){
                  this.getVm().borrarPartidasTerminadas();
                }
                this.dispose();

            }

        }

    }

    private void JugarVsPc(int fila, int columna) {
        String red = "\u001B[31mR\u001B[0m";
        String blue = "\033[34mA\u001B[0m";

        if (getJuego().getJugador1().getCubos() > 0 && getJuego().getJugador2().getCubos() > 0) {

            quienJuega.setText(getJuego().getJugadorActual().getAlias());
            cubos.setText(getJuego().getJugadorActual().getCubos() + "");
            getJuego().colocarFicha(reanudada, pj, red, blue, fila, columna);
            if (!getJuego().getJugadorActual().isHumano() && tiem) {
                this.ppt.reiniciarTiempo();
            }

             if (getJuego().getJugador1().getCubos() == 0 || getJuego().getJugador2().getCubos() == 0) {
                this.getBotones()[0][0].doClick();
                if(tiem){
                    this.timer.cancel();
                }
                
            }

            pj = true;
            quienJuega.setText(getJuego().getJugadorActual().getAlias());
            cubos.setText(getJuego().getJugadorActual().getCubos() + "");
            if (getJuego().getJugador1().getCubos() > 0 && !getJuego().getJugadorActual().isHumano()) {

                getJuego().colocarFicha(reanudada, pj, red, blue, fila, columna);
                if(tiem){
                    this.ppt.reiniciarTiempo();
                }
                
            }

            quienJuega.setText(getJuego().getJugadorActual().getAlias());
            cubos.setText(getJuego().getJugadorActual().getCubos() + "");

        } else {
            if(tiem){
                this.getTimer().cancel();
            }
            
            getJuego().calcularPuntaje(getJuego().getTablero());
            if (getJuego().getJugador1().getPuntaje() > getJuego().getJugador2().getPuntaje()) {
                getJuego().getJugador1().setWin(getJuego().getJugador1().getWin() + 1);
                getJuego().getJugador2().setPartidasPerdidas(getJuego().getJugador2().getPartidasPerdidas() + 1);
                this.gano.setVisible(true);
                this.nombreWinner.setText(this.getJuego().getJugador1().getAlias());
                this.nombreWinner.setVisible(true);
                JOptionPane.showMessageDialog(this, " Gana " + getJuego().getJugador1().getAlias() + " con " + getJuego().getJugador1().getPuntaje() + " puntos!\nPierde " + getJuego().getJugador2().getAlias() + " con " + getJuego().getJugador2().getPuntaje() + " puntos.", " Fin de partida ", 1);
                this.vm.setVisible(true);
                this.getMusica().stop();
                if(reanudada){
                    this.getVm().borrarPartidasTerminadas();
                }
                this.dispose();
            } else if (getJuego().getJugador1().getPuntaje() < getJuego().getJugador2().getPuntaje()) {
                getJuego().getJugador2().setWin(getJuego().getJugador2().getWin() + 1);
                getJuego().getJugador1().setPartidasPerdidas(getJuego().getJugador1().getPartidasPerdidas() + 1);
                this.gano.setVisible(true);
                this.nombreWinner.setText(this.getJuego().getJugador2().getAlias());
                this.nombreWinner.setVisible(true);
                JOptionPane.showMessageDialog(this, " Gana " + getJuego().getJugador2().getAlias() + " con " + getJuego().getJugador2().getPuntaje() + " puntos!\nPierde " + getJuego().getJugador1().getAlias() + " con " + getJuego().getJugador1().getPuntaje() + " puntos.", " Fin de partida ", 1);
                this.vm.setVisible(true);
                this.getMusica().stop();
                if(reanudada){
                    this.getVm().borrarPartidasTerminadas();
                }
                this.dispose();
            } else if (getJuego().getJugador1().getPuntaje() == getJuego().getJugador2().getPuntaje()) {
                JOptionPane.showMessageDialog(this, "Empate", "Empataron", 1);
                this.vm.setVisible(true);
                this.getMusica().stop();
                if(reanudada){
                    this.getVm().borrarPartidasTerminadas();
                }
                this.dispose();
            }

        }

    }

    private void clickBoton(int fila, int columna) {

        if (getJuego().getJugador1().isHumano() && getJuego().getJugador2().isHumano()) {
            
            this.JugarVsHumano(fila, columna);

        } else {
            this.JugarVsPc(fila, columna);
        }

    }

}
