package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion 
{
    String url = "jdbc:mysql://localhost/sesion";
    String usr = "root";
    String pass = "flordemaria117";
    Connection conexion = null;
    Statement sta = null;
    ResultSet rset = null;
    
    public int Conecta (String usuar, String contra)
    {
        int tipo = 0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usr, pass);
        }
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println(e.toString());
        }
        try 
        {
            sta = conexion.createStatement();
            rset = sta.executeQuery("select * from login where usuario = '" + usuar + "' and contra = '" + contra + "'");
            tipo = rset.getInt(tipo);
        } 
        catch (SQLException e) 
        {
            System.out.println( e.toString());
        }
        
        return tipo;
    }
}
