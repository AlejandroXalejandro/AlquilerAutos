/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alquiler.de.autos;

/**
 *
 * @author yc
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
    String bd = "alquilerautos";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "yahir";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Conexion() {
    }
    
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd, user, password);
            System.out.println("Se conecto a bd "+bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conecto a bd "+bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}