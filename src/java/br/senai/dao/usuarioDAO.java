package br.senai.dao;

import br.senai.model.PedidoRegistro;
import br.senai.model.Usuario;
import br.senai.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class usuarioDAO {
    
    public Usuario buscarUsuarioDesejado(int idPedido){
        
        Connection conexao = FabricaConexao.getConexao(); 
        String SELECT = "SELECT * FROM pedidoregistro WHERE idpedido = " + idPedido;
       
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
         try{
            
            stmt = conexao.prepareStatement(SELECT);
            rs = stmt.executeQuery();
            
            Usuario dadosUsuario = new Usuario();
            dadosUsuario.setNome(rs.getString("nome"));
            dadosUsuario.setTelefone(rs.getString("telefone"));
            dadosUsuario.setEmail(rs.getString("email"));
            dadosUsuario.setMatricula(rs.getString("matricula"));
            
            String INSERT = "INSERT INTO usuario (nome, telefone, email, matricula, mestre) VALUES (?, ?, ?, ?, N)";
            
            
                
            } catch (SQLException ex) {
             Logger.getLogger(pedidoRegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }  finally {
             FabricaConexao.fecharConexao();
            }
         
         return dadosUsuario;
        
    }
    
    public void registrarUsuario(Usuario usuario){
        
        
        
    }
    
    // Antigo método salvar.
    public void salvar(Usuario usuario){
        try {
        Connection conexao = FabricaConexao.getConexao();
        PreparedStatement ps;
        if(usuario != null){
            ps = conexao.prepareStatement("INSERT INTO usuario (nome, telefone, email, matricula, mestre) VALUES (?, ?, ?, ?, ?)");
            
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getTelefone());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getMatricula());
            ps.setString(5, "N");
            
            ps.executeUpdate();
            
            FabricaConexao.fecharConexao();
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void excluir(Usuario usuario){
    try {
        Connection conexao = FabricaConexao.getConexao();
        PreparedStatement ps;
        if(usuario != null){
            ps = conexao.prepareStatement("DELETE FROM usuario WHERE id = ?");
            
            ps.setString(1, usuario.getIdUsuario());
            
            ps.executeUpdate();
            
            FabricaConexao.fecharConexao();
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
