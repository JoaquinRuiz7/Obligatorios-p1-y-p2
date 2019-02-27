package Interfaz;

import dominio.*;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VentanaJugarVsPc extends javax.swing.JFrame implements Serializable {

    private Sistema sistema;
   private Mensajes i;
   private String [] music = {"Con musica","Sin musica"};
   private Juego juego;
   private VentanaMenu vm;

    public VentanaMenu getVm() {
        return vm;
    }

    public void setVm(VentanaMenu vm) {
        this.vm = vm;
    }
   
    public Mensajes getI() {
        return i;
    }



    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public VentanaJugarVsPc(Sistema s,VentanaMenu vm) {
         sistema = s;
         juego = juego;
         this.vm = vm;

        initComponents();
        this.setResizable(false);
         this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono7.png")).getImage());
        this.setLocationRelativeTo(vm);
        this.setDefaultCloseOperation(0);
       this.setSize(740,570);
        i =i;
        jugadores.setListData(s.getJugadores().toArray());
        musica.setListData(music);
        this.setTitle("Jugar vs pc");
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jugadores = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        musica = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jugar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);

        jugadores.setBackground(new java.awt.Color(142, 0, 26));
        jugadores.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jugadores.setForeground(new java.awt.Color(255, 255, 255));
        jugadores.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jugadores);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(100, 140, 140, 210);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Elija un jugador");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(110, 90, 120, 40);

        musica.setBackground(new java.awt.Color(142, 0, 26));
        musica.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        musica.setForeground(new java.awt.Color(255, 255, 255));
        musica.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(musica);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(310, 150, 250, 171);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Elija una cancion");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(340, 90, 210, 40);

        jugar.setBackground(new java.awt.Color(142, 0, 26));
        jugar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jugar.setForeground(new java.awt.Color(255, 255, 255));
        jugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/jugar.png"))); // NOI18N
        jugar.setText("Jugar");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });
        jPanel2.add(jugar);
        jugar.setBounds(310, 370, 130, 40);

        jButton1.setBackground(new java.awt.Color(142, 0, 24));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/espalda.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(90, 420, 80, 40);

        jCheckBox1.setBackground(new java.awt.Color(142, 0, 26));
        jCheckBox1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Jugar con tiempo");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1);
        jCheckBox1.setBounds(500, 390, 150, 27);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/versuss.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 740, 540);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 740, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
               if(jugadores.getSelectedValue() == null){
    JOptionPane.showMessageDialog(this,"Debe elegir un jugador","Error", 0);
}else if (musica.getSelectedValue() == null){
    JOptionPane.showMessageDialog(this,"Debe elegir con o sin musica ","Error", 0);
}else{
                Jugador pc = new Jugador("Pc",2,"La pc");
                 Juego juego = new Juego();
                 Jugador jugador1 = new Jugador();
                 jugador1 =(Jugador) jugadores.getSelectedValue();
                 Mensajes i = new Mensajes();
                 Tablero t = new Tablero();
                 Mensajes in = new Mensajes(); 
                 String ta[][] = new String[6][6];
                 for (int j = 0; j <ta.length; j++) {
                     for (int k = 0; k <ta[0].length; k++) {
                         ta[j][k]= " ";
                         
                     }
            
        }
                 t.setTablero(ta);
                 juego.setJugador1(jugador1);
                 juego.setJugador2(pc);
                 juego.getJugador2().setHumano(false);
                 juego.setTablero(t);
                 juego.setMensajes(in);
                 juego.getJugador1().setCubos(25);
                 juego.getJugador2().setCubos(25);
                 juego.setJugadorActual(jugador1);
                 
                 setJuego(juego);
                 
                 
                 
                 VentanaTablero ventT = new VentanaTablero(this.tiempo,this.getSistema(),this.getJuego(), musica.getSelectedValue(),this.getVm()); 
                 ventT.setVisible(true);
                 
                 
                 this.dispose();
    
}
    }//GEN-LAST:event_jugarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.getVm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
private boolean clickeoTiempo;
private boolean tiempo;

    public boolean isClickeoTiempo() {
        return clickeoTiempo;
    }

    public void setClickeoTiempo(boolean clickeoTiempo) {
        this.clickeoTiempo = clickeoTiempo;
    }

    public boolean isTiempo() {
        return tiempo;
    }

    public void setTiempo(boolean tiempo) {
        this.tiempo = tiempo;
    }

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(!clickeoTiempo){
            tiempo = true;
            clickeoTiempo = true;
        }else if (clickeoTiempo){
            tiempo = false;
            clickeoTiempo = false;
            
        }
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList jugadores;
    private javax.swing.JButton jugar;
    private javax.swing.JList<String> musica;
    // End of variables declaration//GEN-END:variables
}
