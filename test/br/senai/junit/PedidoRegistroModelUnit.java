package br.senai.junit;

import br.senai.model.PedidoRegistro;
import org.junit.Test;
import static org.junit.Assert.*;

public class PedidoRegistroModelUnit {
    
    /* Descobri uns erros nos construtores com estes testes! :) */ 
    
    @Test
    public void testeGetter(){
        PedidoRegistro pedido = new PedidoRegistro(1, "Chrys", "91015929", "chrysterafrz@hotmail.com", "1234", "Oi");
        assertEquals(1 , pedido.getIdPedido());
        assertEquals("Chrys" , pedido.getNome());
        assertEquals("91015929" , pedido.getTelefone());
        assertEquals("chrysterafrz@hotmail.com" , pedido.getEmail());
        assertEquals("1234" , pedido.getMatricula());
        assertEquals("Oi" , pedido.getDescricao());
    }
    
    @Test
    public void testeSetter(){
        
        PedidoRegistro pedido = new PedidoRegistro();
        pedido.setIdPedido(1);
        pedido.setNome("Chrys");
        pedido.setTelefone("91015929");
        pedido.setEmail("chrysterafrz@hotmail.com");
        pedido.setMatricula("1234");
        pedido.setDescricao("Oi");
        
        assertEquals(1 , pedido.getIdPedido());
        assertEquals("Chrys" , pedido.getNome());
        assertEquals("91015929" , pedido.getTelefone());
        assertEquals("chrysterafrz@hotmail.com" , pedido.getEmail());
        assertEquals("1234" , pedido.getMatricula());
        assertEquals("Oi" , pedido.getDescricao());
    }
    
}
