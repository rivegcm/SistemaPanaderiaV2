package escritorios;


import clasesUtilidadGeneral.OperacionesUtiles;
import formularios.FormularioEditarIngresoMateriaPrima;
import formularios.FormularioRegistrarIngresoMateriaPrima;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import operacionesIngresoMateriaPrima.ABMIngresoMateriaPrima;
import operacionesIngresoMateriaPrima.InterfazGraficaFormularioEditarIngresoMateriaPrima;
import operacionesIngresoMateriaPrima.InterfazGraficaFormularioRegistrarIngresoMateriaPrima;
import operacionesIngresoMateriaPrima.TablaIngresoMateriaPrima;

import principal.MaterialButton;

/**
 *
 * @author TELCOM MPC
 */
public class PrincipalIngresoMatPrima extends javax.swing.JInternalFrame {


    public PrincipalIngresoMatPrima() {
        initComponents();
        registrarIngresoMateriaPrima = null;
        editarIngresoMateriaPrima = null;
        popMenu.add(menu);
    }

    
     private InterfazGraficaFormularioRegistrarIngresoMateriaPrima formularioRegistrar;
    private InterfazGraficaFormularioEditarIngresoMateriaPrima formularioEditar;
    private FormularioRegistrarIngresoMateriaPrima registrarIngresoMateriaPrima;
    private FormularioEditarIngresoMateriaPrima editarIngresoMateriaPrima;
    private TablaIngresoMateriaPrima tablaIngresoMateriaPrima;
    private final ABMIngresoMateriaPrima abm = new ABMIngresoMateriaPrima();

    public InterfazGraficaFormularioRegistrarIngresoMateriaPrima getFormularioRegistrar() {
        return formularioRegistrar;
    }

    public void setFormularioRegistrar(InterfazGraficaFormularioRegistrarIngresoMateriaPrima formularioRegistrar) {
        this.formularioRegistrar = formularioRegistrar;
    }

    public InterfazGraficaFormularioEditarIngresoMateriaPrima getFormularioEditar() {
        return formularioEditar;
    }

    public void setFormularioEditar(InterfazGraficaFormularioEditarIngresoMateriaPrima formularioEditar) {
        this.formularioEditar = formularioEditar;
    }

    public FormularioRegistrarIngresoMateriaPrima getRegistrarIngresoMateriaPrima() {
        return registrarIngresoMateriaPrima;
    }

    public void setRegistrarIngresoMateriaPrima(FormularioRegistrarIngresoMateriaPrima registrarIngresoMateriaPrima) {
        this.registrarIngresoMateriaPrima = registrarIngresoMateriaPrima;
    }

    public FormularioEditarIngresoMateriaPrima getEditarIngresoMateriaPrima() {
        return editarIngresoMateriaPrima;
    }

    public void setEditarIngresoMateriaPrima(FormularioEditarIngresoMateriaPrima editarIngresoMateriaPrima) {
        this.editarIngresoMateriaPrima = editarIngresoMateriaPrima;
    }

    public TablaIngresoMateriaPrima getTablaIngresoMateriaPrima() {
        return tablaIngresoMateriaPrima;
    }

    public void setTablaIngresoMateriaPrima(TablaIngresoMateriaPrima tablaIngresoMateriaPrima) {
        this.tablaIngresoMateriaPrima = tablaIngresoMateriaPrima;
    }
    
    
    
    
    
    
    
    
    public JTable getTabla() {
        return tablaGrafica;
    }

    public void setTabla(JTable tabla) {
        this.tablaGrafica = tabla;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JTable getTablaGrafica() {
        return tablaGrafica;
    }

    public void setTablaGrafica(JTable tablaGrafica) {
        this.tablaGrafica = tablaGrafica;
    }

     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        popMenu = new javax.swing.JPopupMenu();
        panelPrincipalTop = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGrafica = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        btnReporte = new principal.MaterialButton();
        btnEditar = new principal.MaterialButton();
        btnEliminar = new principal.MaterialButton();

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panelPrincipalTop.setBackground(new java.awt.Color(204, 0, 0));

        txtBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        tablaGrafica.setBackground(new java.awt.Color(255, 255, 255));
        tablaGrafica.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tablaGrafica.setForeground(new java.awt.Color(102, 0, 0));
        tablaGrafica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATERIA PRIMA", "TOTAL ENVASES", "UNIDADES POR ENVASE", "UNIDAD DE MEDIDA", "TOTAL GASTADO", "FECHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaGrafica.setComponentPopupMenu(popMenu);
        tablaGrafica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaGrafica.setDoubleBuffered(true);
        tablaGrafica.setRowHeight(40);
        tablaGrafica.setSelectionBackground(new java.awt.Color(102, 0, 0));
        tablaGrafica.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaGrafica.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaGrafica.getTableHeader().setReorderingAllowed(false);
        tablaGrafica.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                tablaGraficaComponentHidden(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGrafica);
        if (tablaGrafica.getColumnModel().getColumnCount() > 0) {
            tablaGrafica.getColumnModel().getColumn(0).setResizable(false);
            tablaGrafica.getColumnModel().getColumn(1).setResizable(false);
            tablaGrafica.getColumnModel().getColumn(2).setResizable(false);
            tablaGrafica.getColumnModel().getColumn(3).setResizable(false);
            tablaGrafica.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1393, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Flour of Rye_80px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("INGRESO MATERIA PRIMA");

        lblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_60px.png"))); // NOI18N
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(565, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(34, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16)))
        );

        btnReporte.setBackground(new java.awt.Color(0,0,0,60));
        btnReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte.setText("GENERAR REPORTE");
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(0,0,0,60));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0,0,0,60));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalTopLayout = new javax.swing.GroupLayout(panelPrincipalTop);
        panelPrincipalTop.setLayout(panelPrincipalTopLayout);
        panelPrincipalTopLayout.setHorizontalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPrincipalTopLayout.setVerticalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tablaGraficaComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tablaGraficaComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaGraficaComponentHidden


    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed

    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        tablaIngresoMateriaPrima.setPrincipalIngresoMateriaPrima(this);
        if (tablaIngresoMateriaPrima.verificarFilaSeleccionada()) {
            formularioEditar.setPrincipalIngresoMateriaPrima(this);
            formularioEditar.nuevoFormularioEditar();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        abm.setPrincipalIngresoMateriaPrima(this);
        tablaIngresoMateriaPrima.setPrincipalIngresoMateriaPrima(this);
        if (tablaIngresoMateriaPrima.verificarFilaSeleccionada()) {
            if (OperacionesUtiles.mensajeEliminarRegistro()) {
                if (abm.ejecutarEliminar()) {
                    tablaIngresoMateriaPrima.setEstadoConsulta(0);
                    tablaIngresoMateriaPrima.ejecutarRellenarTabla();
                }
            }

        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblSalirMouseClicked

    public JPanel getPanelPrincipalTop() {
        return panelPrincipalTop;
    }

    public void setPanelPrincipalTop(JPanel panelPrincipalTop) {
        this.panelPrincipalTop = panelPrincipalTop;
    }


 

    public MaterialButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(MaterialButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public MaterialButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(MaterialButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton btnEditar;
    private principal.MaterialButton btnEliminar;
    private principal.MaterialButton btnReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel panelPrincipalTop;
    private javax.swing.JPopupMenu popMenu;
    private javax.swing.JTable tablaGrafica;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}