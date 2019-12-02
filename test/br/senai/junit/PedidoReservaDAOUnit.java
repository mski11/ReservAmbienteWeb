package br.senai.junit;

import br.senai.dao.PedidoReservaDAO;
import br.senai.model.Ambiente;
import br.senai.model.Item;
import br.senai.model.Pedido;
import br.senai.model.Usuario;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
    public void testeNegarPedido(){
        PedidoReservaDAO dao = new PedidoReservaDAO();
        
        ArrayList<Item> itensAmbiente = new ArrayList();
        Ambiente ambiente = new Ambiente("Laboratório Aberto", false, itensAmbiente);
        Pedido PedidoReserva = new Pedido();
        
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(2);
        usuario.setNome("Chrys");
        usuario.setTelefone("91015929");
        usuario.setEmail("chrysterafrz@hotmail.com");
        usuario.setMatricula("1234");
        
        
        
        
        LocalDate currentdate = LocalDate.now();
        
        Date diaPedido = new Date(26/11/2019);
        Date horaInicio = new Date("26/11/2019 14:30:00");
        Date horaFim = new Date("26/11/2019 17:30:00");

        PedidoReserva.setDiaPedido(diaPedido);
        PedidoReserva.setHoraInicio(horaInicio);
        PedidoReserva.setHoraFim(horaFim);
        
        PedidoReserva.setDescricao("Descrição do pedido");
        PedidoReserva.setIdUsuario(usuario.getIdUsuario());
        PedidoReserva.setIdAmbiente(ambiente.getIdAmbiente());
        
        dao.criarPedido(ambiente, PedidoReserva, usuario);
        
        PedidoReserva.setRespostaMestre("Oi");
        
        if(dao.responderPedido(PedidoReserva)){
            System.out.println("Foi");
        } else {
            fail("Nao foi");
        }
        
        
    }
    
    public void testePedidoReserva() {
        
        PedidoReservaDAO dao = new PedidoReservaDAO();
        
        ArrayList<Item> itensAmbiente = new ArrayList();
        Ambiente ambiente = new Ambiente("Laboratório Aberto", false, itensAmbiente);
        Pedido PedidoReserva = new Pedido();
        
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(2);
        usuario.setNome("Chrys");
        usuario.setTelefone("91015929");
        usuario.setEmail("chrysterafrz@hotmail.com");
        usuario.setMatricula("1234");
        
        
        
        
        LocalDate currentdate = LocalDate.now();
        
        Date diaPedido = new Date(26/11/2019);
        Date horaInicio = new Date("26/11/2019 14:30:00");
        Date horaFim = new Date("26/11/2019 17:30:00");

        PedidoReserva.setDiaPedido(diaPedido);
        PedidoReserva.setHoraInicio(horaInicio);
        PedidoReserva.setHoraFim(horaFim);
        
        PedidoReserva.setDescricao("Descrição do pedido");
        PedidoReserva.setIdUsuario(usuario.getIdUsuario());
        PedidoReserva.setIdAmbiente(ambiente.getIdAmbiente());
        
        if(dao.criarPedido(ambiente, PedidoReserva, usuario)){
            System.out.println("funfo"); 
       } else {
            fail("Deu ruim");
        }

        
    }
    
}
