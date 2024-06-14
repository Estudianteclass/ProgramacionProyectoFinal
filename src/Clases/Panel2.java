package Clases;

import java.awt.Color;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Panel2 extends javax.swing.JFrame {

    private String[] columnas = {"DNI", "Nombre", "Apellidos", "Dirección", "Fecha de alta", "Monitor", "Clase"};
    private DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
    private ClienteDAO gestion = new ClienteDAO();
    private ArrayList<Object[]> datos = new ArrayList<>();
    private String opcion;

    public Panel2() {
        initComponents();
        cargar();
        opcion = "insertar";
    }

    private void cargar() {
        datos = gestion.mostrarTodos();
        modelo.setNumRows(0);
        for (Object[] dato : datos) {
            modelo.addRow(dato);
        }
        tabla.setModel(modelo);
    }

    private void Visible(boolean bo) {
        campoApellidos.setVisible(bo);
        campoClase.setVisible(bo);
        campoDNI.setVisible(bo);
        campoDireccion.setVisible(bo);
        campoFecha.setVisible(bo);
        campoMonitor.setVisible(bo);
        campoNombre.setVisible(bo);
        labelApellidos.setVisible(bo);
        labelClase.setVisible(bo);
        labelDNI.setVisible(bo);
        labelDireccion.setVisible(bo);
        labelFecha.setVisible(bo);
        labelMonitor.setVisible(bo);
        labelNom.setVisible(bo);

    }

    private void insertar() {
        if (!campoFecha.getText().isEmpty()) {
            Visible(true);
            Cliente inserta = new Cliente(campoDNI.getText(),
                    campoNombre.getText(), campoApellidos.getText(), campoDireccion.getText(),
                    Date.valueOf(campoFecha.getText()),
                    campoMonitor.getText(),
                    campoClase.getText());

            if (gestion.create(inserta) == true) {
                jLabel1mensajes.setText("Cliente insertado");
                cargar();
                campoDNI.setText("");
                campoNombre.setText("");
                campoApellidos.setText("");
                campoDireccion.setText("");
                campoFecha.setText("");
                campoMonitor.setText("");
                campoClase.setText("");
                jLabel1mensajes.setForeground(Color.green);
                jLabel1mensajes.setText("Cliente insertado");
            } else {
                jLabel1mensajes.setForeground(Color.red);
                jLabel1mensajes.setText("No se ha podido insertar el cliente");
            }
        } else {
            jLabel1mensajes.setForeground(Color.red);
            jLabel1mensajes.setText("No se ha podido insertar el cliente");
        }
    }

    private void actualiza() {

        Cliente actualiza = new Cliente(campoDNI.getText(), campoMonitor.getText(), campoDireccion.getText(), campoClase.getText());
        boolean actualizar = gestion.update(actualiza);
        if (actualizar != false) {
            jLabel1mensajes.setForeground(Color.green);
            jLabel1mensajes.setText("Cliente actualizado");
            campoDNI.setText("");
            campoDireccion.setText("");
            campoMonitor.setText("");
            campoClase.setText("");

        } else {
            jLabel1mensajes.setForeground(Color.red);
            jLabel1mensajes.setText("No se podido ha actualizar el cliente");

        }
        cargar();

    }

    private void busca() {
        Cliente buscar = gestion.read(campoDNI.getText());
        if (buscar != null) {
            Object[] cliente = new Object[7];
            cliente[0] = buscar.getIdCliente();
            cliente[1] = buscar.getNombre();
            cliente[2] = buscar.getApellidos();
            cliente[3] = buscar.getDireccion();
            cliente[4] = (Object) buscar.getFechaInscripcion();
            cliente[5] = buscar.getNomEntrenador();
            cliente[6] = buscar.getClase();
            modelo.setNumRows(0);
            modelo.addRow(cliente);
            tabla.setModel(modelo);

        } else {
            jLabel1mensajes.setForeground(Color.red);
            jLabel1mensajes.setText("Cliente no encontrado");

        }
    }

    private void borrar() {

        Boolean borrar = gestion.delete(campoDNI.getText());
        if (borrar != false) {
            jLabel1mensajes.setForeground(Color.green);
            jLabel1mensajes.setText("Cliente borrado");
            campoDNI.setText("");
            campoNombre.setText("");
            campoApellidos.setText("");
            campoDireccion.setText("");
            campoFecha.setText("");
            campoMonitor.setText("");
            campoClase.setText("");
            cargar();
        } else {
            jLabel1mensajes.setForeground(Color.red);
            jLabel1mensajes.setText("No se ha podido borrar el cliente.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelNom = new javax.swing.JLabel();
        labelApellidos = new javax.swing.JLabel();
        labelDNI = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        labelMonitor = new javax.swing.JLabel();
        labelClase = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        campoApellidos = new javax.swing.JTextField();
        campoDNI = new javax.swing.JTextField();
        campoDireccion = new javax.swing.JTextField();
        campoFecha = new javax.swing.JTextField();
        campoMonitor = new javax.swing.JTextField();
        campoClase = new javax.swing.JTextField();
        busca = new javax.swing.JButton();
        inserta = new javax.swing.JButton();
        borra = new javax.swing.JButton();
        actualiza = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1mensajes = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNom.setText("Nombre:");

        labelApellidos.setText("Apellidos:");

        labelDNI.setText("DNI:");

        labelDireccion.setText("Dirección:");

        labelFecha.setText("Fecha de alta (AAAA-MM-DD):");

        labelMonitor.setText("Monitor:");

        labelClase.setText("Clase:");

        campoDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDNIActionPerformed(evt);
            }
        });

        busca.setText("Buscar");
        busca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscaMouseClicked(evt);
            }
        });
        busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaActionPerformed(evt);
            }
        });

        inserta.setText("Insertar");
        inserta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertaMouseClicked(evt);
            }
        });
        inserta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertaActionPerformed(evt);
            }
        });

        borra.setText("Borrar");
        borra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borraActionPerformed(evt);
            }
        });

        actualiza.setText("Actualizar");
        actualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizaActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        titulo.setText("Gestión de clientes del gimnasio");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(inserta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(actualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(borra, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNom, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelClase, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoClase, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                            .addComponent(campoFecha)
                                            .addComponent(campoApellidos)))
                                    .addComponent(jLabel1mensajes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(88, 88, 88))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDNI, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelApellidos)
                        .addComponent(campoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelNom)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccion)
                    .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelClase)
                    .addComponent(campoClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMonitor)
                    .addComponent(campoMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1mensajes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualiza)
                    .addComponent(inserta)
                    .addComponent(busca)
                    .addComponent(borra))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDNIActionPerformed

    private void buscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaMouseClicked

    private void buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaActionPerformed
        Visible(false);
        campoDNI.setVisible(true);
        labelDNI.setVisible(true);
        opcion = "buscar";

    }//GEN-LAST:event_buscaActionPerformed

    private void insertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertaMouseClicked

    }//GEN-LAST:event_insertaMouseClicked

    private void insertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertaActionPerformed
        Visible(true);
        opcion = "insertar";
    }//GEN-LAST:event_insertaActionPerformed

    private void borraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borraActionPerformed
        Visible(false);
        campoDNI.setVisible(true);
        labelDNI.setVisible(true);
        opcion = "borar";

    }//GEN-LAST:event_borraActionPerformed

    private void actualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizaActionPerformed
        Visible(false);
        campoDireccion.setVisible(true);
        campoMonitor.setVisible(true);
        campoClase.setVisible(true);
        campoDNI.setVisible(true);
        labelDNI.setVisible(true);
        labelDireccion.setVisible(true);
        labelMonitor.setVisible(true);
        labelClase.setVisible(true);
        opcion = "actualizar";
    }//GEN-LAST:event_actualizaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        switch (opcion) {
            case "insertar" -> {
                insertar();
            }
            case "buscar" -> {
                busca();
            }
            case "actualizar" -> {
                actualiza();
            }
            case "borar" -> {
                borrar();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualiza;
    private javax.swing.JButton borra;
    private javax.swing.JButton busca;
    private javax.swing.JTextField campoApellidos;
    private javax.swing.JTextField campoClase;
    private javax.swing.JTextField campoDNI;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JTextField campoMonitor;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JButton inserta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1mensajes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelApellidos;
    private javax.swing.JLabel labelClase;
    private javax.swing.JLabel labelDNI;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelMonitor;
    private javax.swing.JLabel labelNom;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
