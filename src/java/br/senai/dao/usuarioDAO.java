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
    
    public void registrarUsuario(int idPedido){
        
        Connection conexao = FabricaConexao.getConexao(); 
        String SELECT = "SELECT * FROM pedidoregistro WHERE idpedido = ?";
       
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            // Abre conexão e executa o SELECT, armazenando os resultados em 'rs'
            stmt = conexao.prepareStatement(SELECT);
            stmt.setInt(1, idPedido);
            rs = stmt.executeQuery();
            
            // Cria objeto usuário com base no resultado do ResultSet
            Usuario dadosUsuario = new Usuario();
            if(rs.next()){
            dadosUsuario.setNome(rs.getString("nome"));
            dadosUsuario.setTelefone(rs.getString("telefone"));
            dadosUsuario.setEmail(rs.getString("email"));
            dadosUsuario.setMatricula(rs.getString("matricula"));
            }
            
            // Inserção na tabela usuario com os dados de dadosUsuario
            stmt = conexao.prepareStatement("INSERT INTO usuario (nome, telefone, email, matricula, mestre) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, dadosUsuario.getNome());
            stmt.setString(2, dadosUsuario.getTelefone());
            stmt.setString(3, dadosUsuario.getEmail());
            if(dadosUsuario.getMatricula() != null){
                stmt.setString(4, dadosUsuario.getMatricula());
            }else{
                stmt.setString(4, "Não matriculado");
            }
            stmt.setString(5, "N");
            
            stmt.executeUpdate();
            FabricaConexao.fecharConexao();
                
        } catch (SQLException ex) {
            Logger.getLogger(pedidoRegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            FabricaConexao.fecharConexao();
        }
                 
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
