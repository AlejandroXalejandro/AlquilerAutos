/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.io.File;
import com.itextpdf.text.pdf.PdfReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Confirmacion extends javax.swing.JFrame {
private Connection connection;
    /**
     * Creates new form Confirmacion
     */
    public Confirmacion() {
        initComponents();
        conectarBaseDatos();
        cargarDatosEnAreaDeTexto();
        setLocationRelativeTo(null);
    }
    private void conectarBaseDatos(){
        String url="jdbc:mysql://localhost:3306/alquilerautos";
        String usuario="root";
        String contraseña="yahir";
        try{
            connection=DriverManager.getConnection(url,usuario,contraseña);
            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos");
            }
    }
    private void cargarDatosEnAreaDeTexto(){
        String consulta = "SELECT nombre_cliente, apellidos_cliente, edad_cliente, telefono_cliente, " +
                      "correo_cliente, lugar_recoleccion, lugar_devolucion, cantidad_ninos, cantidad_adultos, " +
                      "vehiculo_seleccionado, complementos, fecha_inicio_recoleccion, hora_inicio_recoleccion, " +
                      "fecha_fin_devolucion, hora_fin_devolucion " +
                      "FROM alquileres " +
                      "ORDER BY id_alquiler DESC LIMIT 1";  // Seleccionamos solo el último registro

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(consulta)) {

        StringBuilder datos = new StringBuilder();

        if (rs.next()) {
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
        }

        AreaDeTexto.setText(datos.toString());

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al recuperar los datos");
    }
    }
     private void borrarDatosDeLaBaseDeDatos() {
        String consulta = "DELETE FROM alquileres";

        try (Statement stmt = connection.createStatement()) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres borrar todos los datos?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                stmt.executeUpdate(consulta);
                JOptionPane.showMessageDialog(this, "Todos los datos han sido eliminados.");
                AreaDeTexto.setText("");
                System.exit(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al borrar los datos");
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

        jDialog1 = new javax.swing.JDialog();
        aceptaryreservar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaDeTexto = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        textorandom = new javax.swing.JTextArea();
        CancelarSalir = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aceptaryreservar.setBackground(new java.awt.Color(51, 0, 0));
        aceptaryreservar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        aceptaryreservar.setForeground(new java.awt.Color(255, 255, 255));
        aceptaryreservar.setText("Aceptar y Reservar");
        aceptaryreservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptaryreservarActionPerformed(evt);
            }
        });

        AreaDeTexto.setColumns(20);
        AreaDeTexto.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        AreaDeTexto.setRows(5);
        AreaDeTexto.setEnabled(false);
        jScrollPane1.setViewportView(AreaDeTexto);

        textorandom.setEditable(false);
        textorandom.setColumns(20);
        textorandom.setText("Revise que los datos esten agregados de\nmanera correcta antes de hacer la reserva.");
        textorandom.setAutoscrolls(false);
        textorandom.setFocusable(false);
        textorandom.setOpaque(false);
        jScrollPane3.setViewportView(textorandom);

        CancelarSalir.setBackground(new java.awt.Color(255, 0, 0));
        CancelarSalir.setForeground(new java.awt.Color(255, 255, 255));
        CancelarSalir.setText("Cancelar y Salir");
        CancelarSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarSalirActionPerformed(evt);
            }
        });

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
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(aceptaryreservar)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CancelarSalir)
                        .addGap(156, 156, 156))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aceptaryreservar)
                .addGap(18, 18, 18)
                .addComponent(CancelarSalir)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarSalirActionPerformed
        borrarDatosDeLaBaseDeDatos();
        
    }//GEN-LAST:event_CancelarSalirActionPerformed

    private String extraerCorreoDeBaseDeDatos() {
    String consulta = "SELECT correo_cliente FROM alquileres ORDER BY id_alquiler DESC LIMIT 1";  // Ordenar por ID descendente para obtener el último
    String correo = null;

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(consulta)) {
        
        if (rs.next()) {
            correo = rs.getString("correo_cliente");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al recuperar el correo desde la base de datos.");
    }

    return correo;
}
    private void enviarCorreo(String correoDestino, String asunto, String mensaje, String archivoAdjunto) {
    // Parámetros de la cuenta de correo desde la cual se enviará el correo
    final String usuario = "yaii2knsko@gmail.com";  // Tu correo de Gmail
    final String contraseña = "vute ghsc ppep tjyx";      // Tu contraseña de Gmail (puedes generar una contraseña de app si usas la verificación en dos pasos)

    // Propiedades del servidor SMTP de Gmail
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    // Crear la sesión de correo
    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(usuario, contraseña);
        }
    });

    try {
        // Crear el mensaje
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(usuario));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
        message.setSubject(asunto);
        message.setText(mensaje);

        // Adjuntar el archivo PDF
        MimeBodyPart adjunto = new MimeBodyPart();
        adjunto.attachFile(new File(archivoAdjunto));

        // Crear una parte de texto y adjuntar el archivo
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(adjunto);
        message.setContent(multipart);

        // Enviar el correo
        Transport.send(message);

        JOptionPane.showMessageDialog(this, "Correo enviado exitosamente a: " + correoDestino);
    } catch (MessagingException | IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al enviar el correo.");
    }
}

    
    private void aceptaryreservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptaryreservarActionPerformed
        try {
        // Obtener la ruta del escritorio del sistema operativo
        String escritorio = System.getProperty("user.home") + "\\Desktop\\";
        
        // Ruta de destino del PDF en el escritorio
        String destino = escritorio + "ConfirmacionReserva.pdf";
        
        // Crear un nuevo documento PDF
        Document documento = new Document();
        
        // Establecer el escritor para el archivo PDF
        PdfWriter.getInstance(documento, new FileOutputStream(destino));
        
        // Abrir el documento
        documento.open();
        
        // Obtener el contenido del área de texto
        String datos = AreaDeTexto.getText();
        
        // Título
        documento.add(new Paragraph("Confirmación de Reserva", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD)));
        documento.add(new Paragraph("--------------------------------------------------"));
        documento.add(new Paragraph("\n"));
        
        // Datos del cliente
        documento.add(new Paragraph("Detalles del Cliente:", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD)));
        documento.add(new Paragraph(datos));
        documento.add(new Paragraph("\n"));
        
        // Agregar la fecha de la reserva y otros detalles
        documento.add(new Paragraph("Fecha de la Reserva: " + new java.util.Date().toString()));
        documento.add(new Paragraph("--------------------------------------------------"));
        documento.add(new Paragraph("\n"));
        
        double total = calcularTotal();
        documento.add(new Paragraph("Total a pagar: $" + total, new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));

        
        // Confirmación de la reserva
        documento.add(new Paragraph("¡Gracias por confiar en nosotros! Tu reserva ha sido confirmada.", new Font(Font.FontFamily.HELVETICA, 12, Font.ITALIC)));
        
        // Cerrar el documento
        documento.close();
        
        // Extraer el correo desde la base de datos
        String correoDestino = extraerCorreoDeBaseDeDatos(); // Aquí recuperamos el correo

        if (correoDestino != null) {
            // Enviar el correo con el archivo PDF adjunto
            enviarCorreo(correoDestino, "Confirmación de Reserva", "Adjunto encontrarás la confirmación de tu reserva.", destino);
            cerrarVentanas();
            JOptionPane.showMessageDialog(this, "PDF generado y correo enviado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo obtener el correo desde la base de datos.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al generar el PDF o enviar el correo.");
    }
    }//GEN-LAST:event_aceptaryreservarActionPerformed

    private double calcularTotal() throws SQLException {
    // Iniciar el total como 0
    double total = 0.0;

    // Consulta para obtener los datos del alquiler (usando el último alquiler registrado, por ejemplo)
    String consulta = "SELECT * FROM alquileres ORDER BY id_alquiler DESC LIMIT 1";  // Asegúrate de obtener el alquiler más reciente
    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(consulta)) {

        if (rs.next()) {
            // Recuperar las fechas de inicio y fin del alquiler
            String fechaInicio = rs.getString("fecha_inicio_recoleccion");
            String fechaFin = rs.getString("fecha_fin_devolucion");

            // Convertir las fechas a LocalDate
            LocalDate inicio = LocalDate.parse(fechaInicio);
            LocalDate fin = LocalDate.parse(fechaFin);

            // Calcular la cantidad de días entre las dos fechas
            long diasDeAlquiler = ChronoUnit.DAYS.between(inicio, fin);

            // Recuperar el costo del vehículo seleccionado
            String vehiculoSeleccionado = rs.getString("vehiculo_seleccionado");

            // Consultar el precio del vehículo seleccionado
            String consultaPrecio = "SELECT precio_dia FROM vehiculos WHERE marca = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(consultaPrecio)) {
                pstmt.setString(1, vehiculoSeleccionado);

                try (ResultSet rsPrecio = pstmt.executeQuery()) {
                    if (rsPrecio.next()) {
                        double costoVehiculo = rsPrecio.getDouble("precio_dia");

                        // Recuperar los complementos seleccionados
                        String complementos = rs.getString("complementos");

                        // Calcular el costo de los complementos
                        double costoComplementos = 0;
                        if (complementos != null && !complementos.isEmpty()) {
                            String[] listaComplementos = complementos.split(",");
                            for (String complemento : listaComplementos) {
                                // Consulta para obtener el precio de cada complemento
                                String consultaComplemento = "SELECT precio FROM complementos WHERE nombre = ?";
                                try (PreparedStatement pstmtComplemento = connection.prepareStatement(consultaComplemento)) {
                                    pstmtComplemento.setString(1, complemento.trim());
                                    try (ResultSet rsComplemento = pstmtComplemento.executeQuery()) {
                                        if (rsComplemento.next()) {
                                            costoComplementos += rsComplemento.getDouble("precio");
                                        }
                                    }
                                }
                            }
                        }

                        // Calcular el total del alquiler (días * costo vehículo + costo complementos)
                        total = (diasDeAlquiler * costoVehiculo) + costoComplementos;
                    }
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al calcular el total.");
    }

    return total;
}


    private void cerrarVentanas() {
    // Si quieres cerrar todas las ventanas, puedes llamar a dispose() en cada una de ellas
    // Cierra la ventana actual
    this.dispose(); 

    // Si tienes otras ventanas abiertas, ciérralas de manera similar
    // Por ejemplo, si tienes una ventana de reservas abierta:
    // ventanaReservas.dispose();

    // Cierra la aplicación si lo deseas:
    // System.exit(0);
}

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Confirmacion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaDeTexto;
    private javax.swing.JButton CancelarSalir;
    private javax.swing.JButton aceptaryreservar;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea textorandom;
    // End of variables declaration//GEN-END:variables
}
