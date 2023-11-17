package nutricionista.Vistas;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import nutricionista.AccesoADatos.DietaData;
import nutricionista.AccesoADatos.PacienteData;
import nutricionista.Entidades.Dieta;
import nutricionista.Entidades.Paciente;

public class FormularioPaciente extends javax.swing.JInternalFrame {
    
    Calendar fechaActual=new GregorianCalendar();

    public FormularioPaciente() {
        initComponents();
        
        jdFechaInicial.setCalendar(fechaActual);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtDNI = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtDomicilio = new javax.swing.JTextField();
        jtCelular = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();
        jtModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jrbEstado = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtPesoObj = new javax.swing.JTextField();
        jdFechaInicial = new com.toedter.calendar.JDateChooser();
        jtPesoInicial = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jdFechaFin = new com.toedter.calendar.JDateChooser();

        setClosable(true);

        jLabel1.setText("Nombre");

        jLabel2.setText("DNI");

        jLabel3.setText("Domicilio");

        jLabel4.setText("Celular");

        jtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDNIActionPerformed(evt);
            }
        });

        jtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCelularActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("PACIENTE");

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jtModificar.setText("Modificar");
        jtModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtModificarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jLabel6.setText("Estado");

        jLabel7.setText("Peso Inicial");

        jLabel8.setText("Fecha Inicial");

        jLabel9.setText("Peso Objetivo");

        jtPesoObj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPesoObjActionPerformed(evt);
            }
        });

        jdFechaInicial.setEnabled(false);

        jtPesoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPesoInicialActionPerformed(evt);
            }
        });

        jLabel10.setText("Fecha Objetivo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(202, 202, 202))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtDomicilio, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtDNI))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbBuscar)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jrbEstado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtPesoInicial, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdFechaInicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                    .addComponent(jtPesoObj, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtCelular, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap(97, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jdFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbLimpiar)
                                .addGap(18, 18, 18)
                                .addComponent(jbSalir)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscar)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbEstado))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtPesoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jdFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtPesoObj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jdFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jtModificar)
                    .addComponent(jbEliminar)
                    .addComponent(jbSalir)
                    .addComponent(jbLimpiar))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        Boolean estado = false;

        try {

            int dni = Integer.parseInt(jtDNI.getText());
            String nombre = jtNombre.getText();
            String domicilio = jtDomicilio.getText();
            String celular = jtCelular.getText();

            if (jrbEstado.isSelected()) {
                estado = true;
            }

            Paciente paci = new Paciente(dni, nombre, domicilio, celular, estado);
            // JOptionPane.showMessageDialog(null, "Paciente creado Localmente");

            PacienteData pacientedata = new PacienteData();

            Dieta dieta = new Dieta();

            dieta.setPesoInicial(Double.parseDouble(jtPesoInicial.getText()));
          //  dieta.setFechaInicial(jdFechaInicial.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            dieta.setPesoFinal(Double.parseDouble(jtPesoObj.getText()));
            dieta.setFechaFinal(jdFechaFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

            pacientedata.guardarPaciente(paci);
            dieta.setPaciente(paci);
            DietaData dd = new DietaData();
            dd.guardarDieta(dieta);
            limpiarCampos();
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Error en los campos numéricos");
        }


    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDNIActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // Configuracion del boton "SALIR"

        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        //Configuracion del boton "BUSCAR"
        PacienteData pd = new PacienteData();
        Paciente paciente = new Paciente();
        Dieta dieta = new Dieta();
        DietaData dd = new DietaData();

        try {
            Integer dni = Integer.parseInt(jtDNI.getText());
            paciente = pd.buscarPaciente(dni);
            dieta = dd.buscarDieta(paciente);

            if (paciente != null) {
                jtNombre.setText(paciente.getNombre());
                jtDomicilio.setText(paciente.getDomicilio());
                jtCelular.setText(paciente.getTelefono());
                jrbEstado.setSelected(paciente.isEstado());
                jtPesoInicial.setText(dieta.getPesoInicial() + "");
                jtPesoObj.setText(dieta.getPesoFinal() + "");
                LocalDate lci = dieta.getFechaInicial();
                LocalDate lcf = dieta.getFechaFinal();
                Date dateF = Date.from(lcf.atStartOfDay(ZoneId.systemDefault()).toInstant());

                Date dateI = Date.from(lci.atStartOfDay(ZoneId.systemDefault()).toInstant());
                jdFechaInicial.setDate(dateI);

                jdFechaFin.setDate(dateF);

            }
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un documento válido");
            limpiarCampos();
        }catch(NullPointerException np){
            JOptionPane.showMessageDialog(null, "Este paciente no tiene dieta iniciada");
        }


    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jtModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtModificarActionPerformed
        //Configuración del botón "MODIFICAR"
        try {

            Paciente paciente = new Paciente();
            paciente.setDni(Integer.parseInt(jtDNI.getText()));
            paciente.setDomicilio(jtDomicilio.getText());
            paciente.setEstado(jrbEstado.isSelected());
            paciente.setNombre(jtNombre.getText());
            paciente.setTelefono(jtCelular.getText());

            PacienteData pd = new PacienteData();
            pd.actualizarPaciente(paciente);

            int dni = paciente.getDni();
            paciente = pd.buscarPaciente(dni);

            Dieta dieta = new Dieta();
            dieta.setFechaInicial(jdFechaInicial.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            dieta.setPesoInicial(Double.parseDouble(jtPesoInicial.getText()));
            dieta.setPesoFinal(Double.parseDouble(jtPesoObj.getText()));
            dieta.setPaciente(paciente);
            dieta.setFechaFinal(jdFechaFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

            DietaData dd = new DietaData();
            dd.actualizarDieta(dieta);

            limpiarCampos();
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Debe introducir caracteres correctos" + nf);
        }
    }//GEN-LAST:event_jtModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // Configuracion del botón "ELIMINAR"
        Paciente paciente = new Paciente();

        try {

            Integer dni = Integer.parseInt(jtDNI.getText());

            String botones[] = {"SI", "NO"};
            int eleccion = JOptionPane.showOptionDialog(this, "Desea ELIMINAR este Paciente? (si tiene dieta asignada, tambien se eliminará)", "ALERTA!", 0, 0, null, botones, this);

            if (eleccion == JOptionPane.YES_OPTION) {
                PacienteData pd = new PacienteData();
                DietaData dd = new DietaData();

                paciente = pd.buscarPaciente(dni);

                dd.eliminarDieta(paciente.getIdPaciente());
                pd.eliminarPaciente(dni);
                limpiarCampos();

            } else {
                JOptionPane.showMessageDialog(null, "Paciente no Eliminado");
                limpiarCampos();
            }

        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un documento válido");
            limpiarCampos();

    }//GEN-LAST:event_jbEliminarActionPerformed
    }

    private void jtPesoObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPesoObjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPesoObjActionPerformed

    private void jtPesoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPesoInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPesoInicialActionPerformed

    private void jtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCelularActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JDateChooser jdFechaFin;
    private com.toedter.calendar.JDateChooser jdFechaInicial;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTextField jtCelular;
    private javax.swing.JTextField jtDNI;
    private javax.swing.JTextField jtDomicilio;
    private javax.swing.JButton jtModificar;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPesoInicial;
    private javax.swing.JTextField jtPesoObj;
    // End of variables declaration//GEN-END:variables

    public static boolean esNumerico(String cadena) {
        return cadena.matches("\\d+");
    }

    public void limpiarCampos() {
        jtDNI.setText("");
        jtNombre.setText("");
        jtDomicilio.setText("");
        jtCelular.setText("");
        jrbEstado.setSelected(false);
        jtPesoObj.setText("");
        jtPesoInicial.setText("");
        jdFechaInicial.setDate(null);
        jdFechaFin.setDate(null);

    }
}
