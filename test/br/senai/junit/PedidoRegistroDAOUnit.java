package br.senai.junit;

import br.senai.dao.pedidoRegistroDAO;
import br.senai.model.PedidoRegistro;
import org.junit.Test;
import static org.junit.Assert.*;

public class PedidoRegistroDAOUnit {
    
    @Test
    public void testeAdicionarDAO() throws Exception{
        
        PedidoRegistro pedido = new PedidoRegistro(1, "Chrys", "91015929", "chrysterafrz@hotmail.com", "1234", "Oi");
        pedidoRegistroDAO pedidoDAO = new pedidoRegistroDAO();
        
        if(pedidoDAO.salvar(pedido)){
            System.out.println("Pedido de registro salvo com sucesso");
        } else {
            fail("Alguma coisa deu errado! Pedido não salvo.");
        }
    }
    
    @Test
    public void testeExcluirDAO() throws Exception{
        
        PedidoRegistro pedido = new PedidoRegistro(1, "Chrys", "91015929", "chrysterafrz@hotmail.com", "1234", "Oi");
        pedidoRegistroDAO pedidoDAO = new pedidoRegistroDAO();
        
        if(pedidoDAO.excluirPedido(pedido.getIdPedido())){
            System.out.println("Pedido de registro excluido com sucesso");
        } else {
            fail("Alguma coisa deu errado! Pedido não excluido.");
        }
    }
    
}
