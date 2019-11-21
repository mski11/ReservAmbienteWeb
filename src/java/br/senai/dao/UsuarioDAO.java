package br.senai.dao;

import br.senai.model.Item;
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
import java.util.Random;

public class UsuarioDAO {

    public boolean registrarUsuario(int idPedido){

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
            int senhaGerada = (int) (Math.random()*10000);

            if(rs.next()){
                dadosUsuario.setNome(rs.getString("nome"));
                dadosUsuario.setTelefone(rs.getString("telefone"));
                dadosUsuario.setEmail(rs.getString("email"));
                dadosUsuario.setMatricula(rs.getString("matricula"));
            }

            // Inserção na tabela usuario com os dados de dadosUsuario
            stmt = conexao.prepareStatement("INSERT INTO usuario (nome, telefone, email, matricula, mestre, senha) VALUES (?, ?, ?, ?, ?, ?);");
            stmt.setString(1, dadosUsuario.getNome());
            stmt.setString(2, dadosUsuario.getTelefone());
            stmt.setString(3, dadosUsuario.getEmail());
            //if(dadosUsuario.getMatricula() != null){
                stmt.setString(4, dadosUsuario.getMatricula());
            //}else{
            //    stmt.setString(4, "Não matriculado");
            //}
            stmt.setString(5, "N");       
            stmt.setInt(6, senhaGerada);



            stmt.executeUpdate();
            FabricaConexao.fecharConexao();

        } catch (SQLException ex) {
            Logger.getLogger(pedidoRegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  finally {
            FabricaConexao.fecharConexao();
        }
        return true; 
    }


    public boolean excluir(Usuario usuario){
    try {

        Connection conexao = FabricaConexao.getConexao();
        PreparedStatement ps;

        if(usuario != null){
            ps = conexao.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");

            ps.setInt(1, usuario.getIdUsuario());

            ps.executeUpdate();

            FabricaConexao.fecharConexao();
        }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Usuario> buscarUsuarios(){

        List<Usuario> UsuariosEncontrados = new ArrayList<>();

        try { 

            Connection conexao = FabricaConexao.getConexao(); 

            ResultSet rs = null;
            String SELECT = "SELECT * FROM usuario";

            PreparedStatement stmt;
            stmt = conexao.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while(rs.next()){
                Usuario usuario = new Usuario();

                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setEmail(rs.getString("email"));
                usuario.setMatricula(rs.getString("matricula"));

                UsuariosEncontrados.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pedidoRegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.fecharConexao();
        }

        return UsuariosEncontrados;
    }

    public Usuario loginCheck(Usuario userLoginInput){

        Connection conexao = FabricaConexao.getConexao();
        PreparedStatement ps;

        try {

            ps = conexao.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?");
            ps.setString(1, userLoginInput.getEmail());
            ps.setString(2, userLoginInput.getPass());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Usuario usuarioLogado = new Usuario();
                usuarioLogado.setIdUsuario(rs.getInt("idUsuario"));
                usuarioLogado.setNome(rs.getString("nome"));
                usuarioLogado.setMatricula(rs.getString("matricula"));
                usuarioLogado.setEmail(rs.getString("email"));
                usuarioLogado.setTelefone(rs.getString("telefone"));
                usuarioLogado.setMestre(rs.getBoolean("mestre"));

                return usuarioLogado;

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
