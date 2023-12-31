/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Core.Rol;
import javax.swing.JFrame;
import repositorio.ProductoDao;
import repositorio.UsuarioDao;

/**
 *
 * @author losmelli
 */
public class VistaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form VistaAdmin
     */
    public VistaAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        VerEstadisticasButton = new javax.swing.JButton();
        AdministrarInventarioButton = new javax.swing.JButton();
        AñadirUsuariosButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        VerInventarioButton = new javax.swing.JButton();
        CerrarSesionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        VerEstadisticasButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        VerEstadisticasButton.setText("Ver Estadisticas");
        VerEstadisticasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerEstadisticasButtonActionPerformed(evt);
            }
        });

        AdministrarInventarioButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        AdministrarInventarioButton.setText("Administrar Inventario");
        AdministrarInventarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdministrarInventarioButtonActionPerformed(evt);
            }
        });

        AñadirUsuariosButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        AñadirUsuariosButton.setText("Añadir Usuarios");
        AñadirUsuariosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirUsuariosButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Administrador");

        VerInventarioButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        VerInventarioButton.setText("Ver Inventario");
        VerInventarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInventarioButtonActionPerformed(evt);
            }
        });

        CerrarSesionButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CerrarSesionButton.setText("Cerrar Sesion");
        CerrarSesionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CerrarSesionButton)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VerInventarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(AñadirUsuariosButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AdministrarInventarioButton))
                    .addComponent(VerEstadisticasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(177, 177, 177))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CerrarSesionButton))
                .addGap(76, 76, 76)
                .addComponent(AñadirUsuariosButton)
                .addGap(18, 18, 18)
                .addComponent(AdministrarInventarioButton)
                .addGap(18, 18, 18)
                .addComponent(VerInventarioButton)
                .addGap(18, 18, 18)
                .addComponent(VerEstadisticasButton)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AñadirUsuariosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirUsuariosButtonActionPerformed
        JFrame ventana = new Registro(new UsuarioDao());
        ventana.setVisible(true);
    }//GEN-LAST:event_AñadirUsuariosButtonActionPerformed

    private void AdministrarInventarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdministrarInventarioButtonActionPerformed
        JFrame ventana = new AdministrarProducto(new ProductoDao(),Rol.Admin);
        ventana.setVisible(true);
    }//GEN-LAST:event_AdministrarInventarioButtonActionPerformed

    private void VerEstadisticasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerEstadisticasButtonActionPerformed
        JFrame ventana = new VerEstadisticas();
        ventana.setVisible(true);
    }//GEN-LAST:event_VerEstadisticasButtonActionPerformed

    private void VerInventarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerInventarioButtonActionPerformed
        JFrame ventana = new VerInventario();
        ventana.setVisible(true);
    }//GEN-LAST:event_VerInventarioButtonActionPerformed

    private void CerrarSesionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionButtonActionPerformed
        JFrame ventana = new Login();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CerrarSesionButtonActionPerformed

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
            java.util.logging.Logger.getLogger(VistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdministrarInventarioButton;
    private javax.swing.JButton AñadirUsuariosButton;
    private javax.swing.JButton CerrarSesionButton;
    private javax.swing.JButton VerEstadisticasButton;
    private javax.swing.JButton VerInventarioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
