package br.senai.junit;

import br.senai.dao.UsuarioDAO;
import br.senai.model.PedidoRegistro;
import br.senai.model.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioDAOUnit {
    
    @Test
    public void testeRegistrarUsuario(){
        
        PedidoRegistro pedido = new PedidoRegistro();
        pedido.setIdPedido(3);
        pedido.setNome("Chrys");
        pedido.setTelefone("91015929");
        pedido.setEmail("chrysterafrz@hotmail.com");
        pedido.setMatricula("1234");
        pedido.setDescricao("Oi");
        
        UsuarioDAO userDAO = new UsuarioDAO();
        
        if(userDAO.registrarUsuario(pedido.getIdPedido())){
            System.out.println("Pedido de registro aceito e usuário registrado com sucesso!");
        } else {
            fail("Erro! Usuário não registrado");
        }
    }
    
    @Test
    public void testeExcluirUsuario(){
        
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = new Usuario(1, "Chrys", "1234");
        
        if(userDAO.excluir(user)){
            System.out.println("Usuário excluido com sucesso!");
        } else {
            fail("Erro! Usuário não excluído");
        }
    }
    
}
