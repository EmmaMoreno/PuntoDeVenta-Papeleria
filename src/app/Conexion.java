package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    public static Connection getConexion(){
        String url = "jdbc:sqlserver://localhost:1433;"
                + "database=Papeleria;"
                + "user=testjava;"
                + "password=testjava";
        try{
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
}
