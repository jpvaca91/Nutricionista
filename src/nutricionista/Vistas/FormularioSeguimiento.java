package nutricionista.Vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import nutricionista.AccesoADatos.ComidaData;
import nutricionista.AccesoADatos.DietaData;
import nutricionista.AccesoADatos.PacienteData;
import nutricionista.Entidades.Comida;
import nutricionista.Entidades.Dieta;
import nutricionista.Entidades.Paciente;

public class FormularioSeguimiento extends javax.swing.JInternalFrame {

    private PacienteData pd;
    private ComidaData cd;
    private DefaultTableModel modelo;
    private List<Dieta> listaD;

    public FormularioSeguimiento() {
        initComponents();
        modelo = new DefaultTableModel();
        armarCabecera();

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
        jrbFinalizadas = new javax.swing.JRadioButton();
        jrbTodas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla2 = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("SEGUIMIENTO DE DIETAS");

        jrbActivas.setText("Dietas Activas");
        jrbActivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbActivasActionPerformed(evt);
            }
        });

        jrbFinalizadas.setText("Dietas Finalizadas");
        jrbFinalizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFinalizadasActionPerformed(evt);
            }
        });

        jrbTodas.setText("Todas las dietas");
        jrbTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTodasActionPerformed(evt);
            }
        });

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
        jtTabla2.setEnabled(false);
        jtTabla2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jtTabla2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jrbActivas)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrbFinalizadas)
                                .addGap(18, 18, 18)
                                .addComponent(jrbTodas)))))
                .addGap(0, 23, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbActivas)
                    .addComponent(jrbFinalizadas)
                    .addComponent(jrbTodas))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed

        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jrbActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbActivasActionPerformed
        // Listar dietas activas
        jrbFinalizadas.setSelected(false);
        jrbTodas.setSelected(false);
        actualizarTablaActivas();
        

    }//GEN-LAST:event_jrbActivasActionPerformed

    private void jrbFinalizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFinalizadasActionPerformed
        // Listar dietas terminadas
        jrbActivas.setSelected(false);
        jrbTodas.setSelected(false);
        actualizarTablaInactivas();
    }//GEN-LAST:event_jrbFinalizadasActionPerformed

    private void jtTabla2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jtTabla2AncestorAdded
        // TODO add your handling code here:
        // private void armarCabecera() {


    }//GEN-LAST:event_jtTabla2AncestorAdded

    private void jrbTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTodasActionPerformed
        // TODO add your handling code here:
        jrbActivas.setSelected(false);
        jrbFinalizadas.setSelected(false);
        actualizarTablaCompleta();


    }//GEN-LAST:event_jrbTodasActionPerformed
   
    public void actualizarTablaCompleta() {
        borrarTabla();
        DietaData dd = new DietaData();
        listaD = dd.listarTodasLasDietas();

        for (Dieta obj : listaD) {

            Object[] fila = new Object[]{obj.getPaciente().getNombre(), obj.getFechaActual(), obj.getPesoInicial(), obj.getPesoFinal(), obj.getPesoActual(), obj.getFechaFinal()};
            modelo.addRow(fila);

        }
        jtTabla2.setModel(modelo);

    }

    public void actualizarTablaActivas() {
        borrarTabla();
        DietaData dd = new DietaData();
        listaD = dd.listarDietasActivas();

        for (Dieta obj : listaD) {

            Object[] fila = new Object[]{obj.getPaciente().getNombre(), obj.getFechaActual(), obj.getPesoInicial(), obj.getPesoFinal(), obj.getPesoActual(), obj.getFechaFinal()};
            modelo.addRow(fila);

        }
        jtTabla2.setModel(modelo);

    }

     public void actualizarTablaInactivas() {
        borrarTabla();
        DietaData dd = new DietaData();
        listaD = dd.listarDietasInactivas();

        for (Dieta obj : listaD) {

            Object[] fila = new Object[]{obj.getPaciente().getNombre(), obj.getFechaActual(), obj.getPesoInicial(), obj.getPesoFinal(), obj.getPesoActual(), obj.getFechaFinal()};
            modelo.addRow(fila);

        }
        jtTabla2.setModel(modelo);

    }
     
    public void borrarTabla() {

        int cantfilas = jtTabla2.getRowCount();

        if (cantfilas >= 1) {
            modelo.setNumRows(0);

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrbActivas;
    private javax.swing.JRadioButton jrbFinalizadas;
    private javax.swing.JRadioButton jrbTodas;
    private javax.swing.JTable jtTabla2;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {

        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Paciente");
        filaCabecera.add("Ult. Consulta");
        filaCabecera.add("Peso Inicial");
        filaCabecera.add("Peso Objetivo");
        filaCabecera.add("Ult. Peso");
        filaCabecera.add("Fecha Objetivo");

        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jtTabla2.setModel(modelo);

    }
}
