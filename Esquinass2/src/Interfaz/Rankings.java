package Interfaz;

import dominio.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author joaco
 */
public class Rankings extends javax.swing.JFrame {

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

    public Rankings(Sistema s, VentanaMenu vm) {
        this.sistema = s;
        this.vm = vm;
        initComponents();
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono7.png")).getImage());
        this.setLocationRelativeTo(vm);
        this.getVm().toBack();
        this.setSize(1020, 490);
        this.setTitle("Rankings");
        this.setDefaultCloseOperation(0);
        s.ranking(s.getJugadores());
        this.rankings.setListData(s.getJugadores().toArray());
        this.gano.setText("");
        this.perdieron.setText("");
    }

    public void mostrarVictorias() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rankings = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        gano = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();
        perdio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        perdieron = new javax.swing.JLabel();
        crearExcel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        rankings.setBackground(new java.awt.Color(255, 255, 255));
        rankings.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rankings.setForeground(new java.awt.Color(204, 0, 0));
        rankings.setModel(new javax.swing.AbstractListModel() {
            final String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        rankings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rankingsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rankings);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(110, 120, 150, 171);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Click sobre el jugador para ver estadisticas");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 90, 310, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Partidas ganadas :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(170, 390, 140, 30);

        gano.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        gano.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(gano);
        gano.setBounds(300, 390, 70, 30);

        Volver.setBackground(new java.awt.Color(255, 255, 255));
        Volver.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Volver.setForeground(new java.awt.Color(204, 0, 0));
        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-atras (1)_1.png"))); // NOI18N
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        jPanel1.add(Volver);
        Volver.setBounds(30, 20, 60, 50);

        perdio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        perdio.setForeground(new java.awt.Color(153, 0, 0));
        perdio.setText("Partidas perdidas :");
        jPanel1.add(perdio);
        perdio.setBounds(400, 400, 140, 19);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(540, 400, 60, 0);

        perdieron.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        perdieron.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(perdieron);
        perdieron.setBounds(540, 400, 50, 20);

        crearExcel.setBackground(new java.awt.Color(255, 255, 255));
        crearExcel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        crearExcel.setForeground(new java.awt.Color(204, 0, 0));
        crearExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sobresalir.png"))); // NOI18N
        crearExcel.setText("Crear Excel con rankings");
        crearExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearExcelActionPerformed(evt);
            }
        });
        jPanel1.add(crearExcel);
        crearExcel.setBounds(660, 380, 260, 50);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(290, 170, 140, 25);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rankings.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 1020, 450);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1020, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rankingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rankingsMouseClicked
        Jugador j = (Jugador) this.rankings.getSelectedValue();
        this.gano.setText(j.getWin() + "");
        this.perdieron.setText(j.getPartidasPerdidas() + "");
    }//GEN-LAST:event_rankingsMouseClicked

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.getVm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void crearExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearExcelActionPerformed

        String[] encabezados = {"Nombre", "Edad", "Partidas ganadas", "Partidas perdidas"};

        int largoExcel = (this.getSistema().getJugadores().size());

        Workbook workBook = new HSSFWorkbook();
        Sheet sheet = workBook.createSheet("Rankings");

        Row filaEncabezados = sheet.createRow(0);
        for (int i = 0; i < encabezados.length; i++) {
            Cell celdaEncabezados = filaEncabezados.createCell(i);
            celdaEncabezados.setCellValue(encabezados[i]);
            sheet.autoSizeColumn(i);
        }
        ArrayList<Jugador> ordenados = new ArrayList<Jugador>();
        ordenados = this.getSistema().getJugadores();
        Collections.sort(ordenados);
                                                                                                                                       
        // aca en i estoy creando las filas del excel (Ya que el archivo es una matriz de filas y las celdas son las columnas.
        for (int i = 1; i < (largoExcel + 1); i++) {
            Row filaDedatos = sheet.createRow(i);
            String nombre = this.getSistema().getJugadores().get((i - 1)).getNombre();
            int edad = this.getSistema().getJugadores().get((i - 1)).getEdad();
            int partidasGanadas = this.getSistema().getJugadores().get((i - 1)).getWin();
            int partidasPerdidas = this.getSistema().getJugadores().get((i - 1)).getPartidasPerdidas();
            for (int j = 0; j < encabezados.length; j++) {
                // ahora estoy creando las columnas (las Cells son las columnas ) y poniendole sus datos correspondientes a cada una.
                Cell celdaDatos = filaDedatos.createCell(j);
                if (j == 0) {
                    celdaDatos.setCellValue(nombre);
                }
                if (j == 1) {
                    celdaDatos.setCellValue(edad);
                }
                if (j == 2) {
                    celdaDatos.setCellValue(partidasGanadas);
                }
                if (j == 3) {
                    celdaDatos.setCellValue(partidasPerdidas);
                }

            }

        }

        this.guardarExcel(workBook);

        //ArchivoGrabacion archivoExcel = new ArchivoGrabacion(nombreArchivo);

    }//GEN-LAST:event_crearExcelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<Jugador> jug = new ArrayList<>();
        Object [] jugadores = this.rankings.getSelectedValues();
        for (int i = 0; i <jugadores.length; i++) {
            jug.add((Jugador) jugadores[i]);

        }
        for (int i = 0; i <jug.size(); i++) {
            System.out.println(jug.get(i));

        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void guardarExcel(Workbook wb) {
        JFileChooser dondeGuardar = new JFileChooser();
        dondeGuardar.setApproveButtonText("Crear archivo Excel");
        int botonApretado = dondeGuardar.showSaveDialog(this);
       
        File archivoExcel = dondeGuardar.getSelectedFile();
        if(botonApretado == JFileChooser.APPROVE_OPTION){
             try (FileOutputStream out = new FileOutputStream(archivoExcel + ".xls")) {
            wb.write(out);
            out.flush();
            out.close();

            JOptionPane.showMessageDialog(this, "El archivo fue creado con exito", "Exito", 1);

        } catch (IOException e) {

            JOptionPane.showMessageDialog(this, "No se pudo crear el archivo", "Error", 0);

        }
            
        }
       

    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Volver;
    private javax.swing.JButton crearExcel;
    private javax.swing.JLabel gano;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel perdieron;
    private javax.swing.JLabel perdio;
    private javax.swing.JList rankings;
    // End of variables declaration//GEN-END:variables
}
