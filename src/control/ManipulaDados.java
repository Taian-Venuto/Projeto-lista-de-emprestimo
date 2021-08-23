/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import DAO.ConectarBanco;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contato;

/**
 *
 * @author cilla
 */
public class ManipulaDados {
    Connection conexao;
    
    public ManipulaDados(Connection conexao){
        this.conexao =  conexao;    
    }
   
    public void cadastrarContato(Contato c){
        try {
            PreparedStatement p = conexao.prepareStatement("insert into contato(nome, email,telefone) values (?,?,?)");
            p.setString(1, c.getNome());
            p.setString(2, c.getEmail());
            p.setString(3, c.getTelefone());
    
            p.executeUpdate();
            p.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(ManipulaDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public List<Contato> listaContatos(Contato a) throws SQLException{
            Connection con = null;
            List<Contato> listaPessoas = new ArrayList<Contato>();
            try{
                PreparedStatement prepared = conexao.prepareStatement("select*from contato");
                ResultSet resultSet = prepared.executeQuery();
                while(resultSet.next()){
                    Contato c = new Contato();
                    c.setId(resultSet.getInt("id"));
                    c.setNome(resultSet.getString("nome"));
                    c.setTelefone(resultSet.getString("telefone"));
                    c.setEmail(resultSet.getString("email"));
                    listaPessoas.add(c);
                }
            }catch(SQLException e){   
            }
            return listaPessoas;
        }
     
     public void excluir(Contato a){
        try {
            PreparedStatement prepared = conexao.prepareStatement("delete from contato where id=?");
            prepared.setInt(1, a.getId());
            prepared.executeUpdate();   
        } catch (SQLException ex) {
            Logger.getLogger(ManipulaDados.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public void alterarContato(Contato c){
        try {
            PreparedStatement p = conexao.prepareStatement("update contato set nome= ?, telefone= ?, email= ? where id= ?");
            p.setString(1, c.getNome());
            p.setString(2, c.getTelefone());
            p.setString(3, c.getEmail());
            p.setInt(4, c.getId());
           
            p.executeUpdate();
            p.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(ManipulaDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
