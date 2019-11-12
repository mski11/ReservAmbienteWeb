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
        
        List<Ambiente> ambientes = new ArrayList<>();
        
        try{
            
            Connection conexao = FabricaConexao.getConexao(); 

            PreparedStatement stmt = null;
            ResultSet rs = null;

            String SELECT = "SELECT * FROM ambiente";
            stmt = conexao.prepareStatement(SELECT);
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
    
    public void editarIdAmbiente(String idAmbiente){
        try {
            
            Connection conexao = FabricaConexao.getConexao();
            
            String UPDATEitemambiente = "UPDATE itemambiente SET idAmbiente = ? WHERE idAmbiente = ?";
            String UPDATEambiente = "UPDATE ambiente SET idAmbiente = ? WHERE idAmbiente = ?";
            
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement(UPDATEitemambiente);
            stmt.setString(1, idAmbiente);
            stmt.setString(2, idAmbiente);
            stmt.executeQuery();
            
            stmt = conexao.prepareStatement(UPDATEambiente);
            stmt.setString(1, idAmbiente);
            stmt.setString(2, idAmbiente);
            stmt.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.fecharConexao();
        }     
        
    }
    
    public void excluirAmbiente(String idAmbiente){
        try {
            Connection conexao = FabricaConexao.getConexao();
            
            String excluirItens = "DELETE FROM itemambiente WHERE idAmbiente = ?";
            String excluirAmbiente = "DELETE FROM ambiente WHERE idAmbiente = ?";
            
            PreparedStatement ps;
            
            ps = conexao.prepareStatement(excluirItens);
            ps.setString(1, idAmbiente);
            
            ps = conexao.prepareStatement(excluirAmbiente);
            ps.setString(1, idAmbiente);
            
        } catch (SQLException ex) {
            Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.fecharConexao();
        } /* top */
    }
    
}
