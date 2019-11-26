package br.senai.dao;

import br.senai.model.Ambiente;
import br.senai.model.Pedido;
import br.senai.model.Usuario;
import br.senai.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoReservaDAO {
    
    public boolean criarPedido(Ambiente ambiente, Pedido pedido, Usuario usuario){
        
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            
            ps = conexao.prepareStatement("INSERT INTO pedidoreserva (idAmbiente, idUsuario, descricaopedido, horainicio, horafim, dataPedido, statusAtual, repostaMestre) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, ambiente.getIdAmbiente());
            ps.setInt(2, usuario.getIdUsuario());
            ps.setString(3, pedido.getDescricao());
            ps.setString(4, pedido.getHoraInicio());
            ps.setString(5, pedido.getHoraFim());
            ps.setString(6, pedido.getDiaPedido());
            ps.setString(7, "N");
            ps.setString(8, "Aguardando resposta!");
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidoReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            FabricaConexao.fecharConexao();
        }
        return true;
    }
    
    public void responderPedido(Pedido pedido, String resposta, String data){
        
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            
            ps = conexao.prepareStatement("UPDATE pedidoreserva SET (statusAtual, dataResposta, respostaMestre) VALUES (?, ?, ?");
            
            ps.setBoolean(1, pedido.getStatusResposta());
            ps.setString(2, resposta);
            ps.setString(3, data);
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidoReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
