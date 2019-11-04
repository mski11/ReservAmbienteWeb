package br.senai.dao;

import br.senai.model.Ambiente;
import br.senai.model.Item;
import br.senai.model.PedidoRegistro;
import br.senai.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemDAO {
    
    public boolean adicionarItem(Item itemAmbiente, String ambienteInserido){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(itemAmbiente != null){
                ps = conexao.prepareStatement("INSERT INTO itemambiente (idItem, idAmbiente, nome, descricao, quantidade) VALUES (?, ?, ?, ?, ?)"); 
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
}
