/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Core.Producto;
import Core.Venta;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author losmelli
 */
public class VerProductosEstadistica extends javax.swing.JFrame {

    private Venta venta;

    public VerProductosEstadistica(Venta venta) {
        initComponents();
        this.venta = venta;
        cargarDatosTabla();
    }

    private void cargarDatosTabla() {
        List<Producto> lista = new ArrayList<>();
        lista = venta.getProductos();
        DefaultTableModel modelo = (DefaultTableModel) TablaDatos.getModel();
        for (Producto p : lista) {
            Vector<Object> vector = new Vector<>();              
            if(p.getActivo()==0) vector.add("NO Existente");
            else vector.add("Existente");
            vector.add(p.getId());
            vector.add(p.getNombre());
            vector.add(p.getMarca());
            vector.add(p.getPrecio());
            vector.add(p.getCantidad());
            modelo.addRow(vector);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(695, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(695, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Productos de la Venta");

        DefaultTableModel modelo =  new DefaultTableModel();
        String columnas[] = {"Estado","Cod Barra","Nombre","Marca","Precio","Cantidad"};
        modelo.setColumnIdentifiers(columnas);
        TablaDatos.setModel(modelo);
        TablaDatos.setEnabled(false);
        jScrollPane2.setViewportView(TablaDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
