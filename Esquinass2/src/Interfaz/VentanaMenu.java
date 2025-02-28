
package Interfaz;
import dominio.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;






public class VentanaMenu extends javax.swing.JFrame {

    private Sistema sistema;

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    public void borrarPartidasTerminadas(){
         for (int i = 0; i < sistema.getPartidasGuardadas().size(); i++) {
            if(sistema.getPartidasGuardadas().get(i).getJugador1().getCubos() == 0 || sistema.getPartidasGuardadas().get(i).getJugador2().getCubos() == 0){
                sistema.getPartidasGuardadas().remove(i);
            }
            
        }
        
    }
    public VentanaMenu(Sistema s) {
        this.sistema = s;
        initComponents();
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono7.png")).getImage());
        this.setDefaultCloseOperation(0);
        this.borrarPartidasTerminadas();
        this.puedenJugar();
        this.setTitle("Esquinas 2");
        
       
            
        
        
        this.setLocationRelativeTo(this);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Salir = new javax.swing.JButton();
        rankings = new javax.swing.JButton();
        JugarModoVersus = new javax.swing.JButton();
        registrarJugador = new javax.swing.JButton();
        JugarVsPce = new javax.swing.JButton();
        ReanudarPartida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 450));
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);

        Salir.setBackground(new java.awt.Color(188, 87, 71));
        Salir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/brazo-levantado.png"))); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel2.add(Salir);
        Salir.setBounds(30, 350, 130, 40);

        rankings.setBackground(new java.awt.Color(188, 87, 71));
        rankings.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rankings.setForeground(new java.awt.Color(255, 255, 255));
        rankings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marcador-de-posicion.png"))); // NOI18N
        rankings.setText("Rankings");
        rankings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankingsActionPerformed(evt);
            }
        });
        jPanel2.add(rankings);
        rankings.setBounds(250, 310, 180, 40);

        JugarModoVersus.setBackground(new java.awt.Color(188, 91, 71));
        JugarModoVersus.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JugarModoVersus.setForeground(new java.awt.Color(255, 255, 255));
        JugarModoVersus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/versus-juego.png"))); // NOI18N
        JugarModoVersus.setText("Modo Versus");
        JugarModoVersus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarModoVersusActionPerformed(evt);
            }
        });
        jPanel2.add(JugarModoVersus);
        JugarModoVersus.setBounds(250, 160, 180, 36);

        registrarJugador.setBackground(new java.awt.Color(188, 87, 71));
        registrarJugador.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        registrarJugador.setForeground(new java.awt.Color(255, 255, 255));
        registrarJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        registrarJugador.setText("Registrar jugador");
        registrarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarJugadorActionPerformed(evt);
            }
        });
        jPanel2.add(registrarJugador);
        registrarJugador.setBounds(240, 260, 210, 40);

        JugarVsPce.setBackground(new java.awt.Color(190, 87, 71));
        JugarVsPce.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JugarVsPce.setForeground(new java.awt.Color(255, 255, 255));
        JugarVsPce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/roboto-logo.png"))); // NOI18N
        JugarVsPce.setText("Jugar vs Pc");
        JugarVsPce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarVsPceActionPerformed(evt);
            }
        });
        jPanel2.add(JugarVsPce);
        JugarVsPce.setBounds(250, 110, 180, 34);

        ReanudarPartida.setBackground(new java.awt.Color(188, 87, 71));
        ReanudarPartida.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ReanudarPartida.setForeground(new java.awt.Color(255, 255, 255));
        ReanudarPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/simbolo-de-recargar.png"))); // NOI18N
        ReanudarPartida.setText("Reanudar Partida");
        ReanudarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReanudarPartidaActionPerformed(evt);
            }
        });
        jPanel2.add(ReanudarPartida);
        ReanudarPartida.setBounds(240, 210, 210, 40);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Esquinas 2");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(250, 40, 200, 55);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoMenu.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 710, 470);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 710, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JugarVsPceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarVsPceActionPerformed
       
       VentanaJugarVsPc vjvp = new VentanaJugarVsPc(this.getSistema(),this);
       this.setVisible(false);
       vjvp.setVisible(true);
       
        
           
       
      
        
    }//GEN-LAST:event_JugarVsPceActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.getSistema().saveSystem(sistema);
        System.exit(0);
       
    }//GEN-LAST:event_SalirActionPerformed

    private void JugarModoVersusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarModoVersusActionPerformed
        
        JugarVsHumano vvh = new JugarVsHumano(this.getSistema(),this);
        this.setVisible(false);
        vvh.setVisible(true);
        
        
        
        
        
    }//GEN-LAST:event_JugarModoVersusActionPerformed

    private void ReanudarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReanudarPartidaActionPerformed
if(this.getSistema().getPartidasGuardadas().isEmpty()){
    JOptionPane.showMessageDialog(this,"No hay partidas guardadas","No hay partidas",0);
}else{
     ReanudarPartida rp = new ReanudarPartida(this.getSistema(),this);
       this.setVisible(false);
       rp.setVisible(true);
    
}
      
    }//GEN-LAST:event_ReanudarPartidaActionPerformed

    private void rankingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingsActionPerformed
        if(this.getSistema().getJugadores().isEmpty()){
            JOptionPane.showMessageDialog(this,"No hay jugadores registrados","No hay ranking", 0);
        }else{
             Rankings rankings = new Rankings(this.getSistema(),this);
          this.setVisible(false);
          rankings.setVisible(true);
            
        }      
         
    }//GEN-LAST:event_rankingsActionPerformed

    private void registrarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarJugadorActionPerformed
           VentanaRegistroJugador v = new VentanaRegistroJugador(this.getSistema() , this);
             this.setVisible(false);
           v.setVisible(true);
    }//GEN-LAST:event_registrarJugadorActionPerformed
public void puedenJugar(){
    JugarVsPce.setEnabled(this.getSistema().getJugadores().size() > 0);
    JugarModoVersus.setEnabled(this.getSistema().getJugadores().size() >= 2);
}
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JugarModoVersus;
    private javax.swing.JButton JugarVsPce;
    private javax.swing.JButton ReanudarPartida;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton rankings;
    private javax.swing.JButton registrarJugador;
    // End of variables declaration//GEN-END:variables
}
