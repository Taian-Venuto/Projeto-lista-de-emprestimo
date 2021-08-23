package DAO;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConectarBanco
{   
    static final private String driver = "com.mysql.jdbc.Driver";
    static final private String caminho = "jdbc:mysql://localhost/agenda";
    static final private String usuario = "root";
    static final private String senha = "";
    static private Connection conn;
    public Statement stm;    // abrir caminho até o local do banco de dados
    public ResultSet rs;     // armazena no result set os dados
   
    public static com.mysql.jdbc.Connection conectar()
    {
        boolean result = true;
        try 
        {
            Class.forName(driver);
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(caminho, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conexão realizada!!!");
        }   
        catch(ClassNotFoundException driver)
        {
            JOptionPane.showMessageDialog(null, "Driver Não Localizado!!!\n" + driver.getMessage()); //ok
            result = false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro de conexão!!!\n" + ex.getMessage()); //ok
            result = false;
        }
      return (com.mysql.jdbc.Connection) conn;
    }
    
    public void desconectar()
    {
        boolean result = true;
        try
        {
            conn.close();
            JOptionPane.showMessageDialog(null, "Desconectado!!!");    
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro de conexão!!!\n" + ex.getMessage());
            result = false;
        }
    }  
    
    public void executeSQL(String sql)
    {
        try
        {
            stm = conn.createStatement(
                   ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    rs= stm.executeQuery(sql); 
        }
        catch(SQLException sqlex)
        {
            JOptionPane.showMessageDialog(null,"Não foi possível executar o comando sql"+sqlex.getMessage());
        }
    }
}

