package br.senai.dao;

import br.senai.bean.ReservaAmbienteBean;
import br.senai.model.Ambiente;
import br.senai.model.Pedido;
import br.senai.model.Usuario;
import br.senai.util.FabricaConexao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

public class PedidoReservaDAO {
    
    public boolean criarPedido(Ambiente ambiente, Pedido pedido, Usuario usuario){
        
        try {
            
            
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            Time inicio = new Time(pedido.getHoraInicio().getTime());
            Time fim = new Time(pedido.getHoraFim().getTime());
            Date dia = new Date(pedido.getDiaPedido().getTime());
            
            ps = conexao.prepareStatement("INSERT INTO pedidoreserva (idAmbiente, idUsuario, descricaopedido, horainicio, horafim, dataPedido, statusAtual, repostaMestre) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, ambiente.getIdAmbiente());
            ps.setInt(2, usuario.getIdUsuario());
            ps.setString(3, pedido.getDescricao());
            ps.setTime(4, inicio);
            ps.setTime(5, fim);
            ps.setDate(6, dia);
            ps.setString(7, "N");
            ps.setString(8, "Aguardando resposta!");
            ps.executeUpdate();
                   
        } catch (SQLException ex) {
            Logger.getLogger(PedidoReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            FabricaConexao.fecharConexao();
        }
        try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("VisualisarAmbientes.jsf");
            } catch (IOException ex) {
                Logger.getLogger(ReservaAmbienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return true;
    }
    
    public List<Pedido> buscarPedidosPendentes(){
        try {
            
            Connection conexao = FabricaConexao.getConexao(); 
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM pedidoreserva WHERE statusAtual = 'N'");
            ResultSet rs = ps.executeQuery();
            List<Pedido> pedidosPendentes = new ArrayList<>();

            while(rs.next()){
                
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdAmbiente(rs.getString("idAmbiente"));
                pedido.setIdUsuario(rs.getInt("idUsuario"));
                pedido.setDescricao(rs.getString("descricaoPedido"));
                Time inicio = new Time(rs.getTime("horaInicio").getTime());
                Time fim = new Time(rs.getTime("horaFim").getTime());
                pedido.setHoraInicio(inicio);
                pedido.setHoraFim(fim);
                pedido.setDiaPedido(rs.getDate("dataPedido"));
                
                pedidosPendentes.add(pedido);
            }
            
            FabricaConexao.fecharConexao();
            return pedidosPendentes;            
           
        } catch (SQLException ex) {
            Logger.getLogger(PedidoReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList();
    }
    
    public List<Pedido> buscarPedidosRevisados(){
        try {
            Connection conexao = FabricaConexao.getConexao(); 
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM pedidoreserva WHERE statusAtual = 'Y'");
            ResultSet rs = ps.executeQuery();
            List<Pedido> pedidosRevisados = new ArrayList<>();

            while(rs.next()){
                
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdAmbiente(rs.getString("idAmbiente"));
                pedido.setIdUsuario(rs.getInt("idUsuario"));
                pedido.setDescricao(rs.getString("descricaoPedido"));
                Time inicio = new Time(rs.getTime("horaInicio").getTime());
                Time fim = new Time(rs.getTime("horaFim").getTime());
                pedido.setHoraInicio(inicio);
                pedido.setHoraFim(fim);
                pedido.setDiaPedido(rs.getDate("dataPedido"));
                pedido.setRespostaMestre(rs.getString("repostaMestre"));
                
                pedidosRevisados.add(pedido);
            }
            
            FabricaConexao.fecharConexao();
            return pedidosRevisados;            
           
        } catch (SQLException ex) {
            Logger.getLogger(PedidoReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList();
    }
    
    public boolean responderPedido(Pedido pedido){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            
            ps = conexao.prepareStatement("UPDATE pedidoreserva SET statusAtual = ?, repostaMestre = ? WHERE idPedido = ?");
            ps.setBoolean(1, true);
            ps.setString(2, pedido.getRespostaMestre());
            ps.setInt(3, pedido.getIdPedido());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public List<Pedido> buscarPedidosUsuario(Usuario usuario){
        try {
            Connection conexao = FabricaConexao.getConexao();
            
            PreparedStatement ps;
            
            List<Pedido> pedidosUsuario = new ArrayList();
            
            ps = conexao.prepareStatement("SELECT * FROM pedidoreserva WHERE idUsuario = ?");
            ps.setInt(1, usuario.getIdUsuario());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdAmbiente(rs.getString("idAmbiente"));
                pedido.setIdUsuario(rs.getInt("idUsuario"));
                pedido.setDescricao(rs.getString("descricaoPedido"));
                Time inicio = new Time(rs.getTime("horaInicio").getTime());
                Time fim = new Time(rs.getTime("horaFim").getTime());
                pedido.setHoraInicio(inicio);
                pedido.setHoraFim(fim);
                pedido.setDiaPedido(rs.getDate("dataPedido"));
                pedido.setStatusResposta(rs.getBoolean("statusAtual"));
                pedido.setRespostaMestre(rs.getString("repostaMestre"));
                
                pedidosUsuario.add(pedido);
            }
            FabricaConexao.fecharConexao();
            return pedidosUsuario;
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidoReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return new ArrayList();
    }
    
    
}
