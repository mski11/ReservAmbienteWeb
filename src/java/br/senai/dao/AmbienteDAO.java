package br.senai.dao;

import br.senai.model.Ambiente;
import br.senai.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public List buscarAmbientes(){
        
        Connection conexao = FabricaConexao.getConexao(); 
        String sql = "SELECT * FROM ambiente";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Ambiente> ambientes = new ArrayList<>();
        
        try{
            
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
             
            if(rs.next()){
                while(rs.next()){
                    Ambiente ambiente = new Ambiente();

                    ambiente.setIdAmbiente(rs.getString("idAmbiente"));
                    ambientes.add(ambiente);
                }
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.fecharConexao();
        }     
        return ambientes;
    }
}
