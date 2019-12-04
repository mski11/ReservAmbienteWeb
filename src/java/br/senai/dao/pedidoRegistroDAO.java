package br.senai.dao;

import br.senai.model.PedidoRegistro;
import br.senai.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pedidoRegistroDAO {
    
    /*
    *   Método usado pelos desenvolvedores para checar se
    *   a conexão com banco de dados foi realizada.
    */
    public String conectar(){
        Connection conexao = FabricaConexao.getConexao();
        if(conexao == null)
            return "Conexão não pode ser realizada";
        else
        return "Conexão efetuada com sucesso";
    }
    
    /*
    *   Método usado para salvar um novo pedido de 
    *   registro no banco de dados.
    *   @param PR PedidoRegistro - Pedido de registro criado pelo usuário.
    *   @return boolean - TRUE = Sucesso; FALSE = Função defeituosa.
    */
    public boolean salvar(PedidoRegistro PR) {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(PR != null){
                ps = conexao.prepareStatement("INSERT INTO pedidoRegistro (nome, telefone, email, matricula, descricao) VALUES (?, ?, ?, ?, ?)"); 
                ps.setString(1, PR.getNome());
                ps.setString(2, PR.getTelefone());
                ps.setString(3, PR.getEmail());
                ps.setString(4, PR.getMatricula());
                ps.setString(5, PR.getDescricao());
                ps.executeUpdate();
                FabricaConexao.fecharConexao();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
           /* FabricaConexao.cancelarTransacao(); */
           return false;
        } catch (Exception ex) {
             Logger.getLogger(pedidoRegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println(ex);
        }
        return true;
    }
    
    /*
    *   Método usado para deletar um pedido 
    *   de registro no banco de dados.
    *   @param idPedido int - ID do pedido de registro que se deseja excluir.
    *   @return boolean - TRUE = Sucesso; FALSE = Função defeituosa.
    */
    public boolean excluirPedido(int idPedido){
        Connection conexao = FabricaConexao.getConexao();
        String DELETE = "DELETE FROM pedidoregistro WHERE idpedido = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexao.prepareStatement(DELETE);
            stmt.setInt(1, idPedido);
            stmt.executeUpdate();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
     /*
    *   Método usado para buscar pedidos de registro
    *   no banco de dados.
    *   @return List<PedidoRegistro> - Pedidos de registro encontrados.
    */
    public List<PedidoRegistro> buscarPedidos(){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM pedidoregistro;");
            ResultSet rs = ps.executeQuery();
            List<PedidoRegistro> pedidos = new ArrayList();
            
            while(rs.next()){
                PedidoRegistro pedido = new PedidoRegistro();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setNome(rs.getString("nome"));
                pedido.setTelefone(rs.getString("telefone"));
                pedido.setEmail(rs.getString("email"));
                pedido.setMatricula(rs.getString("matricula"));
                pedido.setDescricao(rs.getString("descricao"));
                pedidos.add(pedido);
            }
            
            FabricaConexao.fecharConexao();
            return pedidos;
                    
        } catch (SQLException ex) {
            Logger.getLogger(pedidoRegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList();
    }
    
}
