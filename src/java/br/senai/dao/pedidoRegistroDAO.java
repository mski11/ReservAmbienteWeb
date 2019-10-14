package br.senai.dao;

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

public class pedidoRegistroDAO {
    
    public void salvar(PedidoRegistro PR){
        try {
        Connection conexao = FabricaConexao.getConexao();
        PreparedStatement ps;
        if(PR != null){
            ps = conexao.prepareStatement("INSERT INTO pedidoRegistro (nome, telefone, email, matricula, descricao) VALUES (?, ?, ?, ?, ?)");
            
            ps.setString(1, PR.getNome());
            ps.setString(2, PR.getTelefone());
            ps.setString(3, PR.getEmail());
            ps.setString(4, PR.getMatricula());
            ps.setString(5, PR.getDescricao());
            
            ps.executeUpdate();
            
            FabricaConexao.fecharConexao();
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
