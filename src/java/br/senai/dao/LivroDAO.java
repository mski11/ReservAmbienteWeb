// Esse DAO esta sendo usado
// como um exemplo a ser seguido
// no desenvolvimento dos outros. :)

package br.senai.dao;

import br.senai.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LivroDAO {
//    
//    public String conectar(){
//        Connection conexao = FabricaConexao.getConexao();
//        
//        if(conexao == null)
//            return "Conexão não pode ser realizada";
//        else
//        return "Conexão efetuada com sucesso";
//    }
//    
//    public void salvar(Livro livro){
//        try {
//        Connection conexao = FabricaConexao.getConexao();
//        PreparedStatement ps;
//        if(livro != null){
//            ps = conexao.prepareStatement("INSERT INTO livro (nome, editora) VALUES (?, ?)");
//            
//            ps.setString(1, livro.getNome());
//            ps.setString(2, livro.getEditora());
//            
//            ps.executeUpdate();
//            
//            FabricaConexao.fecharConexao();
//        }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//    
//    public boolean editar(Livro livro){
//        
//        String sql = "UPDATE livro SET nome = ? , editora = ? WHERE codigo = ?";
//        PreparedStatement ps;
//
//        try {
//        Connection conexao = FabricaConexao.getConexao();
//        ps = conexao.prepareStatement(sql);
//        if(livro != null){
//            
//            ps.setString(1, livro.getNome());
//            ps.setString(2, livro.getEditora());
//            ps.setInt(3, livro.getCodigo());
//            
//            ps.executeUpdate();
//            
//            FabricaConexao.fecharConexao();
//            return true;
//        } ;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            
//        }
//        return false;
//    }
//    
//    public List<Livro> buscar(){
//        try {
//            Connection conexao = FabricaConexao.getConexao();
//            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM livro");
//            
//            ResultSet rs = ps.executeQuery();
//            
//            List<Livro> livros = new ArrayList();
//            
//           while(rs.next()){
//                Livro livro = new Livro();
//                livro.setCodigo(rs.getInt("codigo"));
//                livro.setNome(rs.getString("nome"));
//                livro.setEditora(rs.getString("editora"));
//                livros.add(livro);
//            }
//            
//            FabricaConexao.fecharConexao();
//            return livros;
//                    
//        } catch (SQLException ex) {
//            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return new ArrayList();
//    }
//    
}

