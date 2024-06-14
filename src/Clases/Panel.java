package Clases;

import java.awt.Color;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Panel extends javax.swing.JFrame {
    
    public Panel() {
        initComponents();
        cargar();
    }
    
    private void cargar() {
        datos = gestion.mostrarTodos();
        modelo.setNumRows(0);
        for (Object[] dato : datos) {
            modelo.addRow(dato);
        }
        tabla.setModel(modelo);
    }
    String[] columnas = {"DNI", "Nombre", "Apellidos", "Dirección", "Fecha de alta", "Monitor", "Clase"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
    ClienteDAO gestion = new ClienteDAO();
    ArrayList<Object[]> datos = new ArrayList<>();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
        mensajes = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setBackground(new Color(252, 166, 68));
        
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

        mensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mensajesActionPerformed(evt);
            }
        });
        
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(tabla);
       
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(mensajes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(inserta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(actualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(borra, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
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
                    .addComponent(mensajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualiza)
                    .addComponent(inserta)
                    .addComponent(busca)
                    .addComponent(borra))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>                        

    private void buscaActionPerformed(java.awt.event.ActionEvent evt) {                                      
        

    }                                     

    private void insertaActionPerformed(java.awt.event.ActionEvent evt) {                                        

    }                                       

    private void campoDNIActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        // Cliente(String dni, String nombre, String apellidos, String nomEntrenador, String direccion, String clase, Date fechaInscripcion) {

    private void insertaMouseClicked(java.awt.event.MouseEvent evt) {                                     

        //String dni, String nombre, String apellidos, String nomEntrenador, String direccion, String clase, Date fechaInscripcion

        Cliente inserta = new Cliente(campoDNI.getText(),
                campoNombre.getText(), campoApellidos.getText(), campoDireccion.getText(),
                Date.valueOf(campoFecha.getText()),
                campoMonitor.getText(),
                campoClase.getText());
        
        if (gestion.create(inserta) == true) {
            mensajes.setText("Cliente insertado");
            cargar();
            campoDNI.setText("");
            campoNombre.setText("");
            campoApellidos.setText("");
            campoDireccion.setText("");
            campoFecha.setText("");
            campoMonitor.setText("");
            campoClase.setText("");

            mensajes.setText("Cliente insertado");
        } else {
            mensajes.setText("No se ha podido insertar el cliente");
        }

    }                                    

    private void mensajesActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void buscaMouseClicked(java.awt.event.MouseEvent evt) {                                   
        Cliente buscar = gestion.read(campoDNI.getText());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String alta = "";
        if (buscar != null) {
            
            campoNombre.setText(buscar.getNombre());
            campoApellidos.setText(buscar.getApellidos());
            campoDireccion.setText(buscar.getDireccion());
            alta = dateFormat.format(buscar.getFechaInscripcion());
            campoFecha.setText(alta);
            campoMonitor.setText(buscar.getNomEntrenador());
            campoClase.setText(buscar.getClase());
        } else {
            mensajes.setText("Cliente no encontrado");
            
        }
        cargar();
    }                                  

    private void actualizaActionPerformed(java.awt.event.ActionEvent evt) {                                          

        Cliente actualiza = new Cliente(campoDNI.getText(), campoMonitor.getText(), campoDireccion.getText(), campoClase.getText());
        boolean actualizar = gestion.update(actualiza);
        if (actualizar != false) {
            mensajes.setText("Cliente actualizado");
            campoDNI.setText("");
            campoNombre.setText("");
            campoApellidos.setText("");
            campoDireccion.setText("");
            campoFecha.setText("");
            campoMonitor.setText("");
            campoClase.setText("");
            
        } else {
            mensajes.setText("No se podido ha actualizar el cliente");
        }
        cargar();


    }                                         

    private void borraActionPerformed(java.awt.event.ActionEvent evt) {                                      
        Boolean borrar = gestion.delete(campoDNI.getText());
        if (borrar != false) {

            mensajes.setText("Cliente borrado");
            campoDNI.setText("");
            cargar();
        } else {
            mensajes.setText("No se ha podido borrar el cliente.");
        }
    }                                     

    // Variables declaration - do not modify                     
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelApellidos;
    private javax.swing.JLabel labelClase;
    private javax.swing.JLabel labelDNI;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelMonitor;
    private javax.swing.JLabel labelNom;
    private javax.swing.JTextField mensajes;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel titulo;
    // End of variables declaration                   
}
