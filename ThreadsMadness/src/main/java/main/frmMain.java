/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author migu_
 */
public class frmMain extends javax.swing.JFrame {
    
    String[][] sala_cine = new String[3][5]; // sala de cine con 5 asientos en cada fila
    int filas_llenas=0; // contador de filas que se van llenando
    int asientos_ocupados = 0; // contador de posiciones para los asientos de una fila
    int contfilas=0;
    DecimalFormat df =new DecimalFormat("#.00");
    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        for (int i=0; i<3; i++) {
            for (int j=0; j<5; j++)
                sala_cine[i][j] = "Vacío";
        }
    }
    public synchronized void Monitor(String nomb, float dinero){
        String asiento_ob;
        int poporo=0, chicles=0; 
        if(asientos_ocupados==5){
         filas_llenas++;
         asientos_ocupados=0;
        }
        System.out.println("Inicia Compra de Cliente "+nomb+"\n Tengo Q"+dinero+"\n Que me alcanza?");
         sala_cine[filas_llenas][asientos_ocupados] = nomb;
            String fila = switch (filas_llenas) {
                case 0 -> "A";
                case 1 -> "B";
                default -> "C";
            };
            asiento_ob = "Fila " + fila + " Asiento " + String.valueOf(asientos_ocupados + 1);
            asientos_ocupados++;
            System.out.println("Compra entrada Q48.00");
            dinero=dinero-48;
            while(dinero>=5)
            {
                if(dinero>=30)
                {
                    poporo++;
                    dinero=dinero-30;
                }
                else if(dinero>=5)
                {
                    chicles++;
                    dinero=dinero-5;
                }
            }
            System.out.println("Compro Poporopos #"+poporo+"\n Compro Dulces #"+chicles+"\n Vuelto colocho es de Q"+df.format(dinero));
            //entrada 48, poporopos 30, dulces 5
            // el cliente debe indicarle al portero que asiento tiene
            // también debe mostrar cuanto le quedo de dinero para el próximo estreno
            System.out.println(nomb + " finalizado con status: 0");
            System.out.println("***************************************");
    }
            
    public class Cliente extends Thread {
        String nombre;
        String asiento_obtenido;
        float dinero;
        
        public Cliente(char letra) {
            nombre = "Cliente " + letra;
            this.dinero = (float)(Math.random()* 100 + 50);
        }
        
        @Override
        public void run() {
            System.out.println("Proceso " + this.nombre + " iniciado. Tengo Q " + df.format(dinero));
            System.out.println("****************************");
            Monitor(this.nombre,this.dinero);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnVerAsientos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("2a Evaluación Parcial");

        btnBuscar.setText("Buscar boletos");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnVerAsientos.setText("Ver asientos");
        btnVerAsientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerAsientosActionPerformed(evt);
            }
        });

        jLabel2.setText("Función: Dr. Strange in the multiverse of madness");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(169, 169, 169)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(83, 83, 83)
                            .addComponent(btnBuscar)
                            .addGap(80, 80, 80)
                            .addComponent(btnVerAsientos))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnVerAsientos))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        filas_llenas=0;
        asientos_ocupados=0;
        Cliente c;
        char letra = 'A';
        for (int i=0; i<15; i++){
            c = new Cliente(letra);
            c.start();
            letra++;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVerAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerAsientosActionPerformed
        System.out.println("Asientos de la sala:");
        for (int i=0; i<3; i++) {
            String fila = "";
            for (int j=0; j<5; j++) {
                fila += "[" + sala_cine[i][j] + "] ";
            }
            System.out.println(fila);
        }
    }//GEN-LAST:event_btnVerAsientosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVerAsientos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
