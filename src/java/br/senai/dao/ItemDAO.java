package br.senai.dao;

import br.senai.model.Ambiente;
import br.senai.model.Item;
import br.senai.model.PedidoRegistro;
import br.senai.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ItemDAO {
    
    public boolean adicionarItem(Item itemAmbiente, String ambienteInserido){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(itemAmbiente != null){
                ps = conexao.prepareStatement("INSERT INTO itemambiente (idAmbiente, nome, descricao, quantidade) VALUES (?, ?, ?, ?)"); 
                ps.setInt(1, itemAmbiente.getIdItem());
                ps.setString(2, ambienteInserido);
                ps.setString(3, itemAmbiente.getNome());
                ps.setString(4, itemAmbiente.getDescricao());
                ps.setInt(5, itemAmbiente.getQuantidade());
                ps.executeUpdate();
                FabricaConexao.fecharConexao();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
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
}
