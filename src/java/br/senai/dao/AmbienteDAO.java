package br.senai.dao;

import br.senai.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AmbienteDAO {
    /*public void criarAmbiente(){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(itemAmbiente != null){
                ps = conexao.prepareStatement("INSERT INTO ambiente (idAmbiente) VALUES (?)"); 
                ps.setString(1, "oi");
                ps.executeUpdate();
                FabricaConexao.fecharConexao();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }*/
}
