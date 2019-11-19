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
    
    public boolean inserirItem(Item item, String idAmbiente){
        try {
            
            Connection conexao = FabricaConexao.getConexao();
            
            String INSERT = "INSERT INTO itemambiente (idAmbiente, nome, descricao, quantidade) VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps;
            ps = conexao.prepareStatement(INSERT);
            ps.setString(1, idAmbiente);
            ps.setString(2, item.getNome());
            ps.setString(3, item.getDescricao());
            ps.setInt(4, item.getQuantidade());
            ps.executeUpdate();
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            FabricaConexao.fecharConexao();
        }
        return true;
    }   
    
    
    public boolean inserirItemNovoAmbiente(Ambiente ambiente){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(ambiente.getItensAmbiente() != null){
                for(int i = 0; i <  ambiente.getItensAmbiente() .size(); i++){
                    ps = conexao.prepareStatement("INSERT INTO itemambiente (idAmbiente, nome, descricao, quantidade) VALUES (?, ?, ?, ?)"); 
                    ps.setString(1, ambiente.getIdAmbiente());
                    ps.setString(2, ( (Item) ambiente.getItensAmbiente().get(i)).getNome() );
                    ps.setString(3, ( (Item) ambiente.getItensAmbiente().get(i)).getDescricao() );
                    ps.setString(4, ( (Item) ambiente.getItensAmbiente().get(i)).getQuantidadeString() );
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
            
            ps = conexao.prepareStatement("DELETE FROM itemambiente WHERE idItem = ?"); 
            ps.setInt(1, idItem);
            ps.executeUpdate();
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            FabricaConexao.fecharConexao(); 
        }
    }
    
    public void editarItem(Item item){
        try {
            
            Connection conexao = FabricaConexao.getConexao();
            
            String UPDATE = "UPDATE itemambiente SET nome = ?, descricao = ?, quantidade = ? WHERE idItem = ?";
            
            PreparedStatement ps;
            ps = conexao.prepareStatement(UPDATE);
            
            ps.setString(1, item.getNome());
            ps.setString(2, item.getDescricao());
            ps.setInt(3, item.getQuantidade());
            ps.setInt(1, item.getIdItem());
            
            ps.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.fecharConexao();
        }
    }
    
    public ArrayList<Item> buscarItens(String idAmbiente){
        
        ArrayList<Item> itensEncontrados = new ArrayList<>();
        
        try { 
             
            Connection conexao = FabricaConexao.getConexao(); 
            String SELECT = "SELECT * FROM itemambiente WHERE idAmbiente = ?";
            
            ResultSet rs = null;
        
            
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement(SELECT);
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
        } finally {
            FabricaConexao.fecharConexao();
        }
        
        return itensEncontrados;
    }
}
