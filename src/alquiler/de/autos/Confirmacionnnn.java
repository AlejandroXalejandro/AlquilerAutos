/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alquiler.de.autos;

/**
 *
 * @author yc
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Confirmacionnnn extends javax.swing.JFrame {

    private Connection connection;

    /**
     * Creates new form Confirmacion
     */
    public Confirmacionnnn() {
        initComponents();
        conectarBaseDatos();
        cargarDatosEnAreaDeTexto();
    }

    private void conectarBaseDatos() {
        
        String url = "jdbc:mysql://localhost:3306/alquilerautos";
        String usuario = "root";
        String contraseña = "yahir";

        try {
            connection = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos");
        }
    }

    private void cargarDatosEnAreaDeTexto() {
        String consulta = "SELECT nombre_cliente, apellidos_cliente, edad_cliente, telefono_cliente, " +
                          "correo_cliente, lugar_recoleccion, lugar_devolucion, cantidad_ninos, cantidad_adultos, " +
                          "vehiculo_seleccionado, complementos, fecha_inicio_recoleccion, hora_inicio_recoleccion, " +
                          "fecha_fin_devolucion, hora_fin_devolucion FROM alquileres";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            StringBuilder datos = new StringBuilder();

            while (rs.next()) {
                datos.append("Nombre: ").append(rs.getString("nombre_cliente")).append(" ")
                     .append(rs.getString("apellidos_cliente")).append("\n");
                datos.append("Edad: ").append(rs.getInt("edad_cliente")).append("\n");
                datos.append("Teléfono: ").append(rs.getString("telefono_cliente")).append("\n");
                datos.append("Correo: ").append(rs.getString("correo_cliente")).append("\n");
                datos.append("Lugar de Recolección: ").append(rs.getString("lugar_recoleccion")).append("\n");
                datos.append("Lugar de Devolución: ").append(rs.getString("lugar_devolucion")).append("\n");
                datos.append("Cantidad de Niños: ").append(rs.getInt("cantidad_ninos")).append("\n");
                datos.append("Cantidad de Adultos: ").append(rs.getInt("cantidad_adultos")).append("\n");
                datos.append("Vehículo Seleccionado: ").append(rs.getString("vehiculo_seleccionado")).append("\n");
                datos.append("Complementos: ").append(rs.getString("complementos")).append("\n");
                datos.append("Fecha de Inicio de Recolección: ").append(rs.getString("fecha_inicio_recoleccion")).append("\n");
                datos.append("Hora de Inicio de Recolección: ").append(rs.getString("hora_inicio_recoleccion")).append("\n");
                datos.append("Fecha de Fin de Devolución: ").append(rs.getString("fecha_fin_devolucion")).append("\n");
                datos.append("Hora de Fin de Devolución: ").append(rs.getString("hora_fin_devolucion")).append("\n");
                datos.append("-----------------------------\n");
            }

            AreaDeTexto.setText(datos.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al recuperar los datos");
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jDialog1 = new javax.swing.JDialog();
        aceptaryreservar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaDeTexto = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        textorandom = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aceptaryreservar.setBackground(new java.awt.Color(51, 0, 0));
        aceptaryreservar.setFont(new java.awt.Font("Segoe UI", 0, 18));
        aceptaryreservar.setForeground(new java.awt.Color(255, 255, 255));
        aceptaryreservar.setText("Aceptar y Reservar");

        AreaDeTexto.setColumns(20);
        AreaDeTexto.setRows(5);
        jScrollPane1.setViewportView(AreaDeTexto);

        textorandom.setEditable(false);
        textorandom.setColumns(20);
        textorandom.setText("Revise que los datos estén agregados de\nmanera correcta antes de hacer la reserva.");
        textorandom.setAutoscrolls(false);
        textorandom.setFocusable(false);
        textorandom.setOpaque(false);
        jScrollPane3.setViewportView(textorandom);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(aceptaryreservar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(aceptaryreservar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Confirmacion().setVisible(true));
    }

    private javax.swing.JTextArea AreaDeTexto;
    private javax.swing.JButton aceptaryreservar;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea textorandom;
}

