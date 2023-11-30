/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyectodesupermercado.Vista;

/**
 *
 * @author DELL
 */
public class PanelPuntoDeVenta extends javax.swing.JPanel {

    /**
     * Creates new form PanelPuntoDeVenta
     */
    public PanelPuntoDeVenta() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonEliminarProducto1 = new javax.swing.JButton();
        botonEliminarProducto3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        botonVerPendientes = new javax.swing.JButton();
        botonVerEstadoEditores = new javax.swing.JButton();
        botonCrearTransaccion = new javax.swing.JButton();
        botonCancelarActual = new javax.swing.JButton();
        botonAnadirProducto = new javax.swing.JButton();
        botonEliminarProducto2 = new javax.swing.JButton();
        botonConfirmarPedido = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaVentas = new javax.swing.JTable();
        labelPuntodeVenta = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();

        botonEliminarProducto1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonEliminarProducto1.setText("Eliminar Producto");

        botonEliminarProducto3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonEliminarProducto3.setText("Eliminar Producto");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Punto de Venta");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        botonVerPendientes.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonVerPendientes.setText("Ver Pendientes");

        botonVerEstadoEditores.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonVerEstadoEditores.setText("<html> Ver Estado <br>de Editores <html>"); // NOI18N
        botonVerEstadoEditores.setActionCommand("Ver Estado de Editores");
        botonVerEstadoEditores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerEstadoEditoresActionPerformed(evt);
            }
        });

        botonCrearTransaccion.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonCrearTransaccion.setText("Crear Transaccion");

        botonCancelarActual.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonCancelarActual.setText("Cancelar Pedudo");
        botonCancelarActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActualActionPerformed(evt);
            }
        });

        botonAnadirProducto.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonAnadirProducto.setText("Añadir Porducto");

        botonEliminarProducto2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonEliminarProducto2.setText("Eliminar Producto");

        botonConfirmarPedido.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonConfirmarPedido.setText("Confirmar Pedido");

        TablaVentas.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        TablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Impuestos", "Total"
            }
        ));
        jScrollPane2.setViewportView(TablaVentas);

        jScrollPane3.setViewportView(jScrollPane2);

        labelPuntodeVenta.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelPuntodeVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPuntodeVenta.setText("Punto de Venta");
        labelPuntodeVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelPuntodeVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        LabelTotal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        LabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTotal.setText("Total:");
        LabelTotal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        LabelTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LabelTotal.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        LabelTotal.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(botonCrearTransaccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonVerPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(botonCancelarActual))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonConfirmarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addGap(126, 126, 126)
                                .addComponent(LabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botonVerEstadoEditores, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonEliminarProducto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(botonAnadirProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelPuntodeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonVerPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonVerEstadoEditores, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonCrearTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEliminarProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelPuntodeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonConfirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCancelarActual, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(10, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCancelarActualActionPerformed

    private void botonVerEstadoEditoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerEstadoEditoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonVerEstadoEditoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JTable TablaVentas;
    private javax.swing.JButton botonAnadirProducto;
    private javax.swing.JButton botonCancelarActual;
    private javax.swing.JButton botonConfirmarPedido;
    private javax.swing.JButton botonCrearTransaccion;
    private javax.swing.JButton botonEliminarProducto1;
    private javax.swing.JButton botonEliminarProducto2;
    private javax.swing.JButton botonEliminarProducto3;
    private javax.swing.JButton botonVerEstadoEditores;
    private javax.swing.JButton botonVerPendientes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelPuntodeVenta;
    // End of variables declaration//GEN-END:variables
}
