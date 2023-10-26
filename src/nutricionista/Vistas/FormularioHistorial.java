package nutricionista.Vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nutricionista.AccesoADatos.DietaData;
import nutricionista.AccesoADatos.HistorialData;
import nutricionista.AccesoADatos.PacienteData;
import nutricionista.Entidades.Dieta;
import nutricionista.Entidades.Historial;
import nutricionista.Entidades.Paciente;

public class FormularioHistorial extends javax.swing.JInternalFrame {

    private List<Paciente> listaP;
    private PacienteData pd;
    private DefaultTableModel modelo;
    private List<Historial> listaH;

    public FormularioHistorial() {
        initComponents();

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        cargarComboPaciente();
        armarCabecera();

        actualizarTabla();

    }

    private void cargarComboPaciente() {
        pd = new PacienteData();
        listaP = pd.listarPacientes();

        for (Paciente item : listaP) {
            jcbPaciente.addItem(item);
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

        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtPesoInicial = new javax.swing.JTextField();
        jtPesoAct = new javax.swing.JTextField();
        jtPesoObjetivo = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtFechaInicial = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jcbPaciente = new javax.swing.JComboBox<>();
        jdcFechaAct = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jtPesoAnt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtFechaAnt = new javax.swing.JTextField();
        jrbEstado = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtHistorial = new javax.swing.JTable();
        jbEliminar = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setClosable(true);

        jLabel1.setText("SEGUIMIENTO POR PACIENTE");

        jLabel2.setText("Paciente");

        jLabel5.setText("Peso Inicial");

        jLabel6.setText("Peso Actual");

        jLabel7.setText("Peso Objetivo");

        jtPesoInicial.setEditable(false);
        jtPesoInicial.setBackground(new java.awt.Color(204, 204, 204));

        jtPesoObjetivo.setEditable(false);
        jtPesoObjetivo.setBackground(new java.awt.Color(204, 204, 204));

        jbGuardar.setText("Guardar ");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jLabel9.setText("Fecha Inicial");

        jtFechaInicial.setEditable(false);
        jtFechaInicial.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setText("Fecha Actual");

        jcbPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPacienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Peso Anterior");

        jtPesoAnt.setEditable(false);
        jtPesoAnt.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setText("Fecha Anterior");

        jtFechaAnt.setEditable(false);
        jtFechaAnt.setBackground(new java.awt.Color(204, 204, 204));

        jrbEstado.setText("Dieta Activa");

        jtHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jtHistorial);

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(jcbPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jrbEstado)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(jtPesoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jtFechaInicial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtFechaAnt, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtPesoAnt)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jdcFechaAct, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtPesoAct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jtPesoObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtPesoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtPesoAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtPesoObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(jLabel10)
                        .addGap(1, 1, 1)
                        .addComponent(jdcFechaAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtPesoAnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtFechaAnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jrbEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPacienteActionPerformed

        limpiarCampos();
        actualizarDatos();
        actualizarTabla();

    }//GEN-LAST:event_jcbPacienteActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        double pesoActual = 0;
        Paciente paciente = (Paciente) jcbPaciente.getSelectedItem();
        try {
            LocalDate fechaActual = jdcFechaAct.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Boolean estado = true;
            if (jrbEstado.isSelected()) {
                estado = true;
            } else {
                String botones[] = {"SI", "NO"};
                int eleccion = JOptionPane.showOptionDialog(this, "Seguro desea dar por FINALIZADA la dieta de este paciente? ", "ALERTA!", 0, 0, null, botones, this);

                if (eleccion == JOptionPane.YES_OPTION) {
                    estado = false;
                } else {
                    JOptionPane.showMessageDialog(null, "Se cancelan las modificaciones");
                    return;
                }
            }

            pesoActual = Double.parseDouble(jtPesoAct.getText());
            Historial historial = new Historial();
            historial.setPaciente(paciente);
            historial.setFechaRegistro(fechaActual);
            historial.setEstado(estado);
            historial.setPeso(pesoActual);

            HistorialData hd = new HistorialData();
            hd.guardarHistorial(historial);

            paciente.setEstado(estado);
            PacienteData pd = new PacienteData();
            pd.actualizarEstado(paciente);

            Dieta dieta = new Dieta();

            dieta.setPesoActual(Double.parseDouble(jtPesoAct.getText()));
            dieta.setFechaActual(jdcFechaAct.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            dieta.setPaciente(paciente);

            DietaData dd = new DietaData();
            dd.actualizarHistorial(dieta);

            //cargarComboPaciente();
            limpiarCampos();
            actualizarDatos();

            actualizarTabla();

        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Debe introducir un peso correcto");
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(null, "No debe haber campos vacios");
        }


    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // Configuracion del boton "ELIMINAR"

        int filaS = jtHistorial.getSelectedRow();
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "Desea ELIMINAR el dato seleccionado?", "ALERTA!", 0, 0, null, botones, this);

        if (eleccion == JOptionPane.YES_OPTION) {
            Paciente paciente = (Paciente) jcbPaciente.getSelectedItem();
            HistorialData hd = new HistorialData();
            listaH = hd.buscarHistorial((Paciente) jcbPaciente.getSelectedItem());
            
            Historial hist = listaH.get(filaS);
            
            hd.eliminarHistorial(hist);
            actualizarDatos();
            actualizarTabla();
        }
        /*
        String botones[] = {"SI", "NO"};
        int eleccion = JOptionPane.showOptionDialog(this, "Desea ELIMINAR esta Comida al Paciente?", "ALERTA!", 0, 0, null, botones, this);

        if (eleccion == JOptionPane.YES_OPTION) {
            Paciente paciente = (Paciente) jcbPaciente.getSelectedItem();
            DietaData dd = new DietaData();
            Dieta dieta = dd.buscarDieta(paciente);

            DietaComidaData dcd = new DietaComidaData();

            List<DietaComida> ldc = dcd.consultaPorPaciente(dieta);

            DietaComida dc = ldc.get(filaS);

            dcd.eliminarDietaComida(dc);
            actualizarTabla();

        }
         */

    }//GEN-LAST:event_jbEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JComboBox<Paciente> jcbPaciente;
    private com.toedter.calendar.JDateChooser jdcFechaAct;
    private javax.swing.JCheckBox jrbEstado;
    private javax.swing.JTextField jtFechaAnt;
    private javax.swing.JTextField jtFechaInicial;
    private javax.swing.JTable jtHistorial;
    private javax.swing.JTextField jtPesoAct;
    private javax.swing.JTextField jtPesoAnt;
    private javax.swing.JTextField jtPesoInicial;
    private javax.swing.JTextField jtPesoObjetivo;
    // End of variables declaration//GEN-END:variables

    public void limpiarCampos() {
        jtPesoInicial.setText("");
        jtFechaInicial.setText("");
        jtPesoAnt.setText("");
        jtPesoAct.setText("");
        jtPesoObjetivo.setText("");
        jtFechaAnt.setText("");
        jdcFechaAct.setDate(null);

    }

    public void actualizarDatos() {

        Paciente paciente = (Paciente) jcbPaciente.getSelectedItem();
        DietaData dd = new DietaData();
        Dieta dieta = new Dieta();
        Dieta dieta2 = new Dieta();
        limpiarCampos();
        DateTimeFormatter nuevoFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {

            dieta = dd.buscarDietaCompleta(paciente);
            jtPesoInicial.setText(dieta.getPesoInicial() + "");
            jtFechaInicial.setText(dieta.getFechaInicial().format(nuevoFormato));
            jtPesoObjetivo.setText(dieta.getPesoFinal() + "");
            jtPesoAnt.setText(dieta.getPesoActual() + "");
            jtFechaAnt.setText(dieta.getFechaActual().format(nuevoFormato));

        } catch (NullPointerException np) {
            dieta2 = dd.buscarDieta(paciente);
            jtPesoInicial.setText(dieta2.getPesoInicial() + "");
            jtFechaInicial.setText(dieta2.getFechaInicial().format(nuevoFormato));
            jtPesoObjetivo.setText(dieta2.getPesoFinal() + "");
            JOptionPane.showMessageDialog(null, "Es el primer control del paciente seleccionado");

        }
    }

    public void actualizarTabla() {

        borrarTabla();
        HistorialData hd = new HistorialData();
        listaH = hd.buscarHistorial((Paciente) jcbPaciente.getSelectedItem());
        DateTimeFormatter nuevoFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {

            for (Historial it : listaH) {
                Object[] fila = new Object[]{it.getPeso(), it.getFechaRegistro().format(nuevoFormato)};
                modelo.addRow(fila);

            }
            jtHistorial.setModel(modelo);

        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(null, "Este paciente no tiene datos historicos");
        }

    }

    public void borrarTabla() {

        int cantfilas = jtHistorial.getRowCount();

        if (cantfilas >= 1) {
            modelo.setNumRows(0);
            jtHistorial.setModel(modelo);
        }

    }

    private void armarCabecera() {

        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Historial de peso");
        filaCabecera.add("Fecha");

        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jtHistorial.setModel(modelo);
    }
}
