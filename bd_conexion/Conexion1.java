
package bd_conexion;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion1 {
    
  private static Connection conexion;
  private static Conexion1 instancia;
  private static final String URL = "jdbc:mysql://localhost:/bd_empresatecnologia";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "";
  
  public Conexion1(){}
  
  public static Conexion1 getInstancia(){
    if(instancia == null){
      instancia = new Conexion1();
    }   
    return instancia;
  }
  
  public Connection conectar(){
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      conexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
      return conexion;
    }catch(ClassNotFoundException | SQLException e){
      JOptionPane.showMessageDialog(null,"Error :" + e);
    }
      return conexion;
  }
  
  public void cerrarConexion() throws SQLException{
    try{
      conexion.close();
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null,"Error : " + e);
      conexion.close();
    }
      conexion.close();
  }
    
}
