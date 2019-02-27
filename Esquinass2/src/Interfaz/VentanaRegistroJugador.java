package Interfaz;

import dominio.*;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

public class VentanaRegistroJugador extends javax.swing.JFrame {

    private Sistema sistema;
    private VentanaMenu vm;

    public VentanaMenu getVm() {
        return vm;
    }

    public void setVm(VentanaMenu vm) {
        this.vm = vm;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public VentanaRegistroJugador(Sistema s, VentanaMenu vM) {
        this.sistema = s;
        this.vm = vM;
        this.setTitle("Registrar Jugador");

        initComponents();
        this.setResizable(false);
         this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono7.png")).getImage());
        this.setLocationRelativeTo(vM);
        this.setDefaultCloseOperation(0);
        this.setSize(700,460);
        players.setListData(this.getSistema().getJugadores().toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jugadores = new javax.swing.JScrollPane();
        players = new javax.swing.JList();
        eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        alias = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        registrar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        age = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setText("Registro de Jugador");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(186, 36, 237, 28);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("Jugadores");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(490, 110, 110, 19);

        players.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        players.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jugadores.setViewportView(players);

        jPanel1.add(jugadores);
        jugadores.setBounds(480, 139, 130, 170);

        eliminar.setBackground(new java.awt.Color(0, 204, 255));
        eliminar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cruzar.png"))); // NOI18N
        eliminar.setText("Eliminar Jugador");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar);
        eliminar.setBounds(450, 320, 200, 40);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText("Nombre  ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 130, 70, 15);

        nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombreMouseClicked(evt);
            }
        });
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        jPanel1.add(nombre);
        nombre.setBounds(175, 132, 59, 19);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setText("Alias ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(109, 164, 50, 19);

        alias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aliasMouseClicked(evt);
            }
        });
        alias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aliasActionPerformed(evt);
            }
        });
        jPanel1.add(alias);
        alias.setBounds(175, 162, 59, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 51));
        jLabel3.setText("Edad :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(99, 200, 60, 19);

        registrar.setBackground(new java.awt.Color(0, 204, 255));
        registrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        registrar.setForeground(new java.awt.Color(255, 255, 255));
        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        registrar.setText("Registrar");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        jPanel1.add(registrar);
        registrar.setBounds(150, 260, 140, 40);

        Cancelar.setBackground(new java.awt.Color(51, 204, 255));
        Cancelar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-atras (1).png"))); // NOI18N
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(Cancelar);
        Cancelar.setBounds(40, 360, 80, 40);

        age.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ageMouseClicked(evt);
            }
        });
        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });
        jPanel1.add(age);
        age.setBounds(170, 200, 60, 19);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registroJugador.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 680, 440);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(2, 0, 680, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        if( age.getText().isEmpty() ||nombre.getText().isEmpty() || !nombre.getText().matches("[A-Za-z ]*" ) || !age.getText().matches("[0-9]*")){
            JOptionPane.showMessageDialog(this,"Ingrese datos validos","Error", 2);
        }else{
             Jugador jug = new Jugador();
        jug.setNombre(nombre.getText());
        jug.setAlias(alias.getText());
        int edad = Integer.parseInt(age.getText());
        jug.setEdad(edad);
        if (age.getText().isEmpty() ||nombre.getText().isEmpty() || !nombre.getText().matches("[A-Za-z ]*" ) || !age.getText().matches("[0-9]*")) {
            JOptionPane.showMessageDialog(this, "Nombre invalido o vacio", "Ingrese un nombre", 2);

        }else if (edad < 5 || edad > 99) {
            JOptionPane.showMessageDialog(this, "La edad deber ser entre 5 y 99", "Error", 2);
        } else {
            this.getSistema().registrarJugador(jug, this);
            this.getSistema().saveSystem(sistema);
            this.players.setListData(this.getSistema().getJugadores().toArray());
            this.getVm().puedenJugar();
        }
            
        }
       


    }//GEN-LAST:event_registrarActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        nombre.setText("");
    }//GEN-LAST:event_nombreActionPerformed

    private void nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreMouseClicked
        nombre.setText("");
    }//GEN-LAST:event_nombreMouseClicked

    private void aliasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aliasMouseClicked
        alias.setText("");
    }//GEN-LAST:event_aliasMouseClicked

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.getVm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

    private void aliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aliasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aliasActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if(!this.getSistema().getJugadores().isEmpty()){
            this.getSistema().getJugadores().remove((Jugador) players.getSelectedValue());
        players.setListData(this.getSistema().getJugadores().toArray());
        this.getVm().puedenJugar();
        }else{
            JOptionPane.showMessageDialog(this,"No hay ningun jugador registrado para eliminar","Error", 0);
        }
        
    }//GEN-LAST:event_eliminarActionPerformed

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageActionPerformed

    private void ageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ageMouseClicked
                this.age.setText("");
    }//GEN-LAST:event_ageMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField age;
    private javax.swing.JTextField alias;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jugadores;
    private javax.swing.JTextField nombre;
    private javax.swing.JList players;
    private javax.swing.JButton registrar;
    // End of variables declaration//GEN-END:variables
}
