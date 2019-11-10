package br.senai.dao;

import br.senai.model.Ambiente;
import br.senai.model.Item;
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

public class ItemDAO {
    
    public boolean inserirItemNovoAmbiente(List<Item> itensAmbiente, String idAmbiente){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(itensAmbiente != null){
                for(int i = 0; i <  itensAmbiente.size(); i++){
                    ps = conexao.prepareStatement("INSERT INTO itemambiente (idAmbiente, nome, descricao, quantidade) VALUES (?, ?, ?, ?)"); 
                    ps.setString(1, idAmbiente);
                    ps.setString(2, ( (Item) itensAmbiente.get(i)).getNome());
                    ps.setString(3, ( (Item) itensAmbiente.get(i)).getDescricao());
                    ps.setString(4, ( (Item) itensAmbiente.get(i)).getQuantidadeString() );
                ps.executeUpdate();
                }
                FabricaConexao.fecharConexao();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public void excluirItem(int idItem){
        try {
            
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            
            ps = conexao.prepareStatement("DELETE * FROM itemambiente WHERE idItem = ?"); 
            ps.setInt(1, idItem);
            ps.executeUpdate();
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            FabricaConexao.fecharConexao(); 
        }
    }
    
    public List<Item> buscarItens(String idAmbiente){
        
        Connection conexao = FabricaConexao.getConexao(); 
        String sql = "SELECT * FROM itemambiente WHERE idAmbiente = ?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Item> itensEncontrados = new ArrayList<>();
        
         try {
             
             stmt = conexao.prepareStatement(sql);
             stmt.setString(1, idAmbiente);
             rs = stmt.executeQuery();
             
             while(rs.next()){
                Item item = new Item();
                
                item.setIdItem(rs.getInt("idItem"));
                item.setNome(rs.getString("nome"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setDescricao(rs.getString("descricao"));
                itensEncontrados.add(item);
                
            }
             
         } catch (SQLException ex) {
             Logger.getLogger(pedidoRegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
         }  finally {
             FabricaConexao.fecharConexao();
         }
         
         return itensEncontrados;
    }
}
