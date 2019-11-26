package br.senai.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaConexao {
        
    private static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:mysql://localhost/reservese";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
    public static Connection getConexao(){
        if(conexao == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            /*    conexao.setAutoCommit(false);
                conexao.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); */
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexao;
    }
/*    
    public static void confirmarTransacao() throws Exception{
        try {
            if(conexao == null || conexao.isClosed()){
                return;
            }
            conexao.commit();
        } catch(SQLException sql){
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }
    
    public static void cancelarTransacao() throws Exception{
        try {
            if(conexao == null || conexao.isClosed()){
                return;
            }
            conexao.rollback();
        } catch(SQLException sql){
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }
*/
    
    public static void fecharConexao(){
        if(conexao != null){
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
