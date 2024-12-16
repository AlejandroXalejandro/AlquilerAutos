/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package alquiler.de.autos;

import java.awt.Component;
import java.awt.Image;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author yc
 */
public class pasajeros extends javax.swing.JFrame {
    Conexion con1 = new Conexion();
    Connection conet;
    
    private int id_alquiler;

    // Constructor que recibe el id del alquiler
    public pasajeros(int id_alquiler) {
        this.id_alquiler = id_alquiler;
        initComponents(); 
        cargarVehiculos();
        cargarComplementos();
        setLocationRelativeTo(null);
    }
    /**
     * Creates new form pasajeros
     */
    public void cargarVehiculos() {
        String query = "SELECT marca, modelo, año, tipo, color, matricula, precio_dia, disponibilidad FROM vehiculos";
    try (Connection con = con1.conectar(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
        // Crear el modelo para la tabla de vehículos
        DefaultTableModel modeloVehiculos = (DefaultTableModel) tabla_models.getModel();
        modeloVehiculos.setRowCount(0); // Limpiar cualquier dato anterior

        while (rs.next()) {
            // Obtener los datos de cada vehículo
            String marca = rs.getString("marca");
            String modelo = rs.getString("modelo");
            String año = rs.getString("año");
            String tipo = rs.getString("tipo");
            String color = rs.getString("color");
            String matricula = rs.getString("matricula");
            double precioDia = rs.getDouble("precio_dia");
            double disponible = rs.getDouble("disponibilidad");
            

            // Añadir una fila a la tabla (con la URL de la imagen)
            Object[] row = {marca, modelo, año, tipo, color, matricula, precioDia, disponible};
            modeloVehiculos.addRow(row);
        }

        
    } catch (SQLException e) {
        System.out.println("Error al cargar vehículos: " + e.getMessage());
    }
    }

    // Método para cargar los datos de los complementos
    public void cargarComplementos() {
        String query = "SELECT nombre, descripcion, precio, disponible FROM complementos";
        try (Connection con = con1.conectar(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            // Crear el modelo para la tabla de complementos
            DefaultTableModel modeloComplementos = (DefaultTableModel) tabla_complementoss.getModel();
            modeloComplementos.setRowCount(0); // Limpiar cualquier dato anterior

            while (rs.next()) {
                // Obtener los datos de cada complemento
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                double disponible = rs.getDouble("disponible");

                // Añadir una fila a la tabla
                Object[] row = {nombre, descripcion, precio, disponible};
                modeloComplementos.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar complementos: " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cantidad_adultos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_models = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_complementoss = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cantidad_ninos = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TRES CORONAS");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alquiler/de/Imagenes/corona (1).png"))); // NOI18N
        jLabel4.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(319, 319, 319))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Cantidad de pasajeros");

        cantidad_adultos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        cantidad_adultos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad_adultosActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccionar vehiculo");

        jLabel5.setText("Complementos");

        tabla_models.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Marca", "Modelo", "Año", "Tipo", "Color", "Matricula", "Precio dia", "Disponibilidad"
            }
        ));
        jScrollPane1.setViewportView(tabla_models);

        tabla_complementoss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripcion", "Precio", "Disponible"
            }
        ));
        jScrollPane2.setViewportView(tabla_complementoss);

        jButton1.setBackground(new java.awt.Color(51, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Continuar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cantidad_ninos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        cantidad_ninos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad_ninosActionPerformed(evt);
            }
        });

        jLabel6.setText("Niños:");

        jLabel7.setText("Adultos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cantidad_ninos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(45, 45, 45)
                        .addComponent(cantidad_adultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addGap(125, 125, 125))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel1)))
                        .addGap(233, 233, 233)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(431, 431, 431))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cantidad_ninos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad_adultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        vistaR v = new vistaR();
        v.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       // Obtener el vehículo seleccionado
    int row = tabla_models.getSelectedRow();
    if (row != -1) { // Si se ha seleccionado una fila
        // Obtener la marca del vehículo de la columna correspondiente (columna 0 es marca)
        String marcaVehiculo = (String) tabla_models.getValueAt(row, 0);

        // Obtener la cantidad de adultos y niños seleccionados
        String cantidadAdultos = (String) cantidad_adultos.getSelectedItem();
        String cantidadNinos = (String) cantidad_ninos.getSelectedItem();

        // Obtener el complemento seleccionado
        int complementoRow = tabla_complementoss.getSelectedRow();
        String complemento = "";
        if (complementoRow != -1) {
            complemento = (String) tabla_complementoss.getValueAt(complementoRow, 0); // Suponiendo que el nombre del complemento está en la primera columna
        }

        // Llamar a un método para guardar esta información en la base de datos
        guardarAlquiler(marcaVehiculo, cantidadAdultos, cantidadNinos, complemento);
    } else {
        // Si no se ha seleccionado un vehículo, mostrar un mensaje de error
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un vehículo.");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void guardarAlquiler(String marcaVehiculo, String cantidadAdultos, String cantidadNinos, String complemento) {
    // Consulta SQL de actualización para los campos específicos
    String query = "UPDATE alquileres SET vehiculo_seleccionado = ?, cantidad_adultos = ?, cantidad_ninos = ?, complementos = ? WHERE id_alquiler = ?";

    try (Connection con = con1.conectar(); PreparedStatement stmt = con.prepareStatement(query)) {
        // Establecer los parámetros en la consulta SQL
        stmt.setString(1, marcaVehiculo);
        stmt.setInt(2, Integer.parseInt(cantidadAdultos)); // Convertir la cantidad de adultos a int
        stmt.setInt(3, Integer.parseInt(cantidadNinos)); // Convertir la cantidad de niños a int
        
        // Concatenar el complemento con los existentes para no borrar los previos
        String queryComplementos = "SELECT complementos FROM alquileres WHERE id_alquiler = ?";
        try (PreparedStatement stmtCheck = con.prepareStatement(queryComplementos)) {
            stmtCheck.setInt(1, id_alquiler);
            ResultSet rs = stmtCheck.executeQuery();
            if (rs.next()) {
                String prevComplementos = rs.getString("complementos");
                if (prevComplementos != null && !prevComplementos.isEmpty()) {
                    // Concatenar el nuevo complemento con los previos
                    complemento = prevComplementos + ", " + complemento;
                }
            }
        }

        stmt.setString(4, complemento);
        stmt.setInt(5, id_alquiler); // Establecer el id_alquiler para identificar el registro

        // Ejecutar la actualización
        stmt.executeUpdate();
        
        // Confirmar la operación
        JOptionPane.showMessageDialog(this, "Alquiler actualizado exitosamente.");
        
        // Abre la siguiente ventana (tarjeta) y cierra la ventana actual
        reservar n3 = new reservar(id_alquiler);
        n3.setVisible(true);
        this.dispose();
    } catch (SQLException e) {
        System.out.println("Error al guardar el alquiler: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Hubo un error al guardar el alquiler.");
    }
}
    private void cantidad_ninosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad_ninosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidad_ninosActionPerformed

    private void cantidad_adultosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad_adultosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidad_adultosActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pasajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pasajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pasajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pasajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pasajeros(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cantidad_adultos;
    private javax.swing.JComboBox<String> cantidad_ninos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_complementoss;
    private javax.swing.JTable tabla_models;
    // End of variables declaration//GEN-END:variables
}
