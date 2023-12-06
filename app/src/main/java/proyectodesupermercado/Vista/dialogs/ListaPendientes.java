/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyectodesupermercado.Vista.dialogs;

import proyectodesupermercado.Vista.ReportInView;
import proyectodesupermercado.Vista.interfaces.ControlListaPendientes;
import proyectodesupermercado.Vista.interfaces.DialogSource;
import proyectodesupermercado.Vista.interfaces.SesionUsuario;
import proyectodesupermercado.lib.tableModel.ObjectTableModel;
import proyectodesupermercado.modelo.NotificacionPendiente;

import javax.naming.ldap.Control;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SwingUtilities;
import javax.swing.table.TableRowSorter;
import java.util.List;
import java.util.Optional;

/**
 * @author cheerio-pixel
 */
public class ListaPendientes extends javax.swing.JDialog {

    /**
     * Creates new form ListaPendientes
     */
    public ListaPendientes(JComponent component, boolean modal,
                           ControlListaPendientes accionesListaPendientes,
                           SesionUsuario sesionUsuario,
                           DialogSource<List<NotificacionPendiente>> source) {
        super((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, component), modal);
        setLocationRelativeTo(component);

        initComponents();
        pack();
        this.source = source;
        this.accionesListaPendientes = accionesListaPendientes;
        this.sesionUsuario = sesionUsuario;

        refreshModel(accionesListaPendientes.pullNotifications(sesionUsuario.getLoggedUser()));
        sorter = new TableRowSorter<>(mainModel);
        mainTable.setRowSorter(sorter);
        // Remueve el renderizador de columna
        // mainTable.setTableHeader(null);
    }

    private SesionUsuario sesionUsuario;
    private ControlListaPendientes accionesListaPendientes;
    private ObjectTableModel<NotificacionPendiente> mainModel;
    private TableRowSorter<ObjectTableModel<NotificacionPendiente>> sorter;
    private DialogSource<List<NotificacionPendiente>> source;

    private void refreshModel(ObjectTableModel<NotificacionPendiente> model) {
        mainTable.setModel(mainModel = model);
    }

    private void close() {
        setVisible(false);
        dispose();
    }

    private void doSearch() {
        RowFilter<ObjectTableModel<NotificacionPendiente>, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter("(?i)" + busquedaTextfield.getText(), 0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cerrarButton = new javax.swing.JButton();
        solicitarButton = new javax.swing.JButton();
        busquedaTextfield = new javax.swing.JTextField();
        buscarBoton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();

        cerrarButton.setText("Cerrar");
        cerrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarButtonActionPerformed(evt);
            }
        });

        solicitarButton.setText("Solicitar");
        solicitarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitarButtonActionPerformed(evt);
            }
        });

        busquedaTextfield.setColumns(9);
        busquedaTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaTextfieldActionPerformed(evt);
            }
        });

        buscarBoton.setText("Buscar");
        buscarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBotonActionPerformed(evt);
            }
        });

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        mainTable.setTableHeader(null);
        jScrollPane2.setViewportView(mainTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(cerrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(solicitarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(busquedaTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                                .addComponent(buscarBoton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(busquedaTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buscarBoton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cerrarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(solicitarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarButtonActionPerformed
        close();
    }//GEN-LAST:event_cerrarButtonActionPerformed

    private void busquedaTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaTextfieldActionPerformed
        doSearch();
    }//GEN-LAST:event_busquedaTextfieldActionPerformed

    private void buscarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBotonActionPerformed
        doSearch();
    }//GEN-LAST:event_buscarBotonActionPerformed

    private void solicitarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitarButtonActionPerformed
        Optional<String> error = source.accept(
                accionesListaPendientes.getSelected()
        );
        if (error.isPresent()) {
            ReportInView.error(this, error.get());
        } else {
            close();
        }
    }//GEN-LAST:event_solicitarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarBoton;
    private javax.swing.JTextField busquedaTextfield;
    private javax.swing.JButton cerrarButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable mainTable;
    private javax.swing.JButton solicitarButton;
    // End of variables declaration//GEN-END:variables
}
