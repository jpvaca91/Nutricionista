/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionista.Vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import nutricionista.AccesoADatos.ComidaData;
import nutricionista.AccesoADatos.DietaComidaData;
import nutricionista.AccesoADatos.DietaData;
import nutricionista.Entidades.HorarioEspecifico;
import nutricionista.AccesoADatos.PacienteData;
import nutricionista.Entidades.Comida;
import nutricionista.Entidades.Dieta;
import nutricionista.Entidades.DietaComida;
import nutricionista.Entidades.Historial;
import nutricionista.Entidades.Paciente;

/**
 *
 * @author vico_
 */
public class FormularioDietaComida extends javax.swing.JInternalFrame {

    private PacienteData pd;
    private Paciente paciSeleccionado;
    private ComidaData cd;
    private HorarioEspecifico ed;
    private DefaultTableModel modelo;
    private List<Paciente> listaP;
    private List<Comida> listaC;

    public FormularioDietaComida() {
        initComponents();
        llenarComboHorario();
        pd = new PacienteData();
        listaP = pd.listarPacientes();
        modelo = new DefaultTableModel();
        cd = new ComidaData();
        listaC = cd.listarComidas();
        // ed  = new HorarioEspecificoData();

        cargarComboPaciente();
        cargarComboComida();
        armarCabecera();
    }

    private void cargarComboPaciente() {

        for (Paciente item : listaP) {
            jcbPaciente.addItem(item);
        }
    }

    private void cargarComboComida() {

        for (Comida item : listaC) {
            jcbComidas.addItem(item);

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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbPaciente = new javax.swing.JComboBox<>();
        jbBuscar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jcbComidas = new javax.swing.JComboBox<>();
        jcbHorario = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();

        jLabel1.setText("DIETA COMIDA");

        jLabel2.setText("Paciente");

        jLabel4.setText("Comidas");

        jcbPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPacienteActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");

        jbModificar.setText("Modificar");

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jcbComidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbComidasActionPerformed(evt);
            }
        });

        jcbHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbHorarioActionPerformed(evt);
            }
        });

        jLabel5.setText("Horario");

        jLabel6.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel6.setText("(Asignacion de comidas a la dieta)");

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtTabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(jLabel6)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbModificar)
                        .addGap(71, 71, 71)
                        .addComponent(jbEliminar)
                        .addGap(80, 80, 80)
                        .addComponent(jbSalir)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jcbComidas, javax.swing.GroupLayout.Alignment.LEADING, 0, 273, Short.MAX_VALUE)
                            .addComponent(jcbPaciente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbHorario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscar)))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jcbComidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jcbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificar)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar)
                    .addComponent(jbSalir))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbHorarioActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jcbHorarioActionPerformed

    private void jcbPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPacienteActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcbComidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbComidasActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jcbComidasActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        Paciente paciente = (Paciente) jcbPaciente.getSelectedItem();
        Comida comida = (Comida) jcbComidas.getSelectedItem();
        HorarioEspecifico horario = (HorarioEspecifico) jcbHorario.getSelectedItem();

        //ComidaData cd = new ComidaData();
        DietaData dd = new DietaData();
        Dieta dieta = dd.buscarDieta(paciente);

        DietaComida dietaComida = new DietaComida();
        dietaComida.setComida(comida);
        dietaComida.setDieta(dieta);
        dietaComida.setHorario(horario);

        DietaComidaData dcd = new DietaComidaData();
        dcd.GuardarDietaComida(dietaComida);
    }//GEN-LAST:event_jbGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Comida> jcbComidas;
    private javax.swing.JComboBox<HorarioEspecifico> jcbHorario;
    private javax.swing.JComboBox<Paciente> jcbPaciente;
    private javax.swing.JTable jtTabla;
    // End of variables declaration//GEN-END:variables

    public void llenarComboHorario() {

        jcbHorario.setModel(new DefaultComboBoxModel<>(HorarioEspecifico.values()));
    }

    private void armarCabecera() {

        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Horario");
        filaCabecera.add("Comida");
        filaCabecera.add("Detalle");
        filaCabecera.add("Calorias");

        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jtTabla.setModel(modelo);
    }

    private void cargarComidas() {
        Comida select = (Comida) jcbComidas.getSelectedItem();
        listaC = cd.comidasAsignadas(select.getIdComidas());
        /*for (Materia m : listaM) {
            modelo.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getAnioMateria()});
        }*/

    }

}
