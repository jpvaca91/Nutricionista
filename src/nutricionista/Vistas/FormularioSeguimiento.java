/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionista.Vistas;

/**
 *
 * @author vico_
 */
public class FormularioSeguimiento extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioSeguimiento
     */
    public FormularioSeguimiento() {
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

        jLabel1 = new javax.swing.JLabel();
        jrbActivas = new javax.swing.JRadioButton();
        jrbTerminadas = new javax.swing.JRadioButton();
        jrbTodas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla2 = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();

        jLabel1.setText("Seguimientos");

        jrbActivas.setText("Dietas Activas");
        jrbActivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbActivasActionPerformed(evt);
            }
        });

        jrbTerminadas.setText("Dietas Terminadas");

        jrbTodas.setText("Todas las dietas");

        jtTabla2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtTabla2);

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbSalir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jrbActivas)
                                    .addGap(37, 37, 37)
                                    .addComponent(jrbTerminadas))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(163, 163, 163)
                                    .addComponent(jLabel1)))
                            .addGap(39, 39, 39)
                            .addComponent(jrbTodas))))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbActivas)
                    .addComponent(jrbTerminadas)
                    .addComponent(jrbTodas))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
                          
        dispose();        
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jrbActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbActivasActionPerformed
        // Listar dietas activas
    }//GEN-LAST:event_jrbActivasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrbActivas;
    private javax.swing.JRadioButton jrbTerminadas;
    private javax.swing.JRadioButton jrbTodas;
    private javax.swing.JTable jtTabla2;
    // End of variables declaration//GEN-END:variables
}