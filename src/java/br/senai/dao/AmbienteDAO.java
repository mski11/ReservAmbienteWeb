package br.senai.dao;

import br.senai.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AmbienteDAO {
    
    public boolean criarAmbiente(String idAmbiente){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            
            ps = conexao.prepareStatement("INSERT INTO ambiente (idAmbiente, status) VALUES (?, ?)"); 
            ps.setString(1, idAmbiente);
            ps.setString(2, "N");
            ps.executeUpdate();
            FabricaConexao.fecharConexao();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
}
