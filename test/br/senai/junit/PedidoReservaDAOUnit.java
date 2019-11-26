package br.senai.junit;

import br.senai.dao.PedidoReservaDAO;
import br.senai.model.Ambiente;
import br.senai.model.Item;
import br.senai.model.Pedido;
import br.senai.model.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PedidoReservaDAOUnit {
    
    public PedidoReservaDAOUnit() {
    }
    
    @Test
    public void testePedidoReserva() {
        
        PedidoReservaDAO dao = new PedidoReservaDAO();
        
        ArrayList<Item> itensAmbiente = new ArrayList();
        Ambiente ambiente = new Ambiente("TesteConsistencia", false, itensAmbiente);
        Pedido PedidoReserva = new Pedido();
        
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(9);
        usuario.setNome("Chrys");
        usuario.setTelefone("91015929");
        usuario.setEmail("chrysterafrz@hotmail.com");
        usuario.setMatricula("1234");
        
        
        
        
        LocalDate currentdate = LocalDate.now();
        
        PedidoReserva.setDiaReserva("26/11/2019");
        PedidoReserva.setHoraInicio("14:30");
        PedidoReserva.setHoraFim("16:30");
        PedidoReserva.setDescricao("Descrição do pedido");
        PedidoReserva.setDiaPedido(currentdate.toString());
        PedidoReserva.setIdUsuario(usuario.getIdUsuario());
        PedidoReserva.setIdAmbiente(ambiente.getIdAmbiente());
        
        if(dao.criarPedido(ambiente, PedidoReserva, usuario)){
            System.out.println("funfo"); 
       } else {
            fail("Deu ruim");
        }

        
    }
    
}
